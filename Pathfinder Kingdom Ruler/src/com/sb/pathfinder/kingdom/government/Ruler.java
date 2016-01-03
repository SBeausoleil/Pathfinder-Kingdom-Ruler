package com.sb.pathfinder.kingdom.government;

import java.util.HashSet;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.rpg.RPGCharacter;

public class Ruler extends LeadershipRole {

    private HashSet<Kingdom.Attribute> affectedAttributes;

    public Ruler(String title, RPGCharacter character, boolean unavailable) {
	super(title, character, unavailable);
	affectedAttributes = new HashSet<Kingdom.Attribute>();
    }

    @Override
    public void applyTo(Kingdom kingdom) {
	calculateChange();
	applyToKingdom(kingdom, change);
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	applyToKingdom(kingdom, -change);
    }
    
    private void applyToKingdom(Kingdom kingdom, int change) {
	for (Kingdom.Attribute attr : affectedAttributes) {
	    switch (attr) {
	    case Economy:
		kingdom.modEconomy(change);
		break;
	    case Loyalty:
		kingdom.modLoyalty(change);
		break;
	    case Stability:
		kingdom.modStability(change);
		break;
	    }
	}
    }

    public boolean addAffectedAttribute(Kingdom.Attribute attribute, Kingdom kingdom) {
	if (affectedAttributes.contains(attribute))
	    return false;
	removeFrom(kingdom);
	affectedAttributes.add(attribute);
	applyTo(kingdom);
	return true;
    }

    public boolean removeAffectedAttribute(Kingdom.Attribute attribute, Kingdom kingdom) {
	if (!affectedAttributes.contains(attribute))
	    return false;
	removeFrom(kingdom);
	affectedAttributes.remove(attribute);
	applyTo(kingdom);
	return true;
    }
    
    @Override
    protected void calculateChange() {
	if (isUnavailable())
	    change = 0;
	else
	    change = RPGCharacter.getAttributeModifier(character.getCharisma());
    }
}
