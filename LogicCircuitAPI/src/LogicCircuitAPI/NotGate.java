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
public class NotGate extends BooleanUnaryExpression{

    public NotGate(BooleanExpression operand){
        in1 = operand;
    }
    
    @Override
    public boolean calculate(){
        return !(in1.calculate());
    }

    @Override
    public Pair<Boolean, ?> calculatePair() {
        Pair<Boolean, ?> inputPair1 = in1.calculatePair();
        Boolean inputKey1 = inputPair1.getKey();
        if (isTypeBoolean(inputKey1)){
            Boolean inputValue1 = (Boolean) inputPair1.getValue();
            Boolean outputValue = !inputValue1;
            return new Pair<>(Boolean.TRUE, outputValue);
        }else{
            Double inputValue1 = (Double) inputPair1.getValue();
            Double outputValue = 1 - inputValue1;
            return new Pair<>(Boolean.FALSE, outputValue);
        }
    }

    private boolean isTypeBoolean(Boolean key){
        return (key.equals(Boolean.TRUE));
    }
}
