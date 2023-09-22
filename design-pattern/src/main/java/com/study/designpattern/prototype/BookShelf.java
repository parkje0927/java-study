package com.study.designpattern.prototype;

import java.util.ArrayList;

public class BookShelf implements Cloneable {

    private ArrayList<Book> shelf;

    public BookShelf() {
        shelf = new ArrayList<>();
    }

    //얕은 복사가 일어난다.
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    //깊은 복사
    @Override
    protected Object clone() throws CloneNotSupportedException {
        BookShelf anotherBookShelf = new BookShelf();
        for (Book book : shelf) {
            anotherBookShelf.addBook(new Book(book.getAuthor(), book.getTitle()));
        }

        return anotherBookShelf;
    }

    public String toString() {
        return shelf.toString();
    }

    public void addBook(Book book) {
        shelf.add(book);
    }

    public ArrayList<Book> getShelf() {
        return shelf;
    }

    public void setShelf(ArrayList<Book> shelf) {
        this.shelf = shelf;
    }
}
