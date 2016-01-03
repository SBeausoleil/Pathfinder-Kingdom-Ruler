package com.sb.pathfinder.kingdom;

public enum MoralAlignment implements KingdomModifier  {

    GOOD, NEUTRAL, EVIL;

    public void applyTo(Kingdom kingdom) {
	switch (this) {
	case GOOD:
	    kingdom.modLoyalty(2);
	    break;
	case NEUTRAL:
	    kingdom.modStability(2);
	    break;
	case EVIL:
	    kingdom.modEconomy(2);
	    break;
	}
    }

    public void removeFrom(Kingdom kingdom) {
	switch (this) {
	case GOOD:
	    kingdom.modLoyalty(-2);
	    break;
	case NEUTRAL:
	    kingdom.modStability(-2);
	    break;
	case EVIL:
	    kingdom.modEconomy(-2);
	    break;
	}
    }
}
