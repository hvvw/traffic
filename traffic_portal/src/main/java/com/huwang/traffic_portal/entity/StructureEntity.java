package com.huwang.traffic_portal.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="t_structure")
public class StructureEntity implements Serializable {

    private int id;
    private String name;
    private double lat;
    private double lng;
    private String type;
    private String desc;
    private Date createDate;
    private int loadId;
    private boolean display;
    private int showLevel;

    @Column(name="show_level")
    public int getShowLevel() {
        return showLevel;
    }

    public void setShowLevel(int showLevel) {
        this.showLevel = showLevel;
    }

    @Id
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="lat")
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Column(name="lng")
    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Column(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Column(name="create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name="load_id")
    public int getLoadId() {
        return loadId;
    }

    public void setLoadId(int loadId) {
        this.loadId = loadId;
    }

    @Column(name="display")
    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }
}
