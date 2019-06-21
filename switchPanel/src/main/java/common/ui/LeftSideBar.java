package common.ui;

import org.apache.log4j.Logger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;

public class LeftSideBar extends Div {
    protected static Logger logger = Logger.getLogger(LeftSideBar.class);

    //List of Tabs
    final String[] adminTabs = { "Fonts", "Tags", "Groups" };

    private void _loadTabs() {
        for (int i = 0; i < adminTabs.length; i++) {
            final int n = i;
            //adds a button for each tab
            Button b = new Button(adminTabs[n], e -> {
                //On-Click the entire view will be reloaded
                _reloadView(adminTabs[n]);
            });
            b.addClassName("button");
            tabs.add(b);
        }
        tabs.addClassName("tabs");
        topDiv.addClassName("topDiv");
        botDiv.addClassName("botDiv");
        cssDiv.addClassName("css");
        cssDiv.add(topDiv, botDiv);
        add(tabs, cssDiv);
        addClassName("all");
    }

    private void _reloadView(String tabName) {
        logger.info("tabName: " + tabName);
        //        topDiv.removeAll();
        //        botDiv.removeAll();
        //        switch (tabName) {
        //        case "Fonts":
        //            topDiv.add(new temporaryView1());
        //            botDiv.add(new temporaryView1());
        //            break;
        //        case "Tags":
        //            topDiv.add(new temporaryView2());
        //            botDiv.add(new temporaryView2());
        //            break;
        //        case "Groups":
        //            topDiv.add(new temporaryView3());
        //            botDiv.add(new temporaryView3());
        //            break;
        //        default:
        //            topDiv.add(new temporaryView1());
        //            botDiv.add(new temporaryView1());
        //            break;
        //        }
    }

}
