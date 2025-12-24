clear; close all;

port = serialportlist;
a = arduino(port(end),"Nano3"); 

moisture = 'A1'; % moisture sensor
pump = 'D2';     % water pump

dryThreshold = 3.10; % soil is dry
wetThreshold = 2.75; % soil is wet enough

% initialize graph
figure
h = animatedline;
ax = gca;
ax.YGrid = 'on';
ax.YLim = [-0.1 5];
title('Moisture sensor voltage vs time (live)');
xlabel('Time [HH:MM:SS]');
ylabel('Voltage [volt]')
startTime = datetime('now');

while ~readDigitalPin(a,"D6")
    voltage = readVoltage(a, "A0");
    
    % pump state from thresholds
    if voltage >= dryThreshold
        disp('Soil is dry. Watering now.');
        writeDigitalPin(a,pump,1); % pump on
    elseif voltage < dryThreshold && voltage > wetThreshold
        disp('Soil is wet. continuing to water.');
        writeDigitalPin(a,pump,1); % pump on        
    elseif voltage <= wetThreshold
        disp('Soil is wet enough. Stopping watering.');
        writeDigitalPin(a,pump,0); % pump off
    else
        fprintf('Something went wrong.\nRetrying...\n');
        writeDigitalPin(a,pump,0); % pump off
    end
    
    % update graph each loop with the function
    updateGraph(voltage,h,startTime,ax);
    
    pause(0.5); 

end
    % guarantees that when button is pressed, program ends with pump off
    writeDigitalPin(a,'D2',0)

