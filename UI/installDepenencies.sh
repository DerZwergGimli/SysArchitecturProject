#!/bin/bash

wget -q --spider http://google.com

if [ $? -eq 0 ]; then
    echo "Online"
else
    echo "Offline"
fi

#-q : Silence mode
#--spider : don't get, just check page availability
#$? : shell return code
#0 : shell "All OK" code
