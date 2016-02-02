package com.sb.menu;

import java.util.Scanner;

import com.sb.util.IntBracket;

public class MenuUtil {

    public static Scanner keyboard = new Scanner(System.in);
    
    // This is a utility class. It should not be instantiated.
    private MenuUtil() {}
 
    public static int requestInt(String message, IntBracket bracket, String errorMessage) {
	String input;
	int value;
	while (true) {
	    System.out.println(message);
	    input = keyboard.nextLine();
	    if (isInteger(input)) {
		value = Integer.parseInt(input);
		if (bracket.isInside(value))
		    return value;
	    }
	    System.out.println(errorMessage);
	}
    }
    
    public static boolean isInteger(String str) {
	return str.matches("^[0-9]+$");
    }
}
