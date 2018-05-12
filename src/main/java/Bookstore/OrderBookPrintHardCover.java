package Bookstore;

public class OrderBookPrintHardCover extends OrderBookPrint {
    @Override
    public void orderPrint() {
        System.out.println("Zlecono druk z twardą oprawą");
    }

    @Override
    public void mailBookOrder() {
        System.out.println("Wysłano mail z zamówieniem książki z twardą oprawą");
    }
}
