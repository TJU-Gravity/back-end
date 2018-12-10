package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Usernews {
    @Id
    @Column(name = "NEWSID")
    private BigDecimal newsid;


    @Column(name = "USERNAME")
    private String username;

    @Column(name = "ADDTIME")
    private Date addtime;

    /**
     * @return NEWSID
     */
    public BigDecimal getNewsid() {
        return newsid;
    }

    /**
     * @param newsid
     */
    public void setNewsid(BigDecimal newsid) {
        this.newsid = newsid;
    }

    /**
     * @return USERNAME
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return ADDTIME
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * @param addtime
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}