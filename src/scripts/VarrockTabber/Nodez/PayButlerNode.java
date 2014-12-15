package scripts.VarrockTabber.Nodez;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Random;
import org.tbot.methods.Widgets;
import scripts.VarrockTabber.Vars;
import scripts.VarrockTabber.vTabber;

public class PayButlerNode implements vTabber.Node {
    @Override
    public boolean activate() {
        return (Vars.PAY_WIDGET.isValid() && (Vars.PAY_WIDGET.containsText("notice, sir. My fee"))
               || (Widgets.getWidget(230, 1).containsText("Pay servant 5000 coins") && Widgets.getWidget(230, 1).isValid())
               || (Widgets.getWidget(241, 2).containsText("Thank you, sir") && Widgets.getWidget(241,2).isValid()));
    }

    @Override
    public int run() {
        Widgets.getWidget(242, 4).click(true);
        if(Widgets.getWidget(230, 1).containsText("Pay servant 5000 coins") && Widgets.getWidget(230, 1).isOnScreen()) {
            Widgets.getWidget(230, 1).click(true);
        } else if(Widgets.getWidget(241, 2).containsText("Thank you, sir") && Widgets.getWidget(241,2).isOnScreen()) {
            Widgets.getWidget(241,3).click(true);
        }
        return Random.nextInt(250, 500);
    }
}