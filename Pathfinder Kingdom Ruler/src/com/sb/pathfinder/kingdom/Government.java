package com.sb.pathfinder.kingdom;

import java.io.Serializable;
import java.util.LinkedList;

import com.sb.pathfinder.kingdom.government.Consort;
import com.sb.pathfinder.kingdom.government.Councilor;
import com.sb.pathfinder.kingdom.government.General;
import com.sb.pathfinder.kingdom.government.GrandDiplomat;
import com.sb.pathfinder.kingdom.government.Heir;
import com.sb.pathfinder.kingdom.government.HighPriest;
import com.sb.pathfinder.kingdom.government.Magister;
import com.sb.pathfinder.kingdom.government.Marshal;
import com.sb.pathfinder.kingdom.government.RoyalEnforcer;
import com.sb.pathfinder.kingdom.government.Ruler;
import com.sb.pathfinder.kingdom.government.Spymaster;
import com.sb.pathfinder.kingdom.government.Treasurer;
import com.sb.pathfinder.kingdom.government.Viceroy;
import com.sb.pathfinder.kingdom.government.Warden;

public class Government implements KingdomModifier, Serializable {
    private static final long serialVersionUID = -5769498101269069307L;
    
    private LinkedList<Ruler> ruler; // There may be two rulers if they are married and of equal rank.
    private Consort consort;
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
    private LinkedList<Viceroy> viceroys;
    private Warden warden;
    
    public Government() {
	ruler = new LinkedList<Ruler>();
	viceroys = new LinkedList<Viceroy>();
    }
    
    public Government(LinkedList<Ruler> ruler, Consort consort, Councilor councilor, General general,
	    GrandDiplomat grandDiplomat, Heir heir, HighPriest highPriest, Magister magister, Marshal marshal,
	    RoyalEnforcer royalEnforcer, Spymaster spymaster, Treasurer treasurer, LinkedList<Viceroy> viceroys,
	    Warden warden) {
	this.ruler = ruler;
	this.consort = consort;
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

    @Override
    public void applyTo(Kingdom kingdom) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	// TODO Auto-generated method stub
	
    }

    /**
     * Returns the ruler.
     * @return the ruler
     */
    public LinkedList<Ruler> getRuler() {
        return ruler;
    }

    /**
     * Sets the value of ruler to that of the parameter.
     * @param ruler the ruler to set
     */
    public void setRuler(LinkedList<Ruler> ruler) {
        this.ruler = ruler;
    }

    /**
     * Returns the consort.
     * @return the consort
     */
    public Consort getConsort() {
        return consort;
    }

    /**
     * Sets the value of consort to that of the parameter.
     * @param consort the consort to set
     */
    public void setConsort(Consort consort) {
        this.consort = consort;
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
        this.councilor = councilor;
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
        this.general = general;
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
        this.grandDiplomat = grandDiplomat;
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
        this.heir = heir;
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
        this.highPriest = highPriest;
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
        this.magister = magister;
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
        this.marshal = marshal;
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
        this.royalEnforcer = royalEnforcer;
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
        this.spymaster = spymaster;
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
        this.treasurer = treasurer;
    }

    /**
     * Returns the viceroys.
     * @return the viceroys
     */
    public LinkedList<Viceroy> getViceroys() {
        return viceroys;
    }

    /**
     * Sets the value of viceroys to that of the parameter.
     * @param viceroys the viceroys to set
     */
    public void setViceroys(LinkedList<Viceroy> viceroys) {
        this.viceroys = viceroys;
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
        this.warden = warden;
    }

}
