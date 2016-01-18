package com.sb.menu;

import java.util.ArrayList;

import com.sb.util.IntBracket;

public class OptionsMenu extends ArrayList<MenuElement>implements MenuElement {

    private static final long serialVersionUID = 6214800139134389544L;

    private String name;

    public OptionsMenu(String name) {
	this.name = name;
    }

    @Override
    public void open() {
	// Display all the options
	for (int i = 1; i <= size(); i++)
	    System.out.println(i + ") " + get(i - 1).getName());

	// Ask for number
	int index = MenuUtil.requestInt("Enter the number of the desired option: ", new IntBracket(1, size()),
		"Error: the value entered is not valid");
	
	// Open the MenuElement associated with that index
	get(index).open();
    }

    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}
