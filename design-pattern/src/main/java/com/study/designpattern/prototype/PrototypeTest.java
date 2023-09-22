package com.study.designpattern.prototype;

public class PrototypeTest {

    /**
     * 프로토타입을 통해 복제가 가능하고, 자바는 clone() 을 통해 복제가 가능하다.
     * 인터페이스 설계하고, 이를 구체적으로 구현하는 것
     * 객체를 모아둔 객체가 있다.
     * Book, BookShelf
     */

    public static void main(String[] args) throws CloneNotSupportedException {
        BookShelf bookShelf = new BookShelf();

        bookShelf.addBook(new Book("testA", "authorA"));
        bookShelf.addBook(new Book("testB", "authorB"));
        bookShelf.addBook(new Book("testC", "authorC"));

        System.out.println(bookShelf);

        //복제 clone()
        BookShelf anotherBookShelf = (BookShelf) bookShelf.clone();

        System.out.println(anotherBookShelf);

        bookShelf.getShelf().get(0).setAuthor("testA");
        bookShelf.getShelf().get(0).setTitle("깊은 복사");

        //얕은 복사가 이루어져서 anotherBookShelf 도 변경된다.
        //즉, 주소를 복제해준것이다.
        System.out.println(bookShelf);
        System.out.println(anotherBookShelf);
    }
}
