package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class RoyalEnforcer extends LeadershipRole {

    private static final long serialVersionUID = -4031637687091951403L;

    public RoyalEnforcer(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new RoyalEnforcerBonus());
    }

    public class RoyalEnforcerBonus extends SavedKingdomModifier implements LeaderKingdomModifier {

	private static final long serialVersionUID = 1218789248266853003L;

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getDexterity() >= character.getStrength() ? character.getDexterity()
		    : character.getStrength();
	    change = RPGCharacter.getAttributeModifier(change);

	    kingdom.modLoyalty(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modLoyalty(-change);
	}

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> description = new LinkedHashMap<>();

	    if (isVacant())
		description.put("Loyalty", "Strength|Dexterity modifier");
	    else
		description.put("Loyalty", Integer.toString(change));

	    return description;
	}

    }
}
