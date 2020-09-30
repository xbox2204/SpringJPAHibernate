package org.example.db.dao;

import org.example.db.config.DbConfig;
import org.example.db.interfaces.IBookDAO;
import org.example.db.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class BookDAO implements IBookDAO<Book> {

    @PersistenceContext(
           unitName = "VINEET_PERSISTENCE_UNIT"
    )

    @Autowired
    protected EntityManager em;
    DbConfig dbConfig =new DbConfig();

    public BookDAO(){
        super();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("VINEET_PERSISTENCE_UNIT", dbConfig.setPropFromEnv());
        em=factory.createEntityManager();
    }

    public void insert(Book book) {
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
    }

    public void insertBatch(ArrayList<Book> list) {
        EntityTransaction transaction= em.getTransaction();
        Iterator<Book> iterator = list.iterator();
        transaction.begin();
        int count=0;
        while (iterator.hasNext()){
            count++;
            em.merge(iterator.next());
            if(count%1000==0){
                em.flush();
                em.clear();
                transaction.commit();
                transaction.begin();
            }
        }
        transaction.commit();
    }

    public void removeAll() {
        em.getTransaction().begin();
        javax.persistence.Query q = em.createQuery("DELETE FROM Book");
        q.executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteById(int id) {
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM Book where id="+id);
        q.executeUpdate();
        em.getTransaction().commit();
    }

    public Book findById(int id) {
        em.getTransaction().begin();
        Book book=em.find(Book.class, id);
        em.getTransaction().commit();
        return book;
    }

    public List<Book> findAll() {
        List<Book> books = em.createQuery("SELECT b FROM BOOK b").getResultList();
        return books;
    }
}
