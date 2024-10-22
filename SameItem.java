package DessertShop;

// Define a generic interface with a type parameter T
public interface SameItem<T> {
    // Method that takes an item of type T and returns a boolean
    boolean isSameAs(T item);
}
