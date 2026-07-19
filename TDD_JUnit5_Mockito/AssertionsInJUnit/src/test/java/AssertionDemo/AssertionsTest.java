package AssertionDemo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // --- Core Base Scenario Assertions (From your assignment sheet) ---
        
        // Assert equals
        assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        assertNull(null);

        // Assert not null
        assertNotNull(new Object());
        
        // --- Real World Object Context Assertions ---
        Account account = new Account("ACT1001", 5000.50, "Nureet Kaur");
        Account pendingAccount = null;

        assertEquals("ACT1001", account.getAccountId(), "Account IDs should match");
        assertTrue(account.getBalance() > 0, "Initial balance should be positive");
        assertFalse(account.isOverdrawn(), "Account should not be flagged as overdrawn");
        assertNull(pendingAccount, "An uninitialized account reference should be null");
        assertNotNull(account.getHolderName(), "Account holder name field should not be null");
    }
}
