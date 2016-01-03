package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.rpg.RPGCharacter;

public class HighPriest extends LeadershipRole {

    /**
     * Used to keep track of when coming back from a period of absence to keep in mind to remove the
     * loyalty penality.
     */
    private boolean wasAbsent;

    public HighPriest(String title, RPGCharacter character, boolean unavailable) {
	super(title, character, unavailable);
    }

    @Override
    public void applyTo(Kingdom kingdom) {
	calculateChange(); // TODO Fix stacking absence penalties across all LeadershipRoles
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	// TODO Auto-generated method stub

    }

    @Override
    protected void calculateChange() {
	if (isUnavailable()) {
	    change = -2;
	    wasAbsent = true;
	} else {
	    if (character.getWisdom() >= character.getCharisma())
		change = RPGCharacter.getAttributeModifier(character.getWisdom());
	    else
		change = RPGCharacter.getAttributeModifier(character.getCharisma());
	}
    }

}
