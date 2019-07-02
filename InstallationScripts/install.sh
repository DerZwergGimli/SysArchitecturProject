#!/bin/bash
gitDir=`pwd`;
HOSTNAME_SHORT=`hostname -s`;

echo "This will now install all the dependecies that are needed!";
sleep 3;
echo "===> Check for updates";
#sudo apt update;
#sudo apt upgrade -y;
sudo apt install curl redis-server -y;

echo "====> Copy conig file";
sudo cp config.txt /boot/config.txt

echo "====> Copy Sytem Services for SystemCTL"
sudo cp vehicle.service /etc/systemd/system/vehicle.service;
sudo cp communicationManager.service /etc/systemd/system/communicationManager.service;
sudo cp sensors.service /etc/systemd/system/sensors.service;
sudo cp rfid_sensor.service /etc/systemd/system/rfid_sensor.service;


echo "====> Python scripts";
# sensors
mkdir /home/pi/vehicle;
cp -r ../Sensors /home/pi/vehicle/;
sudo systemctl enable sensors;
sudo systemctl enable rfid_sensor.service;



echo "====> Install Lidar-Interface";
sudo apt install build-essential;
mkdir /home/pi/vehicle/lidar;
git clone https://github.com/bmegli/xv11lidar-test.git /home/pi/vehicle/lidar;
cd /home/pi/vehicle/lidar;
make;
cd $gitDir;



echo "====> Install vehicle";
mkdir /home/pi/vehicle/armv7;
cd /home/pi/vehicle/armv7;
curl -LJO https://github.com/DerZwergGimli/SysArchitecturProject/releases/download/v0.9.3/SysArchVehicle_armv7;
chmod +x /home/pi/vehicle/armv7/SysArchVehicle_armv7;
sudo systemctl enable vehicle;

echo "====> Install communicationManager";
mkdir /home/pi/vehicle/commManager;
cd /home/pi/vehicle/commManager;
curl -LJO https://github.com/DerZwergGimli/SysArchitecturProject/releases/download/v0.9.3/CommManager.jar
curl -LJO https://github.com/DerZwergGimli/SysArchitecturProject/releases/download/v0.9.3/config_CommManager.properties;
sudo systemctl enable communicationManager.service;

echo "====> Install Node-Red";
bash <(curl -sL https://raw.githubusercontent.com/node-red/raspbian-deb-package/master/resources/update-nodejs-and-nodered);
cd $gitDir;
cd ../UI-NodeRed;
chmod 750 flows.json;
cp flows.json /home/pi/.node-red/flows_$HOSTNAME_SHORT.json
cd /home/pi/.node-red;
npm install node-red-contrib-redis;
npm install node-red-dashboard;
npm install node-red-contrib-chartjs;
npm install node-red-contrib-ui-led;
npm audit fix;
sudo systemctl enable nodered.service


echo "Start all!"
sudo systemctl start communicationManager.service;
sudo systemctl start vehicle.service;
sudo systemctl start sensors.service;
sudo systemctl start rfid_sensor.service;
sudo systemctl start nodered.service

