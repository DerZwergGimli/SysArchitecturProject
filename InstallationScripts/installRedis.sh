#!/bin/bash
redisInstall(){
   echo "Installing Redis-Server"
   sudo apt install redis-server -y;
}

while true; do
    read -p "Do you wish to install redis-Server? (y/n)" yn
    case $yn in
        [Yy]* ) redisInstall; break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done

