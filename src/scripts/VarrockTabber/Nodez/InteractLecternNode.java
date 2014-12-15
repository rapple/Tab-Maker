package scripts.VarrockTabber.Nodez;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.*;
import org.tbot.methods.tabs.Inventory;
import org.tbot.methods.walking.Walking;
import org.tbot.util.Condition;
import org.tbot.wrappers.GameObject;
import org.tbot.wrappers.NPC;
import org.tbot.wrappers.Tile;
import scripts.VarrockTabber.Vars;
import scripts.VarrockTabber.vTabber;

public class InteractLecternNode implements vTabber.Node {

    @Override
    public boolean activate() {
        NPC butler = Npcs.getNearest(Vars.BUTTLER_ID);
        GameObject lect = GameObjects.getNearest(Vars.LECTERN);
        return ((Inventory.getCount(Vars.S_CLAY_ID) >= 4 && butler != null)
                || (Inventory.getCount(Vars.S_CLAY_ID) > 0 && butler == null))
                && Players.getLocal().getAnimation() == -1
                && (!Vars.TAB_CREATION_INTERFACE.isValid() || Widgets.getWidget(241,2).containsText("Your goods, sir."))
                && Walking.canReach(Vars.MAIN_TILE);
    }

    @Override
    public int run() {
        GameObject lect = GameObjects.getNearest(Vars.LECTERN);

        if(lect != null && lect.isOnScreen() && !Players.getLocal().isMoving()) {
            lect.interact("Study");
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return Vars.TAB_CREATION_INTERFACE.isOnScreen();
                }
            }, Random.nextInt(2500, 3000));

        }
        return Random.nextInt(100, 250);
    }
}