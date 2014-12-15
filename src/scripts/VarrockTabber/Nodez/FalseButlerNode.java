package scripts.VarrockTabber.Nodez;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.GameObjects;
import org.tbot.methods.Npcs;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.tabs.Inventory;
import org.tbot.methods.walking.Walking;
import org.tbot.wrappers.GameObject;
import org.tbot.wrappers.NPC;
import scripts.VarrockTabber.Vars;
import scripts.VarrockTabber.vTabber;

public class FalseButlerNode implements vTabber.Node {

    @Override
    public boolean activate() {
        try {
            NPC butler = Npcs.getNearest(Vars.BUTTLER_ID);
            return Inventory.getCount(Vars.S_CLAY_ID) == 0
                    && butler == null
                    && !Players.getLocal().getLocation().equals(Vars.MAIN_TILE);
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int run() {
        GameObject lect = GameObjects.getNearest(Vars.LECTERN);
        if(Vars.MAIN_TILE.isOnScreen()) {
            Walking.walkTileOnScreen(Vars.MAIN_TILE);
        } else {
            Walking.walkTileMM(lect.getLocation());
        }
        return Random.nextInt(500, 750);
    }
}