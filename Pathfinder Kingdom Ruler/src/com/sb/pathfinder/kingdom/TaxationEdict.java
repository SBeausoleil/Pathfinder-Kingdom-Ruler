package com.sb.pathfinder.kingdom;

public enum TaxationEdict implements KingdomModifier  {

    NONE(0, 1), LIGHT(1, -1), NORMAL(2, -2), HEAVY(3, -4), OVERWHELMING(4, -8);
    
    private int economy;
    private int loyalty;
    
    private TaxationEdict(int economy, int loyalty) {
	this.economy = economy;
	this.loyalty = loyalty;
    }

    @Override
    public void applyTo(Kingdom kingdom) {
	kingdom.modEconomy(economy);
	kingdom.modLoyalty(loyalty);
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	kingdom.modEconomy(-economy);
	kingdom.modLoyalty(-loyalty);
    }
    
}
