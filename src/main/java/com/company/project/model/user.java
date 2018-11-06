package com.company.project.model;

import javax.persistence.*;

@Table(name = "GUSER")
public class user {
    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "PWD")
    private String pwd;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "HEADSHOT")
    private String headshot;

    @Column(name = "LOC")
    private String loc;

    @Column(name = "PHONENUMBER")
    private String phonenumber;

    @Column(name = "INTRODUCTION")
    private String introduction;

    @Column(name = "USERPRIVILEGES")
    private Short userprivileges;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "STATUS")
    private Short status;

    @Column(name = "TAGS")
    private Object tags;

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
     * @return NICKNAME
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return PWD
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return GENDER
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return HEADSHOT
     */
    public String getHeadshot() {
        return headshot;
    }

    /**
     * @param headshot
     */
    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    /**
     * @return LOC
     */
    public String getLoc() {
        return loc;
    }

    /**
     * @param loc
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }

    /**
     * @return PHONENUMBER
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * @return INTRODUCTION
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * @return USERPRIVILEGES
     */
    public Short getUserprivileges() {
        return userprivileges;
    }

    /**
     * @param userprivileges
     */
    public void setUserprivileges(Short userprivileges) {
        this.userprivileges = userprivileges;
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return STATUS
     */
    public Short getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * @return TAGS
     */
    public Object getTags() {
        return tags;
    }

    /**
     * @param tags
     */
    public void setTags(Object tags) {
        this.tags = tags;
    }
}