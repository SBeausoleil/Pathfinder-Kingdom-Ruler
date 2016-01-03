package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.rpg.RPGCharacter;

public class Councilor extends LeadershipRole {

    public Councilor(String title, RPGCharacter character, boolean unavailable) {
	super(title, character, unavailable);
    }

    @Override
    public void applyTo(Kingdom kingdom) {
	calculateChange();
	kingdom.modLoyalty(change);
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	kingdom.modLoyalty(-change);
    }

    @Override
    protected void calculateChange() {
	if (isUnavailable()) {
	    change = -2;
	} else {
	    if (character.getWisdom() >= character.getCharisma())
		change = RPGCharacter.getAttributeModifier(character.getWisdom());
	    else
		change = RPGCharacter.getAttributeModifier(character.getCharisma());
	}
    }

}
