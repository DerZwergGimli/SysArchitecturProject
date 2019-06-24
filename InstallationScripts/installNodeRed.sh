#!/bin/bash

nodeRedInstall(){
   echo "Installing Node-RED";
   sudo apt-get install nodejs-legacy -y;
   sudo apt-get install npm -y;
   sudo npm install -g --unsafe-perm node-red node-red-admin -y;
   sudo ufw allow 1880;
   generateNodeRed_Service;
   sudo systemctl enable node-red;
   sudo systemctl start node-red;
   sudo systemctl stop node-red;
   sudo npm install node-red-contrib-redis;
   sudo npm install node-red-dashboard;
   sudo npm install node-red-contrib-chartjs
}


generateNodeRed_Service(){
cat <<EOT >> /etc/systemd/system/node-red.service
[Unit]
Description=Node-RED
After=syslog.target network.target

[Service]
ExecStart=/usr/local/bin/node-red-pi --max-old-space-size=128 -v
Restart=on-failure
KillSignal=SIGINT

# log output to syslog as 'node-red'
SyslogIdentifier=node-red
StandardOutput=syslog

# non-root user to run as
WorkingDirectory=/home/UTILISATEUR/
User=UTILISATEUR
Group=UTILISATEUR

[Install]
WantedBy=multi-user.target
EOT
}


while true; do
    read -p "Do you wish to install Node-RED-UI? (y/n)" yn
    case $yn in
        [Yy]* ) nodeRedInstall; break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done

