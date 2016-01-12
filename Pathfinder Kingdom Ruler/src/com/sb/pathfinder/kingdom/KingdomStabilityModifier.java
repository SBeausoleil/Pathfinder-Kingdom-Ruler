package com.sb.pathfinder.kingdom;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.KingdomModifier;

public class KingdomStabilityModifier implements KingdomModifier {

    private int modifier;
    
    public KingdomStabilityModifier(int modifier) {
	this.modifier = modifier;
    }
    
    @Override
    public void applyTo(Kingdom kingdom) {
	kingdom.modStability(modifier);
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
	kingdom.modStability(-modifier);
    }

}
