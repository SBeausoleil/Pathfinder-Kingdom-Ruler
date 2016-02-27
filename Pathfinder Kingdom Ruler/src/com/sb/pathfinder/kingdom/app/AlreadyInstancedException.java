package com.sb.pathfinder.kingdom.app;

public class AlreadyInstancedException extends Exception {

    private static final long serialVersionUID = 2582098242854435987L;

    public AlreadyInstancedException(Class clazz) {
	super("The class " + clazz.getName() +" has already been instanciated.");
    }
    
}
