package com.sb.pathfinder.kingdom.app;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class AppDataFileFilter extends FileFilter {

    public static final String FILE_EXTENSTION = ".kmad";

    @Override
    public boolean accept(File file) {
	return file.getName().endsWith(FILE_EXTENSTION);
    }

    @Override
    public String getDescription() {
	return "AppData file for the KMA application (*." + FILE_EXTENSTION + ")";
    }

}
