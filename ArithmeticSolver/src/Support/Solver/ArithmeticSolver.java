package Support.Solver;

import Support.Exceptions.InvalidExpressionException;
import Support.Splitter.ArithmeticSplitter;
import Support.Validation.ArithmeticExpressionValidator;
import Support.ValueExtractor;

import java.util.List;

/**
 * Solves infix arithmetic expression
 * <p>
 * Limited to following operations over Integer and Double
 * + => Addition
 * - => Subtraction
 * * => Multiplication
 * / => Division
 * % => Remainder
 */

public class ArithmeticSolver {


    /**
     * Field for storing solved expression
     */
    protected static String inputExpression;

    /**
     * Getter for inputExpression
     *
     * @return inputExpression
     */
    public static String getInputExpression() {
        return inputExpression;
    }

    /**
     * Entry method to solve the expression
     *
     * @param expression - Expression to be solved
     */
    public static void solve(String expression) throws InvalidExpressionException {
        inputExpression = expression;

        List<String> expressionStringLiterals = extractLiterals(expression);

        boolean canReturnDouble = canReturnDouble(expressionStringLiterals);
        List literals =
                canReturnDouble
                        ? ValueExtractor.extractValuesFromStringListAsDouble(expressionStringLiterals)
                        : ValueExtractor.extractValuesFromStringList(expressionStringLiterals);

        if (!validateExpression(literals))
            throw new InvalidExpressionException("Invalid Expression has been given");

        if (canReturnDouble)
            solveAsDouble(literals);
        else
            solveAsInteger(literals);

    }

    /**
     * Extract literals from expression string
     *
     * @param expression - Expression to be split into literals
     * @return List of literals split from expression
     */
    protected static List<String> extractLiterals(String expression) {
        return new ArithmeticSplitter().split(expression);
    }


    /**
     * Naive check through literals for any Double value
     *
     * @param expressionLiteralsStringList - Literals list to find Double value from
     * @return true If list has any probable Double value else false
     */
    protected static boolean canReturnDouble(List<String> expressionLiteralsStringList) {

        for (String item : expressionLiteralsStringList)
            if (item.indexOf(".") > 0)
                return true;

        return false;
    }


    /**
     * Solve the expression with result as Integer
     *
     * @param expressionLiterals - List of literals to process for evaluation
     */
    protected static void solveAsInteger(List expressionLiterals) {

        int result = 0;
        String operator = null;

        for (Object item : expressionLiterals) {
            if (item instanceof String)
                operator = (String) item;
            else if (operator == null)
                result = (int) item;                       // Item is never double, already checked in 'solve->canReturnDouble', so hard Integer
            else {
                result = evaluate(result, operator, (int) item);
                operator = null;
            }
        }

        System.out.println(String.format("%s = %d", inputExpression, result));

    }

    /**
     * Solve the expression with result as Double
     *
     * @param expressionLiterals - List of literals to process for evaluation
     */
    protected static void solveAsDouble(List expressionLiterals) {

        double result = 0;
        String operator = null;

        for (Object item : expressionLiterals) {
            if (item instanceof String)
                operator = (String) item;
            else if (operator == null)
                result = (double) item;                       // Item might be double (checked in 'solve->canReturnDouble'), so hard double even if no Decimal
            else {
                result = evaluate(result, operator, (double) item);
                operator = null;
            }
        }

        System.out.println(String.format("%s = %f", inputExpression, result));

    }

    /**
     * Evaluate the result as of operator supplied
     * Intended for Integer type result
     *
     * @param result   - Previous carry over result value
     * @param operator - Operation to be performed
     * @param literal  - Upcoming value to operate with carry over result value
     * @return New result after operating over old one
     */
    protected static int evaluate(int result, String operator, int literal) {
        switch (operator) {

            case "+": // Addition
                result += literal;
                break;

            case "-":  // Subtraction
                result -= literal;
                break;

            case "*":  // Multiplication
                result *= literal;
                break;

            case "/": // Division
                result /= literal;
                break;

            case "%": // Remainder
                result %= literal;
                break;
        }
        return result;
    }

    /**
     * Evaluate the result as of operator supplied
     * Intended for Double type result
     *
     * @param result   - Previous carry over result value
     * @param operator - Operation to be performed
     * @param literal  - Upcoming value to operate with carry over result value
     * @return New result after operating over old one
     */
    protected static double evaluate(double result, String operator, double literal) {
        switch (operator) {

            case "+": // Addition
                result += literal;
                break;

            case "-":  // Subtraction
                result -= literal;
                break;

            case "*":  // Multiplication
                result *= literal;
                break;

            case "/": // Division
                result /= literal;
                break;

            case "%": // Remainder
                result %= literal;
                break;
        }
        return result;
    }

    protected static boolean validateExpression(List expressionStringLiterals) {
        return ArithmeticExpressionValidator.isValid(expressionStringLiterals);
    }

}
