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
    
    public BooleanConstant(Pair<Boolean, ?> valuePair){
        this.valuePair = valuePair;
    }

    public BooleanConstant(boolean constant){
        this(constant ?
                new Pair<Boolean, Boolean>(Boolean.TRUE, Boolean.TRUE) :
                new Pair<Boolean, Boolean>(Boolean.TRUE, Boolean.FALSE));
        booleanValue = constant;
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
