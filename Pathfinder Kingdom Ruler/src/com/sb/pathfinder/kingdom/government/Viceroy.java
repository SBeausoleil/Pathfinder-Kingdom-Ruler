package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.rpg.RPGCharacter;

/**
 * The Viceroy represents the Ruler's interests on an ongoing basis in a specific location such as a
 * colony or vassal state (see the optional Vassalage edict). The Viceroy is in effect the Ruler for
 * that territory; her orders are superseded only by direct commands from the Ruler.
 * <p>
 * Benefit(s): Add half your Intelligence or Wisdom modifier to Economy. You may assume any
 * leadership role (including Ruler) for your colony or vassal state, but any benefit you provide in
 * this role is 1 less than normal; if you do so, you must spend 7 days that month performing duties
 * appropriate to that leadership role in addition to the 7 days spent for Viceroy duties.
 * <p>
 * Vacancy Penalty: If you have no Viceroy for your vassal state, treat it as if it had the Ruler
 * vacancy penalty.
 * 
 * @author Samuel Beausoleil
 */
public class Viceroy extends LeadershipRole {

    private static final long serialVersionUID = -1771498286966240728L;

    public Viceroy(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new ViceroyBonus());
	// The Viceroy penalty is not yet modelable
    }

    public class ViceroyBonus extends SavedKingdomModifier implements LeaderKingdomModifier {

	private static final long serialVersionUID = 8228313896264579800L;

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getIntelligence() >= character.getWisdom() ? character.getIntelligence() : character.getWisdom();
	    change = RPGCharacter.getAttributeModifier(change) / 2;
	    
	    kingdom.modEconomy(change);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modEconomy(-change);
	}

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> description = new LinkedHashMap<>();

	    if (isVacant())
		description.put("Economy", "Intelligence|Wisdom modifier");
	    else
		description.put("Economy", Integer.toString(change));

	    return description;
	}

    }
}
