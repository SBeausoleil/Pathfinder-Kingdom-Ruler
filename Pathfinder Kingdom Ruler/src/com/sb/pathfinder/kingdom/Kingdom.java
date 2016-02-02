package com.sb.pathfinder.kingdom;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * A Kingdom as represented in Pathfinder.
 * 
 * @author Samuel Beausoleil
 */
public class Kingdom implements Serializable {

    private static final long serialVersionUID = -5977335406962574382L;

    public static enum Attribute {
	ECONOMY, LOYALTY, STABILITY;
    }

    private String name;
    private MoralAlignment moralAlignment;
    private LawAlignment lawAlignment;
    private long population;
    private LinkedList<Tile> tiles;
    private Map<String, Settlement> settlements;
    private int constructionPoints;

    private int unrest;

    private int economy;
    private int loyalty;
    private int stability;

    private int consumption;

    private int glory;
    private int infamy;

    private Government government;

    private HolidayEdict holidayEdict;
    private PromotionEdict promotionEdict;
    private TaxationEdict taxationEdict;
    // Improvement edict is selected on call of getImprovementEdict() to take into account all changes in kingdom size

    public Kingdom(String name, MoralAlignment moralAlignment, LawAlignment lawAlignment, Government government) {
	this(name, moralAlignment, lawAlignment, government, HolidayEdict.NO_HOLIDAYS, PromotionEdict.NONE,
		TaxationEdict.NONE);
    }

    public Kingdom(String name, MoralAlignment moralAlignment, LawAlignment lawAlignment, Government government,
	    HolidayEdict holidayEdict, PromotionEdict promotionEdict, TaxationEdict taxationEdict) {
	this.name = name;
	this.moralAlignment = moralAlignment;
	this.lawAlignment = lawAlignment;
	this.government = government;
	this.holidayEdict = holidayEdict;
	this.promotionEdict = promotionEdict;
	this.taxationEdict = taxationEdict;
	tiles = new LinkedList<Tile>();
	settlements = new HashMap<String, Settlement>();
    }

    /**
     * Returns the name.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the value of name to that of the parameter.
     * 
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Returns the moralAlignment.
     * 
     * @return the moralAlignment
     */
    public MoralAlignment getMoralAlignment() {
	return moralAlignment;
    }

    /**
     * Sets the value of moralAlignment to that of the parameter.
     * 
     * @param moralAlignment
     *            the moralAlignment to set
     */
    public void setMoralAlignment(MoralAlignment moralAlignment) {
	this.moralAlignment.removeFrom(this);
	this.moralAlignment = moralAlignment;
	moralAlignment.applyTo(this);
    }

    /**
     * Returns the lawAlignment.
     * 
     * @return the lawAlignment
     */
    public LawAlignment getLawAlignment() {
	return lawAlignment;
    }

    /**
     * Sets the value of lawAlignment to that of the parameter.
     * 
     * @param lawAlignment
     *            the lawAlignment to set
     */
    public void setLawAlignment(LawAlignment lawAlignment) {
	this.lawAlignment.removeFrom(this);
	this.lawAlignment = lawAlignment;
	lawAlignment.applyTo(this);
    }

    /**
     * Returns the population.
     * 
     * @return the population
     */
    public long getPopulation() {
	return population;
    }

    /**
     * Sets the value of population to that of the parameter.
     * 
     * @param population
     *            the population to set
     */
    public void setPopulation(long population) {
	this.population = population;
    }

    /**
     * Adds the mod to the population.
     * 
     * @param mod
     *            to add to the population.
     */
    public void modPopulation(long mod) {
	this.population += mod;
    }

    /**
     * Returns the tiles.
     * 
     * @return the tiles
     */
    public Collection<Tile> getTiles() {
	return tiles;
    }

    /**
     * Sets the value of tiles to that of the parameter.
     * 
     * @param tiles
     *            the tiles to set
     */
    public void setTiles(LinkedList<Tile> tiles) {
	this.tiles = tiles;
    }

    /**
     * Returns the unrest.
     * 
     * @return the unrest
     */
    public int getUnrest() {
	return unrest;
    }

    /**
     * Sets the value of unrest to that of the parameter.
     * 
     * @param unrest
     *            the unrest to set
     */
    public void setUnrest(int unrest) {
	this.unrest = unrest;
    }

    /**
     * Adds the mod to the unrest.
     * 
     * @param mod
     *            to add to the unrest.
     */
    public void modUnrest(int mod) {
	this.unrest += mod;
    }

    /**
     * Returns the economy.
     * 
     * @return the economy
     */
    public int getEconomy() {
	return economy;
    }

    /**
     * Sets the value of economy to that of the parameter.
     * 
     * @param economy
     *            the economy to set
     */
    public void setEconomy(int economy) {
	this.economy = economy;
    }

    /**
     * Adds the mod to the economy.
     * 
     * @param mod
     *            to add to the economy.
     */
    public void modEconomy(int mod) {
	this.economy += mod;
    }

    /**
     * Returns the loyalty.
     * 
     * @return the loyalty
     */
    public int getLoyalty() {
	return loyalty;
    }

    /**
     * Sets the value of loyalty to that of the parameter.
     * 
     * @param loyalty
     *            the loyalty to set
     */
    public void setLoyalty(int loyalty) {
	this.loyalty = loyalty;
    }

    /**
     * Adds the mod to the loyalty.
     * 
     * @param mod
     *            to add to the loyalty.
     */
    public void modLoyalty(int mod) {
	this.loyalty += mod;
    }

    /**
     * Returns the stability.
     * 
     * @return the stability
     */
    public int getStability() {
	return stability;
    }

