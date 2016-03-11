package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.EmptyKingdomModifier;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

/**
 * Is a consort to the Ruler of the kingdom.
 * 
 * @author Samuel Beausoleil
 *
 */
public class Consort extends LeadershipRole {

    private static final long serialVersionUID = -2368379344203598322L;

    public Consort(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new ConsortBonus());
	setPenalty(EmptyKingdomModifier.getInstance());
    }
    
    /**
     * A consort applies the following bonus to a kingdom:
     * <p>
     * - Half of the charisma modifier to the loyalty
     * 
     * @author Samuel Beausoleil
     *
     */
    public class ConsortBonus extends SavedKingdomModifier {

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = RPGCharacter.getAttributeModifier(character.getCharisma()) / 2;
	    kingdom.modLoyalty(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modLoyalty(-change);
	}
    }
}
