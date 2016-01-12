package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.Kingdom.Attribute;
import com.sb.pathfinder.kingdom.KingdomModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class Spymaster extends LeadershipRole {

    public Spymaster(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new SpymasterBonus());
	setPenalty(new SpymasterPenalty());
    }

    public SpymasterBonus getBonus() {
	return (SpymasterBonus) bonus;
    }

    public class SpymasterBonus extends SavedKingdomModifier {

	private Kingdom.Attribute affectedAttribute;

	public SpymasterBonus() {
	    this(null);
	}

	public SpymasterBonus(Attribute affectedAttribute) {
	    this.affectedAttribute = affectedAttribute;
	}

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getDexterity() >= character.getIntelligence() ? character.getDexterity()
		    : character.getIntelligence();
	    change = RPGCharacter.getAttributeModifier(change);

	    apply(kingdom, change);
	}

	private void apply(Kingdom kingdom, int mod) {
	    switch (affectedAttribute) {
	    case ECONOMY:
		kingdom.modEconomy(mod);
		break;
	    case LOYALTY:
		kingdom.modLoyalty(mod);
		break;
	    case STABILITY:
		kingdom.modLoyalty(mod);
		break;
	    }
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    apply(kingdom, -change);
	}

	/**
	 * Returns the affectedAttribute.
	 * 
	 * @return the affectedAttribute
	 */
	public Kingdom.Attribute getAffectedAttribute() {
	    return affectedAttribute;
	}

	/**
	 * Sets the value of affectedAttribute to that of the parameter.
	 * 
	 * @param affectedAttribute
	 *            the affectedAttribute to set
	 */
	public void setAffectedAttribute(Kingdom.Attribute affectedAttribute) {
	    this.affectedAttribute = affectedAttribute;
	}

    }

    public class SpymasterPenalty implements KingdomModifier {

	public static final int ECONOMY_PENALTY = -4;
	public static final int UNREST_PENALTY = 1;

	private boolean economyPenaltyApplied;

	@Override
	public void applyTo(Kingdom kingdom) {
	    if (!economyPenaltyApplied) {
		kingdom.modEconomy(ECONOMY_PENALTY);
		economyPenaltyApplied = true;
	    }
	    kingdom.modUnrest(UNREST_PENALTY);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modEconomy(-ECONOMY_PENALTY);
	    economyPenaltyApplied = false;
	}

    }
}
