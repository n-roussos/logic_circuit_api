/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicCircuitAPI;

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
}
