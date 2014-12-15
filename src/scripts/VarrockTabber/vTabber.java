package scripts.VarrockTabber;

import org.tbot.graphics.MouseTrail;
import org.tbot.internal.AbstractScript;
import org.tbot.internal.Manifest;
import org.tbot.internal.ScriptCategory;
import org.tbot.internal.event.events.MessageEvent;
import org.tbot.internal.event.listeners.MessageListener;
import org.tbot.internal.event.listeners.PaintListener;
import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.*;
import org.tbot.methods.tabs.Inventory;
import org.tbot.wrappers.GameObject;
import org.tbot.wrappers.NPC;
import scripts.VarrockTabber.Nodez.*;
import utils.Timer;

import java.awt.*;

@Manifest(name = "JJsTabber", authors = "JJordan", version = 0.1, description = "Makes Varrock Tabs", category = ScriptCategory.MONEY_MAKING)
public class vTabber extends AbstractScript implements PaintListener, MessageListener {

    private Node[] nodes = new Node[] {new MakeTabsNode(), new FalseButlerNode(), new PayButlerNode(),
            new FindButlerNode(), new InteractButlerNode(), new GetClayNode(),
            new FindLecternNode(), new InteractLecternNode(),
            new AntiBanNode()};

    private MouseTrail mt = new MouseTrail();
    GUI gui = new GUI();

    public interface Node {
        public boolean activate();
        public int run();
    }

    public boolean onStart() {
        if(Vars.BUTLER_INDEX == null && Vars.TAB_INDEX == null && Game.isLoggedIn()) {
            gui.setVisible(true);
            while(gui.isVisible()) {
                Time.sleep(200);
            }
        }

        Vars.startTime = System.currentTimeMillis();
        Vars.startTabs = Inventory.getCount(Vars.TAB_ID);
        Vars.startXP = Skills.getExperience(Skills.Skill.Magic);

        Mouse.setSpeed(Random.nextInt(30, 40));
        Inventory.openTab();

        GameObject lect = GameObjects.getNearest(Vars.LECTERN);
        Vars.MAIN_TILE = Getters.getMainTile(Getters.getObjectConfig(Vars.LECTERN), lect.getLocation());
        return true;
    }

    public void onResume() {

    }

    @Override
    public int loop() {
        for(Node n : nodes) {
            if(n.activate()) {
                return n.run();
            }
        }
        return Random.nextInt(100, 250);
    }

    @Override
    public void messageReceived(MessageEvent messageEvent) {

    }

    @Override
    public void onRepaint(Graphics g) {
        NPC butler = Npcs.getNearest(Vars.BUTTLER_ID);
        Vars.timeRunning = System.currentTimeMillis() - Vars.startTime;
        long hours = Vars.timeRunning / 1000 / 60 / 60 % 24;
        long mins = Vars.timeRunning / 1000 / 60 % 60;
        long secs = Vars.timeRunning / 1000 % 60;
        int tabsMade = Inventory.getCount(8007) - Vars.startTabs;
        int tabsHr = Calculations.getPerHour((double) tabsMade, Vars.timeRunning);
        int xpGained = Skills.getExperience(Skills.Skill.Magic) - Vars.startXP;
        int xpHour = Calculations.getPerHour(xpGained, Vars.timeRunning);
        String time = "Time Running: " + hours + " Hrs " + mins + " Mins " + secs + " Secs ";

        Graphics2D g2 = (Graphics2D)g;
        if(Game.isLoggedIn()) {

            g2.setColor(new Color(255, 255, 255, 90));
            g2.fillRect(285, 348, 210, 45);
            g2.setColor(new Color(255, 255, 255));
            g2.drawRect(285, 348, 210, 45);
            g2.setColor(Color.RED);
            //g2.fillOval((int) Mouse.getLocation().getX() - 4, (int) Mouse.getLocation().getY() - 4, 8, 8);
            g2.drawString(time, 290, 360);
            g2.drawString("Tabs Made: " + tabsMade + " (" + tabsHr + "/h)", 290, 375);
            g2.drawString("Exp: " + xpGained + " (" + xpHour + "/h", 290, 390);


            g.setColor(Color.RED);
            //mt.setColor(Color.RED);
            //mt.draw(g);
            if (!Vars.TAB_CREATION_INTERFACE.isValid()) {
                //butler.getLocation().draw(g);
                Vars.MAIN_TILE.draw(g);
                g.setColor(Color.WHITE);
                g2.drawString("Butler", (int) butler.getLocation().toScreen().getX(), (int) butler.getLocation().toScreen().getY() - 10);
            }
        }
    }
}