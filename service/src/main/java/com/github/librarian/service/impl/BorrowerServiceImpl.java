package com.github.librarian.service.impl;

import com.github.librarian.model.custom.BorrowerCustomMapper;
import com.github.librarian.model.mapper.BorrowerMapper;
import com.github.librarian.service.dto.BorrowerDto;
import com.github.librarian.service.dto.BorrowerRegisterDto;
import com.github.librarian.service.interfaces.IBorrowerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zachary on 2017/4/18.
 */

@Service
public class BorrowerServiceImpl implements IBorrowerService{

    @Autowired
    private BorrowerCustomMapper mapper;

    public boolean ban(int borrowerId) {
        return mapper.ban(borrowerId) == 1;
    }

    public boolean enable(int borrowerId) {
        return false;
    }
}
