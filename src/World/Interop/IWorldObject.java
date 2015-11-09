package World.Interop;

import World.WorldObjectTypes;
import javafx.util.Pair;

public interface IWorldObject {

    int getID();

    String getName();

    WorldObjectTypes.Type getType();

    WorldObjectTypes.Sign getSign();

    WorldObjectTypes.Misc getMisc();

    WorldObjectTypes.Lane getLane();

    Pair<Double,Double> getPosition();

    double[][] getTransform() ;

}