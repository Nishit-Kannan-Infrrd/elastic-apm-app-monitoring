package com.crazynerve.library.services;

import com.crazynerve.library.entities.Book;
import com.crazynerve.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class BooksServiceImpl implements BooksService
{
    private static final Logger LOGGER = Logger.getLogger( BooksServiceImpl.class.getName() );

    private BooksRepository booksRepository;

    @Autowired
    public void setBooksRepository( BooksRepository booksRepository )
    {
        this.booksRepository = booksRepository;
    }


    @Override
    public Book addBook( Book book )
    {
        LOGGER.info( () -> "Adding book " + book );
        Book newBook = booksRepository.save( book );
        return newBook;
    }
}
