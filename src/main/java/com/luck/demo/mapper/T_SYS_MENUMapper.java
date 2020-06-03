package com.luck.demo.mapper;

import com.luck.demo.entity.T_SYS_MENU;
import com.luck.demo.entity.ztree;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;

public interface T_SYS_MENUMapper extends Mapper<T_SYS_MENU> {
    List<ztree> getAllData(ztree ztree);

    List<T_SYS_MENU> queryFjd();
}