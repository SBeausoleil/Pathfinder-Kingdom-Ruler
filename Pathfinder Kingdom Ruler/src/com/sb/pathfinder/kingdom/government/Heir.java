package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.rpg.RPGCharacter;

public class Heir extends Consort {

    private static final long serialVersionUID = 3400981099573097808L;

    public Heir(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
    }

}
