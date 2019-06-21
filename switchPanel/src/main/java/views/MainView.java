package views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

@Route("")
@PageTitle("MainView")
@StyleSheet("styles.css")
public class MainView extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	// The Div containing all the tabs
	Div tabs = new Div();
	// The Div containing all the top information
	Div topDiv = new Div();
	// The Div containing all the bot information
	Div botDiv = new Div();
	// A div that contains topDiv and botDiv for css styling
	Div cssDiv = new Div();
	//List of Tabs
	final String[] adminTabs = {"Fonts","Tags","Groups"};

	public MainView() {
		_loadTabs();
		_reloadView(adminTabs[0]);
	}

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
		topDiv.removeAll();
		botDiv.removeAll();
		switch(tabName) {
			case "Fonts":
				topDiv.add(new temporaryView1());
				botDiv.add(new temporaryView1());
				break;
			case "Tags":
				topDiv.add(new temporaryView2());
				botDiv.add(new temporaryView2());
				break;
			case "Groups":
				topDiv.add(new temporaryView3());
				botDiv.add(new temporaryView3());
				break;
			default:
				topDiv.add(new temporaryView1());
				botDiv.add(new temporaryView1());
				break;
		}
	}
}
