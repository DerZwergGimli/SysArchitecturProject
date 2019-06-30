#!/usr/bin/env python

import RPi.GPIO as GPIO
import sys
import redis
import time
from datetime import datetime
from mfrc522 import SimpleMFRC522


r = redis.Redis(host='localhost', port=6379 )
reader = SimpleMFRC522()
dateTime = datetime.now()

while True:
    try:
        dateTime = datetime.now()
        timestamp = dateTime.strftime("%Y%m%dT%H%M%SZ")
        id, text = reader.read()
	present = 1
        r.set('sensors:rfid:ID', id)
        if id != 0:
            r.set('sensors:rfid:present', 1)
	    r.set('sensors:rfid:timestamp', timestamp)
	else:
	    r.set('sensors:rfid:present', 0)
        time.sleep(0.5)

    except:
        id = 0
	present = 0
        r.set('sensors:rfid:ID', id)
        time.sleep(0.5)

