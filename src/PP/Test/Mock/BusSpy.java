package PP.Test.Mock;

import PP.Core.IPP_Out;

public class BusSpy implements IPP_Out{
    private boolean _parkingFoundOnLeft;
    private boolean _parkingFoundOnRight;

    public boolean GetParkingFoundOnLeft() {
        return _parkingFoundOnLeft;
    }

    public boolean GetParkingFoundOnRight() {
        return _parkingFoundOnRight;
    }

    @Override
    public void SetParkingFoundOnLeft(boolean val) {
        _parkingFoundOnLeft = val;
    }

    @Override
    public void SetParkingFoundOnRight(boolean val) {
        _parkingFoundOnRight = val;
    }
}
