package com.sb.pathfinder.kingdom;

public interface KingdomModifier {

    public void applyTo(Kingdom kingdom);
    
    public void removeFrom(Kingdom kingdom);
}
