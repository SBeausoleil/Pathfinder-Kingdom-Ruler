package com.sb.menu;

import java.util.Scanner;

import com.sb.util.IntBracket;

public class MenuUtil {

    public static volatile Scanner keyboard = new Scanner(System.in);

    public static final int CANCELLED_ACTION = Integer.MIN_VALUE;

    // This is a utility class. It should not be instantiated.
    private MenuUtil() {
    }

    public static int requestInt(String message, IntBracket bracket, String errorMessage, String cancel) {
	String input;
	int value;
	while (true) {
	    System.out.println(message);
	    input = keyboard.nextLine();
	    if (isInteger(input)) {
		value = Integer.parseInt(input);
		if (bracket.isInside(value))
		    return value;
	    } else if (input.equals(cancel))
		return CANCELLED_ACTION;
	    System.out.println(errorMessage);
	}
    }

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

    public static int requestInt(String message) {
	return requestInt(message, new IntBracket(Integer.MIN_VALUE, Integer.MAX_VALUE),
		"Error: Please enter an integer");
    }

    public static int requestInt(String message, int defaultValue) {
	String input;
	while (true) {
	    System.out.println(message);
	    input = keyboard.nextLine();
	    if (input.isEmpty())
		return defaultValue;
	    else if (isInteger(input)) {
		return Integer.parseInt(input);
	    }
	    System.out.println(
		    "Error: Please enter an integer (writing nothing will return the default value (" + defaultValue + "))");
	}
    }

    public static boolean isInteger(String str) {
	return str.matches("^-?[0-9]+$");
    }

    public static boolean requestYesNo(String question) {
	while (true) {
	    System.out.println(question + " [Yes/No]:");
	    String input = keyboard.nextLine();
	    if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y"))
		return true;
	    else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n"))
		return false;
	    System.out.println("Please answer the question by \"yes\" or \"no\".");
	}
    }
    
    public static void main(String[] args) {
	System.out.println("Value returned: " + requestInt("Enter an integer:", 1));
    }
}
