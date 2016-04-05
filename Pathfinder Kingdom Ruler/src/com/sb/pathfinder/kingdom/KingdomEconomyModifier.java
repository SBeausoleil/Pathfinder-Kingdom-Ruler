package com.sb.pathfinder.kingdom;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.government.LeaderKingdomModifier;

public class KingdomEconomyModifier implements LeaderKingdomModifier {

    private static final long serialVersionUID = 2690120226105746032L;
    
    private int modifier;
    
    public KingdomEconomyModifier(int modifier) {
	this.modifier = modifier;
    }
    
    @Override
    public void applyTo(Kingdom kingdom) {
	kingdom.modEconomy(modifier);
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	kingdom.modEconomy(-modifier);
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
	description.put("Economy", Integer.toString(modifier));
	return description;
    }

}
