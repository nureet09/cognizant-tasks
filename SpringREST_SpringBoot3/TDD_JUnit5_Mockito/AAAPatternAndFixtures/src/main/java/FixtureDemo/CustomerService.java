package FixtureDemo;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<String> customers = new ArrayList<>();

    public void addCustomer(String name) {
        customers.add(name);
    }

    public int getCustomerCount() {
        return customers.size();
    }

    public void clearRecords() {
        customers.clear();
    }
}