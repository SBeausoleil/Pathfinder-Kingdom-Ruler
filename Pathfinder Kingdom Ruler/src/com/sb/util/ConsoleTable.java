package com.sb.util;

import java.io.PrintStream;

public class ConsoleTable {

    public static char defaultFieldHorizontalSeparator = '|';
    public static char defaultFieldVerticalSeparator = '-';
    public static char defaultFieldIntersectionSeparator = '+';

    private static final int EMPTY_ROW = 0;

    private int fieldLength;

    /**
     * Separates fields from the one to their left and the one to their right.
     */
    private char fieldHorizontalSeparator;

    /**
     * Separates fields from the one over them and the one beneath them.
     */
    private char fieldVerticalSeparator;
    
    private char fieldIntersectionSeparator;

    private final int ROW_SIZE;
    private int field;

    private StringBuilder builder;

    public ConsoleTable(int fieldLength, int rowSize) {
	this.fieldLength = fieldLength;
	builder = new StringBuilder();
	field = EMPTY_ROW;
	ROW_SIZE = rowSize;
	fieldHorizontalSeparator = defaultFieldHorizontalSeparator;
	fieldVerticalSeparator = defaultFieldVerticalSeparator;
	fieldIntersectionSeparator = defaultFieldIntersectionSeparator;
    }

    /*
     * Transfer the content of the rowContent list to the builder.
     */
    public void newRow() {
        if (field != EMPTY_ROW)
            builder.append("%n");
	builder.append(generateLineVerticalSeparation());
	builder.append("%n");
	field = EMPTY_ROW;
    }

    /**
     * Adds a field to the current row.
     * 
     * @param content
     */
    public void addField(String content) {
	if (field == EMPTY_ROW)
	    builder.append(fieldHorizontalSeparator);
	builder.append(pad(content));
	builder.append(fieldHorizontalSeparator);
	field++;
    }

    private String pad(String str) {
	while (str.length() < fieldLength)
	    str += " ";
	return str;
    }

    /**
     * Returns the fieldLength.
     * 
     * @return the fieldLength
     */
    public int getFieldLength() {
	return fieldLength;
    }

    /**
     * Sets the value of fieldLength to that of the parameter.
     * 
     * @param fieldLength
     *            the fieldLength to set
     */
    public void setFieldLength(int fieldLength) {
	this.fieldLength = fieldLength;
    }

    /**
     * Returns the fieldHorizontalSeparator.
     * 
     * @return the fieldHorizontalSeparator
     */
    public char getFieldHorizontalSeparator() {
	return fieldHorizontalSeparator;
    }

    /**
     * Sets the value of fieldHorizontalSeparator to that of the parameter.
     * 
     * @param fieldHorizontalSeparator
     *            the fieldHorizontalSeparator to set
     */
    public void setFieldHorizontalSeparator(char fieldHorizontalSeparator) {
	this.fieldHorizontalSeparator = fieldHorizontalSeparator;
    }

    /**
     * Returns the fieldVerticalSeparator.
     * 
     * @return the fieldVerticalSeparator
     */
    public char getFieldVerticalSeparator() {
	return fieldVerticalSeparator;
    }

    /**
     * Sets the value of fieldVerticalSeparator to that of the parameter.
     * 
     * @param fieldVerticalSeparator
     *            the fieldVerticalSeparator to set
     */
    public void setFieldVerticalSeparator(char fieldVerticalSeparator) {
	this.fieldVerticalSeparator = fieldVerticalSeparator;
    }

    private String generateLineVerticalSeparation() {
	String fieldVerticalSeparation = generateFieldVerticalSeparation();
	StringBuilder accumulator = new StringBuilder();
	for (int i = 0; i < ROW_SIZE; i++)
	    accumulator.append(fieldIntersectionSeparator + fieldVerticalSeparation);
	accumulator.append(fieldIntersectionSeparator);
	return accumulator.toString();
    }

    private String generateFieldVerticalSeparation() {
	char[] separation = new char[fieldLength];
	for (int i = 0; i < fieldLength; i++)
	    separation[i] = fieldVerticalSeparator;
	return new String(separation);
    }

    /**
     * Resets the content of this ConsoleTable.
     */
    public void clear() {
	field = EMPTY_ROW;
	builder = new StringBuilder();
    }

    public void display() {
	display(System.out);
    }
    
    public void display(PrintStream out) {
	out.printf(builder.toString());
	out.println();
	out.println(generateLineVerticalSeparation());
    }

    public static void main(String[] args) {
	ConsoleTable table = new ConsoleTable(6, 3);
	table.newRow();
	table.addField("Test1");
	table.addField("Test2");
	table.addField("Test3");
	table.newRow();
	table.addField("Hello1");
	table.addField("Hello2");
	table.addField("Hello3");
	table.display();
	System.out.println("!");
	table.newRow();
	table.addField("A1");
	table.addField("A2");
	table.addField("A3");
	table.display();
    }

    /**
     * Returns the current field.
     * 
     * @return the current fiel
     */
    public int getField() {
	return field;
    }
}
