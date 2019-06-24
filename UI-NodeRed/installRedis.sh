#!/bin/sh

echo "Downloading Redis.. " ;
wget  -P /usr/src/ "http://http://download.redis.io/releases/redis-5.0.5.tar.gz" ;

echo "Extracting.. " ;
tar zxvf /usr/src/redis-5.0.5.tar.gz -C /usr/src/ ;
echo "You can find the Source code in /usr/src/redis-5.0.5"

echo "installing... " ;
cd /usr/src/redis-5.0.5 ;
make install ;

echo "Do you want to install a specific configuration ?" ;
select yn in "Yes" "No"; do
    case $yn in
        Yes ) cd utils; ./install_server.sh; ;
        No ) echo "no config install";
    esac
done

echo "Do you want to run the Server now ?" ;
select yn in "Yes" "No"; do
    case $yn in
        Yes ) echo "Running The server" ;cd /usr/src/redis-5.0.5/src  ./redis-server ;
        No ) echo " no config install";
    esac
done

