package PP.Test;

import PP.Core.VerticalScanner;
import PP.Test.Mock.FakeSensor;
import junit.framework.Assert;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class VerticalScannerTest {
    final double CAR_WIDTH_PX = 100;
    final double CAR_LENGTH_PX = 250;

    int _projectionDistance = 50;
    Point2D _sensorCenter;
    Point2D _correspondingCornerPosition;

    VerticalScanner _vScenner;
    FakeSensor _fakeSensor;

    @org.junit.Before
    public void Setup() {
        _sensorCenter = new Point2D.Double(CAR_LENGTH_PX, CAR_LENGTH_PX + _projectionDistance + (CAR_WIDTH_PX / 2) + 10);
        _correspondingCornerPosition = new Point2D.Double(CAR_LENGTH_PX, _sensorCenter.getY() - (CAR_WIDTH_PX / 2));

        _fakeSensor = new FakeSensor(new ArrayList<>());
        _vScenner = new VerticalScanner(_fakeSensor);
    }

    @Test
    public void Generate_projected_origo() {
        //Arrange
        Point2D projectedPoint;

        //Act
        projectedPoint = _vScenner.GenerateProjectedOrigo(_sensorCenter, _correspondingCornerPosition, _projectionDistance);

        //Assert
        Assert.assertEquals(CAR_LENGTH_PX, projectedPoint.getX(), 0);
        Assert.assertEquals(CAR_LENGTH_PX+10, projectedPoint.getY(), 0);
    }

    @Test
    public void Measure_place_for_car() {
        //Arrange
        Point2D projectedPoint = new Point2D.Double(CAR_LENGTH_PX,CAR_LENGTH_PX+10);


        //Act
        projectedPoint = _vScenner.GenerateProjectedOrigo(_sensorCenter, _correspondingCornerPosition, _projectionDistance);

        //Assert
        Assert.assertEquals(CAR_LENGTH_PX, projectedPoint.getX(), 0);
        Assert.assertEquals(CAR_LENGTH_PX+10, projectedPoint.getY(), 0);
    }
}
