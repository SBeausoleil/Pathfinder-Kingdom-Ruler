package com.sb.util;

public class Strings {
    public static int getLongestLength(Iterable<String> strs) {
	int length = 0;
	for (String str : strs)
	    if (str.length() > length)
		length = str.length();
	return length;
    }
}
