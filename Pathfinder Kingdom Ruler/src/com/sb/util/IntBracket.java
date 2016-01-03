package com.sb.util;

public class IntBracket {

    private int min;
    private int max;
    
    public IntBracket(int min, int max) {
	this.min = min;
	this.max = max;
    }
    
    public boolean isInside(int x) {
	return x >= min && x <= max;
    }

    /**
     * Returns the min.
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * Sets the value of min to that of the parameter.
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Returns the max.
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * Sets the value of max to that of the parameter.
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }
}
