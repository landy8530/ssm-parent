package com.landy.ssm.controller;

import com.landy.ssm.domain.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 访问URL：http://localhost:8888/[项目名称]/json/brands/landy's-shop
 * 注意：项目名称要看你配置idea是否有配置，未配置则不需要
 * Created by Landy on 2018/7/16.
 */
@Controller
@RequestMapping("/json/brands")
public class JSONController {
    //https://www.cnblogs.com/solverpeng/p/5821726.html
    @RequestMapping(value="{name}", method = RequestMethod.GET)
    @ResponseBody
    public Shop getShopInJSON(@PathVariable String name) {
        Shop shop = new Shop();
        shop.setName(name);
        shop.setStaffName(new String[]{"landy1", "landy2"});
        return shop;
    }

}
