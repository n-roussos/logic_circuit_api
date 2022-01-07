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
    private final boolean value;
    private Pair<Boolean, Double> valuePair;
    
    public BooleanConstant(boolean constant){
        value = constant;
    }
    
    @Override
    public boolean calculate(){
        return value;
    }
}
