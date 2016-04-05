package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.pathfinder.kingdom.TaxationEdict;
import com.sb.rpg.RPGCharacter;

public class Treasurer extends LeadershipRole {

    private static final long serialVersionUID = 1508128157280525063L;

    public Treasurer(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	setBonus(new TreasurerBonus());
	setPenalty(new TreasurerPenalty());
    }

    public class TreasurerBonus extends SavedKingdomModifier implements LeaderKingdomModifier {

	private static final long serialVersionUID = 7431075146013386186L;

	@Override
	public void applyTo(Kingdom kingdom) {
	    change = character.getIntelligence() >= character.getWisdom() ? character.getIntelligence() : character.getWisdom();
	    change = RPGCharacter.getAttributeModifier(change);
	    
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
    
    public static class TreasurerPenalty implements LeaderKingdomModifier {

	private static final long serialVersionUID = -7251169622220161656L;

	public static final int ECONOMY_PENALTY = -4;
	
	private TaxationEdict savedEdict;
	
	@Override
	public void applyTo(Kingdom kingdom) {
	    if (savedEdict != null)
		kingdom.modEconomy(ECONOMY_PENALTY);
	    savedEdict = kingdom.getTaxationEdict();
	    kingdom.setTaxationEdict(TaxationEdict.NONE);
	}

	@Override
	public void removeFrom(Kingdom kingdom) {
	    kingdom.modEconomy(-ECONOMY_PENALTY);
	    kingdom.setTaxationEdict(savedEdict);
	    savedEdict = null;
	}

	@Override
	public LinkedHashMap<String, String> describe() {
	    LinkedHashMap<String, String> description = new LinkedHashMap<>();
	    description.put("Economy", Integer.toString(ECONOMY_PENALTY));
	    return description;
	}
	
    }
}
