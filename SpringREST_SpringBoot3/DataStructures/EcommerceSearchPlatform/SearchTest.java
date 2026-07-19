package DataStructures.SearchFunctionality;

import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(104, "Gaming Chair", "Furniture"),
            new Product(102, "USB-C Cable", "Accessories"),
            new Product(103, "LED Monitor", "Electronics")
        };

        int targetId = 104;

        System.out.println("--- 1. Testing Linear Search ---");
        Product resultLinear = SearchAlgorithms.linearSearch(products, targetId);
        System.out.println("Linear Search Result: " + resultLinear);

        System.out.println("\n--- 2. Preparing Data for Binary Search ---");
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.println("\n--- 3. Testing Binary Search ---");
        Product resultBinary = SearchAlgorithms.binarySearch(products, targetId);
        System.out.println("Binary Search Result: " + resultBinary);
    }
}