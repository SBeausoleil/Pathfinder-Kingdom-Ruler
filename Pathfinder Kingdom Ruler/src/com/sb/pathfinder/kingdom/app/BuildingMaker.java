package com.sb.pathfinder.kingdom.app;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;

import com.sb.menu.MenuUtil;
import com.sb.pathfinder.kingdom.Building;

public class BuildingMaker {

    public static Building createBuilding(boolean saveInAppData) {
	Building building = new Building("New building", 0, 0);
	editBuilding(building, null, saveInAppData);
	return building;
    }

    public static void editBuilding(Building building, boolean saveInAppData) {
	editBuilding(building, null, saveInAppData);
    }
    
    public static void editBuilding(Building building, String nameHint, boolean saveInAppData) {

	//@formatter:off
	// Kingdom properties
	building.setUnrest(MenuUtil.requestInt("Unrest (" + building.getUnrest() + "): ", building.getUnrest()));
	building.setEconomy(MenuUtil.requestInt("Economy (" + building.getEconomy() + "): ", building.getEconomy()));
	building.setLoyalty(MenuUtil.requestInt("Loyalty (" + building.getLoyalty() + "): ", building.getLoyalty()));
	building.setStability(MenuUtil.requestInt("Stability (" + building.getStability() + "): ", building.getStability()));
	building.setConsumption(MenuUtil.requestInt("Consumption (" + building.getConsumption() + "): ", building.getConsumption()));
	building.setGlory(MenuUtil.requestInt("Glory (" + building.getGlory() + "): ", building.getGlory()));
	building.setInfamy(MenuUtil.requestInt("Infamy (" + building.getInfamy() + ") :", building.getInfamy()));

	// Settlement Properties
	building.setCorruption(MenuUtil.requestInt("Corruption (" + building.getCorruption() + "): ", building.getCorruption()));
	building.setCriminality(MenuUtil.requestInt("Criminality (" + building.getCriminality() + "): ", building.getCriminality()));
	building.setLaw(MenuUtil.requestInt("Law (" + building.getLaw() + "): ", building.getLaw()));
	building.setLore(MenuUtil.requestInt("Lore (" + building.getLore() + "): ", building.getLore()));
	building.setProductivity(MenuUtil.requestInt("Productivity (" + building.getProductivity() + "): ", building.getProductivity()));
	building.setSociety(MenuUtil.requestInt("Society (" + building.getSociety() + "): ", building.getSociety()));
	building.setDefense(MenuUtil.requestInt("Defense (" + building.getDefense() + "): ", building.getDefense()));

	// Building properties
	String name = resolveName(building, nameHint);
	Search search = new Search(AppData.getInstance().getBuildings(), name, false, null, null);
	Search reverse = new Search(AppData.getInstance().getBuildings(), name, true, null, null);
	do {
	    System.out.print("Name (" + name + "): ");
	    MenuUtil.keyboard.nextLine();
	} while (nameExists(name, search, reverse, new CountDownLatch(AppData.getInstance().getBuildings().size())));
	building.setUsedLots(MenuUtil.requestInt("Used lots (" + building.getUsedLots() + "): ", building.getUsedLots()));
	building.setConstructionCost(MenuUtil.requestInt("Construction cost (" + building.getConstructionCost() + ") :", building.getConstructionCost()));
	//@formatter:on
	
	if (saveInAppData)
	    AppData.getInstance().getBuildings().add(building);
    }
    
    /**
     * Generates a name for the building
     * 
     * @param building
     * @return
     */
    private static String resolveName(Building building, String nameHint) {
	StringBuilder builder = new StringBuilder();
	if (nameHint != null && !nameHint.isEmpty())
	    builder.append(nameHint);

	builder.append(" ");
	builder.append(building.getName());

	// Check if there is another building with the same name
	return resolveNameNumber(builder.toString(), AppData.getInstance().getBuildings());
    }

    public static String resolveNameNumber(String base, List<Building> buildings) {
	String resolvedName = base;
	int number = 2;
	Search search = new Search(buildings, base, false, null, null);
	Search reverse = new Search(buildings, base, true, null, null);

	List<String> closeMatches = Collections.synchronizedList(new LinkedList<String>());
	search.closeMatches = closeMatches;
	reverse.closeMatches = closeMatches;

	// Check if the name exists
	while (nameExists(resolvedName, search, reverse, new CountDownLatch(buildings.size())))
	    // -- Yes: add a number to the end of the base then check again
	    resolvedName = base + number;
	return resolvedName;
    }

    private static boolean nameExists(String name, Search search, Search reverse, CountDownLatch latch) {
	ConcurrentBoolean found = new ConcurrentBoolean(false);
	search.found = found;
	reverse.found = found;

	search.latch = latch;
	reverse.latch = latch;

	Thread reverseThread = new Thread(reverse);

	reverseThread.start();
	search.run();
	return found.isTrue();
    }


    private static class Search implements Runnable {

	private List<Building>	  buildings;
	/**
	 * Stores building names that are closely matching to the sought name.
	 */
	private List<String>	  closeMatches;
	private String		  name;
	private boolean		  reverse;
	private CountDownLatch	  latch;
	private ConcurrentBoolean found;

	Search(List<Building> buildings, String name, boolean reverse, CountDownLatch latch, ConcurrentBoolean found) {
	    this.buildings = buildings;
	    this.name = name;
	    this.reverse = reverse;
	    this.latch = latch;
	    this.found = found;
	}

	@Override
	public void run() {
	    if (closeMatches != null && !closeMatches.isEmpty())
		searchInCloseMatches();
	    else
		searchInBuildings();
	}

	private void searchInCloseMatches() {
	    synchronized (closeMatches) {
		ListIterator<String> iterator = reverse ? closeMatches.listIterator(closeMatches.size())
			: closeMatches.listIterator();

		while (!found.isTrue() && latch.getCount() > 0) {
		    String current = reverse ? iterator.previous() : iterator.next();
		    if (current.equals(name))
			found.set(true);
		    latch.countDown();
		}
	    }
	}

	private void searchInBuildings() {
	    ListIterator<Building> iterator = reverse ? buildings.listIterator(buildings.size())
		    : buildings.listIterator();

	    while (!found.isTrue() && latch.getCount() > 0) {
		Building current = reverse ? iterator.previous() : iterator.next();
		if (current.getName().contains(name))
		    closeMatches.add(current.getName());
		if (current.getName().equals(name))
		    found.set(true);
		latch.countDown();
	    }
	}
    }

    private static class ConcurrentBoolean {
	private boolean bool;

	ConcurrentBoolean(boolean bool) {
	    this.bool = bool;
	}

	/**
	 * Returns the bool.
	 * 
	 * @return the bool
	 */
	public boolean isTrue() {
	    return bool;
	}

	/**
	 * Sets the value of bool to that of the parameter.
	 * 
	 * @param bool
	 *            the bool to set
	 */
	public synchronized void set(boolean bool) {
	    this.bool = bool;
	}
    }
}
