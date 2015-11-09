package UltraSound.Core.UltraSound;

import World.Interop.IWorldObject;

import java.awt.Point;
import java.util.List;

public interface UltraSound_IN {
	public List<IWorldObject>getObstackles();
	public Point GetCarPositionXY();
	public int GetCarParameter();

}
	