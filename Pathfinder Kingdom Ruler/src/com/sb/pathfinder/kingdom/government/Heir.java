package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.rpg.RPGCharacter;

public class Heir extends LeadershipRole {

    public Heir(String title, RPGCharacter character, boolean unavailable) {
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
	if (isUnavailable())
	    change = 0;
	else
	    change = RPGCharacter.getAttributeModifier(character.getCharisma()) / 2;
    }

}
