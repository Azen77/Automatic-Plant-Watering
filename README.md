# Automatic Plant Watering System

An automated plant watering system that monitors soil moisture using an Arduino sensor and activates a water pump when the soil gets dry.  
The project includes two implementations using the same hardware:  

Java implementation – desktop-side control, OOP design, live graphing  
MATLAB implementation – embedded style control and real time visualization  
  
Reads and processes real-time sensor data    
Threshold based control logic using a state-machine   
Automatic pump activation  
Live updating moisture vs time plots  
Hardware and software integration  

Repository Structure  
java/..............Java implementation (Firmata4J, StdDraw, JUnit)  
matlab/........MATLAB implementation and visualization  
hardware/...Photos of physical setup  
docs/............Flowcharts and graphs      
     
# Java Version                
Interfaces with Arduino using Firmata4J        
Real-time plotting using StdDraw      
Uses TimerTask for non-blocking pump control            
Stores time-series data using ArrayList and HashMap                
Includes JUnit tests for helper logic            
          
# MATLAB Version              
Reads live analog voltage from Arduino                       
Implements threshold-based control to manage pump activation             
Real-time line plotting of sensor voltage vs. time                
Separate update and execution logic for cleaner design               
  
# Hardware:                           
Arduino                                       
Moisture Sensor                   
Water Pump                          
MOSFET Driver         
External Power           
