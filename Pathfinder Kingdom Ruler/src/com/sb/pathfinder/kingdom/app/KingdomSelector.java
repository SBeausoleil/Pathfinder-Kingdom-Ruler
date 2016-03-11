package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuElement;
import com.sb.menu.Selector;
import com.sb.pathfinder.kingdom.Kingdom;

public class KingdomSelector implements MenuElement {

    private static final long serialVersionUID = -6525831733840202342L;
    
    private KingdomManagerApp app;
    
    public KingdomSelector(KingdomManagerApp app) {
	this.app = app;
    }

    @Override
    public void open() {
	Selector<Kingdom> kingdoms = new Selector<>();
	kingdoms.register(AppData.getInstance().getKingdoms(), Kingdom::getName);
	Kingdom selection = kingdoms.select();
	if (selection != Selector.SELECTION_CANCELLED)
	    app.setCurrentKingdom(selection);
    }

}
