package PP.Core;

import java.awt.geom.Point2D;

public interface IScanner {
    void Signal();

    Point2D GenerateProjectedOrigo(Point2D sensorCenter, Point2D correspondingCornerPosition, int projectionDistance);
}
