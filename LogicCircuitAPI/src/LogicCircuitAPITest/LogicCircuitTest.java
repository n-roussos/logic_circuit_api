package LogicCircuitAPITest;

import LogicCircuitAPI.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.util.Pair;
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
        BooleanConstant in1, in2;
        BooleanExpression andGate;
        LogicCircuit lc;

        // test the circuit for different inputs
        in1 = new BooleanConstant(false);
        in2 = new BooleanConstant(false);
        andGate = new AndGate(in1, in2);
        lc = new LogicCircuit(andGate);
        assertFalse(lc.execute());

        in1.set(false);
        in2.set(true);
        assertFalse(lc.execute());

        in1.set(true);
        in2.set(false);
        assertFalse(lc.execute());

        in1.set(true);
        in2.set(true);
        assertTrue(lc.execute());
    }

    /**
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */
    @Test
    public void testX1andX2orX3() {

        // make the circuit
        BooleanConstant in1, in2, in3;
        BooleanExpression andGate, orGate;
        LogicCircuit lc;

        // test the circuit for different inputs
        in1 = new BooleanConstant(false);
        in2 = new BooleanConstant(true);
        in3 = new BooleanConstant(false);
        andGate = new AndGate(in1, in2);
        orGate = new OrGate(andGate, in3);
        lc = new LogicCircuit(orGate);
        assertFalse(lc.execute());

        in1.set(true);
        in2.set(false);
        in3.set(true);
        assertTrue(lc.execute());
    }

    /**
     * Create a circuit to evaluate (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */
    @Test
    public void testAlwaysTrue() {
        // make the circuit
        BooleanConstant in1;
        BooleanExpression notGate, orGate;
        LogicCircuit lc;

        // test the circuit for different inputs
        in1 = new BooleanConstant(false);
        notGate = new NotGate(in1);
        orGate = new OrGate(in1, notGate);
        lc = new LogicCircuit(orGate);
        assertTrue(lc.execute());

        in1.set(true);
        assertTrue(lc.execute());
    }

    /** First of all create a circuit which will evaluate
     * expression (x1 and x2) or not(x1). Hold the circuit
     * in some variable.
     *
     * Feed this circuit with x1=(true, true), x2=(true, false), assert result is (true, false)
     *
     * Feed the same circuit with x1=(true, false), x2=(true, true), assert result is (true, true)
     *
     * Feed the same circuit with x1=(false, 0.0), x2=(false, 1.0), assert result is (false, 1.0)
     *
     * Feed the same circuit with x1=(false, 0.5), x2=(false, 0.5), assert result is (false, 0.625)
     *
     * Feed the same circuit with x1=(false, 0.0), x2=(false, 2.0), make sure it throws an exception
     */
    @Test
    public void testX1andX2orNotX1() {
        // make the circuit
        BooleanConstant in1 = null, in2 = null;
        BooleanExpression andGate, notGate, orGate;
        LogicCircuit lc = null;

        // test the circuit
        try{
            in1 = new BooleanConstant(new Pair<>(Boolean.TRUE, Boolean.TRUE));
            in2 = new BooleanConstant(new Pair<>(Boolean.TRUE, Boolean.FALSE));
            andGate = new AndGate(in1, in2);
            notGate = new NotGate(in1);
            orGate = new OrGate(andGate, notGate);
            lc = new LogicCircuit(orGate);
            assertEquals(new Pair<>(Boolean.TRUE, Boolean.FALSE), lc.operate());
        }catch (CircuitInputException e){
            fail();
        }


        try{
            in1.set(new Pair<>(Boolean.TRUE, Boolean.FALSE));
            in2.set(new Pair<>(Boolean.TRUE, Boolean.TRUE));
            assertEquals(new Pair<>(Boolean.TRUE, Boolean.TRUE), lc.operate());
        }catch (CircuitInputException e){
            fail();
        }


        try {
            in1.set(new Pair<>(Boolean.FALSE, 0.0));
            in2.set(new Pair<>(Boolean.FALSE, 1.0));

            Pair<Boolean, Double> expected = new Pair<>(Boolean.FALSE, 1.0);
            Pair<Boolean, Double> output = lc.operate();
            assertEquals(expected.getKey(), output.getKey());
            assertEquals(expected.getValue(), output.getValue(), 0.001);
        } catch(CircuitInputException e) {
            fail();
        }


        try {
            in1.set(new Pair<>(Boolean.FALSE, 0.5));
            in2.set(new Pair<>(Boolean.FALSE, 0.5));

            Pair<Boolean, Double> expected = new Pair<>(Boolean.FALSE, 0.625);
            Pair<Boolean, Double> output = lc.operate();
            assertEquals(expected.getKey(), output.getKey());
            assertEquals(expected.getValue(), output.getValue(), 0.001);
        } catch(CircuitInputException e) {
            fail();
        }
    }


    @Test
    public void testOtherInputType() {
        // make the circuit
        BooleanConstant in1 = null, in2 = null;
        BooleanExpression andGate, notGate, orGate;
        LogicCircuit lc = null;

        // test the circuit
        try{
            in1 = new BooleanConstant(new Pair<>(Boolean.TRUE, Boolean.TRUE));
            in2 = new BooleanConstant(new Pair<>(Boolean.TRUE, Boolean.FALSE));
            andGate = new AndGate(in1, in2);
            notGate = new NotGate(in1);
            orGate = new OrGate(andGate, notGate);
            lc = new LogicCircuit(orGate);
            assertEquals(new Pair<>(Boolean.TRUE, Boolean.FALSE), lc.operate());
        }catch (CircuitInputException e){
            fail();
        }

//        // String type case: exception
//        try{
//            in1.set(new Pair<>(Boolean.TRUE, Boolean.FALSE));
//            in2.set(new Pair<>(Boolean.TRUE, "Hiba"));
//            assertEquals(new Pair<>(Boolean.TRUE, Boolean.TRUE), lc.operate());
//        }catch (CircuitInputException e){
//            System.out.println("fail at String");
//            fail();
//        }

//        // Char type case: exception
//        try{
//            Boolean variable1 = Boolean.TRUE;
//            char variable2 = 'D';
//            in1.set(new Pair<>(variable1, variable2));
//            in2.set(new Pair<>(Boolean.TRUE, Boolean.TRUE));
//            assertEquals(new Pair<>(Boolean.TRUE, Boolean.TRUE), lc.operate());
//        }catch (CircuitInputException e){
//            System.out.println("fail at char");
//            fail();
//        }


//        // Case of number higher than 1.0: exception
//        try {
//            in1.set(new Pair<>(Boolean.FALSE, 3.0));
//            in2.set(new Pair<>(Boolean.FALSE, 0.5));
//
//            Pair<Boolean, Double> expected = new Pair<>(Boolean.FALSE, 0.625);
//            Pair<Boolean, Double> output = lc.operate();
//            assertEquals(expected.getKey(), output.getKey());
//            assertEquals(expected.getValue(), output.getValue(), 0.001);
//        } catch(CircuitInputException e) {
//            System.out.println("fail at number higher than 1");
//            fail();
//        }


        // Integer type case: pass
        try {
            in1.set(new Pair<>(Boolean.FALSE, 1));
            in2.set(new Pair<>(Boolean.FALSE, 0.5));

            Pair<Boolean, Double> expected = new Pair<>(Boolean.FALSE, 0.5);
            Pair<Boolean, Double> output = lc.operate();
            assertEquals(expected.getKey(), output.getKey());
            assertEquals(expected.getValue(), output.getValue(), 0.001);
        } catch(CircuitInputException e) {
            fail();
        }


        // Integer type case: pass
        try {
            in1.set(new Pair<>(Boolean.FALSE, 1));
            in2.set(new Pair<>(Boolean.FALSE, 1));

            Pair<Boolean, Double> expected = new Pair<>(Boolean.FALSE, 1.0);
            Pair<Boolean, Double> output = lc.operate();
            assertEquals(expected.getKey(), output.getKey());
            assertEquals(expected.getValue(), output.getValue(), 0.001);
        } catch(CircuitInputException e) {
            fail();
        }

        // Integer type case: pass
        try {
            in1.set(new Pair<>(Boolean.TRUE, Boolean.FALSE));
            in2.set(new Pair<>(Boolean.FALSE, 0.5));

            Pair<Boolean, Double> expected = new Pair<>(Boolean.FALSE, 0.5);
            Pair<Boolean, Double> output = lc.operate();
            assertEquals(expected.getKey(), output.getKey());
            assertEquals(expected.getValue(), output.getValue(), 0.001);
        } catch(CircuitInputException e) {
            fail();
        }


    }

}
