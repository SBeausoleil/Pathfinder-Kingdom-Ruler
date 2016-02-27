package com.sb.menu;

/**
 * A menu with options to select. The selected option will be executed.
 * 
 * @author Samuel Beausoleil
 */
public class OptionsMenu extends Selector<MenuElement> implements MenuElement {

    private static final long serialVersionUID = 6214800139134389544L;

    @Override
    public void open() {
	MenuElement selection = select();

	if (selection != Selector.SELECTION_CANCELLED)
	    selection.open();
    }

    public static void main(String[] args) {
	MenuElement element = () -> System.out.println("Hello World");

	OptionsMenu menu = new OptionsMenu();
	menu.register("Test", element);
	menu.register("Test 2", element);
	menu.register("Test 3", element);
	System.out.println(menu);
	menu.unregister(element);
	menu.unregister("Test 3");
	System.out.println(menu);
    }
}
