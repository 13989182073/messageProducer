package com.luck.demo.mapper;

import com.luck.demo.entity.T_DZ_MX;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface T_DZ_MXMapper extends Mapper<T_DZ_MX> {
    List<T_DZ_MX> info(T_DZ_MX t_dz_mx);
}