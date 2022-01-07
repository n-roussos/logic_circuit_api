/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package LogicCircuitAPI;

public class LogicCircuit {
    private BooleanExpression be;
    
    public LogicCircuit(BooleanExpression booleanExpression){
        be = booleanExpression;
    }
    
    public boolean execute(){
        return be.calculate();
    }

    public <T> T operate() throws CircuitInputException {
        return (T) be.calculatePair();
    }


}
