package com.stylefeng.guns.common;

import com.stylefeng.guns.trade.utils.TradeUtils;
import org.junit.Test;

import java.io.File;

public class MainTest {



    @Test
    public void test1(){
        String parent = new File("").getAbsoluteFile().getParent();
        parent += File.separator + "nginx" + File.separator+
                "nginx-1.15.12" + File.separator +"qrCode";
        System.out.println(parent);
    }

    @Test
    public void getQRCode(){
        String qrCode = TradeUtils.getQRCode("20881002003044005013", 10);
        System.out.println(qrCode);
    }

    @Test
    public void isPay(){
        boolean pay = TradeUtils.isPay("20881002003044005013");
        System.out.println(pay);
    }
}
