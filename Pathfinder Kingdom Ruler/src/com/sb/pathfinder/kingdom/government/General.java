package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomLoyaltyModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class General extends LeadershipRole {

    private static final long serialVersionUID = 4676837781762450095L;
    public static final int   LOYALTY_PENALTY  = -4;

    public General(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new GeneralBonus());
	setPenalty(new KingdomLoyaltyModifier(LOYALTY_PENALTY));
    }

    public class GeneralBonus extends SavedKingdomModifier implements LeaderKingdomModifier {

	private static final long serialVersionUID = -4288562443727817964L;

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getCharisma() >= character.getStrength() ? character.getCharisma()
		    : character.getStrength();
	    change = RPGCharacter.getAttributeModifier(change);
	    kingdom.modStability(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modStability(-change);
	}

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> bonusDescription = new LinkedHashMap<>();

	    if (isVacant())
		bonusDescription.put("Stability", "Charisma|Strength modifier");
	    else
		bonusDescription.put("Stability", Integer.toString(change));

	    return bonusDescription;
	}

    }
}
