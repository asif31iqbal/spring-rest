package com.asif.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asif.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
