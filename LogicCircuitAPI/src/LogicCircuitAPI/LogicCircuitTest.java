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
        BooleanExpression in1, in2, andGate;
        LogicCircuit lc;

        // test the circuit for different inputs
        in1 = new BooleanConstant(false);
        in2 = new BooleanConstant(false);
        andGate = new AndGate(in1, in2);
        lc = new LogicCircuit(andGate);
        assertEquals(false, lc.execute());

        in1 = new BooleanConstant(false);
        in2 = new BooleanConstant(true);
        andGate = new AndGate(in1, in2);
        lc = new LogicCircuit(andGate);
        assertEquals(false, lc.execute());

        in1 = new BooleanConstant(true);
        in2 = new BooleanConstant(false);
        andGate = new AndGate(in1, in2);
        lc = new LogicCircuit(andGate);
        assertEquals(false, lc.execute());

        in1 = new BooleanConstant(true);
        in2 = new BooleanConstant(true);
        andGate = new AndGate(in1, in2);
        lc = new LogicCircuit(andGate);
        assertEquals(true, lc.execute());
    }

    /**
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */
    @Test
    public void testX1andX2orX3() {

        // make the circuit
        BooleanExpression in1, in2, in3, andGate, orGate;
        LogicCircuit lc;

        // test the circuit for different inputs
        in1 = new BooleanConstant(false);
        in2 = new BooleanConstant(true);
        in3 = new BooleanConstant(false);
        andGate = new AndGate(in1, in2);
        orGate = new OrGate(andGate, in3);
        lc = new LogicCircuit(orGate);
        assertEquals(false, lc.execute());

        in1 = new BooleanConstant(true);
        in2 = new BooleanConstant(false);
        in3 = new BooleanConstant(true);
        andGate = new AndGate(in1, in2);
        orGate = new OrGate(andGate, in3);
        lc = new LogicCircuit(orGate);
        assertEquals(true, lc.execute());
    }

    /**
     * Create a circuit to evaluate (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */
    @Test
    public void testAlwaysTrue() {
        // make the circuit
        BooleanExpression in1, notGate, orGate;
        LogicCircuit lc;

        // test the circuit for different inputs
        in1 = new BooleanConstant(false);
        notGate = new NotGate(in1);
        orGate = new OrGate(in1, notGate);
        lc = new LogicCircuit(orGate);
        assertEquals(true, lc.execute());

        in1 = new BooleanConstant(true);
        notGate = new NotGate(in1);
        orGate = new OrGate(in1, notGate);
        lc = new LogicCircuit(orGate);
        assertEquals(true, lc.execute());
    }

}
