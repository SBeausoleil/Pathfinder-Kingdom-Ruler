package com.sb.pathfinder.kingdom;

import com.sb.util.IntBracket;

public enum SettlementSize {

    ABANDONNED(0), 
    THORP(50), 
    HAMLET(200), 
    VILLAGE(500), 
    SMALL_TOWN(1000), 
    LARGE_TOWN(2000), 
    SMALL_CITY(4000),
    LARGE_CITY(8000),
    METROPOLIS(16000);
    
    public static final IntBracket POPULATION_ABANDONNED = new IntBracket(Integer.MIN_VALUE, 0);
    public static final IntBracket POPULATION_THORP = new IntBracket(1, 20);
    public static final IntBracket POPULATION_HAMLET = new IntBracket(21, 60);
    public static final IntBracket POPULATION_VILLAGE = new IntBracket(61, 200);
    public static final IntBracket POPULATION_SMALL_TOWN = new IntBracket(201, 2000);
    public static final IntBracket POPULATION_LARGE_TOWN = new IntBracket(2001, 5000);
    public static final IntBracket POPULATION_SMALL_CITY = new IntBracket(5001, 10000);
    public static final IntBracket POPULATION_LARGE_CITY = new IntBracket(10001, 25000);
    public static final IntBracket POPULATION_METROPOLIS = new IntBracket(25001, Integer.MAX_VALUE);
    
    private final int BASE_VALUE;

    private SettlementSize(int baseValue) {
	this.BASE_VALUE = baseValue;
    }

    /**
     * Returns the base value of the settlement.
     * @return the base value of the settlement
     */
    public int getBaseValue() {
	return BASE_VALUE;
    }
    
    public static SettlementSize getSettlementSize(Settlement settlement) {
	if (POPULATION_ABANDONNED.isInside(settlement.getPopulation()))
	    return ABANDONNED;
	else if (POPULATION_THORP.isInside(settlement.getPopulation()))
	    return THORP;
	else if (POPULATION_HAMLET.isInside(settlement.getPopulation()))
	    return HAMLET;
	else if (POPULATION_VILLAGE.isInside(settlement.getPopulation()))
	    return VILLAGE;
	else if (POPULATION_SMALL_TOWN.isInside(settlement.getPopulation()))
	    return SMALL_TOWN;
	else if (POPULATION_LARGE_TOWN.isInside(settlement.getPopulation()))
	    return LARGE_TOWN;
	else if (POPULATION_SMALL_CITY.isInside(settlement.getPopulation()))
	    return SMALL_CITY;
	else if (POPULATION_LARGE_CITY.isInside(settlement.getPopulation()))
	    return LARGE_CITY;
	else
	    return METROPOLIS;
    }
}
