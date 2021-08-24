package com.crazynerve.library.repositories;

import com.crazynerve.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<Book, String>
{
}
