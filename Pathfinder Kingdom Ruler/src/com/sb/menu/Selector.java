package com.sb.menu;

import java.io.Serializable;
import java.util.ArrayList;

import com.sb.util.Getter;
import com.sb.util.IntBracket;
import com.sb.util.Lists;

public class Selector<E> {

    public static final Object SELECTION_CANCELLED = null;

    public static String exitString = "!";

    private ArrayList<Choice> choices;

    public Selector() {
	choices = new ArrayList<Choice>();
    }

    public E select() {
	// Display all the options
	for (int i = 1; i <= choices.size(); i++)
	    System.out.println(i + ") " + choices.get(i - 1).name);

	// Ask for number
	int index = MenuUtil.requestInt("Enter the number of the desired option: ", new IntBracket(1, choices.size()),
		"Error: the value entered is not valid", exitString);
	
	if (index == MenuUtil.CANCELLED_ACTION)
	    return (E) SELECTION_CANCELLED;
	else
	    return (E) choices.get(index - 1).choice;
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
}
