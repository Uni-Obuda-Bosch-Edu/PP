package PP.Core;

import UltraSound.Core.Interop.IUltraSound_Out_Ext;

import java.awt.geom.Point2D;

public interface IScanner {

    void Scan(IUltraSound_Out_Ext sensor);

    Point2D GenerateProjectedOrigo(Point2D sensorCenter, Point2D correspondingCornerPosition, int projectionDistance);
}
