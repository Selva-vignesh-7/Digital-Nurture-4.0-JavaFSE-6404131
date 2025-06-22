public class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String cat) {
        productId = id;
        productName = name;
        category = cat;
    }

    public String toString() {
        return productName + " (" + category + ")";
    }
}