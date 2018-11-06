package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Post {
    @Id
    @Column(name = "POSTID")
    private BigDecimal postid;

    @Column(name = "POSTTYPE")
    private String posttype;

    @Column(name = "POSTERID")
    private String posterid;

    @Column(name = "JUDGETAG")
    private Short judgetag;

    @Column(name = "POSTINGTIME")
    private Date postingtime;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "HITS")
    private BigDecimal hits;

    @Column(name = "LASTPOST")
    private Date lastpost;

    @Column(name = "POSTBODY")
    private String postbody;

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
     * @return POSTTYPE
     */
    public String getPosttype() {
        return posttype;
    }

    /**
     * @param posttype
     */
    public void setPosttype(String posttype) {
        this.posttype = posttype;
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
     * @return JUDGETAG
     */
    public Short getJudgetag() {
        return judgetag;
    }

    /**
     * @param judgetag
     */
    public void setJudgetag(Short judgetag) {
        this.judgetag = judgetag;
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
     * @return TITLE
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return HITS
     */
    public BigDecimal getHits() {
        return hits;
    }

    /**
     * @param hits
     */
    public void setHits(BigDecimal hits) {
        this.hits = hits;
    }

    /**
     * @return LASTPOST
     */
    public Date getLastpost() {
        return lastpost;
    }

    /**
     * @param lastpost
     */
    public void setLastpost(Date lastpost) {
        this.lastpost = lastpost;
    }

    /**
     * @return POSTBODY
     */
    public String getPostbody() {
        return postbody;
    }

    /**
     * @param postbody
     */
    public void setPostbody(String postbody) {
        this.postbody = postbody;
    }
}