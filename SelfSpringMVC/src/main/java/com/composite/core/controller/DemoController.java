package com.composite.core.controller;

import com.composite.annotation.SelfController;
import com.composite.annotation.SelfRequestMapping;
import com.composite.annotation.SelfRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SelfController
@SelfRequestMapping
public class DemoController {

    @SelfRequestMapping("/doTest")
    public void test1(HttpServletRequest request, HttpServletResponse response, @SelfRequestParam("param") String param) {
        try {
            response.getWriter().write("test1 method success! param = " + param);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
