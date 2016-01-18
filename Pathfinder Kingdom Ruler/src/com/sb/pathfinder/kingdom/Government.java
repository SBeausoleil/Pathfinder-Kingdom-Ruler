package com.sb.pathfinder.kingdom;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.function.Consumer;

import com.sb.pathfinder.kingdom.government.Consort;
import com.sb.pathfinder.kingdom.government.Councilor;
import com.sb.pathfinder.kingdom.government.General;
import com.sb.pathfinder.kingdom.government.GrandDiplomat;
import com.sb.pathfinder.kingdom.government.Heir;
import com.sb.pathfinder.kingdom.government.HighPriest;
import com.sb.pathfinder.kingdom.government.LeaderAction;
import com.sb.pathfinder.kingdom.government.LeadershipRole;
import com.sb.pathfinder.kingdom.government.Magister;
import com.sb.pathfinder.kingdom.government.Marshal;
import com.sb.pathfinder.kingdom.government.RoyalEnforcer;
import com.sb.pathfinder.kingdom.government.Ruler;
import com.sb.pathfinder.kingdom.government.Spymaster;
import com.sb.pathfinder.kingdom.government.Treasurer;
import com.sb.pathfinder.kingdom.government.Viceroy;
import com.sb.pathfinder.kingdom.government.Warden;

public class Government implements Serializable {
    private static final long serialVersionUID = -5769498101269069307L;
    
    private Kingdom kingdom;
    
    private LinkedHashSet<Ruler> rulers; // There may be two rulers if they are married and of equal rank.
    private LinkedHashSet<Consort> consorts;
    private Councilor councilor;
    private General general;
    private GrandDiplomat grandDiplomat;
    private Heir heir;
    private HighPriest highPriest;
    private Magister magister;
    private Marshal marshal;
    private RoyalEnforcer royalEnforcer;
    private Spymaster spymaster;
    private Treasurer treasurer;
    private LinkedHashSet<Viceroy> viceroys;
    private Warden warden;
    
    public Government(Kingdom kingdom) {
	this.kingdom = kingdom;
	rulers = new LinkedHashSet<Ruler>();
	consorts = new LinkedHashSet<Consort>();
	councilor = new Councilor("Councilor", null, false, kingdom);
	general = new General("General", null, false, kingdom);
	grandDiplomat = new GrandDiplomat("Grand Diplomat", null, false, kingdom);
	heir = new Heir("Heir", null, false, kingdom);
	highPriest = new HighPriest("High Priest", null, false, kingdom);
	magister = new Magister("Magister", null, false, kingdom);
	marshal = new Marshal("Marshal", null, false, kingdom);
	royalEnforcer = new RoyalEnforcer("Royal Enforcer", null, false, kingdom);
	spymaster = new Spymaster("Spymaster", null, false, kingdom);
	treasurer = new Treasurer("Treasurer", null, false, kingdom);
	viceroys = new LinkedHashSet<Viceroy>();
	warden = new Warden("Warden", null, false, kingdom);
    }
    
    public Government(Kingdom kingdom, LinkedHashSet<Ruler> ruler, LinkedHashSet<Consort> consorts, Councilor councilor, General general,
	    GrandDiplomat grandDiplomat, Heir heir, HighPriest highPriest, Magister magister, Marshal marshal,
	    RoyalEnforcer royalEnforcer, Spymaster spymaster, Treasurer treasurer, LinkedHashSet<Viceroy> viceroys,
	    Warden warden) {
	this.kingdom = kingdom;
	this.rulers = ruler;
	this.consorts = consorts;
	this.councilor = councilor;
	this.general = general;
	this.grandDiplomat = grandDiplomat;
	this.heir = heir;
	this.highPriest = highPriest;
	this.magister = magister;
	this.marshal = marshal;
	this.royalEnforcer = royalEnforcer;
	this.spymaster = spymaster;
	this.treasurer = treasurer;
	this.viceroys = viceroys;
	this.warden = warden;
    }

    /**
     * Returns the list of rulers.
     * @return the list of rulers.
     */
    public Iterator<Ruler> getRulers() {
        return rulers.iterator();
    }

    public boolean addRuler(Ruler ruler) {
	if (ruler != null && rulers.add(ruler)) {
	    ruler.apply();
	    return true;
	}
	return false;
    }
    
    public boolean removeRuler(Ruler ruler) {
	if (ruler != null && rulers.remove(ruler)) {
	    ruler.remove();
	    return true;
	}
	return false;
    }
    
    /**
     * Returns the consort.
     * @return the consort
     */
    public Iterator<Consort> getConsorts() {
        return consorts.iterator();
    }
    
    public boolean addConsort(Consort consort) {
	if (consort != null && consorts.add(consort)) {
	    consort.apply();
	    return true;
	}
	return false;
    }
    
    public boolean removeConsort(Consort consort) {
	if (consort != null && consorts.remove(consort)) {
	    consort.remove();
	    return true;
	}
	return false;
    }

    /**
     * Returns the councilor.
     * @return the councilor
     */
    public Councilor getCouncilor() {
        return councilor;
    }

    /**
     * Sets the value of councilor to that of the parameter.
     * @param councilor the councilor to set
     */
    public void setCouncilor(Councilor councilor) {
	if (this.councilor != null)
	    this.councilor.remove();
        this.councilor = councilor;
        if (councilor != null)
            councilor.apply();
    }

    /**
     * Returns the general.
     * @return the general
     */
    public General getGeneral() {
        return general;
    }

    /**
     * Sets the value of general to that of the parameter.
     * @param general the general to set
     */
    public void setGeneral(General general) {
	if (this.general != null)
	    this.general.remove();
        this.general = general;
        if (general != null)
            general.apply();
    }

