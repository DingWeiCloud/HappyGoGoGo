package com.happy.controller;

import com.happy.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: HiController
 * @package: com.happy.controller
 * @author: DingWei
 * @date: 2019/12/8 15:32
 */
@RestController
public class HiController {
    @Autowired
    SchedualServiceHi schedualServiceHi;
    @GetMapping(value = "/hi")
    public  String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne( name );
    }
}
