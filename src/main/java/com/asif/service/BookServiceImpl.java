package com.asif.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asif.model.Book;
import com.asif.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService{
    
    @Resource
    BookRepository repository;
    
    @Override
    public Book findById(long id){
        return repository.findOne(id);
    }
    
    @Override
    public void createBook(Book book){
        repository.save(book);
    }
}
