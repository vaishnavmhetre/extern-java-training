package Support.Splitter;

import Support.Splitter.Contract.StringSplitterContract;

import java.util.Arrays;
import java.util.List;

/**
 * Splitter for Arithmetic expression
 *
 * Limited to split following literals
 *      + => Addition
 *      - => Subtraction
 *      * => Multiplication
 *      / => Division
 *      % => Remainder
 */
public class ArithmeticSplitter implements StringSplitterContract<List<String>> {

    /**
     * Splitter expression regex
     */
    private static final String DELIMITER_REGEX = "(?<=[-+*/%])|(?=[-+*/%])";

    /**
     * Entry point for splitting string
     *
     * @param input - Expression to be split into literals
     * @return Literals split from expression as List
     */
    public List<String> split(String input) {
        return split(input, DELIMITER_REGEX);
    }

    /**
     * Entry point for splitting string
     *
     * @param input - Expression to be split into literals
     * @param delimiterRegex - Custom delimiter to use for expression split
     * @return Literals split from expression as List
     */
    @Override
    public List<String> split(String input, String delimiterRegex) {
        return Arrays.asList(input.split(delimiterRegex));
    }

}
