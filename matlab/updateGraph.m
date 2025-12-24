% function to update graph on each loop
function updateGraph(voltage, h, startTime, ax)
    t = datetime('now') - startTime;
    addpoints(h,datenum(t),voltage)
    ax.XLim = datenum([t-seconds(15) t]);
    datetick('x','keeplimits')
    drawnow
end