package com.sb.util;

import java.util.List;
import java.util.ListIterator;

public class Lists {

    public static boolean remove(List list, Getter getter, Object remove) {
	ListIterator crawler = list.listIterator();
	while (crawler.hasNext()) {
	    if (getter.get(crawler.next()).equals(remove)) {
		crawler.remove();
		return true;
	    }
	}
	return false;
    }
    
    public static int removeAll(List list, Object remove) {
	ListIterator crawler = list.listIterator();
	int editsCount = 0;
	while (crawler.hasNext()) {
	    if (crawler.next().equals(remove)) {
		crawler.remove();
		editsCount++;
	    }
	}
	return editsCount;
    }
}
