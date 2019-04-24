package com.stylefeng.guns.rest.persistence.model.vo.filmVo;

import java.io.Serializable;

/**
 * Created by Flying Elephant
 * Date 2019/4/23 0023 Time 16:22
 */
public class InfoRequestVo implements Serializable {
    private String biography;
    private ActorsVo actors;

    @Override
    public String toString() {
        return "InfoRequestVo{" +
                "biography='" + biography + '\'' +
                ", actors=" + actors +
                '}';
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public ActorsVo getActors() {
        return actors;
    }

    public void setActors(ActorsVo actors) {
        this.actors = actors;
    }
}
