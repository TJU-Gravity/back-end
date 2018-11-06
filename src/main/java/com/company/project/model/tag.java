package com.company.project.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "GTAG")
public class tag {
    @Id
    @Column(name = "TAGID")
    private BigDecimal tagid;

    @Column(name = "TAGDESCRIPTION")
    private String tagdescription;

    /**
     * @return TAGID
     */
    public BigDecimal getTagid() {
        return tagid;
    }

    /**
     * @param tagid
     */
    public void setTagid(BigDecimal tagid) {
        this.tagid = tagid;
    }

    /**
     * @return TAGDESCRIPTION
     */
    public String getTagdescription() {
        return tagdescription;
    }

    /**
     * @param tagdescription
     */
    public void setTagdescription(String tagdescription) {
        this.tagdescription = tagdescription;
    }
}