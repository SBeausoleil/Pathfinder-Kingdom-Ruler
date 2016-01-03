package com.sb.pathfinder.kingdom;

public enum HolidayEdict implements KingdomModifier {
    
    NO_HOLIDAYS(-1, 0), ONE(1, 1), SIX(2, 2), TWELVE(3, 4), TWENTY_FOUR(4, 8);

    private int loyalty;
    private int consumption;
    
    private HolidayEdict(int loyalty, int consumption) {
	this.loyalty = loyalty;
	this.consumption = consumption;
    }
    
    @Override
    public void applyTo(Kingdom kingdom) {
	kingdom.modLoyalty(loyalty);
	kingdom.modConsumption(consumption);
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	kingdom.modLoyalty(-loyalty);
	kingdom.modConsumption(-consumption);
    }
    
}
