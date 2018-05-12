package Bookstore;

public class OrderBookPrintSoftCover extends OrderBookPrint {

    @Override
    public void orderPrint() {
        System.out.println("Zlecono druk z miękką oprawą");
    }

    @Override
    public void mailBookOrder() {
        System.out.println("Wysłano mail z zamówieniemksiążki z miękką oprawą");

    }
}
