package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class News {
    @Id
    @Column(name = "NEWSID")
    private BigDecimal newsid;

    @Column(name = "TITLE")
    private String title;



    @Column(name = "EDITORID")
    private String editorid;

    @Column(name = "SPONSOR")
    private String sponsor;

    @Column(name = "REGISTRATIONSTARTDATE")
    private Date registrationstartdate;

    @Column(name = "REGISTRATIONENDDATE")
    private Date registrationenddate;

    @Column(name = "CONTESTSTARTDATE")
    private Date conteststartdate;

    @Column(name = "CONTESTENDDATE")
    private Date contestenddate;

    @Column(name = "POSTER")
    private String poster;

    @Column(name = "HITS")
    private BigDecimal hits;

    @Column(name = "NEWSBODY")
    private String newsbody;

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
     * @return EDITORID
     */
    public String getEditorid() {
        return editorid;
    }

    /**
     * @param editorid
     */
    public void setEditorid(String editorid) {
        this.editorid = editorid;
    }

    /**
     * @return SPONSOR
     */
    public String getSponsor() {
        return sponsor;
    }

    /**
     * @param sponsor
     */
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * @return REGISTRATIONSTARTDATE
     */
    public Date getRegistrationstartdate() {
        return registrationstartdate;
    }

    /**
     * @param registrationstartdate
     */
    public void setRegistrationstartdate(Date registrationstartdate) {
        this.registrationstartdate = registrationstartdate;
    }

    /**
     * @return REGISTRATIONENDDATE
     */
    public Date getRegistrationenddate() {
        return registrationenddate;
    }

    /**
     * @param registrationenddate
     */
    public void setRegistrationenddate(Date registrationenddate) {
        this.registrationenddate = registrationenddate;
    }

    /**
     * @return CONTESTSTARTDATE
     */
    public Date getConteststartdate() {
        return conteststartdate;
    }

    /**
     * @param conteststartdate
     */
    public void setConteststartdate(Date conteststartdate) {
        this.conteststartdate = conteststartdate;
    }

    /**
     * @return CONTESTENDDATE
     */
    public Date getContestenddate() {
        return contestenddate;
    }

    /**
     * @param contestenddate
     */
    public void setContestenddate(Date contestenddate) {
        this.contestenddate = contestenddate;
    }

    /**
     * @return POSTER
     */
    public String getPoster() {
        return poster;
    }

    /**
     * @param poster
     */
    public void setPoster(String poster) {
        this.poster = poster;
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
     * @return NEWSBODY
     */
    public String getNewsbody() {
        return newsbody;
    }

    /**
     * @param newsbody
     */
    public void setNewsbody(String newsbody) {
        this.newsbody = newsbody;
    }
}