package Support;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Extracts/Parses values from String
 *
 * Limited to following extractions
 *      - Integer
 *      - Double
 */
public class ValueExtractor {


    /**
     * Check if data is Double type parsable
     *
     * @param data - Data to be parsable checked
     * @return true if data can be parsed as Double else false
     */
    public static boolean isDouble(String data) {
        try {
            getDouble(data);
            return (data.indexOf(".") > 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Check if data is Double type parsable
     *
     * @param data - Data to be parsable checked
     * @return true if data can be parsed as Double else false
     */
    public static boolean isDoubleWithoutDecimal(String data) {
        try {
            getDouble(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Parse Double value from data
     *
     * @param data - Data to parse value from
     * @return Parsed Double value
     * @throws NumberFormatException - In case parsing goes haywire or invalid expression is passed in
     */
    public static double getDouble(String data) throws NumberFormatException {
        return Double.parseDouble(data);
    }

    /**
     * Check if data is Integer type parsable
     *
     * @param data - Data to be parsable checked
     * @return true if data can be parsed as Integer else false
     */
    public static boolean isInt(String data) {
        try {
            getInt(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Parse Integer value from data
     *
     * @param data - Data to parse value from
     * @return Parsed Integer value
     * @throws NumberFormatException - In case parsing goes haywire or invalid expression is passed in
     */
    public static int getInt(String data) throws NumberFormatException {
        return Integer.parseInt(data);
    }

    /**
     * Extract values from the list of data passed
     * Smartly decides the type of data to parse into
     *
     * @param stringList - List of data to parse values from
     * @return - List of parsed values with respective derived type
     */
    public static List extractValuesFromStringList(List<String> stringList) {
        List items = new ArrayList();

        for (String item : stringList)
            items.add(isDouble(item) ? getDouble(item) : isInt(item) ? getInt(item) : item);

        return items;
    }

    /**
     * Extract values from the list of data passed
     * Force parsing of data into Double type values
     *
     * @param stringList - List of data to parse values from
     * @return - List of parsed values with Double type
     */
    public static List extractValuesFromStringListAsDouble(List<String> stringList) {
        List items = new ArrayList();

        for (String item : stringList)
            items.add(isDouble(item) || isDoubleWithoutDecimal(item) ? getDouble(item) : item);

        return items;
    }

}
