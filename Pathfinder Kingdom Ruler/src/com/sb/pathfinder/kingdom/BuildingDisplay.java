package com.sb.pathfinder.kingdom;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.sb.util.ConsoleTable;

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
	LinkedHashMap<Building, LinkedHashMap<String, Integer>> modifiers = getKingdomModifiers(buildings,
		displayCost);

	display(buildings, modifiers);
    }

    private static void display(Iterable<Building> buildings,
	    LinkedHashMap<Building, LinkedHashMap<String, Integer>> modifiers) {
	// Find all the modifiers used at least once
	Set<String> usedModifiers = new LinkedHashSet<>();
	for (String modifier : ((LinkedHashMap<String, Integer>) (modifiers.values())).keySet())
	    usedModifiers.add(modifier);

	// Build a header containing all the used modifiers
	ConsoleTable table = new ConsoleTable(getLongestLength(usedModifiers), usedModifiers.size() + 1);
	table.newRow();
	// One empty cell
	table.addField("");
	// Start building header
	for (String modifier : usedModifiers)
	    table.addField(modifier);

	// Each row follow the format: <Building name><modifier1><modifier2>...
	Iterator<Building> buildingsIterator = buildings.iterator();
	Integer currentModifier;
	for (LinkedHashMap<String, Integer> buildingModifiers : modifiers.values()) {
	    table.newRow();
	    Building building = buildingsIterator.next();
	    table.addField(building.getName());
	    for (String modifier : usedModifiers) {
		currentModifier = buildingModifiers.get(modifier);
		table.addField(currentModifier != null ? currentModifier.toString() : "");
	    }
	}
	table.display();
    }

    public static void displaySettlementModifiers(Building building) {
	displaySettlementModifiers(building, null, true);
    }

    public static void displaySettlementModifiers(Building building, ConsoleTable table, boolean newRow) {
	Map<String, Integer> content = getSettlementModifiers(building);
	if (table == null)
	    table = new ConsoleTable(getLongestLength(content.keySet()), content.size());
	addToTable(table, newRow, content);
	table.display();
    }

    public static void displaySettlementModifiers(Iterable<Building> buildings, boolean displayCost) {
	LinkedHashMap<Building, LinkedHashMap<String, Integer>> modifiers = getSettlementModifiers(buildings,
		displayCost);

	display(buildings, modifiers);
    }

    public static LinkedHashMap<String, Integer> getSettlementModifiers(Building building) {
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
	LinkedHashMap<String, Integer> content = new LinkedHashMap<>();
	if (corruption != 0)
	    content.put("Corruption", corruption);
	if (criminality != 0)
	    content.put("Criminality", criminality);
	if (law != 0)
	    content.put("Law", law);
	if (lore != 0)
	    content.put("Lore", lore);
	if (productivity != 0)
	    content.put("Productivity", productivity);
	if (society != 0)
	    content.put("Society", society);
	if (defense != 0)
	    content.put("Defense", defense);

	return content;
    }

    public static LinkedHashMap<Building, LinkedHashMap<String, Integer>> getSettlementModifiers(
	    Iterable<Building> buildings, boolean displayCost) {
	LinkedHashMap<Building, LinkedHashMap<String, Integer>> modifiers = new LinkedHashMap<>();
	for (Building building : buildings)
	    modifiers.put(building, getSettlementModifiers(building));
	return modifiers;
    }

    public static void displayKingdomModifiers(Building building, boolean displayCost) {
	displayKingdomModifiers(building, displayCost, null, true);
    }

    public static void displayKingdomModifiers(Building building, boolean displayCost, ConsoleTable table,
	    boolean newRow) {
	Map<String, Integer> content = getKingdomModifiers(building, displayCost);
	if (table == null)
	    table = new ConsoleTable(getLongestLength(content.keySet()), content.size());
	addToTable(table, newRow, content);
	table.display();
    }

    public static LinkedHashMap<String, Integer> getKingdomModifiers(Building building, boolean getCost) {
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
	LinkedHashMap<String, Integer> content = new LinkedHashMap<>();
	if (economy != 0)
	    content.put("Economy", economy);
	if (loyalty != 0)
	    content.put("Loyalty", loyalty);
	if (stability != 0)
	    content.put("Stability", stability);
	if (unrest != 0)
	    content.put("Unrest", unrest);
	if (consumption != 0)
	    content.put("Consumption", consumption);
	if (glory != 0)
	    content.put("Glory", glory);
	if (infamy != 0)
	    content.put("Infamy", infamy);

	if (getCost)
	    content.put("Cost", building.getConstructionCost());

	return content;
    }

    public static LinkedHashMap<Building, LinkedHashMap<String, Integer>> getKingdomModifiers(
	    Iterable<Building> buildings, boolean displayCost) {
	LinkedHashMap<Building, LinkedHashMap<String, Integer>> modifiers = new LinkedHashMap<>();
	for (Building building : buildings)
	    modifiers.put(building, getKingdomModifiers(building, displayCost));
	return modifiers;
    }

    private static void addToTable(ConsoleTable table, boolean newRow, Map<String, Integer> content) {
	if (newRow) {
	    table.newRow();
	    // Make header
	    for (String title : content.keySet())
		table.addField(title);
	    table.newRow();
	}
	for (int value : content.values())
	    table.addField(Integer.toString(value));
    }

    private static int getLongestLength(Iterable<String> strs) {
	int length = 0;
	for (String str : strs)
	    if (str.length() > length)
		length = str.length();
	return length;
    }

    public static void main(String[] args) {
	Building building = new Building("Test Building", 5, 16);
	building.setEconomy(5);
	building.setUnrest(-2);
	building.setCriminality(1);
	building.setProductivity(2);
	building.setLore(-1);
	display(building, true);
    }
}