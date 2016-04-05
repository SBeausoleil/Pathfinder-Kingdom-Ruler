package com.sb.pathfinder.kingdom;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.government.LeaderKingdomModifier;

public class KingdomLoyaltyModifier implements LeaderKingdomModifier {

    private static final long serialVersionUID = 5700279789965645569L;
    
    private int modifier;
    
    public KingdomLoyaltyModifier(int modifier) {
	this.modifier = modifier;
    }
    
    @Override
    public void applyTo(Kingdom kingdom) {
	kingdom.modLoyalty(modifier);
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	kingdom.modLoyalty(-modifier);
    }

    /**
     * Returns the modifier.
     * @return the modifier
     */
    public int getModifier() {
        return modifier;
    }

    /**
     * Sets the value of modifier to that of the parameter.
     * @param modifier the modifier to set
     */
    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    @Override
    public LinkedHashMap<String, String> describe() {
	LinkedHashMap<String, String> description = new LinkedHashMap<>();
	description.put("Loyalty", Integer.toString(modifier));
	return description;
    }

}
