package com.sb.pathfinder.kingdom;

public interface SettlementModifier {

    public void applyTo(Settlement settlement);
    
    public void removeFrom(Settlement settlement);
}
