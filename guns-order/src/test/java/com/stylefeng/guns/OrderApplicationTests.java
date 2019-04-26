package com.stylefeng.guns;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stylefeng.guns.rest.OrderApplication;
import com.stylefeng.guns.rest.persistence.model.bo.orderBo.SeatBo;
import com.stylefeng.guns.rest.persistence.model.bo.orderBo.SeatJsonBo;
import com.stylefeng.guns.rest.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class OrderApplicationTests {

	@Test
	public void Order() {

			String JsonContext = new FileUtils().ReadFile("D:\\王道\\课件\\Project4\\接口文档\\订单模块接口文档\\cgs.json");
			//将读取的数据转换为JSONObject
		JSONObject jsonObject1 = JSON.parseObject(JsonContext);
		String ids =(String) jsonObject1.get("ids");
		String[] split = ids.split(",");
		for (String s : split) {
			if(s.equals("2")) System.out.println("true");
		}
			System.out.println(jsonObject1.toString());
	}

}
