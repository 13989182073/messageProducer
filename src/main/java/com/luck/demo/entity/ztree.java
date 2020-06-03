package com.luck.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class ztree {
    private String id;
    private String pid;
    private String name;

    public List<ztree> getChildren() {
        return children;
    }

    public void setChildren(List<ztree> children) {
        this.children = children;
    }

    private List<ztree> children=new ArrayList<ztree>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
