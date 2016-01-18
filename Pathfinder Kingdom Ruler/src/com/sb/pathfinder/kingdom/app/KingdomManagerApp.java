package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuElement;
import com.sb.menu.OptionsMenu;
import com.sb.pathfinder.kingdom.Kingdom;

public class KingdomManagerApp {
    
    public static Kingdom kingdom;
    
    public static void main(String[] args) {
	OptionsMenu mainMenu = new OptionsMenu("Main menu");
	
	// Register the different menu options
	mainMenu.add(new MenuElement() {
	    
	    @Override
	    public void open() {
		
	    }
	    
	    @Override
	    public String getName() {
		return "Display kingdom state";
	    }
	});
    }
}
