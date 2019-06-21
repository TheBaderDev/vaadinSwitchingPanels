package common.ui;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@PageTitle("MainView")
@StyleSheet("styles.css")
public class MainView extends VerticalLayout {
    private static final long serialVersionUID = 1L;
    // The Div containing all the tabs
    LeftSideBar tabs = new LeftSideBar();

    // The Div containing all the top information
    Div topDiv = new Div();
    // The Div containing all the bot information
    Div botDiv = new Div();
    // A div that contains topDiv and botDiv for css styling
    Div cssDiv = new Div();

    public MainView() {
        _loadTabs();
        _reloadView(adminTabs[0]);
    }

}
