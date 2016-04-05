package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuUtil;
import com.sb.rpg.RPGCharacter;

public class CharacterMaker {

    public static RPGCharacter makeCharacter() {
	RPGCharacter character = new RPGCharacter(null, 10, 10, 10, 10, 10, 10, 10, null, 0, 0);
	editCharacter(character);
	return character;
    }

    public static void editCharacter(RPGCharacter character) {
	System.out.print("Name (" + character.getName() + "): ");
	String name = MenuUtil.keyboard.nextLine();
	character.setName(name.isEmpty() ? character.getName() : name); // If user entered nothing, do not change the name
	character.setStrength(MenuUtil.requestInt("Strength (" + character.getStrength() + "): " , character.getStrength()));
	character.setDexterity(MenuUtil.requestInt("Dexterity (" + character.getDexterity() + "): " , character.getDexterity()));
	character.setConstitution(MenuUtil.requestInt("Constitution (" + character.getConstitution() + "): " , character.getConstitution()));
	character.setIntelligence(MenuUtil.requestInt("Intelligence (" + character.getIntelligence() + "): " , character.getIntelligence()));
	character.setWisdom(MenuUtil.requestInt("Wisdom (" + character.getWisdom() + "): " , character.getWisdom()));
	character.setCharisma(MenuUtil.requestInt("Charisma (" + character.getCharisma() + "): " , character.getCharisma()));
    }
}
