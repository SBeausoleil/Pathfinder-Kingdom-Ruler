package com.sb.menu;

/**
 * A menu with options to select. The selected option will be executed.
 * 
 * @author Samuel Beausoleil
 */
public class OptionsMenu extends Selector<MenuElement>implements MenuElement {

    private static final long serialVersionUID = 6214800139134389544L;

    private boolean loopUntilCancelled;

    public OptionsMenu() {
	this(false);
    }

    public OptionsMenu(boolean loopUntilCancelled) {
	super();
	this.loopUntilCancelled = loopUntilCancelled;
    }

    @Override
    public void open() {
	do {
	    MenuElement selection = super.select();

	    if (selection == Selector.SELECTION_CANCELLED)
		break;
	    else
		selection.open();
	} while (loopUntilCancelled);
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
