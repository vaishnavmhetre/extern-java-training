import Support.Exceptions.InvalidExpressionException;
import Support.Solver.ArithmeticSolver;

/**
 * Main Arithmetic Solution(s) Runner Class
 */
public class ArithmeticSolverRunner {

    /**
     * Entry point for Arithmetic Solution(s) runner
     *
     * @param args - Expressions passed through command line arguments
     */
    public static void main(String[] args) throws InvalidExpressionException {

        for (String arg : args) {
            arg = arg.replaceAll("\\s+","");            // Trim any whitespaces in expression(s)
            ArithmeticSolver.solve(arg);
        }

    }
}
