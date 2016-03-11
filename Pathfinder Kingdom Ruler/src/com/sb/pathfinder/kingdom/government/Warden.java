/**
 * 
 */
package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

/**
 * The Warden is responsible for enforcing laws in larger settlements, as well as ensuring the
 * safety of the kingdom leaders. The Warden also works with the General to deploy forces to protect
 * settlements and react to internal threats.
 * <p>
 * Benefit(s): Add your Constitution modifier or Strength modifier to Loyalty.
 * <p>
 * Vacancy Penalty: Loyalty and Stability decrease by 2.
 * 
 * @author Samuel Beausoleil
 */
public class Warden extends LeadershipRole {

    private static final long serialVersionUID = -2406350209281065588L;

    public Warden(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new WardenBonus());
	setPenalty(new WardenPenalty());
    }

    public class WardenBonus extends SavedKingdomModifier {

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getConstitution() >= character.getStrength() ? character.getConstitution() : character.getStrength();
	    change = RPGCharacter.getAttributeModifier(change);
	    
	    kingdom.modLoyalty(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modLoyalty(-change);
	}
	
    }
    
    public class WardenPenalty implements KingdomModifier {

	public static final int LOYALTY_PENALTY = -2;
	public static final int STABILITY_PENALTY = -2;
	
	@Override
	public void applyTo(Kingdom kingdom) {
	    kingdom.modLoyalty(LOYALTY_PENALTY);
	    kingdom.modStability(STABILITY_PENALTY);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modLoyalty(-LOYALTY_PENALTY);
	    kingdom.modStability(-STABILITY_PENALTY);
	}
	
    }
}
