package com.asif.service;

import java.util.List;

import com.asif.model.Book;

public interface BookService {
    public Book findById(long id);
    public List<Book> findAll();
    public void createBook(Book book);
    public void updateBook(Book book, long id);
}
