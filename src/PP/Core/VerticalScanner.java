package PP.Core;

import UltraSound.Core.Interop.IUltraSound_Out_Ext;

import java.awt.geom.Point2D;

public class VerticalScanner implements IScanner {

    private final IUltraSound_Out_Ext _sensor;

    public VerticalScanner(IUltraSound_Out_Ext sensor) {

        _sensor = sensor;
    }

    @Override
    public void Signal() {
        //Project o1 point
    }

    @Override
    public Point2D GenerateProjectedOrigo(Point2D sensorCenter, Point2D correspondingCornerPosition, int projectionDistance) {
        double sensorCornerDistance = sensorCenter.distance(correspondingCornerPosition);
        double co = projectionDistance / sensorCornerDistance;

        Point2D vector = MathLib.ToVector(sensorCenter, correspondingCornerPosition, co);

        return MathLib.TransformPointWithVector(correspondingCornerPosition,vector);
    }
}
