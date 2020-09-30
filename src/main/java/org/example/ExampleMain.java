package org.example;

import org.example.db.config.DbConfig;
import org.example.db.model.Book;
import org.example.db.service.BookService;

import java.util.Map;

public class ExampleMain {
    public static void main(String[] args){
        DbConfig dbConfig =new DbConfig();
        System.out.println("DATABASE_URL= "+System.getenv("DATABASE_URL"));

        Map<String,Object> map = dbConfig.setPropFromEnv();
        for (Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+"= "+entry.getValue().toString());
        }
        Book book1 = new Book();
        book1.setAuthor_name("vineet");
        book1.setBook_name("java");
        book1.setIsbn("007");
        BookService bookService = new BookService();
        bookService.insert(book1);
        System.out.println("Book inserted in library!!!");
    }
}
