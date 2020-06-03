package com.luck.demo.entity;

import javax.persistence.*;

public class T_DZ_MX {
    @Column(name = "ID")
    private String id;

    @Column(name = "FW_ID")
    private String fwId;

    @Column(name = "FW_NAME")
    private String fwName;

    @Column(name = "DZRY_GH")
    private String dzryGh;

    @Column(name = "DZRY_NAME")
    private String dzryName;

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
     * @return FW_ID
     */
    public String getFwId() {
        return fwId;
    }

    /**
     * @param fwId
     */
    public void setFwId(String fwId) {
        this.fwId = fwId == null ? null : fwId.trim();
    }

    /**
     * @return FW_NAME
     */
    public String getFwName() {
        return fwName;
    }

    /**
     * @param fwName
     */
    public void setFwName(String fwName) {
        this.fwName = fwName == null ? null : fwName.trim();
    }

    /**
     * @return DZRY_GH
     */
    public String getDzryGh() {
        return dzryGh;
    }

    /**
     * @param dzryGh
     */
    public void setDzryGh(String dzryGh) {
        this.dzryGh = dzryGh == null ? null : dzryGh.trim();
    }

    /**
     * @return DZRY_NAME
     */
    public String getDzryName() {
        return dzryName;
    }

    /**
     * @param dzryName
     */
    public void setDzryName(String dzryName) {
        this.dzryName = dzryName == null ? null : dzryName.trim();
    }
}