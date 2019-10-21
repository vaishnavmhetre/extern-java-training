package Support.Validation;

import java.util.List;

public class ArithmeticExpressionValidator {

    public static boolean isValid(List literals) {

        int counter = 0;
        
        for (Object item : literals)
            if (item instanceof String)
                counter++;

        return counter == (literals.size() / 2);

    }
}
