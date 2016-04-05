package com.sb.rpg;

import java.util.Collection;

public class RPGCharacter {
    
    protected String name;

    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;

    protected int maxHP;
    protected int currentHP;

    protected Collection<Feat> feats;

    protected int xp;
    protected int level;

    public RPGCharacter(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
	    int maxHP, Collection<Feat> feats, int xp, int level) {
	this.strength = strength;
	this.dexterity = dexterity;
	this.constitution = constitution;
	this.intelligence = intelligence;
	this.wisdom = wisdom;
	this.charisma = charisma;
	this.maxHP = maxHP;
	this.currentHP = maxHP;
	this.feats = feats;
	this.xp = xp;
	this.level = level;
    }

    /**
     * Returns the strength.
     * 
     * @return the strength
     */
    public int getStrength() {
	return strength;
    }

    /**
     * Sets the value of strength to that of the parameter.
     * 
     * @param strength
     *            the strength to set
     */
    public void setStrength(int strength) {
	this.strength = strength;
    }
    
    /**
     * Returns the dexterity.
     * 
     * @return the dexterity
     */
    public int getDexterity() {
	return dexterity;
    }

    /**
     * Sets the value of dexterity to that of the parameter.
     * 
     * @param dexterity
     *            the dexterity to set
     */
    public void setDexterity(int dexterity) {
	this.dexterity = dexterity;
    }
    
    /**
     * Returns the constitution.
     * 
     * @return the constitution
     */
    public int getConstitution() {
	return constitution;
    }

    /**
     * Sets the value of constitution to that of the parameter.
     * 
     * @param constitution
     *            the constitution to set
     */
    public void setConstitution(int constitution) {
	this.constitution = constitution;
    }

    /**
     * Returns the intelligence.
     * 
     * @return the intelligence
     */
    public int getIntelligence() {
	return intelligence;
    }

    /**
     * Sets the value of intelligence to that of the parameter.
     * 
     * @param intelligence
     *            the intelligence to set
     */
    public void setIntelligence(int intelligence) {
	this.intelligence = intelligence;
    }

    /**
     * Returns the wisdom.
     * 
     * @return the wisdom
     */
    public int getWisdom() {
	return wisdom;
    }

    /**
     * Sets the value of wisdom to that of the parameter.
     * 
     * @param wisdom
     *            the wisdom to set
     */
    public void setWisdom(int wisdom) {
	this.wisdom = wisdom;
    }

    /**
     * Returns the charisma.
     * 
     * @return the charisma
     */
    public int getCharisma() {
	return charisma;
    }

    /**
     * Sets the value of charisma to that of the parameter.
     * 
     * @param charisma
     *            the charisma to set
     */
    public void setCharisma(int charisma) {
	this.charisma = charisma;
    }

    /**
     * Returns the maxHP.
     * 
     * @return the maxHP
     */
    public int getMaxHP() {
	return maxHP;
    }

    /**
     * Sets the value of maxHP to that of the parameter.
     * 
     * @param maxHP
     *            the maxHP to set
     */
    public void setMaxHP(int maxHP) {
	this.maxHP = maxHP;
    }

    /**
     * Returns the currentHP.
     * 
     * @return the currentHP
     */
    public int getCurrentHP() {
	return currentHP;
    }

    /**
     * Sets the value of currentHP to that of the parameter.
     * 
     * @param currentHP
     *            the currentHP to set
     */
    public void setCurrentHP(int currentHP) {
	this.currentHP = currentHP;
    }

    /**
     * Returns the xp.
     * @return the xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * Sets the value of xp to that of the parameter.
     * @param xp the xp to set
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * Returns the level.
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the value of level to that of the parameter.
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of name to that of the parameter.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public static int getAttributeModifier(int attribute) {
	return attribute - 10 / 2;
    }

    /**
     * Returns the feats.
     * @return the feats
     */
    public Collection<Feat> getFeats() {
        return feats;
    }

    /**
     * Sets the value of feats to that of the parameter.
     * @param feats the feats to set
     */
    public void setFeats(Collection<Feat> feats) {
        this.feats = feats;
    }
}
