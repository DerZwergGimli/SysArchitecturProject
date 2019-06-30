#!/usr/bin/python
#
# Show the main interfaces of the three sensor classes
#
#

from time import sleep
import redis
from altimu.lsm6ds33 import LSM6DS33
from altimu.lis3mdl  import LIS3MDL
from altimu.lps25h   import LPS25H
from datetime import datetime

imu = LSM6DS33()        # Accelerometer and Gyroscope
imu.enable()

magnet = LIS3MDL()      # Magnetometer
magnet.enable()

baro = LPS25H()         # Barometric and Temperature
baro.enable()
r = redis.Redis(host='localhost', port=6379)


while True:
    dateTime = datetime.now()
    timestamp = dateTime.strftime("%Y%m%dT%H%M%SZ")

    vektor_gyro = imu.getGyroscopeDPS()
    vektor_acce = imu.getAccelerometerMPS2()
    vektor_magnet = magnet.getMagnetometerRaw()

    r.set('sensors:gyro:gyro_x', vektor_gyro[0])
    r.set('sensors:gyro:gyro_y', vektor_gyro[1])
    r.set('sensors:gyro:gyro_z', vektor_gyro[2])
    r.set('sensors:gyro:timestamp', timestamp )
    r.set('sensors:gyro:unit', "degrees/s")    

    r.set('sensors:accelerometer:accelerometer_x', vektor_acce[0])
    r.set('sensors:accelerometer:accelerometer_y', vektor_acce[1])
    r.set('sensors:accelerometer:accelerometer_z', vektor_acce[2])
    r.set('sensors:accelerometer:timestamp', timestamp )
    r.set('sensors:accelerometer:unit', "m/s^2")

    r.set('sensors:magnetometer:magnetometer_x', vektor_magnet[0])
    r.set('sensors:magnetometer:magnetometer_y', vektor_magnet[1])
    r.set('sensors:magnetometer:magnetometer_z', vektor_magnet[2])
    r.set('sensors:magnetometer:timestamp', timestamp )
    r.set('sensors:magnetometer:unit', "Gauss")

    r.set('sensors:barometer:pressure:data', baro.getBarometerMillibars())
    r.set('sensors:barometer:pressure:timestamp', timestamp)
    r.set('sensors:barometer:pressure:unit', "milliBar")
    r.set('sensors:barometer:metersinheight:data', baro.getAltitude())
    r.set('sensors:barometer:metersinheight:timestamp', timestamp )
    r.set('sensors:barometer:metersinheight:unit', "m")

    r.set('sensors:temperatur:celsius', imu.getTemperatureCelsius())
    r.set('sensors:temperatur:timestamp', timestamp )
    r.set('sensors:temperatur:unit', "degrees Celsius")

    sleep(1)