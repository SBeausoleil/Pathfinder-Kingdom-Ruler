package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuElement;
import com.sb.menu.MenuUtil;
import com.sb.menu.OptionsMenu;
import com.sb.menu.Selector;
import com.sb.pathfinder.kingdom.Government;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.government.GovernmentDisplay;
import com.sb.pathfinder.kingdom.government.LeadershipRole;

public class GovernmentManager implements MenuElement, KingdomDependant {

    private static final long serialVersionUID = -7537862739742959788L;
    
    private static final byte RULERS_OPTION = (byte) 0;
    private static final byte CONSORTS_OPTION = (byte) 1;
    private static final byte VICEROYS_OPTIONS = (byte) 2;
    
    private Kingdom currentKingdom;    
    
    public GovernmentManager(Kingdom currentKingdom) {
	this.currentKingdom = currentKingdom;
    }
    
    @Override
    public void open() {
	if (currentKingdom == null) {
	    System.out.println("A kingdom need to be selected first.");
	    return;
	}
	
	GovernmentDisplay.displayCurrentEffects(currentKingdom.getGovernment());
	
	OptionsMenu menu = new OptionsMenu();
	menu.register("Display bonuses", () -> GovernmentDisplay.displayBonuses(currentKingdom.getGovernment()));
	menu.register("Display penalties", () -> GovernmentDisplay.displayPenalties(currentKingdom.getGovernment()));
	menu.register("Edit roles", this::editRoles);
	
    }
    
    public void editRoles() {
	// Choices:
	/*
	 * 1- Select role to edit.
	 * 
	 * 1.1- Change role name
	 * 1.2- Change person in that role
	 * 1.3- If that role is a list, add a new role to it
	 */
	Government gov = currentKingdom.getGovernment();
	Selector<Object> roles = new Selector<>();
	roles.register("Ruler(s)", RULERS_OPTION);
	roles.register("Consort(s)", CONSORTS_OPTION);
	roles.register("Councilor", gov.getCouncilor());
	roles.register("General", gov.getGeneral());
	roles.register("Grand Diplomat", gov.getGrandDiplomat());
	roles.register("Heir", gov.getHeir());
	roles.register("High Priest", gov.getHighPriest());
	roles.register("Magister", gov.getMagister());
	roles.register("Royal Enforcer", gov.getRoyalEnforcer());
	roles.register("Spymaster", gov.getSpymaster());
	roles.register("Treasurer", gov.getTreasurer());
	roles.register("Viceroys", VICEROYS_OPTIONS);
	roles.register("Warden", gov.getWarden());
	
	Object selection = roles.select();
	if (selection == Selector.SELECTION_CANCELLED)
	    return;

	if (selection.getClass() == Byte.class) {
	    // Do stuff for when there can be multiple places in that spot
	} else if (selection instanceof LeadershipRole) {
	    edit((LeadershipRole) selection);
	} else {
	    System.err.println("Error: the selection type is not recognized.");
	}
    }

    private void edit(LeadershipRole role) {
	// Display all relevant data concerning this role
	role.displayProperties();
	System.out.println();
	
	// Make it possible to edit each one of the role's properties.
	OptionsMenu menu = new OptionsMenu();
	menu.register("Edit title", () -> editTitle(role));
	menu.register("Change character", () -> editCharacter(role));
	menu.register("Change availability", () -> editAvailablity(role));
	menu.register("Change kingdom", () -> editKingdom(role));
    }

    private void editCharacter(LeadershipRole role) {
	// TODO Auto-generated method stub
    }

    private void editKingdom(LeadershipRole role) {
	System.out.println("Current kingdom: " + (role.getKingdom() != null ? role.getKingdom().getName() : "None"));
	System.out.println("Select the new kingdom of this role: ");
	Selector<Kingdom> kingdoms = new Selector<>();
	kingdoms.register(AppData.getInstance().getKingdoms(), Kingdom::getName);
	Kingdom selection = kingdoms.select();
	if (selection == Selector.SELECTION_CANCELLED)
	    return;
	
	role.setKingdom(selection);
	
	if (!selection.equals(currentKingdom))
	    currentKingdom.getGovernment().checkLoyalties(false);
    }

    private void editAvailablity(LeadershipRole role) {
	System.out.println("Current availability: " + (role.isAvailable() ? "Available" : "Not available"));
	role.setAvailable(MenuUtil.requestYesNo("Is the character available?"));
    }

    private void editTitle(LeadershipRole role) {
	System.out.println("Current title: " + role.getTitle());
	System.out.print("New title: ");
	role.setTitle(MenuUtil.keyboard.nextLine());
    }

    @Override
    public Kingdom getCurrentKingdom() {
	return currentKingdom;
    }

    @Override
    public void setCurrentKingdom(Kingdom currentKingdom) {
	this.currentKingdom = currentKingdom;
    }

}
