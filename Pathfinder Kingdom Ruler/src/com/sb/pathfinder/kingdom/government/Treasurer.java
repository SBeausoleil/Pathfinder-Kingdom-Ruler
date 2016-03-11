package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomModifier;
import com.sb.pathfinder.kingdom.SavedKingdomModifier;
import com.sb.pathfinder.kingdom.TaxationEdict;
import com.sb.rpg.RPGCharacter;

public class Treasurer extends LeadershipRole {

    private static final long serialVersionUID = 1508128157280525063L;

    public Treasurer(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	super(title, character, available, kingdom);
	// TODO Auto-generated constructor stub
    }

    public class TreasurerBonus extends SavedKingdomModifier {

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
	
    }
    
    public class TreasurerPenalty implements KingdomModifier {

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
	
    }
}
