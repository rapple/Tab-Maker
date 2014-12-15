package utils.paint;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Timer;

import org.tbot.graphics.MouseTrail;
import org.tbot.methods.Mouse;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.Time;
import org.tbot.wrappers.Tile;

public abstract class Paint extends Graphics {


    public static final Color T_RED = new Color(255, 0, 24, 90);
    public static final Color T_GREEN = new Color(0, 255, 43, 80);

    public static final void paintMouse(Graphics g, MouseTrail mt) {
        Point p = Mouse.getLocation();
        g.setColor(Color.GREEN);
        //g.drawOval((int) p.getX()-4, (int) p.getY()-4, 8, 8);
        //if(Mouse.isPressed()) {
            //g.fillOval((int) p.getX()-4, (int) p.getY()-4, 8, 8);
        //}
        mt.draw(g);
        mt.setColor(Color.GREEN);
    }

    public static final void onClick(Point p, Graphics2D g) {
        double x = p.getX(), y = p.getY();
        g.setColor(Color.GREEN);
        for(int i = 0; i < 20; i++) {
            g.fillOval((int) x-1, (int) y-1, 2, 2);
            x = x + Random.nextInt(-2, 2);
            y = y + Random.nextInt(-2, 2);
            Time.sleep(100);
        }
    }

    public static final void paintAnimation(Graphics g) {
        Point p = Mouse.getLocation();
        Timer t = new Timer(true);
        int x = (int) p.getX(), y = (int) p.getY();
        g.setColor(Color.GREEN);
        g.fillOval(x - 1, y - 1, 2, 2);
        if(Mouse.getClickState() == Mouse.CURSOR_STATE_YELLOW) {
            for(int i = 0; i < 50; i++) {
                g.fillOval(x - 1, y - 1, 2, 2);
                x = x + 2;
                y = y + 2;
            }
        }

    }

    public static final void paintPlayerTile(Graphics g) {
        Tile t = Players.getLocal().getLocation();
        g.setColor(Color.GREEN);
        t.draw(g);
        g.setColor(T_GREEN);
        t.fill(g);
    }

    public static final void paintMovement(Graphics g) {
        Tile x = Players.getLocal().getLocation();
        if(Players.getLocal().isMoving()) {
            g.setColor(Color.GREEN);
            x.draw(g);
            g.setColor(T_GREEN);
            x.fill(g);
        } else {
            g.setColor(Color.RED);
            x.draw(g);
            g.setColor(T_RED);
            x.fill(g);
        }

    }
    // Paints a tile at (x,y) from Tile z
    public static final void paintOtherTile(Graphics g, Tile z, int x, int y) {
        int tx = z.getX() + x;
        int ty = z.getY() + y;
        Tile tn = new Tile(tx, ty);
        g.setColor(Color.GREEN);
        tn.draw(g);
        g.setColor(T_GREEN);
        tn.fill(g);
    }

    public static final void paintOtherTile(Graphics g, Tile z) {
        g.setColor(Color.GREEN);
        z.draw(g);
        g.setColor(T_GREEN);
        z.fill(g);
    }

    public static void paintPaint(Graphics g, Graphics2D g2) {
        final Color color1 = new Color(0, 255, 0, 90);
        final Color color2 = new Color(0, 204, 51, 114);
        final Color color3 = new Color(255, 255, 255);

        final Font font1 = new Font("Impact", 1, 20);
        final Font font2 = new Font("Impact", 1, 14);

        g2.setColor(color1);
        g2.fillRect(345, 14, 163, 110);
        g2.setColor(color2);
        g2.fillRect(351, 21, 151, 33);
        g2.setFont(font1);
        g2.setColor(color3);
        g2.drawString("Script Name", 360, 46);
        g2.setFont(font2);
        g2.drawString("Time: " + "0 : 0 : 0", 360, 68);
        g2.drawString("Profit: ", 360, 83);
        g2.setColor(color3);
        g2.drawString("XP: ", 360, 98);
        g2.drawString("Level: ", 360, 113);



    }

}