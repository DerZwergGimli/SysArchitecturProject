#!/bin/bash

#!/bin/bash


generateVehilce_Service(){
cat <<EOT >> /etc/systemd/system/vehicle.service
[Unit]
Description=Vehilce SysArchitecture
After=syslog.target network.target

[Service]
ExecStart=/home/pi/Vehicle/armv7/SysArchVehicle_armv7
Restart=on-failure
KillSignal=SIGINT

# non-root user to run as
WorkingDirectory=/home/UTILISATEUR/
User=root
Group=root

[Install]
WantedBy=multi-user.target
EOT
}

while true; do
    read -p "Do you wish to install the Vehicle-Service? (y/n)" yn
    case $yn in
        [Yy]* ) echo "installing..."; break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done

