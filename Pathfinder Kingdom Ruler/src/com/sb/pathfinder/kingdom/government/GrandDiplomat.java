package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.rpg.RPGCharacter;

public class GrandDiplomat extends LeadershipRole {

    public GrandDiplomat(String title, RPGCharacter character, boolean unavailable) {
	super(title, character, unavailable);
    }

    @Override
    public void applyTo(Kingdom kingdom) {
	calculateChange();
	kingdom.modStability(change);
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	kingdom.modStability(-change);
    }

    @Override
    protected void calculateChange() {
	if (isUnavailable()) {
	    change = -2;
	} else {
	    if (character.getIntelligence() >= character.getCharisma())
		change = RPGCharacter.getAttributeModifier(character.getIntelligence());
	    else
		change = RPGCharacter.getAttributeModifier(character.getCharisma());
	}
    }

}
