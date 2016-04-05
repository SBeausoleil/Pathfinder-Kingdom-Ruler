package com.sb.pathfinder.kingdom.government;

import java.util.HashSet;
import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

/**
 * A Ruler in Pathfinder.
 * 
 * @author Samuel Beausoleil
 *
 */
public class Ruler extends LeadershipRole {

    private static final long serialVersionUID = 1768627935825417418L;

    public Ruler(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new RulerBonus());
	setPenalty(new RulerPenalty());
    }

    public class RulerBonus extends SavedKingdomModifier implements LeaderKingdomModifier {

	private static final long serialVersionUID = -168654583637209587L;
	private HashSet<Kingdom.Attribute> modifiedAttributes;

	public RulerBonus() {
	    modifiedAttributes = new HashSet<Kingdom.Attribute>();
	}

	/**
	 * Add a kingdom attribute to be modified by the ruler.
	 * The caller should always call removeFrom() before calling this method to avoid bugs.
	 * 
	 * @param attribute
	 *            can be a Kingdom.Attribute: Economy, Loyalty, or Stability.
	 * @return <tt>true</tt> if the attributes list has been modified.
	 */
	public boolean addKingdomAttribute(Kingdom.Attribute attribute) {
	    if (       attribute == Kingdom.Attribute.ECONOMY
		    || attribute == Kingdom.Attribute.LOYALTY
		    || attribute == Kingdom.Attribute.STABILITY) {
		return modifiedAttributes.add(attribute);
	    }
	    return false;
	}

	/**
	 * Removes a kingdom attribute to be modified by this role.
	 * 
	 * @param attribute
	 * @return <tt>true</tt> if the modified attributes list was modified.
	 */
	public boolean removeKingdomAttribute(Kingdom.Attribute attribute) {
	    return modifiedAttributes.remove(attribute);
	}

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = RPGCharacter.getAttributeModifier(character.getCharisma());
	    modify(kingdom, change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    modify(kingdom, -change);
	}

	private void modify(Kingdom kingdom, int mod) {
	    for (Kingdom.Attribute attr : modifiedAttributes) {
		switch (attr) {
		case ECONOMY:
		    kingdom.modEconomy(mod);
		    break;
		case LOYALTY:
		    kingdom.modEconomy(mod);
		    break;
		case STABILITY:
		    kingdom.modStability(mod);
		    break;
		}
	    }
	}

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> description = new LinkedHashMap<>();

	    for (Kingdom.Attribute attr : modifiedAttributes) {
		switch (attr) {
		case ECONOMY:
		    description.put("Economy", isVacant() ? "Charisma modifier" : Integer.toString(change));
		    break;
		case LOYALTY:
		    description.put("Loyalty", isVacant() ? "Charisma modifier" : Integer.toString(change));
		    break;
		case STABILITY:
		    description.put("Stability", isVacant() ? "Charisma modifier" : Integer.toString(change));
		    break;
		}
	    }
	    
	    return description;
	}
    }

    public static class RulerPenalty implements LeaderKingdomModifier {

	private static final long serialVersionUID = -2370687647465958372L;
	
	public static final int UNREST_PENALTY = 4;

	/**
	 * Increases the unrest by 4.
	 * According to the rules, a kingdom without a ruler cannot claim new hexes, create Farms,
	 * build Roads, or purchase settlement districts. Unrest increases by 4 during the kingdom's
	 * Upkeep Phase.
	 * NOTE: Only the unrest penalty is applied.
	 */
	@Override
	public void applyTo(Kingdom kingdom) {
	    kingdom.modUnrest(UNREST_PENALTY);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	}

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> description = new LinkedHashMap<>();
	    description.put("Unrest", "+" + UNREST_PENALTY + "/turn");
	    return description;
	}
    }
}
