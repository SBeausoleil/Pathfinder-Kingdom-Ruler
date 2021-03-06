package com.sb.pathfinder.kingdom.government;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.rpg.RPGCharacter;

/**
 * Represents a leadership role in the government of a kingdom.
 * Can be used as-is to create quick instances of leadership role.
 * All call to setters in this class will result in updates of the state of the affected kingdom.
 * 
 * @author Samuel Beausoleil
 */
public abstract class LeadershipRole implements Serializable {

    private static final long serialVersionUID = -8226566758974968846L;

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
    protected LeaderKingdomModifier bonus;

    /**
     * The penalty applied to a kingdom.
     * The penalty is to be applied when a kingdom does not have this role fulfilled.
     */
    protected LeaderKingdomModifier penalty;

    /**
     * The current effect applied on the kingdom.
     */
    private LeaderKingdomModifier currentEffect;

    public LeadershipRole(String title, RPGCharacter character, boolean available, Kingdom kingdom) {
	this(title, character, available, kingdom, EmptyLeaderKingdomModifier.getInstance(),
		EmptyLeaderKingdomModifier.getInstance());
    }

    public LeadershipRole(String title, RPGCharacter character, boolean available, Kingdom kingdom,
	    LeaderKingdomModifier bonus, LeaderKingdomModifier penalty) {
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
    public final void setCharacter(RPGCharacter character) {
	remove();
	this.character = character;
	apply();
    }

    /**
     * Returns the bonus.
     * 
     * @return the bonus
     */
    public LeaderKingdomModifier getBonus() {
	return bonus;
    }

    /**
     * Sets the value of bonus to that of the parameter.
     * 
     * @param bonus
     *            the bonus to set
     */
    public final void setBonus(LeaderKingdomModifier bonus) {
	remove();
	this.bonus = bonus;
	apply();
    }

    /**
     * Returns the penalty.
     * 
     * @return the penalty
     */
    public LeaderKingdomModifier getPenalty() {
	return penalty;
    }

    /**
     * Sets the value of penalty to that of the parameter.
     * 
     * @param penalty
     *            the penalty to set
     */
    public final void setPenalty(LeaderKingdomModifier penalty) {
	remove();
	this.penalty = penalty;
	apply();
    }

    /**
     * Returns the availability of the character.
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
    public final void setAvailable(boolean available) {
	remove();
	this.available = available;
	apply();
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
     * Checks if the role is vacant.
     * 
     * @return <tt>true</tt> if the role is currently not occupied or is unavailable.
     */
    public boolean isVacant() {
	return !isOccupied() || !isAvailable();
    }

    /**
     * Updates the effects of this role that is applied on the kingdom.
     * Starts by removing the current effect(s), then checks which set of effects should be applied.
     */
    public void apply() {
	if (currentEffect != null)
	    currentEffect.removeFrom(kingdom);

	if (isVacant())
	    currentEffect = penalty;
	else
	    currentEffect = bonus;

	currentEffect.applyTo(kingdom);
    }

    /**
     * Removes the current effects of this leadership role from it's kingdom.
     */
    public void remove() {
	if (kingdom != null && currentEffect != null)
	    currentEffect.removeFrom(kingdom);
	currentEffect = null;
    }

    /**
     * Returns the kingdom.
     * 
     * @return the kingdom
     */
    public Kingdom getKingdom() {
	return kingdom;
    }

    /**
     * Sets the value of kingdom to that of the parameter.
     * 
     * @param kingdom
     *            the kingdom to set
     */
    public final void setKingdom(Kingdom kingdom) {
	remove();
	this.kingdom = kingdom;
	apply();
    }

    /**
     * Returns the currentEffect.
     * 
     * @return the currentEffect
     */
    public LeaderKingdomModifier getCurrentEffect() {
	return currentEffect;
    }

    public void displayProperties() {
	System.out.println("Title: " + title);
	System.out.println("Character: " + character != null ? character.getName() : "This post is vacant");
	System.out.println(available ? "The person in charge of this role is available to fulfill their functions."
		: "The person in charge of this role is not available to fulfill their functions.");
	System.out.println("Kingdom: " + kingdom != null ? kingdom.getName() : "");
	System.out.println("Current effect(s): ");
	LinkedHashMap<String, String> description = currentEffect.describe();
	Iterator<String> keys = description.keySet().iterator();
	Iterator<String> values = description.values().iterator();
	while (keys.hasNext())
	    System.out.println(" -> " + keys.next() + ": " + values.next());
    }
}
