package scripts.VarrockTabber.Nodez;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.*;
import org.tbot.methods.tabs.Inventory;
import org.tbot.methods.walking.Walking;
import org.tbot.util.Condition;
import org.tbot.wrappers.NPC;
import scripts.VarrockTabber.Vars;
import scripts.VarrockTabber.vTabber;

public class InteractButlerNode implements vTabber.Node {

    @Override
    public boolean activate() {
        try {
            NPC butler = new Npcs().getNearest(Vars.BUTTLER_ID);
            return (butler.distance() < 5 && butler != null
                    && Inventory.getCount(Vars.S_CLAY_ID) == 0
                    && Players.getLocal().getAnimation() == -1
                    && !(Vars.TALK_1_CONTINUE.isOnScreen()
                    && Walking.canReach(butler.getLocation())
                    || Vars.TALK_2_TO_BANK.isOnScreen()
                    || Vars.TALK_3_BRING_FROM_BANK.isOnScreen()
                    || Vars.TALK_4_CONTINUE.isOnScreen()
                    || Vars.TALK_5_CONTINUE.isOnScreen()
                    || Vars.TALK_6_MORE.isOnScreen()
                    || Vars.TALK_7_SOFT_CLAY.isOnScreen()
                    || Vars.ENTER_AMOUNT_INTERFACE.isValid()
                    || Vars.TALK_8_CONTINUE.isOnScreen()))
                    || (butler.distance() < 5 && butler != null
                            && Inventory.getCount(Vars.S_CLAY_ID) < 4
                            && Players.getLocal().getAnimation() != -1
                            && !(Vars.TALK_1_CONTINUE.isOnScreen()
                            && Walking.canReach(butler.getLocation())
                            || Vars.TALK_2_TO_BANK.isOnScreen()
                            || Vars.TALK_3_BRING_FROM_BANK.isOnScreen()
                            || Vars.TALK_4_CONTINUE.isOnScreen()
                            || Vars.TALK_5_CONTINUE.isOnScreen()
                            || Vars.TALK_6_MORE.isOnScreen()
                            || Vars.TALK_7_SOFT_CLAY.isOnScreen()
                            || Vars.ENTER_AMOUNT_INTERFACE.isValid()
                            || Vars.TALK_8_CONTINUE.isOnScreen()));

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int run() {
        NPC butler = new Npcs().getNearest(Vars.BUTTLER_ID);
            if (butler.isMoving() && !Players.getLocal().isMoving()) {
                double mp = Mouse.getSpeed();
                Mouse.setSpeed(Random.nextInt(30, 40));
                butler.interact("Talk-to");
                Time.sleepUntil(new Condition() {
                    @Override
                    public boolean check() {
                        return Vars.TALK_1_CONTINUE.isOnScreen();
                    }
                }, Random.nextInt(1000, 1500));
                Mouse.setSpeed((int) mp);
            } else if (!Players.getLocal().isMoving()) {
                butler.interact("Talk-to");
                Time.sleepUntil(new Condition() {
                    @Override
                    public boolean check() {
                        return Vars.TALK_1_CONTINUE.isOnScreen();
                    }
                }, Random.nextInt(1000, 1500));
            }
        return Random.nextInt(250, 500);
    }
}