package PP.Core;

import UltraSound.Core.Interop.IUltraSound_Out_Ext;

public class VerticalScanner implements IScanner {

    private final IUltraSound_Out_Ext _sensor;
    private final SensorDirection _direction;

    private VerticalScanner(IUltraSound_Out_Ext sensor, SensorDirection direction) {

        _sensor = sensor;
        _direction = direction;
    }

    @Override
    public void Signal() {

    }
}
