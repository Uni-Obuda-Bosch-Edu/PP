package PP.Core;

import PP.Test.Mock.BusSpy;
import UltraSound.Core.Interop.IUltraSound_Out_Ext;

import java.awt.geom.Point2D;

public class VerticalScanner implements IScanner {

    private final BusSpy _busSpy;

    public VerticalScanner(BusSpy _busSpy) {
        this._busSpy = _busSpy;
    }

    @Override
    public void Scan(IUltraSound_Out_Ext sensor) {
        //Project o1 point
        _busSpy.SetParkingFoundOnLeft(false);
    }

    @Override
    public Point2D GenerateProjectedOrigo(Point2D sensorCenter, Point2D correspondingCornerPosition, int projectionDistance) {
        double sensorCornerDistance = sensorCenter.distance(correspondingCornerPosition);
        double co = projectionDistance / sensorCornerDistance;

        Point2D vector = MathLib.ToVector(sensorCenter, correspondingCornerPosition, co);

        return MathLib.TransformPointWithVector(correspondingCornerPosition,vector);
    }
}
