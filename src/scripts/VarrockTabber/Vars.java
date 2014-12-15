package scripts.VarrockTabber;

import org.tbot.client.Widget;
import org.tbot.methods.GameObjects;
import org.tbot.methods.Npcs;
import org.tbot.methods.Random;
import org.tbot.methods.Widgets;
import org.tbot.wrappers.GameObject;
import org.tbot.wrappers.NPC;
import org.tbot.wrappers.Tile;
import org.tbot.wrappers.WidgetChild;
import utils.Timer;

public class Vars {

    //ITEMS
    public static final int S_CLAY_ID = 1761;
    public static final int V_TAB_ID = 8007;
    public static final int L_TAB_ID = 8008;
    public static final int C_TAB_ID = 8010;
    public static final int A_TAB_ID = 8011;
    public static final int F_TAB_ID = 8009;
    public static final int H_TAB_ID = 8013;


    //NPC
    public static final int NORMAL_BUTLER_ID = 227;
    public static final int DEMON_BUTLER_ID = 123; // GET ID

    //GAME OBJECTS
    public static final int[] LECTERN = {13643};

    //BUTLER WIDGETS
    public static final WidgetChild TALK_1_CONTINUE = Widgets.getWidget(241, 3);
    public static final WidgetChild TALK_2_TO_BANK = Widgets.getWidget(234, 2);
    public static final WidgetChild TALK_3_BRING_FROM_BANK = Widgets.getWidget(228, 2);
    public static final WidgetChild TALK_4_CONTINUE = Widgets.getWidget(64, 3);
    public static final WidgetChild TALK_5_CONTINUE = Widgets.getWidget(242, 4);
    public static final WidgetChild TALK_6_MORE = Widgets.getWidget(234, 5);
    public static final WidgetChild TALK_7_SOFT_CLAY = Widgets.getWidget(234, 1);
    public static final org.tbot.wrappers.Widget ENTER_AMOUNT_INTERFACE = Widgets.getWidget(204);
    public static final WidgetChild TALK_8_CONTINUE = Widgets.getWidget(241, 3);
    public static final WidgetChild PAY_WIDGET = Widgets.getWidget(242, 3);

    //TAB CREATION WIDGETS
    public static final WidgetChild TAB_CREATION_INTERFACE = Widgets.getWidget(79, 0);

    public static final WidgetChild TAB_CREATION_INTERFACE_VARROCK = Widgets.getWidget(79, 11);
    public static final WidgetChild TAB_CREATION_INTERFACE_LUMBRIDGE = Widgets.getWidget(79, 12);
    public static final WidgetChild TAB_CREATION_INTERFACE_FALADOR = Widgets.getWidget(79, 13);
    public static final WidgetChild TAB_CREATION_INTERFACE_CAMELOT = Widgets.getWidget(79, 14);
    public static final WidgetChild TAB_CREATION_INTERFACE_ARDY = Widgets.getWidget(79, 15);
    public static final WidgetChild TAB_CREATION_INTERFACE_HOUSE = Widgets.getWidget(79, 17);



    //TILES
    public static Tile MAIN_TILE = null;

    //PAINT
    public static long startTime = 0;
    public static int startTabs = 0;
    public static long timeRunning = 0;
    public static int startXP = 0;

    //LECTERN CONFIG
    public static final int EAST_FACE = 330;
    public static final int SOUTH_FACE = 394;
    public static final int WEST_FACE = 458;
    public static final int NORTH_FACE = 266;

    //GUI VARS
    public static Integer BUTLER_INDEX = null;
    public static Integer TAB_INDEX = null;
    public static Integer TAB_ID = null;
    public static WidgetChild CREATE_TAB_WIDGET = null;
    public static Integer BUTTLER_ID = null;



}