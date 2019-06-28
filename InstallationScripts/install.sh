#!/bin/bash
Install_Redis="./installRedis.sh"
Install_NodeRed="./installNodeRed.sh"

echo "This will now install all the dependecies that are needed!";
sleep 3;
echo "Check for updates";
sudo apt update;
sudo apt upgrade -y;

. "$Install_Redis";
. "$Install_NodeRed";
