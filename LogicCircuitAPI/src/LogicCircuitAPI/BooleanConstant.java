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
        if(valuePair.getKey()) {
            try{
                this.valuePair = new Pair<>(Boolean.TRUE, (Boolean) valuePair.getValue());
            }catch (Exception e) {
                throw new CircuitInputException("Invalid Input: expected boolean for second parameter.");
            }
        }
        else{
            try {
                double d = Double.parseDouble(valuePair.getValue().toString());

                if (d < 0 || d > 1) {
                    throw new CircuitInputException("Invalid input: expected a real number between 0 and 1.");
                }
                else
                    this.valuePair = new Pair<>(Boolean.FALSE, d);
            }
            catch (Exception e){
                    throw new CircuitInputException("Invalid input: expected double number for second parameter.");
            }
        }
    }

    public BooleanConstant(boolean constant){
        if(constant)
            this.valuePair= new Pair<>(Boolean.TRUE, Boolean.TRUE);
        else
            this.valuePair= new Pair<>(Boolean.TRUE, Boolean.FALSE);
        this.booleanValue = constant;
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
