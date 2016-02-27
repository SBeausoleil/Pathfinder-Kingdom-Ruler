package com.sb.pathfinder.kingdom.app;

import com.sb.pathfinder.kingdom.Kingdom;

public interface KingdomDependant {

    public Kingdom getCurrentKingdom();
    
    public void setCurrentKingdom(Kingdom currentKingdom);
}
