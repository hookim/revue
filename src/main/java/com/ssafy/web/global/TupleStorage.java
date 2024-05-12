package com.ssafy.web.global;

import java.util.Date;

public class TupleStorage {
    private String userId;
    private Date expireDate;

    public TupleStorage(String userId, Date expireDate) {
        this.userId = userId;
        this.expireDate = expireDate;
    }

    public String getUserId() {
        return userId;
    }

    public Date getExpireDate() {
        return expireDate;
    }

}
