package com.asif.service;

import com.asif.model.Book;

public interface BookService {
    public Book findById(long id);
    public void createBook(Book book);
}
