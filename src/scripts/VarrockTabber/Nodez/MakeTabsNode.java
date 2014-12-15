package scripts.VarrockTabber.Nodez;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.Time;
import org.tbot.methods.tabs.Inventory;
import org.tbot.util.Condition;
import scripts.VarrockTabber.Vars;
import scripts.VarrockTabber.vTabber;

public class MakeTabsNode implements vTabber.Node {
    @Override
    public boolean activate() {
        return Vars.TAB_CREATION_INTERFACE.isOnScreen()
                && Inventory.getCount(Vars.S_CLAY_ID) >= 1
                && Vars.CREATE_TAB_WIDGET.hasAction("Make-All");
    }

    @Override
    public int run() {
        Vars.CREATE_TAB_WIDGET.interact("Make-All");
        Time.sleepUntil(new Condition() {
            @Override
            public boolean check() {
                return !Vars.TAB_CREATION_INTERFACE.isOnScreen() && Players.getLocal().getAnimation() != -1;
            }
        }, Random.nextInt(2000, 2500));
        return Random.nextInt(100, 250);
    }
}