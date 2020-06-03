package com.luck.demo.controller;

import com.luck.demo.entity.T_DZ_MX;
import com.luck.demo.service.infoService;
import com.luck.demo.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/luck")
public class InfoController {

    @Resource
    private infoService infoService;


    @RequestMapping("/info")
    public CommonResult<List<T_DZ_MX>> info(T_DZ_MX t_dz_mx) {
        List<T_DZ_MX> info = infoService.info(t_dz_mx);

        if (info.isEmpty()) {
            return null;
        } else {
            return CommonResult.success(info);
        }


    }

}
