package com.luck.demo.service.impl;

import com.luck.demo.entity.T_DZ_MX;
import com.luck.demo.mapper.T_DZ_MXMapper;
import com.luck.demo.service.infoService;
import com.luck.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class infoServiceImpl implements infoService {

    @Autowired
    private T_DZ_MXMapper t_dz_mxMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<T_DZ_MX> info(T_DZ_MX t_dz_mx) {

//        先从redis中判断信息是否存在
        List<Object> list = redisUtil.lGet("info", 0, -1);
        if (list.isEmpty()) {
//            没有，查询数据库
            List<T_DZ_MX> info = t_dz_mxMapper.info(t_dz_mx);
            if (info.isEmpty()) {
                redisUtil.lSet("info", "");
                redisUtil.expire("info", 10);
            } else {
                redisUtil.lSet("info", info);
                redisUtil.expire("info", 100);
            }
            return info;
        } else {
//            取缓存中的数据
            List<T_DZ_MX> redisInfo = (List<T_DZ_MX>) list.get(0);
            return redisInfo;

        }
    }
}
