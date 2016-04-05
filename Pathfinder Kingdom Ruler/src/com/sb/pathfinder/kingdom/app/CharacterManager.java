package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuElement;
import com.sb.menu.Selector;
import com.sb.rpg.RPGCharacter;

public class CharacterManager implements MenuElement {

    private static final long serialVersionUID = 2877089366599977871L;

    @Override
    public void open() {
	Selector<RPGCharacter> characters = new Selector<>();
	characters.register(AppData.getInstance().getCharacters(), RPGCharacter::getName);
	RPGCharacter selection = characters.select();
	if (selection != Selector.SELECTION_CANCELLED)
	    CharacterMaker.editCharacter(selection);
    }

}
