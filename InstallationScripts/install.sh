#!/bin/bash
Install_Redis="./installRedis.sh"
Install_NodeRed="./installNodeRed.sh"

echo "This will now install all the dependecies that are needed!";
sleep 3;
echo "===> Check for updates";
sudo apt update;
sudo apt upgrade -y;
sudo apt install wget redis-server -y;

echo "====> Copy Sytem Services for SystemCTL"
sudo cp vehicle.service /etc/systemd/system/vehicle.service
sudo cp communicationManager.service /etc/systemd/system/communicationManager.service


echo "====> Install Lidar-Interface"
sudo apt install build-essential;
mkdir /home/pi/vehicle/lidar;
git clone https://github.com/bmegli/xv11lidar-test.git /home/pi/vehicle/lidar;
cd /home/pi/vehicle/lidar;
make;
cd /home/pi/SysArchitecturProject/InstallationScripts;



echo "====> Install vehicle";
mkdir /home/pi/vehicle/armv7;
cd /home/pi/vehicle/armv7;
curl -LJO https://github.com/DerZwergGimli/SysArchitecturProject/releases/download/v0.9.2/SysArchVehicle_armv7
chmod +x /home/pi/vehicle/armv7/SysArchVehicle_armv7
sudo systemctl enable vehicle;

echo "====> Install communicationManager";
mkdir /home/pi/vehicle/commManager;
cd /home/pi/vehicle/commManager;
curl -LJO https://github.com/DerZwergGimli/SysArchitecturProject/releases/download/v0.9.2/CommManager.jar;
curl -LJO https://raw.githubusercontent.com/DerZwergGimli/SysArchitecturProject/master/CommManager/config.properties;
sudo systemctl enable communicationManager.service;


echo "====> Install Python-scripts";

echo "====> Install Node-Red";



echo "Start all!"
sudo systemctl start communicationManager.service;
sudo systemctl start vehicle;

