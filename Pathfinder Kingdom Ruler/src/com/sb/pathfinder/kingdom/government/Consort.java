package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

/**
 * Is a consort to the Ruler of the kingdom.
 * 
 * @author Samuel Beausoleil
 */
public class Consort extends LeadershipRole {

    private static final long serialVersionUID = -2368379344203598322L;

    public Consort(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new ConsortBonus());
    }

    /**
     * A consort applies the following bonus to a kingdom:
     * <p>
     * - Half of the charisma modifier to the loyalty
     * 
     * @author Samuel Beausoleil
     */
    public class ConsortBonus extends SavedKingdomModifier implements LeaderKingdomModifier {

	private static final long serialVersionUID = -795386951420144389L;

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = RPGCharacter.getAttributeModifier(character.getCharisma()) / 2;
	    kingdom.modLoyalty(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modLoyalty(-change);
	}

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> bonusDescription = new LinkedHashMap<>();

	    if (isVacant())
		bonusDescription.put("Loyalty", "Charisma modifier / 2");
	    else
		bonusDescription.put("Loyalty", Integer.toString(change));

	    return bonusDescription;
	}
    }

}
