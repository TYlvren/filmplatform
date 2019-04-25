/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FileUtils
 * Author:   john
 * Date:     2019/4/24 23:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.stylefeng.guns.rest.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author john
 * @create 2019/4/24
 * @since 1.0.0
 */
public class FileUtils {


        public String ReadFile(String Path) {
            BufferedReader reader = null;
            String laststr = "";
            try {
                FileInputStream fileInputStream = new FileInputStream(Path);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
                reader = new BufferedReader(inputStreamReader);
                String tempString = null;
                while ((tempString = reader.readLine()) != null) {
                    laststr += tempString;
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return laststr;
        }

}
