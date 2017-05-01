package com.github.librarian.model.enums;

/**
 * Created by zachary on 2017/5/1.
 */
public enum BorrowerStatus {

    BAN(2),NORMAL(1);

    private int value = 0;

    private BorrowerStatus(int val){
        this.value = val;
    }

    public static BorrowerStatus valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return NORMAL;
            case 2:
                return BAN;
            default:
                return null;
        }
    }
}
