package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class RoyalEnforcer extends LeadershipRole {

    public RoyalEnforcer(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new RoyalEnforcerBonus());
    }

    public class RoyalEnforcerBonus extends SavedKingdomModifier {

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getDexterity() >= character.getStrength() ? character.getDexterity() : character.getStrength();
	    change = RPGCharacter.getAttributeModifier(change);
	    
	    kingdom.modLoyalty(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modLoyalty(-change);
	}
	
    }
}
