package com.stylefeng.guns.rest.persistence.model.bo.filmBo;


import java.io.Serializable;

public class FilmActor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uuid;

    private Integer filmId;

    private Integer actorId;

    private String roleName;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Override
    public String toString() {
        return "FilmActor{" +
        "uuid=" + uuid +
        ", filmId=" + filmId +
        ", actorId=" + actorId +
        ", roleName=" + roleName +
        "}";
    }
}
