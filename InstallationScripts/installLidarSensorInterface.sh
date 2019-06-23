#!/bin/bash

download_lidar_sensor()
{
   git clone https://github.com/bmegli/xv11lidar-test.git;
   sudo apt-get update
   sudo apt-get install build-essential
   ./xv11lidar-test make
}

while true; do
    read -p "Do you wish to install lidar-sensor-interface? (y/n)" yn
    case $yn in
        [Yy]* ) echo "installing..."; break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done



