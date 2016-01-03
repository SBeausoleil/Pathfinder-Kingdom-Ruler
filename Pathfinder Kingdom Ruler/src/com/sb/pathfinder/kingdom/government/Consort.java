package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.rpg.RPGCharacter;

public class Consort extends LeadershipRole {

    public Consort(String title, RPGCharacter character, boolean unavailable) {
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
	if (isUnavailable())
	    change = 0;
	else
	    change = RPGCharacter.getAttributeModifier(character.getCharisma()) / 2;
    }

}
