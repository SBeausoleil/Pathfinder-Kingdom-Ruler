package com.sb.pathfinder.kingdom;

import com.sb.util.IntBracket;

public enum ImprovementEdict {

    NONEXISTANT(1, 0, 0, 1),
    TINY(1, 1, 2, 1),
    SMALL(1, 2, 3, 2),
    MEDIUM(1, 5, 5, 3),
    LARGE(2, 10, 7, 4),
    HUGE(3, 20, 9, 8),
    EMPIRE(4, Integer.MAX_VALUE, 12, 12);
    
    public static IntBracket SIZE_NONEXISTANT = new IntBracket(Integer.MIN_VALUE, 0);
    public static IntBracket SIZE_TINY = new IntBracket(1, 10);
    public static IntBracket SIZE_SMALL = new IntBracket(11, 25);
    public static IntBracket SIZE_MEDIUM = new IntBracket(26, 50);
    public static IntBracket SIZE_LARGE = new IntBracket(51, 100);
    public static IntBracket SIZE_HUGE = new IntBracket(101, 200);
    public static IntBracket SIZE_EMPIRE = new IntBracket(201, Integer.MAX_VALUE);
    
    private int settlement;
    private int buildings;
    private int improvements;
    private int tileClaims;
    
    private ImprovementEdict(int settlement, int buildings, int improvements, int tileClaims) {
	this.settlement = settlement;
	this.buildings = buildings;
	this.improvements = improvements;
	this.tileClaims = tileClaims;
    }

    /**
     * Returns the settlement.
     * @return the settlement
     */
    public int getSettlement() {
        return settlement;
    }

    /**
     * Returns the buildings.
     * @return the buildings
     */
    public int getBuildings() {
        return buildings;
    }

    /**
     * Returns the improvements.
     * @return the improvements
     */
    public int getImprovements() {
        return improvements;
    }

    /**
     * Returns the tileClaims.
     * @return the tileClaims
     */
    public int getTileClaims() {
        return tileClaims;
    }

    public String toString() {
	return "New settlements: " + settlement + ", new buildings: " + (buildings != Integer.MAX_VALUE ? buildings : "No limit")
		+ ", terrain improvements: " + improvements + ", tile claims: " + tileClaims;
    }
    
    public static ImprovementEdict getImprovementEdict(Kingdom kingdom) {
	if (SIZE_NONEXISTANT.isInside(kingdom.getSize()))
	    return NONEXISTANT;
	else if (SIZE_TINY.isInside(kingdom.getSize()))
	    return TINY;
	else if (SIZE_SMALL.isInside(kingdom.getSize()))
	    return SMALL;
	else if (SIZE_MEDIUM.isInside(kingdom.getSize()))
	    return MEDIUM;
	else if (SIZE_LARGE.isInside(kingdom.getSize()))
	    return LARGE;
	else if (SIZE_HUGE.isInside(kingdom.getSize()))
	    return HUGE;
	else
	    return EMPIRE;
    }
}
