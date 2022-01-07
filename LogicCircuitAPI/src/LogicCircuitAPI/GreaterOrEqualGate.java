package LogicCircuitAPI;

import javafx.util.Pair;

public class GreaterOrEqualGate extends BooleanBinaryExpression{
    public GreaterOrEqualGate(BooleanExpression operand1, BooleanExpression operand2){
        in1 = operand1;
        in2 = operand2;
    }

    @Override
    public boolean calculate() {
        return false;
    }

    @Override
    public Pair<Boolean, Boolean> calculatePair() throws CircuitInputException {
        Pair<Boolean, ?> inputPair1 = in1.calculatePair();
        Pair<Boolean, ?> inputPair2 = in2.calculatePair();

        if (areNeitherInputsDouble(inputPair1, inputPair2)){
            throw new CircuitInputException("Invalid Input: Second argument of " +
                    "both inputs for GreaterOrEqualGate should be Double.");
        }
        Double inputKey1 = (Double) inputPair1.getValue();
        Double inputKey2 = (Double) inputPair2.getValue();
        Boolean outputValue = (inputKey1 >= inputKey2);
        return new Pair<>(Boolean.TRUE, outputValue);
    }

    private boolean areNeitherInputsDouble(Pair<Boolean, ?> pair1, Pair<Boolean, ?> pair2){
        boolean isSecondParameterOfPair1Double = (pair1.getValue() instanceof Double);
        boolean isSecondParameterOfPair2Double = (pair2.getValue() instanceof Double);
        return ((!isSecondParameterOfPair1Double) && (!isSecondParameterOfPair2Double));
    }
}
