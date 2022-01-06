/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicCircuitAPI;

/**
 *
 * @author Pooyan
 */
public class Main {
    public static void main(String[] args){
         
        
        BooleanExpression in1, in2, in3, andGate, orGate, notGate;
        
        // test the circuit for different inputs
        
        in1 = new BooleanConstant(true);
        in2 = new BooleanConstant(false);
        in3 = new BooleanConstant(false);
        andGate = new AndGate(in1, in2);
        LogicCircuit resAnd = new LogicCircuit(andGate);
        orGate = new OrGate(new BooleanConstant(resAnd.execute()),in3);
                      
        LogicCircuit resOr = new LogicCircuit(andGate);
        System.out.println("OUTPUT IS: "+resOr.execute()); 
    }
}
