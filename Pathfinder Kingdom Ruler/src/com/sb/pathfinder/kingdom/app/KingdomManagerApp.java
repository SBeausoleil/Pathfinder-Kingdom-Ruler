package com.sb.pathfinder.kingdom.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sb.menu.MenuElement;
import com.sb.menu.MenuUtil;
import com.sb.menu.OptionsMenu;
import com.sb.pathfinder.kingdom.BuildingDisplay;
import com.sb.pathfinder.kingdom.Kingdom;

public class KingdomManagerApp implements KingdomDependant, MenuElement {

    private static final long serialVersionUID = -2199803296265328815L;

    public static final File SAVES_DIRECTORY = new File("saves");

    public static final JFileChooser FILE_CHOOSER = makeAppFileChooser();

    private Kingdom			 currentKingdom;
    private OptionsMenu			 mainMenu;
    private LinkedList<KingdomDependant> dependants;

    private File save;

    public KingdomManagerApp() {
	mainMenu = new OptionsMenu();
	dependants = new LinkedList<KingdomDependant>();

	// Register the different menu options
	registerMenuElement("Display kingdom state", new KingdomStateDisplay(currentKingdom));
	registerMenuElement("Access settlements", new SettlementAccessor(currentKingdom));
	registerMenuElement("Make a new kingdom", new KingdomMaker());
	registerMenuElement("Select a kingdom", new KingdomSelector(this));
	registerMenuElement("Create a building", () -> BuildingMaker.createBuilding(true));
	registerMenuElement("Edit a building", new BuildingsManager(currentKingdom, null));
	registerMenuElement("List all buildings",
		() -> BuildingDisplay.display(AppData.getInstance().getBuildings(), true));
	registerMenuElement("Create a new character",
		() -> AppData.getInstance().getCharacters().add(CharacterMaker.makeCharacter()));
	registerMenuElement("Edit a character", new CharacterManager());
	//registerMenuElement("Access government", new GovernmentManager());
	registerMenuElement("Save", this::save);
	registerMenuElement("Save at", this::saveAt);
	registerMenuElement("Save and exit", () -> {
	    save();
	    System.exit(0);
	});
    }

    /**
     * Returns the currentKingdom.
     * 
     * @return the currentKingdom
     */
    @Override
    public Kingdom getCurrentKingdom() {
	return currentKingdom;
    }

    /**
     * Sets the value of currentKingdom to that of the parameter.
     * 
     * @param currentKingdom
     *            the currentKingdom to set
     */
    @Override
    public void setCurrentKingdom(Kingdom currentKingdom) {
	this.currentKingdom = currentKingdom;
	for (KingdomDependant kd : dependants)
	    kd.setCurrentKingdom(currentKingdom);
    }

    /**
     * Returns the mainMenu.
     * 
     * @return the mainMenu
     */
    public OptionsMenu getMainMenu() {
	return mainMenu;
    }

    /**
     * Sets the value of mainMenu to that of the parameter.
     * 
     * @param mainMenu
     *            the mainMenu to set
     */
    public void setMainMenu(OptionsMenu mainMenu) {
	this.mainMenu = mainMenu;
    }

    public boolean registerMenuElement(String name, MenuElement element) {
	if (mainMenu.register(name, element)) {
	    if (element instanceof KingdomDependant)
		dependants.add((KingdomDependant) element);
	    return true;
	}
	return false;
    }

    @Override
    public void open() {
	while (true) {
	    mainMenu.open();
	    System.out.println();
	}
    }

    public void save() {
	if (save == null)
	    if (!selectSaveFile()) {
		System.out.println("Save cancelled");
		return;
	    }
	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(save))) {
	    out.writeObject(AppData.getInstance());
	    System.out.println("App saved successfully");
	} catch (IOException e) {
	    System.err.println("Error when saving the application state");
	    e.printStackTrace();
	}
    }

    public void saveAt() {
	if (selectSaveFile())
	    save();
	else
	    System.out.println("Save cancelled");
    }

    private boolean selectSaveFile() {
	if (FILE_CHOOSER.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
	    File tempSave = FILE_CHOOSER.getSelectedFile();
	    if (!tempSave.getName().endsWith(AppData.FILE_EXTENSION))
		tempSave = new File(tempSave.getName() + AppData.FILE_EXTENSION);
	    if (!tempSave.exists()) {
		save = tempSave;
		return true;
	    } else {
		System.out.println("The file already exists.");
		return true; // FIXME
	    }
	}
	return false;
    }

    /**
     * Returns the save.
     * 
     * @return the save
     */
    public File getSave() {
	return save;
    }

    /**
     * Sets the value of save to that of the parameter.
     * 
     * @param save
     *            the save to set
     */
    public void setSave(File save) {
	this.save = save;
    }

    public static void main(String[] args) {
	if (!SAVES_DIRECTORY.exists())
	    SAVES_DIRECTORY.mkdir();

	// If there is no AppData save in the Saves directory
	//	Directly enter the program with a fresh AppData
	// Else
	//	Offer to make a new save or select an existing one

	File save = null;
	if (SAVES_DIRECTORY.list((dir, fileName) -> fileName.endsWith(AppData.FILE_EXTENSION)).length > 0) {
	    if (MenuUtil.requestYesNo("There exists save(s) of the application. Do you want to load one?"))
		save = restoreAppData();
	}

	KingdomManagerApp app = new KingdomManagerApp();
	if (save == null) {
	    System.out.println("Creating a new save");
	    app.setSave(save);
	}
	app.open();
    }

    private static File restoreAppData() {
	// open a GUI to select the save
	File save = null;
	if (FILE_CHOOSER.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_CHOOSER.getSelectedFile()))) {
		AppData.setInstance((AppData) in.readObject());
		save = FILE_CHOOSER.getSelectedFile();
	    } catch (ClassNotFoundException | AlreadyInstancedException | IOException e) {
		System.err.println("Error when reading the application save.");
		e.printStackTrace();
	    }
	}
	return save;
    }

    private static JFileChooser makeAppFileChooser() {
	JFileChooser chooser = new JFileChooser(SAVES_DIRECTORY);
	chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	chooser.setFileFilter(new FileNameExtensionFilter("Kingdom Manager App Data", AppData.FILE_EXTENSION));
	return chooser;
    }
}
