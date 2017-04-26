package com.github.librarian.model.custom;

/**
 * Created by zack.wu on 2017/4/26.
 */
public interface BorrowerCustomMapper {
    int ban(Integer id);
    int enable(Integer id);
}
