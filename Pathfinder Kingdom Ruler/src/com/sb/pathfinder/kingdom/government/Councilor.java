package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.HolidayEdict;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

/**
 * A Councilor in Pathfinder.
 * 
 * @author Samuel Beausoleil
 */
public class Councilor extends LeadershipRole {

    private static final long serialVersionUID = 425193963722886738L;

    public Councilor(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new CouncilorBonus());
	setPenalty(new CouncilorPenalty());
    }

    public class CouncilorBonus extends SavedKingdomModifier implements LeaderKingdomModifier {

	private static final long serialVersionUID = -7635578593107579433L;

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getCharisma() >= character.getWisdom() ? character.getCharisma() : character.getWisdom();
	    change = RPGCharacter.getAttributeModifier(change);

	    kingdom.modLoyalty(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modLoyalty(-change);
	}

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> description = new LinkedHashMap<>();

	    if (isVacant())
		description.put("Loyalty", "Charisma|Wisdom modifier");
	    else
		description.put("Loyalty", Integer.toString(change));

	    return description;
	}

    }

    public static class CouncilorPenalty implements LeaderKingdomModifier {

	private static final long serialVersionUID = -2878727908316176210L;

	public static final int UNREST_PENALTY = 1;

	public static final int LOYALTY_PENALTY = -2;

	private HolidayEdict savedEdict = null;

	/**
	 * Increases unrest by 1 every turns, decreases loyalty by 2 and sets the holiday edict to
	 * no holidays.
	 */
	@Override
	public void applyTo(Kingdom kingdom) {
	    kingdom.modUnrest(UNREST_PENALTY);
	    if (savedEdict == null) {
		savedEdict = kingdom.getHolidayEdict();
		kingdom.setHolidayEdict(HolidayEdict.NO_HOLIDAYS);
		kingdom.modLoyalty(LOYALTY_PENALTY);
	    }
	}

	/**
	 * Restores the holiday edict and the loyalty.
	 * The holiday edict is the one that was in place at the last call to applyTo() following a
	 * call to removeFrom().
	 */
	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.setHolidayEdict(savedEdict);
	    savedEdict = null;
	    kingdom.modLoyalty(-LOYALTY_PENALTY);
	}

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> description = new LinkedHashMap<>();
	    description.put("Unrest", Integer.toString(UNREST_PENALTY));
	    description.put("Loyalty", Integer.toString(LOYALTY_PENALTY));
	    return description;
	}

    }

}
