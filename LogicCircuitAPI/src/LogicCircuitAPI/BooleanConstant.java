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
public class BooleanConstant extends BooleanExpression{
    private boolean booleanValue;
    private Pair<Boolean, ?> valuePair;
    
    public BooleanConstant(Pair<Boolean, ?> valuePair) throws CircuitInputException {
        set(valuePair);
    }

    public BooleanConstant(boolean constant){
        if(constant)
            this.valuePair= new Pair<>(Boolean.TRUE, Boolean.TRUE);
        else
            this.valuePair= new Pair<>(Boolean.TRUE, Boolean.FALSE);
        this.booleanValue = constant;
    }

    public void set(boolean value){
        booleanValue = value;
    }

    public void set(Pair<Boolean, ?> valuePair) throws CircuitInputException{
        Object value = valuePair.getValue();
        if (!(value instanceof Boolean) && !(value instanceof Double)){
            throw new CircuitInputException("Invalid Input: Second parameter should be of type Boolean or Double.");
        }
        if(valuePair.getKey()) {
            if (!(value instanceof Boolean)){
                throw new CircuitInputException("Invalid Input: Second parameter should be of type Boolean.");
            }
            this.valuePair = new Pair<>(Boolean.TRUE, (Boolean) valuePair.getValue());
        }
        else{
            if (!(value instanceof Double)){
                throw new CircuitInputException("Invalid Input: Second parameter should be of type Double.");
            }
            double d = Double.parseDouble(valuePair.getValue().toString());

            if (d < 0 || d > 1) {
                throw new CircuitInputException("Invalid input: expected a real number between 0 and 1.");
            }
            else
                this.valuePair = new Pair<>(Boolean.FALSE, d);
        }
    }
    
    @Override
    public boolean calculate(){
        return booleanValue;
    }

    @Override
    public Pair<Boolean, ?> calculatePair() {
        return valuePair;
    }
}
