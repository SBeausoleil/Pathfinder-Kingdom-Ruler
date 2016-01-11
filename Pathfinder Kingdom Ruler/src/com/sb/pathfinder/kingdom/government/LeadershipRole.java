package com.sb.pathfinder.kingdom.government;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomModifier;
import com.sb.rpg.RPGCharacter;

/**
 * Represents a leadership role in the government of a kingdom.
 * Can be used as-is to create quick instances of leadership role.
 * 
 * @author Samuel Beausoleil
 */
public class LeadershipRole {

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
     * Indicates if the current character occupying this role is available to fulfill their duties.
     */
    protected boolean available;

    /**
     * The kingdom affected by this role.
     */
    protected Kingdom kingdom;

    /**
     * The bonus applied to a kingdom.
     * The bonus is to be applied when a kingdom has this role fulfilled.
     */
    protected KingdomModifier bonus;

    /**
     * The penalty applied to a kingdom.
     * The penalty is to be applied when a kingdom does not have this role fulfilled.
     */
    protected KingdomModifier penalty;

    /**
     * The current effect applied on the kingdom.
     */
    private KingdomModifier currentEffect;

    public LeadershipRole(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	this(title, character, available, kingdom, null, null);
    }

    public LeadershipRole(String title, RPGCharacter character, boolean available, Kingdom kingdom,
	    KingdomModifier bonus, KingdomModifier penalty) {
	this.title = title;
	this.character = character;
	this.available = available;
	this.kingdom = kingdom;
	this.bonus = bonus;
	this.penalty = penalty;
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
     * Returns the bonus.
     * 
     * @return the bonus
     */
    public KingdomModifier getBonus() {
	return bonus;
    }

    /**
     * Sets the value of bonus to that of the parameter.
     * 
     * @param bonus
     *            the bonus to set
     */
    public void setBonus(KingdomModifier bonus) {
	this.bonus = bonus;
    }

    /**
     * Returns the penalty.
     * 
     * @return the penalty
     */
    public KingdomModifier getPenalty() {
	return penalty;
    }

    /**
     * Sets the value of penalty to that of the parameter.
     * 
     * @param penalty
     *            the penalty to set
     */
    public void setPenalty(KingdomModifier penalty) {
	this.penalty = penalty;
    }

    /**
     * Returns the available.
     * 
     * @return the available
     */
    public boolean isAvailable() {
	return available;
    }

    /**
     * Sets the value of available to that of the parameter.
     * 
     * @param available
     *            the available to set
     */
    public void setAvailable(boolean available) {
	this.available = available;
    }

    /**
     * Checks if there is currently a character occupying this role.
     * 
     * @return <tt>true</tt> if <code>character != null</code>.
     */
    public boolean isOccupied() {
	return character != null;
    }

    /**
     * Checks if there is a character present to apply this role's bonus.
     * 
     * @return <tt>true</tt> if the role is currently occupied and is available.
     */
    public boolean isPresent() {
	return isOccupied() && isAvailable();
    }

    /**
     * Updates the effects of this role that is applied on the kingdom.
     * Starts by removing the current effect(s), then checks which set of effects should be applied.
     * 
     * @throws NullPointerException
     *             if the bonus or the penalty of the kingdom was not set before calling this
     *             method.
     */
    public void apply() {
	if (currentEffect != null)
	    currentEffect.removeFrom(kingdom);

	if (isPresent())
	    currentEffect = bonus;
	else
	    currentEffect = penalty;

	currentEffect.applyTo(kingdom);
    }
}
