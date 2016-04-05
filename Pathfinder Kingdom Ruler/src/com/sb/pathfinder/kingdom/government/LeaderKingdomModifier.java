package com.sb.pathfinder.kingdom.government;

import java.util.LinkedHashMap;

import com.sb.pathfinder.kingdom.SerializableKingdomModifier;

public interface LeaderKingdomModifier extends SerializableKingdomModifier {

    /**
     * Describes the bonuses of this leadership role on it's affected kingdom.
     * The map returned must be formated as so:
     * 	<String, String (number)>
     * 	<Affected element name, value of the change> 
     * 
     * In case the role is currently unnocupied, the returned values must describe how is calculated the bonus.
     * @return a map describing the bonuses brought by this role.
     */
    public LinkedHashMap<String, String> describe();
}
