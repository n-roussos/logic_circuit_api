/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicCircuitAPI;

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
}
