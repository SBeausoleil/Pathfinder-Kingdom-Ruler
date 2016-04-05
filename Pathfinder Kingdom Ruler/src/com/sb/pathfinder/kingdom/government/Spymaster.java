package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.Kingdom.Attribute;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class Spymaster extends LeadershipRole {

    private static final long serialVersionUID = 5947435884473566705L;

    public Spymaster(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new SpymasterBonus());
	setPenalty(new SpymasterPenalty());
    }

    @Override
    public SpymasterBonus getBonus() {
	return (SpymasterBonus) bonus;
    }

    public class SpymasterBonus extends SavedKingdomModifier implements LeaderKingdomModifier {

	private static final long serialVersionUID = -2451943251181465716L;
	
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

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> description = new LinkedHashMap<>();

	    switch(affectedAttribute) {
	    case ECONOMY:
		description.put("Economy", isVacant() ? "Intelligence|Dexterity modifier" : Integer.toString(change));
		break;
	    case LOYALTY:
		description.put("Loyalty", isVacant() ? "Intelligence|Dexterity modifier" : Integer.toString(change));
		break;
	    case STABILITY:
		description.put("Stability", isVacant() ? "Intelligence|Dexterity modifier" : Integer.toString(change));
		break;
	    }
	    
	    return description;
	}

    }

    public static class SpymasterPenalty implements LeaderKingdomModifier {

	private static final long serialVersionUID = 7287718208028442683L;
	
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

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> description = new LinkedHashMap<>();
	    description.put("Economy", Integer.toString(ECONOMY_PENALTY));
	    description.put("Unrest", Integer.toString(UNREST_PENALTY));
	    return description;
	}

    }
}
