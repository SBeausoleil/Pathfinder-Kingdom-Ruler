package com.sb.rpg;

public class Feat {

    protected final String name;
    
    protected String description;

    public Feat(String name, String description) {
	this.name = name;
	this.description = description;
    }

    /**
     * Returns the description.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of description to that of the parameter.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    
}
