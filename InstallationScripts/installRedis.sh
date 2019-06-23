#!/bin/bash

while true; do
    read -p "Do you wish to install redis-Server? (y/n)" yn
    case $yn in
        [Yy]* ) echo "installing..."; break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done

