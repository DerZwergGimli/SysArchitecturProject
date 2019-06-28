#!/bin/bash

#!/bin/bash


generateVehilce_Service(){
cat <<EOT >> /etc/systemd/system/node-red.service
[Unit]
Description=Vehilce SysArchitecture
After=syslog.target network.target

[Service]
ExecStart=XXX
Restart=on-failure
KillSignal=SIGINT

# non-root user to run as
WorkingDirectory=/home/UTILISATEUR/
User=UTILISATEUR
Group=UTILISATEUR

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

