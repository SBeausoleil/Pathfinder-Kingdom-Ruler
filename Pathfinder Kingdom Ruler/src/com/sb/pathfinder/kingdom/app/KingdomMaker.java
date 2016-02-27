package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuElement;
import com.sb.menu.MenuUtil;
import com.sb.menu.Selector;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.LawAlignment;
import com.sb.pathfinder.kingdom.MoralAlignment;

public class KingdomMaker implements MenuElement {

    private static final long serialVersionUID = 863854764213082448L;

    @Override
    public void open() {
	// Name
	String name;
	while (true) {
	    System.out.println("Name: ");
	    name = MenuUtil.keyboard.nextLine();
	    if (kingdomDoesNotExists(name))
		break;
	    System.out.println("There is already a kingdom named \"" + name + "\"");
	}

	// Moral alignment
	Selector<MoralAlignment> moralSelector = new Selector<>();
	for (MoralAlignment ma : MoralAlignment.values())
	    moralSelector.register(ma.name(), ma);
	System.out.println("Select the moral alignment of the kingdom:");
	MoralAlignment moral = moralSelector.select();

	// Law alignment
	Selector<LawAlignment> lawSelector = new Selector<>();
	for (LawAlignment la : LawAlignment.values())
	    lawSelector.register(la.name(), la);
	System.out.println("Select the lawfulness of the kingdom:");
	LawAlignment law = lawSelector.select();
	
	Kingdom kingdom = new Kingdom(name, moral, law);
	if (AppData.getInstance().getKingdoms().add(kingdom))
	    System.out.println("Kingdom " + name + " has been successfully created.");
	else
	    System.out.println("An error happened while registering the kingdom.");
    }

    private boolean kingdomDoesNotExists(String name) {
	for (Kingdom k : AppData.getInstance().getKingdoms())
	    if (k.getName().equals(k))
		return false;
	return true;
    }

}
