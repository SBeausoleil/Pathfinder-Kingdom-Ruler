package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomEconomyModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class Marshal extends LeadershipRole {

    private static final long serialVersionUID = 7116156845531463562L;

    public static final int ECONOMY_PENALTY = -4;

    public Marshal(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new MarshalBonus());
	setPenalty(new KingdomEconomyModifier(ECONOMY_PENALTY));
    }

    public class MarshalBonus extends SavedKingdomModifier implements LeaderKingdomModifier {

	private static final long serialVersionUID = 4472935984385565856L;

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getDexterity() >= character.getWisdom() ? character.getDexterity()
		    : character.getWisdom();
	    change = RPGCharacter.getAttributeModifier(change);

	    kingdom.modEconomy(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modEconomy(-change);
	}

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> description = new LinkedHashMap<>();

	    if (isVacant())
		description.put("Economy", "Dexterity|Wisdom modifier");
	    else
		description.put("Economy", Integer.toString(change));

	    return description;
	}

    }
}
