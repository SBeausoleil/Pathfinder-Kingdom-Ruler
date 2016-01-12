package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomStabilityModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class GrandDiplomat extends LeadershipRole {

    public static final int STABILITY_PENALTY = -2;
    
    public GrandDiplomat(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new GrandDiplomatBonus());
	setPenalty(new KingdomStabilityModifier(STABILITY_PENALTY));
    }

    public class GrandDiplomatBonus extends SavedKingdomModifier {

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getCharisma() >= character.getIntelligence() ? character.getCharisma() : character.getIntelligence();
	    change = RPGCharacter.getAttributeModifier(change);
	    
	    kingdom.modStability(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modStability(-change);
	}
	
    }
}
