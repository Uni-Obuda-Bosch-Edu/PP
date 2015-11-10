package PP.Core;

import virtualDataBus.*;
import java.util.Timer;
import java.util.TimerTask;

public class Integration {
    private final int _busReadPeriodMs;
    private final Container _container;
    private final PP[] _pps;
    private final Timer _messagePump;

    private boolean _isConnected;

    public Integration(Container container, int busReadPeriodMs, PP... pps) {
        _container = container;
        _pps = pps;
        _messagePump = new Timer();
        _busReadPeriodMs = busReadPeriodMs;
    }

    public void Connect(){
        if(_isConnected)
            return;

        _messagePump.schedule(new TimerTask() {
            @Override
            public void run() {
                Signal();
            }
        }, _busReadPeriodMs);
        _isConnected = true;
    }

    public void Disconnect(){
        _messagePump.cancel();
        _isConnected = false;
        _container.setEngineRevolution(0);
    }

    private void Signal(){
        for(PP m : _pps)
            m.Signal();
    }

    public boolean IsConnected() {
        return _isConnected;
    }

    public int GetBusReadPeriodMs() {
        return _busReadPeriodMs;
    }
}
