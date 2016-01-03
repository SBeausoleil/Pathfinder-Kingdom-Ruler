package com.sb.pathfinder.kingdom;

public enum LawAlignment implements KingdomModifier  {
    
    LAWFUL, NEUTRAL, CHAOTIC;
   
    public void applyTo(Kingdom kingdom) {
	switch (this) {
	case LAWFUL:
	    kingdom.modEconomy(2);
	    break;
	case NEUTRAL:
	    kingdom.modStability(2);
	    break;
	case CHAOTIC:
	    kingdom.modLoyalty(2);
	    break;
	}
    }

    public void removeFrom(Kingdom kingdom) {
	switch (this) {
	case LAWFUL:
	    kingdom.modEconomy(-2);
	    break;
	case NEUTRAL:
	    kingdom.modStability(-2);
	    break;
	case CHAOTIC:
	    kingdom.modLoyalty(-2);
	    break;
	}
    }
}
