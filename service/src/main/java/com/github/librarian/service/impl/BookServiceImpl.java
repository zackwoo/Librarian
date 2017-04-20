package com.github.librarian.service.impl;

import com.github.librarian.service.dto.BookDto;
import com.github.librarian.service.interfaces.IBookService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by zachary on 2017/4/18.
 */
@Service
public class BookServiceImpl implements IBookService {

    public boolean borrowBook(int borrowerId, String bookISBN) {
        return false;
    }

    public boolean returnBook(int borrowerId, String bookISBN) {
        return false;
    }

    public PageInfo<BookDto> queryBookInfo() {
        return null;
    }

    public PageInfo<BookDto> queryBookByName() {
        return null;
    }

    public BookDto queryBookByISBN(String isbn) {
        return null;
    }

    public boolean loss(String isbn) {
        return false;
    }

    public boolean addBook(String isbn, int count) {
        return false;
    }

    public boolean addBook(BookDto book, int count) {
        return false;
    }
}
