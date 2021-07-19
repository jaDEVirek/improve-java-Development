package testUtils;

//Interfejs zamówienia
public interface OrderBehavior {
    //zachowania
    void placeAnOrder();
    void addProductToOrder(String product);
    Order showOrderInformation();
}


