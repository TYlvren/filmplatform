package com.stylefeng.guns.rest.persistence.model.bo.filmBo;


import java.io.Serializable;

public class SourceDict implements Serializable {

    private String sourceId;
    private String sourceName;
    private boolean isActive;

    @Override
    public String toString() {
        return "SourceDict{" +
                "sourceId='" + sourceId + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
