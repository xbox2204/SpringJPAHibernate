package org.example.db.service;

import org.example.db.dao.BookDAO;
import org.example.db.model.Book;

import javax.persistence.Query;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional("mysqltx")
public class BookService {
    @Autowired
    private BookDAO bookDAO= new BookDAO();

    public void insert(Book book) {
    if (book == null){
       throw new IllegalArgumentException("Invalid Argument");
    }
    bookDAO.insert(book);
    }

    public void insertBatch(ArrayList<Book> list) {
        if (list == null){
            throw new IllegalArgumentException("Invalid Argument");
        }
        bookDAO.insertBatch(list);
    }

    public void removeAll() {
        bookDAO.removeAll();
    }

    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    public Book findById(int id) {
        Book book = bookDAO.findById(id);
        return book;
    }

    public List<Book> findAll() {
        List<Book> books = bookDAO.findAll();
        return books;
    }

}
