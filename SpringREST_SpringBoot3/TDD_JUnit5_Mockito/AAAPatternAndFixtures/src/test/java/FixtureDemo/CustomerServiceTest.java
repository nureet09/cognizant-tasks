package FixtureDemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest {
    private CustomerService customerService;

    // Run once before all tests run in this class
    @BeforeAll
    public static void initAll() {
        System.out.println("[Lifecycle: @BeforeAll] Starting Test Suite Execution.");
    }

    // Setup Method: Runs before EACH individual test case (Replaces JUnit 4's @Before)
    @BeforeEach
    public void setUp() {
        System.out.println("[Lifecycle: @BeforeEach] Initializing clean test fixtures.");
        customerService = new CustomerService();
    }

    @Test
    public void testCustomerAdditionCount() {
        // 1. ARRANGE: Set up initial variables and parameters
        String newCustomer = "Nureet Kaur";

        // 2. ACT: Execute the specific action under evaluation
        customerService.addCustomer(newCustomer);

        // 3. ASSERT: Verify the outcome against expected benchmarks
        assertEquals(1, customerService.getCustomerCount(), "Customer list size should reflect exactly 1 entry.");
    }

    // Teardown Method: Runs after EACH individual test completes (Replaces JUnit 4's @After)
    @AfterEach
    public void tearDown() {
        System.out.println("[Lifecycle: @AfterEach] Cleaning up system resources/data.");
        customerService.clearRecords();
    }

    // Run once after all tests complete inside this class
    @AfterAll
    public static void tearDownAll() {
        System.out.println("[Lifecycle: @AfterAll] Test Suite completely finished.");
    }
}