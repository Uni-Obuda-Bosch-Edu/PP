package PP.Test.Helpers;

import PP.Test.Mock.DetectedObj;
import UltraSound.Core.Interop.IUltraSound_Out_Ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorBuilder implements IUltraSound_Out_Ext{

    private final Map<Integer,DetectedObj> _map = new HashMap<>();

    @Override
    public Map<Integer, Double> getDetectedObstackles() {
        return null;
    }

    @Override
    public Map<Integer, Double> getDistanceByObstackles() {
        return null;
    }

    public SensorBuilder(List<DetectedObj> objs) {
        int id = 0;
        for (DetectedObj x : objs)
            _map.put(++id,x);
    }
}
