package com.crazynerve.library.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class Book implements Serializable
{
    @Id
    @Column(name = "book_id")
    @GeneratedValue (generator = "uuid")
    @GenericGenerator (name = "uuid", strategy = "uuid2")
    private String bookId;
    private String author;
    private String title;


    public Book()
    {
    }


    public String getBookId()
    {
        return bookId;
    }


    public void setBookId( String bookId )
    {
        this.bookId = bookId;
    }


    public String getAuthor()
    {
        return author;
    }


    public void setAuthor( String author )
    {
        this.author = author;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle( String title )
    {
        this.title = title;
    }


    @Override
    public String toString()
    {
        return "Book{" + "bookId='" + bookId + '\'' + ", author='" + author + '\'' + ", title='" + title + '\'' + '}';
    }
}
