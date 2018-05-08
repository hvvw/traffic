package com.huwang.traffic_portal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_load")
public class LoadEntity implements Serializable {

    private int id;
    private String name;
    private int techLevel;
    private int lane;
    private String pavementType;
    private int pavementWidth;
    private int subgradeWidth;
    private Date createTime;
    private boolean display;
    private double pointLat;
    private double pointLng;
    private int showLevel;
    private List<Point> points;

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Point.class)
    @JoinColumn(name = "id")
    public List<Point> getPoints() {
        return points;
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

    @Column(name="tech_level")
    public int getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }

    @Column(name="lane")
    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    @Column(name="pavement_type")
    public String getPavementType() {
        return pavementType;
    }

    public void setPavementType(String pavementType) {
        this.pavementType = pavementType;
    }

    @Column(name="pavement_width")
    public int getPavementWidth() {
        return pavementWidth;
    }

    public void setPavementWidth(int pavementWidth) {
        this.pavementWidth = pavementWidth;
    }

    @Column(name="subgrade_width")
    public int getSubgradeWidth() {
        return subgradeWidth;
    }

    public void setSubgradeWidth(int subgradeWidth) {
        this.subgradeWidth = subgradeWidth;
    }

    @Column(name="create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name="display")
    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    @Column(name="center_point_lat")
    public double getPointLat() {
        return pointLat;
    }

    public void setPointLat(double pointLat) {
        this.pointLat = pointLat;
    }

    @Column(name="center_point_lng")
    public double getPointLng() {
        return pointLng;
    }

    public void setPointLng(double pointLng) {
        this.pointLng = pointLng;
    }

    @Column(name="show_level")
    public int getShowLevel() {
        return showLevel;
    }

    public void setShowLevel(int showLevel) {
        this.showLevel = showLevel;
    }
}
