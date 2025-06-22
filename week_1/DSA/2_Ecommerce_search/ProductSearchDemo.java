import java.util.Arrays;

public class ProductSearchDemo {

    // Linear search: checks each product one by one
    /**
     * Linear search: checks each product one by one
     * Time Complexity: O(n) - must check each element in the worst case
     * Space Complexity: O(1) - uses constant extra space
     */
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Binary search: works only if products are sorted by productName
    /**
     * Binary search: works only if products are sorted by productName
     * Time Complexity: O(log n) - divides the search space in half each time
     * Space Complexity: O(1) - uses constant extra space
     */
    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shirt", "Clothing"),
            new Product(3, "Book", "Books"),
            new Product(4, "Phone", "Electronics")
        };

        // Sort products by productName for binary search
        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        // Try searching for "Book"
        Product foundLinear = linearSearch(products, "Book");
        Product foundBinary = binarySearch(products, "Laptop");

        System.out.println("Linear Search Result: " + foundLinear);
        System.out.println("Binary Search Result: " + foundBinary);
    }
}