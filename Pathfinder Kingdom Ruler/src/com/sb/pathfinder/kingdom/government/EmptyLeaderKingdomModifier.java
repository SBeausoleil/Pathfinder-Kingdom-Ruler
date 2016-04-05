package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.Kingdom;

public final class EmptyLeaderKingdomModifier implements LeaderKingdomModifier {

    private static final long serialVersionUID = 1621722912140160341L;

    private static final EmptyLeaderKingdomModifier INSTANCE = new EmptyLeaderKingdomModifier();

    @Override
    public void applyTo(Kingdom kingdom) {
    }

    @Override
    public void removeFrom(Kingdom kingdom) {
    }

    @Override
    public LinkedHashMap<String, String> describe() {
	LinkedHashMap<String, String> description = new LinkedHashMap<>();
	return description;
    }

    public static EmptyLeaderKingdomModifier getInstance() {
	return INSTANCE;
    }
}
