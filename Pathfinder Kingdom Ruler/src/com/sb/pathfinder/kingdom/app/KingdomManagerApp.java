package com.sb.pathfinder.kingdom.app;

import java.util.LinkedList;

import com.sb.menu.MenuElement;
import com.sb.menu.OptionsMenu;
import com.sb.pathfinder.kingdom.BuildingDisplay;
import com.sb.pathfinder.kingdom.Kingdom;

public class KingdomManagerApp implements KingdomDependant, MenuElement {

    private static final long serialVersionUID = -2199803296265328815L;

    private static KingdomManagerApp instance = null;

    private Kingdom			 currentKingdom;
    private OptionsMenu			 mainMenu;
    private LinkedList<KingdomDependant> dependants;

    private KingdomManagerApp() {
	mainMenu = new OptionsMenu();
	dependants = new LinkedList<KingdomDependant>();

	// Register the different menu options
	registerMenuElement("Display kingdom state", new KingdomStateDisplay(currentKingdom));
	registerMenuElement("Access settlements", new SettlementAccessor(currentKingdom));
	registerMenuElement("Make a new kingdom", new KingdomMaker());
	registerMenuElement("Select a kingdom", new KingdomSelector());
	registerMenuElement("Create a building", BuildingMaker::createBuilding);
	registerMenuElement("List all buildings", () -> BuildingDisplay.display(AppData.getInstance().getBuildings(), true));
    }

    public static KingdomManagerApp getInstance() {
	if (instance == null)
	    instance = new KingdomManagerApp();
	return instance;
    }

    /**
     * Returns the currentKingdom.
     * 
     * @return the currentKingdom
     */
    @Override
    public Kingdom getCurrentKingdom() {
	return currentKingdom;
    }

    /**
     * Sets the value of currentKingdom to that of the parameter.
     * 
     * @param currentKingdom
     *            the currentKingdom to set
     */
    @Override
    public void setCurrentKingdom(Kingdom currentKingdom) {
	this.currentKingdom = currentKingdom;
	for (KingdomDependant kd : dependants)
	    kd.setCurrentKingdom(currentKingdom);
    }

    /**
     * Returns the mainMenu.
     * 
     * @return the mainMenu
     */
    public OptionsMenu getMainMenu() {
	return mainMenu;
    }

    /**
     * Sets the value of mainMenu to that of the parameter.
     * 
     * @param mainMenu
     *            the mainMenu to set
     */
    public void setMainMenu(OptionsMenu mainMenu) {
	this.mainMenu = mainMenu;
    }

    public boolean registerMenuElement(String name, MenuElement element) {
	if (mainMenu.register(name, element)) {
	    if (element instanceof KingdomDependant)
		dependants.add((KingdomDependant) element);
	    return true;
	}
	return false;
    }

    @Override
    public void open() {
	while (true) {
	    mainMenu.open();
	    System.out.println();
	}
    }

    public static void main(String[] args) {
	KingdomManagerApp app = new KingdomManagerApp();
	app.open();
    }

}
