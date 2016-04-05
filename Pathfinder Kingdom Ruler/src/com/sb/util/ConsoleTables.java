package com.sb.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class ConsoleTables {

    public static void display(LinkedHashMap<String, LinkedHashMap<String, String>> table) {
   	// Find all the keys used at least once
   	Set<String> keys = new LinkedHashSet<>();
   	for (LinkedHashMap<String, String> columns : table.values())
   	    for (String key : columns.keySet())
   		keys.add(key);

   	// Build a header containing all the used modifiers
   	ConsoleTable console = new ConsoleTable(Strings.getLongestLength(keys), keys.size() + 1);
   	console.newRow();
   	// One empty cell
   	console.addField("");
   	// Start building header
   	for (String modifier : keys)
   	    console.addField(modifier);

   	// Each row follow the format: <table.key><modifier1><modifier2>...
   	for (LinkedHashMap<String, String> row : table.values()) {
   	    console.newRow();
   	    Iterator<String> keysIterator = keys.iterator();
   	    String column;
   	    while (keysIterator.hasNext()) {
   		column = row.get(keysIterator.next());
   		console.addField(column != null ? column : "");
   	    }
   	}
   	
   	console.display();
       }
    
}
