package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.HolidayEdict;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

/**
 * A Councilor in Pathfinder.
 * 
 * @author Samuel Beausoleil
 */
public class Councilor extends LeadershipRole {

    public Councilor(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	// TODO Auto-generated constructor stub
    }

    public class CouncilorBonus extends SavedKingdomModifier {

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

    }

    public class CouncilorPenalty implements KingdomModifier {

	public static final int UNREST_PENALTY = 1;

	public static final int LOYALTY_PENALTY = -2;

	private HolidayEdict edict = null;

	/**
	 * Increases unrest by 1 every turns, decreases loyalty by 2 and sets the holiday edict to
	 * no holidays.
	 */
	@Override
	public void applyTo(Kingdom kingdom) {
	    kingdom.modUnrest(UNREST_PENALTY);
	    if (edict == null) {
		edict = kingdom.getHolidayEdict();
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
	    kingdom.setHolidayEdict(edict);
	    edict = null;
	    kingdom.modLoyalty(-LOYALTY_PENALTY);
	}

    }
}
