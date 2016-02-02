package com.sb.pathfinder.kingdom.app;

import com.sb.menu.OptionsMenu;
import com.sb.pathfinder.kingdom.Kingdom;

public class KingdomManagerApp {
    
    public static Kingdom kingdom;
    
    public static void main(String[] args) {
	OptionsMenu mainMenu = new OptionsMenu();
	
	// Register the different menu options
	mainMenu.register("Display kingdom state", new KingdomStateDisplay(null));
	mainMenu.register("List settlements", new SettlementAccessor(null));
    }
}
