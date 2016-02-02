package com.sb.menu;

import java.io.Serializable;
import java.util.ArrayList;

import com.sb.util.IntBracket;

/**
 * A menu with options to select.
 * 
 * @author Samuel Beausoleil
 *
 */
public class OptionsMenu implements MenuElement {

    private static final long serialVersionUID = 6214800139134389544L;

    protected ArrayList<MenuNode> elements;
    
    public OptionsMenu() {
	elements = new ArrayList<MenuNode>();
    }

    @Override
    public void open() {
	// Display all the options
	for (int i = 1; i <= elements.size(); i++)
	    System.out.println(i + ") " + elements.get(i - 1).getName());

	// Ask for number
	int index = MenuUtil.requestInt("Enter the number of the desired option: ", new IntBracket(1, elements.size()),
		"Error: the value entered is not valid");
	
	// Open the MenuElement associated with that index
	elements.get(index).getElement().open();
    }

    /**
     * Returns the elements.
     * @return the elements
     */
    public ArrayList<MenuNode> getElements() {
        return elements;
    }
    
    public boolean register(String name, MenuElement element) {
	return elements.add(new MenuNode(name, element));
    }
    
    public boolean unregister(MenuElement element) {
	return elements.remove(element);
    }
    
    public static class MenuNode implements Serializable {	
	
	private static final long serialVersionUID = 2825228504760349534L;
	
	private String name;
	private MenuElement element;
	
	public MenuNode(String name, MenuElement element) {
	    this.name = name;
	    this.element = element;
	}

	/**
	 * Returns the element.
	 * @return the element
	 */
	public MenuElement getElement() {
	    return element;
	}

	/**
	 * Sets the value of element to that of the parameter.
	 * @param element the element to set
	 */
	public void setElement(MenuElement element) {
	    this.element = element;
	}

	/**
	 * Returns the name.
	 * @return the name
	 */
	public String getName() {
	    return name;
	}

	/**
	 * Sets the value of name to that of the parameter.
	 * @param name the name to set
	 */
	public void setName(String name) {
	    this.name = name;
	}
    }
}
