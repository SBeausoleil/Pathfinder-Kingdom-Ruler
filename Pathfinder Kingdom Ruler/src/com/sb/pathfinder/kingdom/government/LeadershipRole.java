package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomModifier;
import com.sb.rpg.RPGCharacter;

/**
 * Represents a leadership role in the government of a kingdom.
 * 
 * @author Samuel Beausoleil
 */
public abstract class LeadershipRole implements KingdomModifier {

    /**
     * The title of the role.
     */
    protected String title;

    /**
     * The character filling the position.
     * If null, we assume that the position is free.
     */
    protected RPGCharacter character;

    /**
     * Indicates if the current character occupying this role is unavailable to fulfill their duty.
     */
    protected boolean unavailable;

    /**
     * Records the size of the changes brought by this role.
     * This field is used for reverting changes. It is reccomended to update it every times as the
     * first step of the <code>applyTo()</code> abstract function.
     */
    protected int change;

    public LeadershipRole(String title, RPGCharacter character, boolean unavailable) {
	this.title = title;
	this.character = character;
	this.unavailable = unavailable;
    }

    /**
     * Returns the title.
     * 
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * Sets the value of title to that of the parameter.
     * 
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * Returns the character.
     * 
     * @return the character
     */
    public RPGCharacter getCharacter() {
	return character;
    }

    /**
     * Sets the value of character to that of the parameter.
     * 
     * @param character
     *            the character to set
     */
    public void setCharacter(RPGCharacter character) {
	this.character = character;
    }

    /**
     * Returns the unavailable.
     * 
     * @return the unavailable
     */
    public boolean isUnavailable() {
	return character == null || unavailable;
    }

    /**
     * Sets the value of unavailable to that of the parameter.
     * 
     * @param unavailable
     *            the unavailable to set
     */
    public void setUnavailable(boolean unavailable) {
	this.unavailable = unavailable;
    }

    /**
     * Checks if the character holding the role has the Prestige feat.
     * 
     * @return <tt>true</tt> if the character has a feat named "prestige".
     *         <tt>false</tt> if the character is null or does not have the Prestige feat.
     */
    public boolean hasPrestige() {
	if (character == null)
	    return false;

	return character.getFeats().hasFeat("prestige");
    }

    /**
     * Forces an updates of the stats provided by this leadership role.
     * Starts by removing the current effects of the role by calling <code>removeFrom()</code>
     * then applying the updated statistics of the character in the role by calling
     * <code>applyTo()</code>.
     * 
     * @param kingdom
     */
    public void update(Kingdom kingdom) {
	removeFrom(kingdom);
	applyTo(kingdom);
    }

    /**
     * Returns the change.
     * 
     * @return the change
     */
    public int getChange() {
	return change;
    }

    /**
     * Calculates the value of the changes brought by this role and applies it to the
     * <tt>change</tt> field.
     */
    protected abstract void calculateChange();
}
