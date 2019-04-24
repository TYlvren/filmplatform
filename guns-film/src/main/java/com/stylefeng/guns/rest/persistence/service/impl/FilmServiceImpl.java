package com.stylefeng.guns.rest.persistence.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.dao.*;
import com.stylefeng.guns.rest.persistence.model.MtimeFilmInfoT;
import com.stylefeng.guns.rest.persistence.model.MtimeFilmT;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.*;
import com.stylefeng.guns.rest.persistence.model.vo.filmVo.*;
import com.stylefeng.guns.rest.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Flying Elephant
 * Date 2019/4/23 0023 Time 11:30
 */
@Service(interfaceClass = FilmService.class)
@Component
public class FilmServiceImpl implements FilmService {

    @Autowired
    MtimeCatDictTMapper mtimeCatDictTMapper;
    @Autowired
    MtimeSourceDictTMapper mtimeSourceDictTMapper;
    @Autowired
    MtimeYearDictTMapper mtimeYearDictTMapper;
    @Autowired
    MtimeFilmTMapper mtimeFilmTMapper;
    @Autowired
    MtimeFilmInfoTMapper mtimeFilmInfoTMapper;
    @Autowired
    MtimeFilmActorTMapper mtimeFilmActorTMapper;
    @Override
    public FilmConditionVo selectFilmCondition(String catId, String sourceId, String yearId) {
        FilmConditionVo filmConditionVo = new FilmConditionVo();
        List<CatDict> cats = mtimeCatDictTMapper.getCats();
        for (CatDict cat : cats) {
            if (cat.getCatId().equals(catId)) {
                cat.setActive(true);
            }
        }
        List<SourceDict> sources = mtimeSourceDictTMapper.getSources();
        for (SourceDict source : sources) {
            if (source.getSourceId().equals(sourceId)) {
                source.setActive(true);
            }
        }
        List<YearDict> years = mtimeYearDictTMapper.getYears();
        for (YearDict year : years) {
            if (year.getYearId().equals(yearId)) {
                year.setActive(true);
            }
        }
        filmConditionVo.setCatDicts(cats);
        filmConditionVo.setSourceDicts(sources);
        filmConditionVo.setYearDicts(years);
        return filmConditionVo;
    }

    @Override
    public ResponseSearchFIlmVo searchFilmVoByMultibleCondition(FilmRequestVo filmRequestVo) throws Exception {
        ResponseSearchFIlmVo responseSearchFIlmVo = new ResponseSearchFIlmVo();
        LinkedList<SearchFilmVo> searchFilmVos = null;
        Integer limit = filmRequestVo.getPageSize();
        //1-按热门搜索 film_box_office   2-按时间搜索  film_time 3-按评价搜索   film_score
        searchFilmVos=mtimeFilmTMapper.searchFilmsOrderByMultibleCondition(filmRequestVo.getShowType(),filmRequestVo.getSortId(),filmRequestVo.getCatId(),filmRequestVo.getSourceId(),filmRequestVo.getYearId());

        int size = searchFilmVos.size();
        int totalpage=(size+limit)/limit;
        responseSearchFIlmVo.setNowPage(1);
        responseSearchFIlmVo.setTotalPage(totalpage);
        responseSearchFIlmVo.setSearchFilmVos(searchFilmVos);
        return responseSearchFIlmVo;
    }

    @Override
    public FilmDetailVo getFilmDetail(String searchType, String value) throws Exception {
        int searchtag = Integer.parseInt(searchType);
        FilmDetailVo filmDetailVo = new FilmDetailVo();
        MtimeFilmInfoT mfit=null;
        MtimeFilmT mft=null;
        if(searchtag==0){
             mfit= mtimeFilmInfoTMapper.selectbyFilmId(value);
             mft=mtimeFilmTMapper.searchByUUID(mfit.getUuid());
        }else if(searchtag==1){
             mft=mtimeFilmTMapper.searchByFilmName(value);
             mfit=mtimeFilmInfoTMapper.searchByUUID(mft.getUuid());
        }else{
            throw new Exception("数据格式不正确");
        }
        filmDetailVo.setFilmName(mft.getFilmName());
        filmDetailVo.setFilmEnName(mfit.getFilmEnName());
        filmDetailVo.setImgAddress(mft.getImgAddress());
        filmDetailVo.setScore(mft.getFilmScore());
        filmDetailVo.setScoreNum(mfit.getFilmScoreNum().toString()+"万人评分");
        filmDetailVo.setTotalBox(mft.getFilmBoxOffice()+"万");
        //设置分类字符串拼接
        String filmCats = mft.getFilmCats();
         filmCats = filmCats.substring(1, filmCats.length() - 1);
        String[] split = filmCats.split("#");
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<split.length;i++){
            stringBuffer.append(mtimeCatDictTMapper.searchById(split[i]));//查找分类表进行添加
            if(i!=split.length-1)stringBuffer.append(",");
        }
        String s1 = stringBuffer.toString();
        filmDetailVo.setInfo01(s1);
        //设置地区时长字符串拼接
        Integer filmArea = mft.getFilmArea();
         String area= mtimeSourceDictTMapper.searchAreaById(filmArea);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(area);
        stringBuffer2.append("/");
        stringBuffer2.append(mfit.getFilmLength()+"分钟");
        String s2 = stringBuffer2.toString();
        filmDetailVo.setInfo02(s2);
        //设置上映时间
        Date filmTime = mft.getFilmTime();
        String sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(filmTime);
        filmDetailVo.setInfo03(sdate+" "+area+"上映");
        InfoRequestVo infoRequestVo = new InfoRequestVo();
        infoRequestVo.setBiography(mfit.getBiography());
        ActorsVo actorsVo = new ActorsVo();
        actorsVo.setDirector(new Director("actors/02134.jpg","韩延"));
        LinkedList<Actor>  actorsList= mtimeFilmActorTMapper.searchByFilmId(mfit.getFilmId());
        actorsVo.setActors(actorsList);
        infoRequestVo.setActors(actorsVo);
        filmDetailVo.setInfo04(infoRequestVo);
        //设置图片
        String filmImgs = mfit.getFilmImgs();
        String[] s = filmImgs.split(",");
        FilmImgVo filmImgVo = new FilmImgVo();
        filmImgVo.setMainImg(mft.getImgAddress());
        filmImgVo.setImg01(s[0]);
        filmImgVo.setImg02(s[1]);
        filmImgVo.setImg03(s[2]);
        filmImgVo.setImg04(s[3]);
        filmDetailVo.setImgs(filmImgVo);
        filmDetailVo.setFilmId(mfit.getFilmId());
        return filmDetailVo;
    }
}
