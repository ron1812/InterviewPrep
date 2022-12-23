package com.practice.designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable{

    private String shopName;
    private List<Book> books = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadBooksFromDb(){

        for(int i=0;i<5;i++){
            Book b = new Book();
            b.setBookId(i);
            b.setBookName("Book"+i);

            books.add(b);
        }
    }

    @Override
    protected BookShop clone() {

        BookShop bookShop = new BookShop();

        for(Book b : this.getBooks()){

            bookShop.getBooks().add(b);
        }

        return bookShop;
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }
}
