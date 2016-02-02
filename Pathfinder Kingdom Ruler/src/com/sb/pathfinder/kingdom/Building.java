package com.sb.pathfinder.kingdom;

import java.io.Serializable;

public class Building implements Serializable, KingdomModifier, SettlementModifier {

    private static final long serialVersionUID = -4627855905786711186L;

    // Building properties
    private String name;
    private int usedLots;
    private int constructionCost;

    // Kingdom modifiers
    private int unrest;
    private int economy;
    private int loyalty;
    private int stability;
    private int consumption;
    private int glory;
    private int infamy;

    // Settlement modifiers
    private int corruption;
    private int criminality;
    private int law;
    private int lore;
    private int productivity;
    private int society;
    private int defense;

    public Building(String name, int usedLots, int constructionCost) {
	this.name = name;
	this.usedLots = usedLots;
	this.constructionCost = constructionCost;
    }


    /**
     * Returns the unrest.
     * @return the unrest
     */
    public int getUnrest() {
        return unrest;
    }


    /**
     * Sets the value of unrest to that of the parameter.
     * @param unrest the unrest to set
     */
    public void setUnrest(int unrest) {
        this.unrest = unrest;
    }


    /**
     * Returns the economy.
     * @return the economy
     */
    public int getEconomy() {
        return economy;
    }


    /**
     * Sets the value of economy to that of the parameter.
     * @param economy the economy to set
     */
    public void setEconomy(int economy) {
        this.economy = economy;
    }


    /**
     * Returns the loyalty.
     * @return the loyalty
     */
    public int getLoyalty() {
        return loyalty;
    }


    /**
     * Sets the value of loyalty to that of the parameter.
     * @param loyalty the loyalty to set
     */
    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }


    /**
     * Returns the stability.
     * @return the stability
     */
    public int getStability() {
        return stability;
    }


    /**
     * Sets the value of stability to that of the parameter.
     * @param stability the stability to set
     */
    public void setStability(int stability) {
        this.stability = stability;
    }


    /**
     * Returns the consumption.
     * @return the consumption
     */
    public int getConsumption() {
        return consumption;
    }


    /**
     * Sets the value of consumption to that of the parameter.
     * @param consumption the consumption to set
     */
    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }


    /**
     * Returns the glory.
     * @return the glory
     */
    public int getGlory() {
        return glory;
    }


    /**
     * Sets the value of glory to that of the parameter.
     * @param glory the glory to set
     */
    public void setGlory(int glory) {
        this.glory = glory;
    }


    /**
     * Returns the infamy.
     * @return the infamy
     */
    public int getInfamy() {
        return infamy;
    }


    /**
     * Sets the value of infamy to that of the parameter.
     * @param infamy the infamy to set
     */
    public void setInfamy(int infamy) {
        this.infamy = infamy;
    }


    /**
     * Returns the corruption.
     * @return the corruption
     */
    public int getCorruption() {
        return corruption;
    }


    /**
     * Sets the value of corruption to that of the parameter.
     * @param corruption the corruption to set
     */
    public void setCorruption(int corruption) {
        this.corruption = corruption;
    }


    /**
     * Returns the criminality.
     * @return the criminality
     */
    public int getCriminality() {
        return criminality;
    }


    /**
     * Sets the value of criminality to that of the parameter.
     * @param criminality the criminality to set
     */
    public void setCriminality(int criminality) {
        this.criminality = criminality;
    }


    /**
     * Returns the law.
     * @return the law
     */
    public int getLaw() {
        return law;
    }


    /**
     * Sets the value of law to that of the parameter.
     * @param law the law to set
     */
    public void setLaw(int law) {
        this.law = law;
    }


    /**
     * Returns the lore.
     * @return the lore
     */
    public int getLore() {
        return lore;
    }


    /**
     * Sets the value of lore to that of the parameter.
     * @param lore the lore to set
     */
    public void setLore(int lore) {
        this.lore = lore;
    }


    /**
     * Returns the productivity.
     * @return the productivity
     */
    public int getProductivity() {
        return productivity;
    }


    /**
     * Sets the value of productivity to that of the parameter.
     * @param productivity the productivity to set
     */
    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }


    /**
     * Returns the society.
     * @return the society
     */
    public int getSociety() {
        return society;
    }


    /**
     * Sets the value of society to that of the parameter.
     * @param society the society to set
     */
    public void setSociety(int society) {
        this.society = society;
    }


    /**
     * Returns the defense.
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }


    /**
     * Sets the value of defense to that of the parameter.
     * @param defense the defense to set
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }


    @Override
    public void applyTo(Kingdom kingdom) {
	kingdom.modUnrest(unrest);
	kingdom.modEconomy(economy);
	kingdom.modLoyalty(loyalty);
	kingdom.modStability(stability);
	kingdom.modConsumption(consumption);
	kingdom.modGlory(glory);
	kingdom.modInfamy(infamy);
    }


    @Override
    public void removeFrom(Kingdom kingdom) {
	kingdom.modUnrest(-unrest);
	kingdom.modEconomy(-economy);
	kingdom.modLoyalty(-loyalty);
	kingdom.modStability(-stability);
	kingdom.modConsumption(-consumption);
	kingdom.modGlory(-glory);
	kingdom.modInfamy(-infamy);
    }


    @Override
    public void applyTo(Settlement settlement) {
	settlement.modCorruption(corruption);
	settlement.modCriminality(criminality);
	settlement.modLaw(law);
	settlement.modLore(lore);
	settlement.modProductivity(productivity);
	settlement.modSociety(society);
	settlement.modDefense(defense);
    }


    @Override
    public void removeFrom(Settlement settlement) {
	settlement.modCorruption(-corruption);
	settlement.modCriminality(-criminality);
	settlement.modLaw(-law);
	settlement.modLore(-lore);
	settlement.modProductivity(-productivity);
	settlement.modSociety(-society);
	settlement.modDefense(-defense);
    }

    @Override
    public Building clone() {
	Building clone = new Building(name, usedLots, constructionCost);
	
	// Transfer kingdom properties
	clone.setUnrest(unrest);
	clone.setEconomy(economy);
	clone.setLoyalty(loyalty);
	clone.setStability(stability);
	clone.setConsumption(consumption);
	clone.setGlory(glory);
	clone.setInfamy(infamy);
	
	// Transfer settlement properties
	clone.setCorruption(corruption);
	clone.setCriminality(criminality);
	clone.setLaw(law);
	clone.setLore(lore);
	clone.setProductivity(productivity);
	clone.setSociety(society);
	clone.setDefense(defense);
	
	return clone;
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


    /**
     * Returns the usedLots.
     * @return the usedLots
     */
    public int getUsedLots() {
        return usedLots;
    }


    /**
     * Sets the value of usedLots to that of the parameter.
     * @param usedLots the usedLots to set
     */
    public void setUsedLots(int usedLots) {
        this.usedLots = usedLots;
    }


    /**
     * Returns the constructionCost.
     * @return the constructionCost
     */
    public int getConstructionCost() {
        return constructionCost;
    }


    /**
     * Sets the value of constructionCost to that of the parameter.
     * @param constructionCost the constructionCost to set
     */
    public void setConstructionCost(int constructionCost) {
        this.constructionCost = constructionCost;
    }
}
