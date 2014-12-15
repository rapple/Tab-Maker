package scripts.VarrockTabber;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.tbot.gui.frame.TFrame;
import org.tbot.gui.frame.TFrameShadowBorder;
import org.tbot.gui.menu.TButton;

/**
 * Created by Jordan on 12/14/2014.
 */
public class GUI extends TFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public GUI() {
        this.setVisible(true);
        this.setTitle("AIO Tab Maker");
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(TFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JLabel label1 = new JLabel("AIO Tab Maker");
        panel.add(label1);
        JLabel label2 = new JLabel("- JJordan");
        panel.add(label2);

        String[] butlerOptions = {"Normal Butler", "Demon Butler"};
        final JComboBox box1 = new JComboBox(butlerOptions);
        box1.setEnabled(false);
        panel.add(box1);

        String[] tabOptions = {"Varrock", "Lumbridge", "Falador", "Camelot", "Ardougne", "House"};
        final JComboBox box2 = new JComboBox(tabOptions);
        panel.add(box2);

        TButton startButton = new TButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vars.BUTLER_INDEX = box1.getSelectedIndex();
                Vars.TAB_INDEX = box2.getSelectedIndex();

                if(Vars.BUTLER_INDEX == 0) {
                    Vars.BUTTLER_ID = Vars.NORMAL_BUTLER_ID;
                } else {
                    Vars.BUTTLER_ID = Vars.DEMON_BUTLER_ID;
                }

                if(Vars.TAB_INDEX == 0) {

                    Vars.TAB_ID = Vars.V_TAB_ID;
                    Vars.CREATE_TAB_WIDGET = Vars.TAB_CREATION_INTERFACE_VARROCK;

                } else if(Vars.TAB_INDEX == 1) {

                    Vars.TAB_ID = Vars.L_TAB_ID;
                    Vars.CREATE_TAB_WIDGET = Vars.TAB_CREATION_INTERFACE_LUMBRIDGE;

                } else if(Vars.TAB_INDEX == 2) {

                    Vars.TAB_ID = Vars.F_TAB_ID;
                    Vars.CREATE_TAB_WIDGET = Vars.TAB_CREATION_INTERFACE_FALADOR;

                } else if(Vars.TAB_INDEX == 3) {

                    Vars.TAB_ID = Vars.C_TAB_ID;
                    Vars.CREATE_TAB_WIDGET = Vars.TAB_CREATION_INTERFACE_CAMELOT;

                } else if(Vars.TAB_INDEX == 4) {

                    Vars.TAB_ID = Vars.A_TAB_ID;
                    Vars.CREATE_TAB_WIDGET = Vars.TAB_CREATION_INTERFACE_ARDY;

                } else if(Vars.TAB_INDEX == 5) {

                    Vars.TAB_ID = Vars.H_TAB_ID;
                    Vars.CREATE_TAB_WIDGET = Vars.TAB_CREATION_INTERFACE_HOUSE;

                }
                setVisible(false);
            }
        });
        panel.add(startButton);

        this.pack();


    }

}

