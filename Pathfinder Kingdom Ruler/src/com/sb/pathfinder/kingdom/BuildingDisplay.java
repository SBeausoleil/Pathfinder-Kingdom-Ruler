package com.sb.pathfinder.kingdom;

import java.util.LinkedHashMap;
import java.util.Map;

import com.sb.util.ConsoleTable;
import com.sb.util.ConsoleTables;
import com.sb.util.Strings;

public class BuildingDisplay {

    public static void display(Building building, boolean displayCost) {
	displayKingdomModifiers(building, displayCost);
	displaySettlementModifiers(building);
    }

    public static void display(Building building, boolean displayCost, ConsoleTable table, boolean newRow) {
	displayKingdomModifiers(building, displayCost, table, newRow);
	displaySettlementModifiers(building, table, newRow);
    }

    public static void display(Iterable<Building> buildings, boolean displayCost) {
	displayKingdomModifiers(buildings, displayCost);
    }

    public static void displayKingdomModifiers(Iterable<Building> buildings, boolean displayCost) {
	LinkedHashMap<String, LinkedHashMap<String, String>> modifiers = getKingdomModifiers(buildings,
		displayCost);

	ConsoleTables.display(modifiers);
    }

    public static void displaySettlementModifiers(Building building) {
	displaySettlementModifiers(building, null, true);
    }

    public static void displaySettlementModifiers(Building building, ConsoleTable table, boolean newRow) {
	Map<String, String> content = getSettlementModifiers(building);
	if (table == null)
	    table = new ConsoleTable(Strings.getLongestLength(content.keySet()), content.size());
	addToTable(table, newRow, content);
	table.display();
    }

    public static void displaySettlementModifiers(Iterable<Building> buildings, boolean displayCost) {
	LinkedHashMap<String, LinkedHashMap<String, String>> modifiers = getSettlementModifiers(buildings,
		displayCost);

	ConsoleTables.display(modifiers);
    }

    public static LinkedHashMap<String, String> getSettlementModifiers(Building building) {
	// @formatter:off
	int corruption	 = building.getCorruption();
	int criminality	 = building.getCriminality();
	int law		 = building.getLaw();
	int lore	 = building.getLore();
	int productivity = building.getProductivity();
	int society	 = building.getSociety();
	int defense	 = building.getDefense();
	// @formatter:on
	// If the modifier is non-zero, add it to the content map
	LinkedHashMap<String, String> content = new LinkedHashMap<>();
	if (corruption != 0)
	    content.put("Corruption", Integer.toString(corruption));
	if (criminality != 0)
	    content.put("Criminality", Integer.toString(criminality));
	if (law != 0)
	    content.put("Law", Integer.toString(law));
	if (lore != 0)
	    content.put("Lore", Integer.toString(lore));
	if (productivity != 0)
	    content.put("Productivity", Integer.toString(productivity));
	if (society != 0)
	    content.put("Society", Integer.toString(society));
	if (defense != 0)
	    content.put("Defense", Integer.toString(defense));

	return content;
    }

    public static LinkedHashMap<String, LinkedHashMap<String, String>> getSettlementModifiers(
	    Iterable<Building> buildings, boolean displayCost) {
	LinkedHashMap<String, LinkedHashMap<String, String>> modifiers = new LinkedHashMap<>();
	for (Building building : buildings)
	    modifiers.put(building.getName(), getSettlementModifiers(building));
	return modifiers;
    }

    public static void displayKingdomModifiers(Building building, boolean displayCost) {
	displayKingdomModifiers(building, displayCost, null, true);
    }

    public static void displayKingdomModifiers(Building building, boolean displayCost, ConsoleTable table,
	    boolean newRow) {
	Map<String, String> content = getKingdomModifiers(building, displayCost);
	if (table == null)
	    table = new ConsoleTable(Strings.getLongestLength(content.keySet()), content.size());
	addToTable(table, newRow, content);
	table.display();
    }

    public static LinkedHashMap<String, String> getKingdomModifiers(Building building, boolean getCost) {
	// Get kingdom modifier
	// @formatter:off
	int economy	= building.getEconomy();
	int loyalty	= building.getLoyalty();
	int stability	= building.getStability();
	int unrest	= building.getUnrest();
	int consumption	= building.getConsumption();
	int glory	= building.getGlory();
	int infamy	= building.getInfamy();
	// @formatter:on
	// If the modifier is non-zero, add it to the content map
	LinkedHashMap<String, String> content = new LinkedHashMap<>();
	if (economy != 0)
	    content.put("Economy", Integer.toString(economy));
	if (loyalty != 0)
	    content.put("Loyalty", Integer.toString(loyalty));
	if (stability != 0)
	    content.put("Stability", Integer.toString(stability));
	if (unrest != 0)
	    content.put("Unrest", Integer.toString(unrest));
	if (consumption != 0)
	    content.put("Consumption", Integer.toString(consumption));
	if (glory != 0)
	    content.put("Glory", Integer.toString(glory));
	if (infamy != 0)
	    content.put("Infamy", Integer.toString(infamy));

	if (getCost)
	    content.put("Cost", Integer.toString(building.getConstructionCost()));

	return content;
    }

    public static LinkedHashMap<String, LinkedHashMap<String, String>> getKingdomModifiers(
	    Iterable<Building> buildings, boolean displayCost) {
	LinkedHashMap<String, LinkedHashMap<String, String>> modifiers = new LinkedHashMap<>();
	for (Building building : buildings)
	    modifiers.put(building.getName(), getKingdomModifiers(building, displayCost));
	return modifiers;
    }

    private static void addToTable(ConsoleTable table, boolean newRow, Map<String, String> content) {
	if (newRow) {
	    table.newRow();
	    // Make header
	    for (String title : content.keySet())
		table.addField(title);
	    table.newRow();
	}
	for (String value : content.values())
	    table.addField(value);
    }
}