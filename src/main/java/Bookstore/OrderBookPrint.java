package Bookstore;

public abstract class OrderBookPrint {

    public static void chooseAndPrintBookByISBN(String numberISBN) {
        Book bookToPrint = BooksFunctions.findBookByISBN(BookList.getBookListInstance().getBookListItems(), numberISBN);
        if (bookToPrint != null) {
            OrderBookPrint orderBookPrint = new OrderBookPrintHardCover();
            switch (bookToPrint.getCover()) {
                case 'M':
                    orderBookPrint = new OrderBookPrintSoftCover();
                    break;
                case 'T':
                    orderBookPrint = new OrderBookPrintHardCover();
                    break;
                default:
                    break;
            }
            orderBookPrint.startPrintOrder();
            orderBookPrint.orderPrint();
            orderBookPrint.endPrintOrder();
            orderBookPrint.mailBookOrder();
        } else System.out.println("Brak książki o podanym numerze ISBN");
    }


    public void startPrintOrder() {
        System.out.println("Rozpoczęcie zlecenia druku");
    }

    public abstract void orderPrint();

    public void endPrintOrder() {
        System.out.println("Zakończenie zlecenia druku");
    }

    public abstract void mailBookOrder();


}
