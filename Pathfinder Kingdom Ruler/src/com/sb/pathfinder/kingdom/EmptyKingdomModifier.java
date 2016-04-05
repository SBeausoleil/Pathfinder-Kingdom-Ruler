package com.sb.pathfinder.kingdom;

/**
 * An implementation of KingdomModifier interface that does nothing.
 * 
 * @author Samuel Beausoleil
 *
 */
public final class EmptyKingdomModifier implements SerializableKingdomModifier {

    private static final long serialVersionUID = -4086513925346567040L;
    
    private static final EmptyKingdomModifier INSTANCE = new EmptyKingdomModifier();
    
    public static EmptyKingdomModifier getInstance() {
	return INSTANCE;
    }
    
    private EmptyKingdomModifier() {}
    
    /**
     * Does nothing.
     */
    @Override
    public void applyTo(Kingdom kingdom) {
    }

    /**
     * Does nothing.
     */
    @Override
    public void removeFrom(Kingdom kingdom) {
    }
}
