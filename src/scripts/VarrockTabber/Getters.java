package scripts.VarrockTabber;

import org.tbot.methods.GameObjects;
import org.tbot.methods.walking.Path;
import org.tbot.methods.walking.Walking;
import org.tbot.wrappers.GameObject;
import org.tbot.wrappers.Locatable;
import org.tbot.wrappers.Tile;

public class Getters {

    public static final int getObjectConfig(int[] ID) {

        GameObject o = GameObjects.getNearest(ID);

        return o.getObjConf();
    }

    public static final Tile getMainTile(int CONF_ID, Tile lectTile) {
        Tile returnTile = null;

        switch (CONF_ID) {
            case 330:
                returnTile = new Tile(lectTile.getX() + 1, lectTile.getY(), lectTile.getPlane());
                break;
            case 394:
                returnTile = new Tile(lectTile.getX(), lectTile.getY() - 1, lectTile.getPlane());
                break;
            case 358:
                returnTile = new Tile(lectTile.getX() - 1, lectTile.getY(), lectTile.getPlane());
                break;
            case 266:
                returnTile = new Tile(lectTile.getX(), lectTile.getY() + 1, lectTile.getPlane());
                break;
        }

        return returnTile;
    }

    public static Path getPath(Locatable locatable) {
        return null;
    }

}