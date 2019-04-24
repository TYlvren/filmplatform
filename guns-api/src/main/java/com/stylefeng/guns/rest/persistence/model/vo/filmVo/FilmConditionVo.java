package com.stylefeng.guns.rest.persistence.model.vo.filmVo;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.CatDict;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.SourceDict;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.YearDict;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Flying Elephant
 * Date 2019/4/23 0023 Time 9:54
 */

public class FilmConditionVo implements Serializable {
    private List<CatDict> catDicts;
    private List<SourceDict> sourceDicts;
    private List<YearDict> yearDicts;

    public List<CatDict> getCatDicts() {
        return catDicts;
    }

    public void setCatDicts(List<CatDict> catDicts) {
        this.catDicts = catDicts;
    }

    public List<SourceDict> getSourceDicts() {
        return sourceDicts;
    }

    public void setSourceDicts(List<SourceDict> sourceDicts) {
        this.sourceDicts = sourceDicts;
    }

    public List<YearDict> getYearDicts() {
        return yearDicts;
    }

    public void setYearDicts(List<YearDict> yearDicts) {
        this.yearDicts = yearDicts;
    }

    @Override
    public String toString() {
        return "FilmConditionVo{" +
                "catDicts=" + catDicts +
                ", sourceDicts=" + sourceDicts +
                ", yearDicts=" + yearDicts +
                '}';
    }
}
