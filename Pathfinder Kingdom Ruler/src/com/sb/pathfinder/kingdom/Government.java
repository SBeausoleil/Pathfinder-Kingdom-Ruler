package com.sb.pathfinder.kingdom;

import java.io.Serializable;
import java.util.LinkedList;

import com.sb.pathfinder.kingdom.government.Consort;
import com.sb.pathfinder.kingdom.government.Councilor;
import com.sb.pathfinder.kingdom.government.General;
import com.sb.pathfinder.kingdom.government.GrandDiplomat;
import com.sb.pathfinder.kingdom.government.Heir;
import com.sb.pathfinder.kingdom.government.HighPriest;
import com.sb.pathfinder.kingdom.government.Ruler;

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
    @Override
    public void applyTo(Kingdom kingdom) {
	// TODO Auto-generated method stub
	
    }
    @Override
    public void removeFrom(Kingdom kingdom) {
	// TODO Auto-generated method stub
	
    }
  
    
}