    /**
     * Returns the grandDiplomat.
     * @return the grandDiplomat
     */
    public GrandDiplomat getGrandDiplomat() {
        return grandDiplomat;
    }

    /**
     * Sets the value of grandDiplomat to that of the parameter.
     * @param grandDiplomat the grandDiplomat to set
     */
    public void setGrandDiplomat(GrandDiplomat grandDiplomat) {
	if (this.grandDiplomat != null)
	    this.grandDiplomat.remove();
        this.grandDiplomat = grandDiplomat;
        if (grandDiplomat != null)
            grandDiplomat.apply();
    }

    /**
     * Returns the heir.
     * @return the heir
     */
    public Heir getHeir() {
        return heir;
    }

    /**
     * Sets the value of heir to that of the parameter.
     * @param heir the heir to set
     */
    public void setHeir(Heir heir) {
	if (this.heir != null)
	    this.heir.remove();
        this.heir = heir;
        if (heir != null)
            heir.apply();
    }

    /**
     * Returns the highPriest.
     * @return the highPriest
     */
    public HighPriest getHighPriest() {
        return highPriest;
    }

    /**
     * Sets the value of highPriest to that of the parameter.
     * @param highPriest the highPriest to set
     */
    public void setHighPriest(HighPriest highPriest) {
	if (this.highPriest != null)
	    this.highPriest.remove();
        this.highPriest = highPriest;
        if (highPriest != null)
            highPriest.apply();
    }

    /**
     * Returns the magister.
     * @return the magister
     */
    public Magister getMagister() {
        return magister;
    }

    /**
     * Sets the value of magister to that of the parameter.
     * @param magister the magister to set
     */
    public void setMagister(Magister magister) {
	if (this.magister != null)
	    this.magister.remove();
        this.magister = magister;
        if (magister != null)
            magister.apply();
    }

    /**
     * Returns the marshal.
     * @return the marshal
     */
    public Marshal getMarshal() {
        return marshal;
    }

    /**
     * Sets the value of marshal to that of the parameter.
     * @param marshal the marshal to set
     */
    public void setMarshal(Marshal marshal) {
	if (this.marshal != null)
	    this.marshal.remove();
        this.marshal = marshal;
        if (marshal != null)
            marshal.apply();
    }

    /**
     * Returns the royalEnforcer.
     * @return the royalEnforcer
     */
    public RoyalEnforcer getRoyalEnforcer() {
        return royalEnforcer;
    }

    /**
     * Sets the value of royalEnforcer to that of the parameter.
     * @param royalEnforcer the royalEnforcer to set
     */
    public void setRoyalEnforcer(RoyalEnforcer royalEnforcer) {
	if (this.royalEnforcer != null)
	    this.royalEnforcer.remove();
        this.royalEnforcer = royalEnforcer;
        if (royalEnforcer != null)
            royalEnforcer.apply();
    }

    /**
     * Returns the spymaster.
     * @return the spymaster
     */
    public Spymaster getSpymaster() {
        return spymaster;
    }

    /**
     * Sets the value of spymaster to that of the parameter.
     * @param spymaster the spymaster to set
     */
    public void setSpymaster(Spymaster spymaster) {
	if (this.spymaster != null)
	    this.spymaster.remove();
        this.spymaster = spymaster;
        if (spymaster != null)
            spymaster.remove();
    }

    /**
     * Returns the treasurer.
     * @return the treasurer
     */
    public Treasurer getTreasurer() {
        return treasurer;
    }

    /**
     * Sets the value of treasurer to that of the parameter.
     * @param treasurer the treasurer to set
     */
    public void setTreasurer(Treasurer treasurer) {
	if (this.treasurer != null)
	    this.treasurer.remove();
        this.treasurer = treasurer;
        if (treasurer != null)
            treasurer.apply();
    }

    /**
     * Returns the viceroys.
     * @return the viceroys
     */
    public Iterator<Viceroy> getViceroys() {
        return viceroys.iterator();
    }

    public boolean addViceroy(Viceroy viceroy) {
	if (viceroy != null && viceroys.add(viceroy)) {
	    viceroy.apply();
	    return true;
	}
	return false;
	    
    }
    
    public boolean removeViceroy(Viceroy viceroy) {
	if (viceroy != null && viceroys.remove(viceroy)) {
	    viceroy.remove();
	    return true;
	}
	return false;
    }
    
    /**
     * Returns the warden.
     * @return the warden
     */
    public Warden getWarden() {
        return warden;
    }

    /**
     * Sets the value of warden to that of the parameter.
     * @param warden the warden to set
     */
    public void setWarden(Warden warden) {
	if (this.warden != null)
	    this.warden.remove();
        this.warden = warden;
        if (warden != null)
            warden.apply();
    }

    /**
     * Returns the kingdom.
     * @return the kingdom
     */
    public Kingdom getKingdom() {
        return kingdom;
    }

    /**
     * Sets the value of kingdom to that of the parameter.
     * Changes the kingdom of every leadership roles in the government.
     * @param kingdom the kingdom to set
     */
    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
        
        // Update the loyalties of the leaders
        leadersDo((role) -> role.setKingdom(kingdom));
    }

    public void leadersDo(Consumer<LeadershipRole> action) {
	for (LeadershipRole ruler : rulers)
	    action.accept(ruler);
	for (LeadershipRole consort : consorts)
	    action.accept(consort);
	action.accept(councilor);
	action.accept(general);
	action.accept(general);
	action.accept(grandDiplomat);
	action.accept(heir);
	action.accept(highPriest);
	action.accept(magister);
	action.accept(marshal);
	action.accept(royalEnforcer);
	action.accept(spymaster);
	action.accept(treasurer);
	for (LeadershipRole viceroy : viceroys)
	    action.accept(viceroy);
	action.accept(warden);
    }
}
