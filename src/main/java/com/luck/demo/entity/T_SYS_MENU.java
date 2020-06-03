package com.luck.demo.entity;

import javax.persistence.*;

public class T_SYS_MENU {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL")
    private String url;

    @Column(name = "TYPE")
    private Short type;

    @Column(name = "PID")
    private String pid;

    @Column(name = "SORT")
    private Short sort;

    @Column(name = "ICONCSS")
    private String iconcss;

    @Column(name = "STATUS")
    private Short status;

    @Column(name = "LOADMODE")
    private Short loadmode;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "FLAG")
    private String flag;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return TYPE
     */
    public Short getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * @return PID
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * @return SORT
     */
    public Short getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * @return ICONCSS
     */
    public String getIconcss() {
        return iconcss;
    }

    /**
     * @param iconcss
     */
    public void setIconcss(String iconcss) {
        this.iconcss = iconcss == null ? null : iconcss.trim();
    }

    /**
     * @return STATUS
     */
    public Short getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * @return LOADMODE
     */
    public Short getLoadmode() {
        return loadmode;
    }

    /**
     * @param loadmode
     */
    public void setLoadmode(Short loadmode) {
        this.loadmode = loadmode;
    }

    /**
     * @return VERSION
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * @return FLAG
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}