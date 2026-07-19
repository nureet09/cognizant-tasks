package MockDemo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Create a mock object for the external API dependency
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub the methods to return predefined values when invoked
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Write a test case that uses the mock object to verify behavior
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Validate outcomes using clean JUnit 5 assertions
        assertEquals("Mock Data", result, "The service should return the stubbed data provided by the mock API.");
    }
}