    /**
     * Sets the value of stability to that of the parameter.
     * 
     * @param stability
     *            the stability to set
     */
    public void setStability(int stability) {
	this.stability = stability;
    }

    /**
     * Adds the mod to the stability.
     * 
     * @param mod
     *            to add to the stability.
     */
    public void modStability(int mod) {
	this.stability += mod;
    }

    /**
     * Returns the consumption.
     * 
     * @return the consumption
     */
    public int getConsumption() {
	return consumption;
    }

    /**
     * Sets the value of consumption to that of the parameter.
     * 
     * @param consumption
     *            the consumption to set
     */
    public void setConsumption(int consumption) {
	this.consumption = consumption;
    }

    /**
     * Adds the mod to the consumption.
     * 
     * @param mod
     *            to add to the consumption.
     */
    public void modConsumption(int mod) {
	this.consumption += mod;
    }

    /**
     * Returns the glory.
     * 
     * @return the glory
     */
    public int getGlory() {
	return glory;
    }

    /**
     * Sets the value of glory to that of the parameter.
     * 
     * @param glory
     *            the glory to set
     */
    public void setGlory(int glory) {
	this.glory = glory;
    }

    /**
     * Adds the mod to the glory.
     * 
     * @param mod
     *            to add to the glory.
     */
    public void modGlory(int mod) {
	this.glory += mod;
    }

    /**
     * Returns the infamy.
     * 
     * @return the infamy
     */
    public int getInfamy() {
	return infamy;
    }

    /**
     * Sets the value of infamy to that of the parameter.
     * 
     * @param infamy
     *            the infamy to set
     */
    public void setInfamy(int infamy) {
	this.infamy = infamy;
    }

    /**
     * Adds the mod to the infamy.
     * 
     * @param mod
     *            to add to the infamy.
     */
    public void modInfamy(int mod) {
	this.infamy += mod;
    }

    /**
     * Returns the government.
     * 
     * @return the government
     */
    public Government getGovernment() {
	return government;
    }

    /**
     * Sets the value of government to that of the parameter.
     * 
     * @param government
     *            the government to set
     */
    public void setGovernment(Government government) {
	this.government.leadersDo((r) -> r.remove());
	this.government = government;
	if (government.getKingdom() != this)
	    government.setKingdom(this);
    }

    /**
     * Returns the holidayEdict.
     * 
     * @return the holidayEdict
     */
    public HolidayEdict getHolidayEdict() {
	return holidayEdict;
    }

    /**
     * Sets the value of holidayEdict to that of the parameter.
     * 
     * @param holidayEdict
     *            the holidayEdict to set
     */
    public void setHolidayEdict(HolidayEdict holidayEdict) {
	this.holidayEdict.removeFrom(this);
	this.holidayEdict = holidayEdict;
	holidayEdict.applyTo(this);
    }

    /**
     * Returns the promotionEdict.
     * 
     * @return the promotionEdict
     */
    public PromotionEdict getPromotionEdict() {
	return promotionEdict;
    }

    /**
     * Sets the value of promotionEdict to that of the parameter.
     * 
     * @param promotionEdict
     *            the promotionEdict to set
     */
    public void setPromotionEdict(PromotionEdict promotionEdict) {
	this.promotionEdict.removeFrom(this);
	this.promotionEdict = promotionEdict;
	promotionEdict.applyTo(this);
    }

    /**
     * Returns the taxationEdict.
     * 
     * @return the taxationEdict
     */
    public TaxationEdict getTaxationEdict() {
	return taxationEdict;
    }

    /**
     * Sets the value of taxationEdict to that of the parameter.
     * 
     * @param taxationEdict
     *            the taxationEdict to set
     */
    public void setTaxationEdict(TaxationEdict taxationEdict) {
	this.taxationEdict.removeFrom(this);
	this.taxationEdict = taxationEdict;
	taxationEdict.applyTo(this);
    }

    /**
     * Returns the improvementEdict.
     * 
     * @return the improvementEdict
     */
    public ImprovementEdict getImprovementEdict() {
	return ImprovementEdict.getImprovementEdict(this);
    }

    /**
     * Returns the size of the kingdom.
     * The size of the kingdom is it's number of tiles.
     * 
     * @return the size of the kingdom.
     */
    public int getSize() {
	return tiles.size();
    }

    /**
     * Returns the constructionPoints.
     * 
     * @return the constructionPoints
     */
    public int getConstructionPoints() {
	return constructionPoints;
    }

    /**
     * Sets the value of constructionPoints to that of the parameter.
     * 
     * @param constructionPoints
     *            the constructionPoints to set
     */
    public void setConstructionPoints(int constructionPoints) {
	this.constructionPoints = constructionPoints;
    }

    /**
     * Adds the mod to the construction points.
     * 
     * @param mod
     *            to add to the construction points.
     */
    public void modConstructionPoints(int mod) {
	this.constructionPoints += mod;
    }

    public boolean addSettlement(Settlement settlement) {
	if (settlements.containsKey(settlement.getName()))
	    return false;

	if (settlement.getKingdom() != this)
	    settlement.setKingdom(this);

	settlements.put(settlement.getName(), settlement);
	return true;
    }

    public Settlement removeSettlement(Settlement settlement) {
	if (settlement.getKingdom() == this)
	    settlement.setKingdom(null);

	return removeSettlement(settlement.getName());
    }

    public Settlement removeSettlement(String name) {
	return settlements.remove(name);
    }

    public int getNumberOfSettlements() {
	return settlements.size();
    }

    public Iterable<Settlement> getSettlements() {
	return settlements.values();
    }

    public Settlement getSettlement(String name) {
	return settlements.get(name);
    }
}
