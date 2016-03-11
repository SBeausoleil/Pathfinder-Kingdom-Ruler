package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomEconomyModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class Magister extends LeadershipRole {

    private static final long serialVersionUID = 3339813729402004117L;
    
    public static final int ECONOMY_PENALTY = -2;
    
    public Magister(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new MagisterBonus());
	setPenalty(new KingdomEconomyModifier(ECONOMY_PENALTY));
    }

    public class MagisterBonus extends SavedKingdomModifier {

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getCharisma() >= character.getIntelligence() ? character.getCharisma() : character.getIntelligence();
	    change = RPGCharacter.getAttributeModifier(change);
	    
	    kingdom.modEconomy(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modEconomy(-change);
	}
	
    }

}
