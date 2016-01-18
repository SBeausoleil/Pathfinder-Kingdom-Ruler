package com.sb.menu;

import java.io.Serializable;

/**
 * An element of a menu.
 * 
 * @author Samuel Beausoleil
 */
public interface MenuElement extends Serializable {

    /**
     * Open this element of the menu.
     */
    public void open();

    /**
     * Returns the name of this menu element.
     * 
     * @return the name of this menu element.
     */
    public String getName();
}
