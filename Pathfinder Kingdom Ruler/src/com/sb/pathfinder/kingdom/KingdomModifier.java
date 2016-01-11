package com.sb.pathfinder.kingdom;

/**
 * The interface for objects that modify the Kingdom object.
 * 
 * @author Samuel Beausoleil
 */
public interface KingdomModifier {

    /**
     * Applies the modifications of the object to the Kingdom.
     * 
     * @param kingdom
     */
    public void applyTo(Kingdom kingdom);

    /**
     * Removes the modifications brought by this object to the kingdom.
     * 
     * @param kingdom
     */
    public void removeFrom(Kingdom kingdom);
}
