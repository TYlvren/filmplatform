/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SeatJsonBo
 * Author:   john
 * Date:     2019/4/24 23:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.stylefeng.guns.rest.persistence.model.bo.orderBo;

import lombok.Data;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author john
 * @create 2019/4/24
 * @since 1.0.0
 */
@Data
public class SeatBo {
    private int seatId;
    private int row;
    private int column;
}
