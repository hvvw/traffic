package com.huwang.traffic_portal.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="t_maintenance")
public class MaintenanceEntity implements Serializable {

    private int id;
    private double centerPointLat;
    private double centerPointLng;
    private int loadId;
    private String situation;
    private String disease;
    private String plantVariety;
    private double afforestedArea;
    private boolean display;


    @Id
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="center_point_lat")
    public double getCenterPointLat() {
        return centerPointLat;
    }

    public void setCenterPointLat(double centerPointLat) {
        this.centerPointLat = centerPointLat;
    }

    @Column(name="center_point_lng")
    public double getCenterPointLng() {
        return centerPointLng;
    }

    public void setCenterPointLng(double centerPointLng) {
        this.centerPointLng = centerPointLng;
    }

    @Column(name="load_id")
    public int getLoadId() {
        return loadId;
    }

    public void setLoadId(int loadId) {
        this.loadId = loadId;
    }

    @Column(name="situation")
    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    @Column(name="disease")
    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Column(name="plant_variety")
    public String getPlantVariety() {
        return plantVariety;
    }

    public void setPlantVariety(String plantVariety) {
        this.plantVariety = plantVariety;
    }

    @Column(name="afforested_area")
    public double getAfforestedArea() {
        return afforestedArea;
    }

    public void setAfforestedArea(double afforestedArea) {
        this.afforestedArea = afforestedArea;
    }

    @Column(name="display")
    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }
}
