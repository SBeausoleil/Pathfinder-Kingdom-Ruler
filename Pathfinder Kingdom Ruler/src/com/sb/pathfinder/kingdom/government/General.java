package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.rpg.RPGCharacter;

public class General extends LeadershipRole {

    public General(String title, RPGCharacter character, boolean unavailable) {
	super(title, character, unavailable);
    }

    @Override
    public void applyTo(Kingdom kingdom) {
	// TODO Auto-generated method stub

    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	// TODO Auto-generated method stub

    }

    @Override
    protected void calculateChange() {
	if (isUnavailable()) {
	    change = -4;
	} else {
	    if (character.getStrength() >= character.getCharisma())
		change = RPGCharacter.getAttributeModifier(character.getStrength());
	    else
		change = RPGCharacter.getAttributeModifier(character.getCharisma());
	}
    }

}
