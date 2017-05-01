package com.github.librarian.service.impl;

import com.github.librarian.model.entity.Book;
import com.github.librarian.model.entity.BookBorrowingRecord;
import com.github.librarian.model.entity.Borrower;
import com.github.librarian.model.enums.BorrowerStatus;
import com.github.librarian.model.mapper.BookBorrowingRecordMapper;
import com.github.librarian.model.mapper.BookMapper;
import com.github.librarian.model.mapper.BorrowerMapper;
import com.github.librarian.service.common.IGeneralService;
import com.github.librarian.service.convert.GeneralBeanConvert;
import com.github.librarian.service.dto.AddBookDto;
import com.github.librarian.service.dto.BookDto;
import com.github.librarian.service.dto.LossBookDto;
import com.github.librarian.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by zachary on 2017/4/18.
 */
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    IGeneralService generalService;
    @Autowired
    BorrowerMapper borrowerMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookBorrowingRecordMapper bookBorrowingRecordMapper;


    //检查借阅者是否有资格借阅
    private boolean checkBorrower(int borrowerId) {
        Borrower borrower = borrowerMapper.selectByPrimaryKey(borrowerId);
        if (null == borrower) return false;
        if (borrower.getStatus() != BorrowerStatus.BAN) return false;
        return true;
    }

    @Transactional
    public boolean borrowBook(int borrowerId, String bookISBN) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if(!checkBorrower(borrowerId)){
            return false;
        }
        Book book = bookMapper.selectByPrimaryKey(bookISBN);
        Integer bookcount = book.getBookcount();
        if (bookcount<1) return false;

        book.setBookcount(bookcount-1);
        bookMapper.updateByPrimaryKey(book);
        BookBorrowingRecord bookBorrowingRecord = new BookBorrowingRecord();
        bookBorrowingRecord.setBorrowerid(borrowerId);
        bookBorrowingRecord.setBorrowtime(new Date());
        bookBorrowingRecord.setIsbn(bookISBN);
        bookBorrowingRecord.setIsover(false);
        bookBorrowingRecordMapper.insert(bookBorrowingRecord);
        return true;
    }

    public boolean returnBook(int borrowerId, String bookISBN) {
        if(!checkBorrower(borrowerId)){
            return false;
        }
        return false;
    }


    public BookDto queryBookByISBN(String isbn) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        return  (BookDto)generalService.selectByPrimaryKey(BookMapper.class,isbn,BookDto.class);
    }

    public boolean loss(LossBookDto bookDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Book book = generalService.selectByPrimaryKey(BookMapper.class, bookDto.getIsbn());
        if (book == null) return false;//未查到图书

        Integer bookcount = book.getBookcount();
        if (bookcount<bookDto.getCount()) return false;//图书数量不够
        book.setBookcount(bookcount-bookDto.getCount());
        return generalService.updateByPrimaryKey(BookMapper.class,book) == 1;
    }


    public boolean addBook(AddBookDto book) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Book entity = generalService.selectByPrimaryKey(BookMapper.class, book.getIsbn());
        if (entity != null) return false;
        int affectCount  = generalService.insert(BookMapper.class, book, GeneralBeanConvert.class);
        return affectCount == 1;
    }
}
