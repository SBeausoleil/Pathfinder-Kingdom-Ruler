package com.sb.pathfinder.kingdom.government;

import java.util.LinkedList;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class Ruler extends LeadershipRole {

    public Ruler(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new RulerBonus());
	setPenalty(new RulerPenalty());
    }

    public class RulerBonus extends SavedKingdomModifier {

	private LinkedList<Kingdom.Attribute> modifiedAttributes;

	public RulerBonus() {
	    modifiedAttributes = new LinkedList<>();
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
	    if ((attribute == Kingdom.Attribute.Economy
		    || attribute == Kingdom.Attribute.Loyalty
		    || attribute == Kingdom.Attribute.Stability)
		    && !modifiedAttributes.contains(attribute)) {
		modifiedAttributes.add(attribute);
		return true;
	    }
	    return false;
	}

	/**
	 * Removes a kingdom attribute to be modified by this role.
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
		case Economy:
		    kingdom.modEconomy(mod);
		    break;
		case Loyalty:
		    kingdom.modEconomy(mod);
		    break;
		case Stability:
		    kingdom.modStability(mod);
		    break;
		}
	    }
	}
    }

    private class RulerPenalty implements KingdomModifier {

	@Override
	public void applyTo(Kingdom kingdom) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    // TODO Auto-generated method stub

	}

    }
}
