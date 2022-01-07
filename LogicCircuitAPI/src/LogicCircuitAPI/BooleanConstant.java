/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicCircuitAPI;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

/**
 *
 * @author Panikos
 */
public class BooleanConstant extends BooleanExpression{
    private boolean booleanValue;
    private Pair<Boolean, ?> valuePair;
    
    public BooleanConstant(Pair<Boolean, ?> valuePair) throws Exception {
        if(valuePair.getKey()== true) {
            this.valuePair = new Pair<Boolean, Boolean>(true,valuePair.getKey().booleanValue() );
            {
                throw new Exception("Invalid Input: expected boolean for second parameter.");
            }
        }
        else{
            try {
                Double d = Double.parseDouble(valuePair.getValue().toString());

                if (d < 0 || d > 1) {
                    throw new Exception("Invalid input: expected a real number between 0 and 1.");
                }
                else
                    this.valuePair = new Pair<Boolean, Double>(false,d );
            }
            catch (Exception ex){
                    throw new Exception("Invalid input: expected double number for second parameter.");
            }
        }
    }

    public BooleanConstant(boolean constant){
        if(constant)
            this.valuePair=new Pair<Boolean, Boolean>(Boolean.TRUE, Boolean.TRUE);
        else
            this.valuePair=new Pair<Boolean, Boolean>(Boolean.TRUE, Boolean.FALSE);
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
