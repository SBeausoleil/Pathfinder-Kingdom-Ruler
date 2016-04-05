package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Government;
import com.sb.util.ConsoleTables;

public class GovernmentDisplay {

    public static void displayCurrentEffects(Government gov) {
	// Acquire all the modifiers' descriptions (except for empty modifiers)
	LinkedHashMap<String, LinkedHashMap<String, String>> modifiers = new LinkedHashMap<>();
	gov.leadersDo((role) -> {
	    if (role.getCurrentEffect().getClass() != EmptyLeaderKingdomModifier.class)
		modifiers.put(role.getTitle(), role.getCurrentEffect().describe());
	});
	ConsoleTables.display(modifiers);
    }

    public static void displayBonuses(Government gov) {
	// Acquire all the modifiers' descriptions (except for empty modifiers)
	LinkedHashMap<String, LinkedHashMap<String, String>> modifiers = new LinkedHashMap<>();
	gov.leadersDo((role) -> {
	    if (role.getBonus().getClass() != EmptyLeaderKingdomModifier.class)
		modifiers.put(role.getTitle(), role.getBonus().describe());
	});
	ConsoleTables.display(modifiers);
    }

    public static void displayPenalties(Government gov) {
	// Acquire all the modifiers' descriptions (except for empty modifiers)
	LinkedHashMap<String, LinkedHashMap<String, String>> modifiers = new LinkedHashMap<>();
	gov.leadersDo((role) -> {
	    if (role.getPenalty().getClass() != EmptyLeaderKingdomModifier.class)
		modifiers.put(role.getTitle(), role.getPenalty().describe());
	});
	ConsoleTables.display(modifiers);
    }
}
