/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicCircuitAPI;

import javafx.util.Pair;

/**
 *
 * @author Panikos
 */
public class AndGate extends BooleanBinaryExpression{
    
    public AndGate(BooleanExpression operand1, BooleanExpression operand2){
        in1 = operand1;
        in2 = operand2;
    }
    
    @Override
    public boolean calculate(){
        return ((in1.calculate()) && (in2.calculate()));
    }

    @Override
    public Pair<Boolean, ?> calculatePair() {
        Pair<Boolean, ?> inputPair1 = in1.calculatePair();
        Pair<Boolean, ?> inputPair2 = in2.calculatePair();

        Boolean inputKey1 = inputPair1.getKey();
        Boolean inputKey2 = inputPair2.getKey();

        if (areArgumentsDifferent(inputKey1, inputKey2)){
            if (isTypeBoolean(inputKey1)){
                inputPair1 = convertToDouble(inputPair1);
            }else{
                inputPair2 = convertToDouble(inputPair2);
            }
            return calculateDoublePair(inputPair1, inputPair2);
        }else{
            if (isTypeBoolean(inputKey1)){
                return calculateBooleanPair(inputPair1, inputPair2);
            }else{
                return calculateDoublePair(inputPair1, inputPair2);
            }
        }

    }

    private Pair<Boolean, Boolean> calculateBooleanPair(
            Pair<Boolean, ?> pair1, Pair<Boolean, ?> pair2
    ){
        Boolean pairValue1 = (Boolean) pair1.getValue();
        Boolean pairValue2 = (Boolean) pair2.getValue();
        Boolean outputValue = pairValue1 && pairValue2;
        return new Pair<>(Boolean.TRUE, outputValue);
    }

    private Pair<Boolean, Double> calculateDoublePair(
            Pair<Boolean, ?> pair1, Pair<Boolean, ?> pair2
    ){
        Double pairValue1 = (Double) pair1.getValue();
        Double pairValue2 = (Double) pair2.getValue();
        Double outputValue = pairValue1 * pairValue2;
        return new Pair<>(Boolean.TRUE, outputValue);
    }

    private boolean areArgumentsDifferent(Boolean key1, Boolean key2){
        return (isTypeBoolean(key1) && isTypeDouble(key2));
    }

    private boolean isTypeBoolean(Boolean key){
        return (key.equals(Boolean.TRUE));
    }

    private boolean isTypeDouble(Boolean key){
        return (key.equals(Boolean.FALSE));
    }

    private Pair<Boolean, Double> convertToDouble(Pair<Boolean, ?> pair){
        if (pair.getValue().equals(Boolean.TRUE)){
            return new Pair<>(Boolean.FALSE, 1.0);
        }else{
            return new Pair<>(Boolean.FALSE, 0.0);
        }
    }
}
