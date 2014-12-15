package scripts.VarrockTabber.Nodez;

import org.tbot.methods.*;
import org.tbot.methods.tabs.Inventory;
import org.tbot.methods.walking.Walking;
import org.tbot.wrappers.GameObject;
import scripts.VarrockTabber.Vars;
import scripts.VarrockTabber.vTabber;

import java.awt.*;

public class FindLecternNode implements vTabber.Node {

    @Override
    public boolean activate() {
        GameObject lect = GameObjects.getNearest(Vars.LECTERN);
        return Inventory.getCount(Vars.S_CLAY_ID) > 0
                && !lect.isOnScreen()
                && Players.getLocal().getAnimation() == -1;
    }

    @Override
    public int run() {
        GameObject lect = GameObjects.getNearest(Vars.LECTERN);
        Walking.findLocalPath(Vars.MAIN_TILE).traverse();
        Camera.turnTo(lect, Random.nextInt(2, 30));
        return Random.nextInt(250, 600);
    }
}