package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomStabilityModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

public class GrandDiplomat extends LeadershipRole {

    private static final long serialVersionUID	= -6136619645061955096L;
    public static final int   STABILITY_PENALTY	= -2;

    public GrandDiplomat(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new GrandDiplomatBonus());
	setPenalty(new KingdomStabilityModifier(STABILITY_PENALTY));
    }

    public class GrandDiplomatBonus extends SavedKingdomModifier implements LeaderKingdomModifier {

	private static final long serialVersionUID = 1083251761192156008L;

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getCharisma() >= character.getIntelligence() ? character.getCharisma()
		    : character.getIntelligence();
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
		bonusDescription.put("Stability", "Charisma|Intelligence modifier");
	    else
		bonusDescription.put("Stability", Integer.toString(change));

	    return bonusDescription;
	}
    }
}
