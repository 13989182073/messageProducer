package com.luck.demo.service;

import com.luck.demo.entity.T_SYS_MENU;
import com.luck.demo.entity.ztree;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ztreeService {

    List<ztree> getAllData(ztree ztree);

    List<T_SYS_MENU> queryFjd();
}
