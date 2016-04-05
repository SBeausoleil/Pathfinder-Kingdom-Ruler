package com.sb.pathfinder.kingdom;

/**
 * A KingdomModifier that retains the value of it's change.
 * 
 * @author Samuel Beausoleil
 *
 */
public abstract class SavedKingdomModifier implements SerializableKingdomModifier {
    
    private static final long serialVersionUID = 3385602197174228218L;
    
    protected int change;

    /**
     * Returns the change.
     * @return the change
     */
    public int getChange() {
        return change;
    }

    /**
     * Sets the value of change to that of the parameter.
     * @param change the change to set
     */
    public void setChange(int change) {
        this.change = change;
    }

}
