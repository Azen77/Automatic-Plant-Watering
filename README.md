# Automatic Plant Watering System

An automated plant watering system that monitors soil moisture using an Arduino sensor and activates  
a water pump when the soil becomes dry.  
This project includes **two implementations** using the same hardware:

- **Java Implementation** – desktop-side control, OOP design, real-time plotting  
- **MATLAB Implementation** – embedded-style control with live visualization  

---

## Features
- Real-time soil moisture monitoring  
- Threshold-based control using state-machine logic  
- Automatic pump activation  
- Live updating moisture-vs-time plots  
- Hardware + software integration  

---

## Repository Structure
- java/ Java implementation (Firmata4J, StdDraw, JUnit)  
- matlab/ MATLAB implementation and visualization  
- hardware/ Photos of physical setup  
- docs/ Flowcharts and graphs  


---

## Java Implementation
- Communicates with Arduino using **Firmata4J**
- Real-time plotting with **StdDraw**
- **Non-blocking pump control** using `TimerTask`
- Time-series storage using **ArrayList** and **HashMap**
- Includes **JUnit tests** for helper logic
- Demonstrates OOP, event-driven behavior, and testing discipline

---

## MATLAB Implementation
- Reads live analog voltage from Arduino
- Implements **threshold-based automatic watering**
- Real-time plotting of moisture voltage vs time
- Separation of sensor reading, control logic, and visualization
- Simple, reliable embedded-style workflow

---

## Hardware
- Arduino  
- Moisture Sensor  
- Water Pump  
- MOSFET / Driver Circuit  
- External Power Supply  

---

## Author
**Mazen Rashrash**
