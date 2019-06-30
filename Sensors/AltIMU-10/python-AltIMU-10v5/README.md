# python-AltIMU-10v5

** python-AltIMU-10v5 ** is a suite of python libraries to access the Pololu AltiIMU-10 v5 over the I2C bus. This code is decended from the David E. Grayson C++ implementation, which was first ported to Python by Torsten Kurbad. It has only been tested on the AltIMU-10 v5, but should be reasonably portable to other IMUs. 

This package uses these sensors:

* LSM6DS33 accelerometer and gyro
* LIS3MDL magnetometer
* LPS25H barometric and temperature

This code has been developed and tested on a Raspberry Pi 3, but should work on the other Raspberry Pi boards without trouble. It should also work on many other small system Linux boards that have their I2C busses enabled.

The libraries give access to the raw sensor data and have a few tools to handle the mathematics of angles, but does not do the level of absolute orientation work that David's libraries are capable of.

## Getting Started

To enable I2C on the RPi and ensuring you have basic connectivity with the AltiMu-10 v5, follow David's README instructions at:
  https://raw.githubusercontent.com/DavidEGrayson/minimu9-ahrs/master/README.md

## Library goals

This is not intended to be an exhaustive library for the full feature set of the AltIMU-10 v5. Feature requests are welcome, but forks and pull requests are more valuable.
