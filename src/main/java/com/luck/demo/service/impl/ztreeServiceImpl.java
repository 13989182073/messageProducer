package com.luck.demo.service.impl;

import com.luck.demo.entity.T_SYS_MENU;
import com.luck.demo.entity.ztree;
import com.luck.demo.mapper.T_SYS_MENUMapper;
import com.luck.demo.service.ztreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ztreeServiceImpl implements ztreeService {

    @Autowired
    private T_SYS_MENUMapper t_sys_menuMapper;

    @Override
    public List<ztree> getAllData(ztree ztree) {
        return t_sys_menuMapper.getAllData(ztree);
    }

    @Override
    public List<T_SYS_MENU> queryFjd() {
        return t_sys_menuMapper.queryFjd();
    }


}
