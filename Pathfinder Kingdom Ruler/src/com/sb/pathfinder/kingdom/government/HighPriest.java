package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class HighPriest extends LeadershipRole {

    private static final long serialVersionUID = 8077238745675927236L;

    public HighPriest(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new HighPriestBonus());
	setPenalty(new HighPriestPenalty());
    }

    public class HighPriestBonus extends SavedKingdomModifier {

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getCharisma() >= character.getWisdom() ? character.getCharisma() : character.getWisdom();
	    change = RPGCharacter.getAttributeModifier(change);
	    
	    kingdom.modStability(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modStability(-change);
	}
	
    }
    
    public class HighPriestPenalty implements KingdomModifier {

	public static final int STABILITY_PENALTY = -2;
	public static final int LOYALTY_PENALTY = -2;
	public static final int UNREST_PENALTY = 1;
	
	@Override
	public void applyTo(Kingdom kingdom) {
	    kingdom.modStability(STABILITY_PENALTY);
	    kingdom.modLoyalty(LOYALTY_PENALTY);
	    kingdom.modUnrest(UNREST_PENALTY);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modStability(-STABILITY_PENALTY);
	    kingdom.modLoyalty(-LOYALTY_PENALTY);
	    kingdom.modUnrest(-UNREST_PENALTY);
	}
	
    }
}
