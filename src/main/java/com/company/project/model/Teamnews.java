package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Teamnews {
    @Id
    @Column(name = "NEWSID")
    private BigDecimal newsid;


    @Column(name = "TEAMID")
    private BigDecimal teamid;

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
     * @return TEAMID
     */
    public BigDecimal getTeamid() {
        return teamid;
    }

    /**
     * @param teamid
     */
    public void setTeamid(BigDecimal teamid) {
        this.teamid = teamid;
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