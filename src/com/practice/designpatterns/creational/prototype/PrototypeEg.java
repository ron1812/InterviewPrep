package com.practice.designpatterns.creational.prototype;

public class PrototypeEg {

    // Create deep copy of an object
    // Assume you have to do a database call to bring in loads of data during creation of new instance of BookShop object
    // In this case instead of calling the database during each new instance creation we can do a deep clone which will save crucial time and Io call to db
    public static void main(String[] args) {
        BookShop bookShop1 = new BookShop();
        bookShop1.setShopName("Novelty");

        bookShop1.loadBooksFromDb();

        System.out.println("BOOK SHOP 1 ATTRIBUTES BEFORE DELETION OF BOOK  \n"+bookShop1);

        BookShop bookShop2 = bookShop1.clone();
        bookShop2.setShopName("A1");

        bookShop1.getBooks().remove(3);

        System.out.println("BOOK SHOP 1 ATTRIBUTES AFTER DELETION OF BOOK  \n"+bookShop1);
        System.out.println("BOOK SHOP 2 ATTRIBUTES  \n"+bookShop2);


    }
}
