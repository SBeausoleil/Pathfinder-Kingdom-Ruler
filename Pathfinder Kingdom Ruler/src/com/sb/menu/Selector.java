package com.sb.menu;

import java.io.Serializable;
import java.util.LinkedList;

import com.sb.util.Getter;
import com.sb.util.IntBracket;
import com.sb.util.Lists;

public class Selector<E> implements Serializable {

    private static final long serialVersionUID = -6242706904024047564L;

    public static final Object SELECTION_CANCELLED = null;

    public static String exitString = "!";

    private LinkedList<Choice> choices;
    
    private boolean allowCancel;

    public Selector() {
	this(false);
    }
    
    public Selector(boolean allowCancel) {
	choices = new LinkedList<>();
	this.allowCancel = allowCancel;
    }

    public E select() {
	// Display all the options
	int i = 1;
	for (Choice choice : choices) {
	    if (choice.choice != null) {
		System.out.println(i + ") " + choices.get(i - 1).name);
		i++;
	    } else
		System.out.println(choice.getName() == null ? "" : choice.getName());
	}
	/*
	 * for (int i = 1; i <= choices.size(); i++)
	 * System.out.println(i + ") " + choices.get(i - 1).name);
	 */

	// Ask for number
	int index;
	
	if (allowCancel)
	    index = MenuUtil.requestInt("Enter the number of the desired option (" + exitString + " to cancel): ", new IntBracket(1, choices.size()),
			"Error: the value entered is not valid", exitString);
	else
	    index = MenuUtil.requestInt("Enter the number of the desired option: ", new IntBracket(1, choices.size()),
		    "Error: The value entered is not valid");
	    
	if (index == MenuUtil.CANCELLED_ACTION)
	    return (E) SELECTION_CANCELLED;
	else {
	    index--; // Correct the index to the zero alignment
	    i = 0;
	    for (Choice c : choices)
		if (c.choice != null)
		    if (i++ == index)
			return (E) c.choice;

	    return (E) choices.get(index - 1).choice;
	}
    }

    public boolean register(String name, E element) {
	return choices.add(new Choice(name, element));
    }

    public boolean register(Iterable<E> elements, Getter<E, String> nameGenerator) {
	int startSize = choices.size();
	for (E element : elements)
	    choices.add(new Choice(nameGenerator.get(element), element));
	return startSize != choices.size();
    }

    public boolean unregister(E element) {
	return Lists.remove(choices, Choice.CHOICE_GETTER, element);
    }

    public boolean unregister(String name) {
	return Lists.remove(choices, Choice.NAME_GETTER, name);
    }

    private static class Choice implements Serializable {

	private static final long serialVersionUID = -8479572974680393052L;

	public static final Getter<Choice, String> NAME_GETTER	 = Choice::getName;
	public static final Getter<Choice, Object> CHOICE_GETTER = Choice::getChoice;

	private String name;
	private Object choice;

	public Choice(String name, Object choice) {
	    this.name = name;
	    this.choice = choice;
	}

	/**
	 * Returns the name.
	 * 
	 * @return the name
	 */
	public String getName() {
	    return name;
	}

	/**
	 * Returns the choice.
	 * 
	 * @return the choice
	 */
	public Object getChoice() {
	    return choice;
	}
    }

    /**
     * Returns the allowCancel.
     * @return the allowCancel
     */
    public boolean isAllowCancel() {
        return allowCancel;
    }

    /**
     * Sets the value of allowCancel to that of the parameter.
     * @param allowCancel the allowCancel to set
     */
    public void setAllowCancel(boolean allowCancel) {
        this.allowCancel = allowCancel;
    }
}
