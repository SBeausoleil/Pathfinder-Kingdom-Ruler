package com.sb.pathfinder.kingdom;

public enum PromotionEdict implements KingdomModifier  {

    NONE(-1, 0), TOKEN(1, 1), STANDARD(2, 2), AGGRESSIVE(3, 4), EXPANSIONIST(4, 8);
    
    private int stability;
    private int consumption;
    
    private PromotionEdict(int stability, int consumption) {
	this.stability = stability;
	this.consumption = consumption;
    }

    @Override
    public void applyTo(Kingdom kingdom) {
	kingdom.modStability(stability);
	kingdom.modConsumption(consumption);
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	kingdom.modStability(-stability);
	kingdom.modConsumption(-consumption);
    }
    
    
}
