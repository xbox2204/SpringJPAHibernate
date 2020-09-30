package org.example.db.interfaces;

import java.util.ArrayList;
import java.util.List;
import org.example.db.model.Book;

public interface IBookDAO<Book> {
    void insert(Book book);
    void insertBatch(ArrayList<Book> list);
    void removeAll();
    void deleteById(int id);
    Book findById(int id);
    List<Book> findAll();
}
