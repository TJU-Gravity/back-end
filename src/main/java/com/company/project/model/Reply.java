package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Reply {
    @Id
    @Column(name = "REPLYID")
    private BigDecimal replyid;

    @Column(name = "POSTID")
    private BigDecimal postid;

    @Column(name = "POSTERID")
    private String posterid;

    @Column(name = "POSTINGTIME")
    private Date postingtime;

    @Column(name = "REPLYBODY")
    private String replybody;

    /**
     * @return REPLYID
     */
    public BigDecimal getReplyid() {
        return replyid;
    }

    /**
     * @param replyid
     */
    public void setReplyid(BigDecimal replyid) {
        this.replyid = replyid;
    }

    /**
     * @return POSTID
     */
    public BigDecimal getPostid() {
        return postid;
    }

    /**
     * @param postid
     */
    public void setPostid(BigDecimal postid) {
        this.postid = postid;
    }

    /**
     * @return POSTERID
     */
    public String getPosterid() {
        return posterid;
    }

    /**
     * @param posterid
     */
    public void setPosterid(String posterid) {
        this.posterid = posterid;
    }

    /**
     * @return POSTINGTIME
     */
    public Date getPostingtime() {
        return postingtime;
    }

    /**
     * @param postingtime
     */
    public void setPostingtime(Date postingtime) {
        this.postingtime = postingtime;
    }

    /**
     * @return REPLYBODY
     */
    public String getReplybody() {
        return replybody;
    }

    /**
     * @param replybody
     */
    public void setReplybody(String replybody) {
        this.replybody = replybody;
    }
}