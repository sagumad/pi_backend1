package com.example.application.service;

import com.example.application.model.Book;
import com.example.application.model.RentBook;
import com.example.application.model.SaleBook;
import com.example.application.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean rentBook(Long id, int days) {
        Optional<Book> b = repository.findById(id);
        if (b.isPresent() && b.get().isAvailable()) {
            Book book = b.get();
            book.setAvailable(false);
            if (book instanceof RentBook) {
                ((RentBook) book).setRentalDays(days);
            }
            repository.save(book);
            return true;
        }
        return false;
    }

    public boolean sellBook(Long id) {
        Optional<Book> b = repository.findById(id);
        if (b.isPresent() && b.get().isAvailable()) {
            Book book = b.get();
            book.setAvailable(false);
            repository.save(book);
            return true;
        }
        return false;
    }

    @PostConstruct
    private void init() {
        if (repository.count() == 0) {
            repository.save(new SaleBook("Java efectivo", "Joshua Bloch", 45.0, "nuevo"));
            repository.save(new RentBook("Código Limpio", "Robert C. Martin", 5.0, 7));
            repository.save(new SaleBook("Concurrencia en Java", "Brian Goetz", 50.0, "usado"));
        }
    }
}
