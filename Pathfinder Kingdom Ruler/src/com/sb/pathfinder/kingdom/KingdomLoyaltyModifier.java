package com.sb.pathfinder.kingdom;

public class KingdomLoyaltyModifier implements KingdomModifier {

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

}
