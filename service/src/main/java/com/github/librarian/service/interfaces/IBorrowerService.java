package com.github.librarian.service.interfaces;

import com.github.librarian.service.dto.BorrowerDto;
import com.github.librarian.service.dto.BorrowerRegisterDto;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zack.wu on 2017/4/18.
 */
public interface IBorrowerService {

    /**
     * 冻结借阅者账号
     * @param borrowerId
     * @return
     */
    boolean ban(int borrowerId);

    /**
     * 激活借阅者账号
     * @param borrowerId
     * @return
     */
    boolean enable(int borrowerId);


}
