/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResponseSearchFIlmVo
 * Author:   john
 * Date:     2019/4/23 12:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.stylefeng.guns.rest.persistence.model.vo.filmVo;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author john
 * @create 2019/4/23
 * @since 1.0.0
 */
@Data
public class ResponseSearchFIlmVo implements Serializable {
    private LinkedList<SearchFilmVo> searchFilmVos;
    private Integer nowPage;
    private Integer totalPage ;
}
