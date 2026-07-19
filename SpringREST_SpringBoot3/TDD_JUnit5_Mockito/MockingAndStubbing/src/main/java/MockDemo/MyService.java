package MockDemo;

public class MyService {
    private final ExternalApi externalApi;

    // Inject dependency via constructor
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}