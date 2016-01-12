package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomLoyaltyModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class General extends LeadershipRole {

    public static final int LOYALTY_PENALTY = -4;
    
    public General(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new GeneralBonus());
	setPenalty(new KingdomLoyaltyModifier(LOYALTY_PENALTY));
    }

    public class GeneralBonus extends SavedKingdomModifier {

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getCharisma() >= character.getStrength() ? character.getCharisma() : character.getStrength();
	    change = RPGCharacter.getAttributeModifier(change);
	    kingdom.modStability(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modStability(-change);
	}
	
    }
}
