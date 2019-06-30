#!/bin/bash
Install_Redis="./installRedis.sh"
Install_NodeRed="./installNodeRed.sh"

echo "This will now install all the dependecies that are needed!";
sleep 3;
echo "Check for updates";
sudo apt update;
sudo apt upgrade -y;
sudo apt install wget redis-server -y;

echo "Install Lidar-Interface"
sudo apt install build-essential;
mkdir /home/pi/vehicle/lidar;
git clone https://github.com/bmegli/xv11lidar-test.git /home/pi/vehicle/lidar;
cd /home/pi/vehicle/lidar;
make;
cd /home/pi/SysArchitecturProject/InstallationScripts;

echo "Install vehicle";
mkdir /home/pi/vehicle/armv7;
wget -P /home/pi/vehicle/armv7 https://github.com/DerZwergGimli/SysArchitecturProject/blob/master/Vehicle_Project/build/armv7/SysArchVehicle_armv7;
cp vehicle.service /etc/systemd/system/vehicle.service
sudo systemctl enable vehicle;

echo "Install communicationManager";
mkdir /home/pi/vehicle/commManager;
wget -p /home/pi/vehicle/commManager https://github.com/DerZwergGimli/SysArchitecturProject/blob/master/CommManager/out/artifacts/CommManager_jar2/CommManager.jar;
wget -p /home/pi/vehicle/commManager https://github.com/DerZwergGimli/SysArchitecturProject/blob/master/CommManager/config.properties;
cp communicationManager.service /etc/systemd/system/communicationManager.service
sudo systemctl enable communicationManager.service;


echo "Install Python-scripts";

echo "Install Node-Red";



echo "Start all!"
sudo systemctl start communicationManager.service;
sudo systemctl start vehicle;

