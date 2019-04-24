package com.stylefeng.guns.rest.persistence.model.vo.filmVo;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.Actor;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.Director;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Flying Elephant
 * Date 2019/4/23 0023 Time 16:29
 */
@Data
public class ActorsVo implements Serializable {
    private Director director;
    private List<Actor> actors;
}
