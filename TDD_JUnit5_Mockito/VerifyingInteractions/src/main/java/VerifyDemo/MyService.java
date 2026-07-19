package VerifyDemo;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public void fetchData() {
        // Invokes the method on our dependency
        externalApi.getData();
    }
}