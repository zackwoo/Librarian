package com.github.librarian.service.interfaces;

import com.github.librarian.service.dto.BookDto;
import com.github.pagehelper.PageInfo;

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
    boolean borrowBook(int borrowerId,String bookISBN);
    /**
     * 还书
     * @param borrowerId
     * @param bookISBN
     * @return
     */
    boolean returnBook(int borrowerId,String bookISBN);

    /**
     * 查询所有书籍
     * @return
     */
    PageInfo<BookDto> queryBookInfo();
    /**
     * 查询所有书籍-根据书名模糊查询
     * @return
     */
    PageInfo<BookDto> queryBookByName();
    /**
     * 查询书籍 -- 根据ISBN精确查询
     * @return
     */
    BookDto queryBookByISBN(String isbn);

    /**
     * 损耗图书
     * @param isbn
     * @return
     */
    boolean loss(String isbn);

    /**
     * 添加图书 --已有图书增加
     * @return
     */
    boolean addBook(String isbn,int count);

    /**
     * 新书添加
     * @param book
     * @param count
     * @return
     */
    boolean addBook(BookDto book,int count);

}
