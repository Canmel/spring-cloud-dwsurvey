package com.camel.getway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.ModelAndView;

/**
 * 　　　　　　　 ┏┓　　　┏┓
 * 　　　　　　　┏┛┻━━━━━┛┻┓
 * 　　　　　　　┃         ┃ 　  站点控制器
 * 　　　　　　　┃    ━    ┃
 * 　　　　　　　┃  >   <  ┃
 * 　　　　　　　┃         ┃
 * 　　　　　　　┃... ⌒ ...┃
 * 　　　　　　　┃         ┃
 *             ┗━┓     ┏━┛
 *               ┃     ┃　Code is far away from bug with the animal protecting　　　　　　　　　　
 *               ┃     ┃   神兽保佑,代码无bug
 *               ┃     ┃　　　　　　　　　　　
 *               ┃     ┃  　　　　　　
 *               ┃     ┃
 *               ┃     ┃　　　　　　　　　　　
 *               ┃     ┗━━━━┓
 *               ┃          ┣┓
 *               ┃          ┏┛
 *               ┗┓┓┏━━━━┳┓┏┛
 *                ┃┫┫    ┃┫┫
 *                ┗┻┛    ┗┻┛
 */
@RestController
public class CloudSiteController {

    @Autowired
    private RestOperations restOperations;

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello From Auth-Client!";
    }

    @GetMapping("/personInfo")
    public ModelAndView person() {
        ModelAndView mav = new ModelAndView("personinfo");
        String personResourceUrl = "http://localhost:9000/person";
        mav.addObject("person", restOperations.getForObject(personResourceUrl, String.class));
        return mav;
    }

}
