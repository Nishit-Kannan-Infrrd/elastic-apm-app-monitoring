package com.crazynerve.library.controller;

import com.crazynerve.library.entities.Book;
import com.crazynerve.library.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
@RequestMapping("/books")
public class BooksController
{
    private static final Logger LOGGER = Logger.getLogger( BooksController.class.getName() );
    private BooksService booksService;

    @Autowired
    public void setBooksService( BooksService booksService )
    {
        this.booksService = booksService;
    }


    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<>(booksService.addBook( book ), HttpStatus.CREATED);
    }
}
