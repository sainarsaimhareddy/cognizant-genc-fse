package Algorithms_Data_Structures;

//E-commerce Platform Search Function
import java.util.*;
class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}

public class EcommercePlatformSearchFunction {
    public static Product linearSearch(List<Product> products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(List<Product> products, String targetName) {
        List<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort(Comparator.comparing(p -> p.productName.toLowerCase()));
        int low = 0, high = sortedProducts.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Product midProduct = sortedProducts.get(mid);
            int compare = midProduct.productName.compareToIgnoreCase(targetName);
            if (compare == 0) return midProduct;
            else if (compare < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product(101, "Apple Watch", "Electronics"),
            new Product(102, "Bluetooth Speaker", "Electronics"),
            new Product(103, "Camera", "Photography"),
            new Product(104, "Desk Lamp", "Furniture")
        );

        Product result1 = linearSearch(products, "Camera");
        Product result2 = binarySearch(products, "Desk Lamp");

        System.out.println("Linear Search: " + (result1 != null ? result1 : "Not found"));
        System.out.println("Binary Search: " + (result2 != null ? result2 : "Not found"));
    }
}
