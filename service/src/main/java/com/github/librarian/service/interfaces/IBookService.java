package com.github.librarian.service.interfaces;

import com.github.librarian.service.dto.AddBookDto;
import com.github.librarian.service.dto.BookDto;
import com.github.librarian.service.dto.LossBookDto;
import com.github.pagehelper.PageInfo;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by zack.wu on 2017/4/18.
 */
public interface IBookService {
    /**
     * 借书
     * @param borrowerId
     * @param bookISBN
     * @return
     */
    boolean borrowBook(int borrowerId,String bookISBN) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    /**
     * 还书
     * @param borrowerId
     * @param bookISBN
     * @return
     */
    boolean returnBook(int borrowerId,String bookISBN);


    /**
     * 查询书籍 -- 根据ISBN精确查询
     * @return
     */
    BookDto queryBookByISBN(String isbn) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    /**
     * 损耗图书
     * @return
     */
    boolean loss(LossBookDto bookDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    /**
     * 新书添加
     * @param book
     * @return
     */
    boolean addBook(AddBookDto book) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

}
