package com.wechat.msgdemo.util;

import org.springframework.web.servlet.ModelAndView;

/**
*@Author: ZhangZhe
*@Description
*@Date: 2018/1/15
*/

public class CreateView {

    public static ModelAndView createView(String msg, String viewName) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", msg);
        mv.setViewName(viewName);
        return mv;
    }
}
