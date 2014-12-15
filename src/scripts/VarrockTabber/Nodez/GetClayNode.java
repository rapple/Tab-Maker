package scripts.VarrockTabber.Nodez;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.*;
import org.tbot.methods.input.keyboard.Keyboard;
import org.tbot.methods.tabs.Inventory;
import org.tbot.util.Condition;
import org.tbot.wrappers.NPC;
import scripts.VarrockTabber.Vars;
import scripts.VarrockTabber.vTabber;

public class GetClayNode implements vTabber.Node {

    @Override
    public boolean activate() {
        NPC butler = Npcs.getNearest(Vars.BUTTLER_ID);
        return ((Vars.TALK_1_CONTINUE.isOnScreen() && Widgets.getWidget(241,2).containsText("Yes, sir?"))
                || Vars.TALK_2_TO_BANK.isOnScreen()
                || Vars.TALK_3_BRING_FROM_BANK.isOnScreen()
                || Vars.TALK_4_CONTINUE.isOnScreen()
                || Vars.TALK_5_CONTINUE.isOnScreen()
                || Vars.TALK_6_MORE.isOnScreen()
                || Vars.TALK_7_SOFT_CLAY.isOnScreen()
                || Vars.ENTER_AMOUNT_INTERFACE.isValid()
                || (Vars.TALK_8_CONTINUE.isOnScreen() && Widgets.getWidget(241,2).containsText("Very good, sir."))
                && Players.getLocal().getAnimation() == -1
                && butler != null);
    }

    @Override
    public int run() {
        if(Vars.TALK_1_CONTINUE.isOnScreen() && Widgets.getWidget(241,2).containsText("Yes, sir?")) {
            Vars.TALK_1_CONTINUE.click(true);
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return Vars.TALK_2_TO_BANK.isOnScreen();
                }
            }, Random.nextInt(1000, 1500));

        } else if(Vars.TALK_2_TO_BANK.isOnScreen() && Vars.TALK_2_TO_BANK.containsText("Go to the bank")) {
            Vars.TALK_2_TO_BANK.click(true);
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return Vars.TALK_3_BRING_FROM_BANK.isOnScreen();
                }
            }, Random.nextInt(1000, 1500));

        } else if(Vars.TALK_3_BRING_FROM_BANK.isOnScreen()) {
            Vars.TALK_3_BRING_FROM_BANK.click(true);
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return Vars.TALK_4_CONTINUE.isOnScreen();
                }
            }, Random.nextInt(1000, 1500));

        } else if(Vars.TALK_4_CONTINUE.isOnScreen()) {
            Vars.TALK_4_CONTINUE.click(true);
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return Vars.TALK_5_CONTINUE.isOnScreen();
                }
            }, Random.nextInt(1000, 1500));

        } else if(Vars.TALK_5_CONTINUE.isOnScreen()) {
            Vars.TALK_5_CONTINUE.click(true);
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return Vars.TALK_6_MORE.isOnScreen();
                }
            }, Random.nextInt(1000, 1500));

        } else if(Vars.TALK_6_MORE.isOnScreen() && Vars.TALK_6_MORE.containsText("More")
                && (!Vars.TALK_7_SOFT_CLAY.isOnScreen() || Widgets.getWidget(234,1).containsText("Wooden planks"))) {

            Vars.TALK_6_MORE.click(true);
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return Vars.TALK_7_SOFT_CLAY.isOnScreen();
                }
            }, Random.nextInt(1000, 1500));
            Time.sleep(500, 800);

        } else if(Vars.TALK_7_SOFT_CLAY.isOnScreen() && Vars.TALK_7_SOFT_CLAY.containsText("Soft clay")) {
            Vars.TALK_7_SOFT_CLAY.click(true);
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return Vars.ENTER_AMOUNT_INTERFACE.isValid();
                }
            }, Random.nextInt(1000, 1500));

        } else if(Vars.ENTER_AMOUNT_INTERFACE.isValid()) {
            Keyboard.sendText("20", true);
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return Vars.TALK_8_CONTINUE.isOnScreen();
                }
            }, Random.nextInt(1000, 1500));

        } else if(Vars.TALK_8_CONTINUE.isOnScreen() && Widgets.getWidget(241,2).containsText("Very good, sir.")) {
            Vars.TALK_8_CONTINUE.click(true);
            Time.sleepUntil(new Condition() {
                @Override
                public boolean check() {
                    return !Vars.TALK_8_CONTINUE.isOnScreen();
                }
            }, Random.nextInt(1000, 1500));
        }

        return Random.nextInt(250, 500);
    }
}