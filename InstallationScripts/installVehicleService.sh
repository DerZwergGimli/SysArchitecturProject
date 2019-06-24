#!/bin/bash

#!/bin/bash

while true; do
    read -p "Do you wish to install the Vehicle-Service? (y/n)" yn
    case $yn in
        [Yy]* ) echo "installing..."; break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done

