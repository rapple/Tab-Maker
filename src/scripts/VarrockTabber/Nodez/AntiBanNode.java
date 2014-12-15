package scripts.VarrockTabber.Nodez;

import org.tbot.methods.*;
import scripts.VarrockTabber.Vars;
import scripts.VarrockTabber.vTabber;
import utils.MyMouse;

public class AntiBanNode implements vTabber.Node {
    @Override
    public boolean activate() {
        return (Players.getLocal().getAnimation() == 4068
                && !Vars.TAB_CREATION_INTERFACE.isValid());
    }

    @Override
    public int run() {
        int rand = Random.nextInt(1, 100);
        int rand2 = Random.nextInt(1, 14);
        if(rand >= 1 && rand <= 3) {
            Widgets.openTab(Widgets.TAB_STATS);
            Time.sleep(Random.nextInt(1000, 3000));
            Widgets.openTab(Widgets.TAB_INVENTORY);
        } else
        if(rand >= 4 && rand <= 20) {
            switch (rand2) {
                case 1:
                    Widgets.openTab(Widgets.TAB_COMBAT);
                    Time.sleep(1000, 2000);
                    Widgets.openTab(Widgets.TAB_INVENTORY);
                    break;
                case 2:
                    Widgets.openTab(Widgets.TAB_CLAN);
                    Time.sleep(1000, 2000);
                    Widgets.openTab(Widgets.TAB_INVENTORY);
                    break;
                case 3:
                    Widgets.openTab(Widgets.TAB_EQUIPMENT);
                    Time.sleep(1000, 2000);
                    Widgets.openTab(Widgets.TAB_INVENTORY);
                    break;
                case 4:
                    Widgets.openTab(Widgets.TAB_FRIENDS);
                    Time.sleep(1000, 2000);
                    Widgets.openTab(Widgets.TAB_INVENTORY);
                    break;
                case 5:
                    Widgets.openTab(Widgets.TAB_MAGIC);
                    Time.sleep(1000, 2000);
                    Widgets.openTab(Widgets.TAB_INVENTORY);
                    break;
                case 6:
                    Widgets.openTab(Widgets.TAB_STATS);
                    Time.sleep(1000, 2000);
                    Widgets.openTab(Widgets.TAB_INVENTORY);
                    break;
                case 7:
                    Widgets.openTab(Widgets.TAB_PRAYER);
                    Time.sleep(1000, 2000);
                    Widgets.openTab(Widgets.TAB_INVENTORY);
                    break;
                case 8:
                    Widgets.openTab(Widgets.TAB_QUESTS);
                    Time.sleep(1000, 2000);
                    Widgets.openTab(Widgets.TAB_INVENTORY);
                    break;
                case 9:
                    Widgets.openTab(Widgets.TAB_OPTIONS);
                    Time.sleep(1000, 2000);
                    Widgets.openTab(Widgets.TAB_INVENTORY);
                    break;
            }
        } else
        if(rand >= 21 && rand <= 70) {
            Mouse.moveRandomly();
            if(rand2 >= 7) {
                MyMouse.wiggleMouseRand();
            } else {
                Camera.rotateAndTiltRandomly();
            }
        } else
        if(rand >= 71 && rand <= 100) {
            //if(rand2 < 8) {
            //    Mouse.moveRandomly();
            //}
            //Camera.rotateAndTiltRandomly();
        }
        return Random.nextInt(3000, 7000);
    }
}