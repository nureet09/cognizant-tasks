package TestingDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    // Run before each test case to initialize clean components
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        int result = calculator.add(10, 5);
        // JUnit 5 Assertion checking if expected matches actual value
        assertEquals(15, result, "10 + 5 should equal 15");
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(10, 5);
        assertEquals(5, result, "10 - 5 should equal 5");
    }
}