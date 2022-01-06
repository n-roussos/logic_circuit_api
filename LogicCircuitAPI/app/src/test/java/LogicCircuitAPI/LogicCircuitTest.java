/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package LogicCircuitAPI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LogicCircuitTest {
    /** 
     * Create a circuit to evaluate x1 and x2 and then
     * verify that its result is false for input (false, true) and
     * it is true for input (true, true).
     */
    @Test
    public void testX1andX2() {
        // make the circuit       
	//LogicCircuit lc = ...;
        boolean x1, x2;
        
        // test the circuit for different inputs
        x1 = false;
	x2 = false;
        assertEquals(false, " circuit output"); 
        
 	x1 = false;
	x2 = true;
        assertEquals(false, " circuit output");
        
        x1 = true;
	x2 = false;
        assertEquals(false, " circuit output"); 
        
        x1 = true;
        x2 = true;
        assertEquals(true, " circuit output");
    }
    
    /** 
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */ 
    @Test
    public void testX1andX2orX3() {
        // make the circuit        
	//LogicCircuit lc = ...;
        boolean x1, x2, x3;
        
        // test the circuit for different inputs        
        x1 = false;
        x2 = true;
        x3 = false;
        assertEquals(false, " circuit output");
        
        x1 = true;
        x2 = false;
        x3 = true;
        assertEquals(true, " circuit output");      	  
    }
    
    /** 
     * Create a circuit to evaluate (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */
    @Test
    public void testAlwaysTrue() {
        // make the circuit   
	//LogicCircuit lc = ...;
        boolean x1;
        // test the circuit for different inputs
        x1 = false;
        assertEquals(true, " circuit output");
        
       x1 = true;        
        assertEquals(true, " circuit output");      	 
    }

}