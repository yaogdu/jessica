/*
 * Copyright 2013-2015 duolabao.com All right reserved. This software is the
 * confidential and proprietary information of duolabao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with duolabao.com.
 */
package org.jessica.me.web;

import org.jessica.me.main.App;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类JessicaController的实现描述：jessica controller
 *
 * @author yaoguang.du 2018/1/6 22:54
 */
@Controller
@RequestMapping("/jessica")
public class JessicaController {

    @Resource
    App app;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String jessica(HttpServletRequest request, HttpServletResponse response) {

        return "hello";
    }

}
