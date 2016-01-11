package com.sb.pathfinder.kingdom;

/**
 * The interface for objects that modify the Settlement object.
 * 
 * @author Samuel Beausoleil
 */
public interface SettlementModifier {

    /**
     * Applies the modifications of the object to the settlement.
     * 
     * @param settlement
     */
    public void applyTo(Settlement settlement);

    /**
     * Removes the modifications brought by this object to the settlement.
     * 
     * @param settlement
     */
    public void removeFrom(Settlement settlement);
}
