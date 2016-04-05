package com.sb.pathfinder.kingdom;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.government.LeaderKingdomModifier;

public class KingdomStabilityModifier implements LeaderKingdomModifier {

    private static final long serialVersionUID = -2008803563011843570L;
    
    private int modifier;
    
    public KingdomStabilityModifier(int modifier) {
	this.modifier = modifier;
    }
    
    @Override
    public void applyTo(Kingdom kingdom) {
	kingdom.modStability(modifier);
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	kingdom.modStability(-modifier);
    }

    @Override
    public LinkedHashMap<String, String> describe() {
	LinkedHashMap<String, String> description = new LinkedHashMap<>();
	description.put("Stability", Integer.toString(modifier));
	return null;
    }

}
