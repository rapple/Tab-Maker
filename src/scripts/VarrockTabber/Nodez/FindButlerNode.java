package scripts.VarrockTabber.Nodez;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Camera;
import org.tbot.methods.Npcs;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.tabs.Inventory;
import org.tbot.methods.walking.Walking;
import org.tbot.wrappers.NPC;
import scripts.VarrockTabber.Vars;
import scripts.VarrockTabber.vTabber;

public class FindButlerNode implements vTabber.Node {

    @Override
    public boolean activate() {
        try {
            NPC butler = Npcs.getNearest(Vars.BUTTLER_ID);
            return Inventory.getCount(Vars.S_CLAY_ID) == 0
                    && butler != null
                    && !butler.isOnScreen()
                    && Players.getLocal().getAnimation() == -1;
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int run() {
        try {
            NPC butler = Npcs.getNearest(Vars.BUTTLER_ID);
            Walking.findLocalPath(butler.getLocation()).traverse();
            Camera.turnTo(butler, Random.nextInt(2, 30));
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return Random.nextInt(250, 500);
    }
}