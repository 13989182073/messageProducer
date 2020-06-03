package com.luck.demo.service;

import com.luck.demo.entity.T_DZ_MX;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface infoService {
    List<T_DZ_MX> info(T_DZ_MX t_dz_mx);
}
