/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RequestOrder
 * Author:   john
 * Date:     2019/4/23 11:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.stylefeng.guns.rest.persistence.model.vo.filmVo;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author john
 * @create 2019/4/23
 * @since 1.0.0
 */
@Data
public class FilmRequestVo  implements Serializable {
    private Integer showType=1;
    private Integer sortId=1;
    private Integer catId=99;
    private Integer sourceId=99;
    private Integer yearId=99;
    private Integer nowPage=1;
    private Integer pageSize=18;
}
