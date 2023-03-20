package br.org.sesisc.sim.backend.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "signal_results")
public class SignalResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name="comorbidities")
    private boolean comorbidities;

    @Column(name = "hrv_lfhf")
    private double hrv_lfhf;

    @Column(name = "hrv_lnhf")
    private double hrv_lnhf;

    @Column(name="bpm")
    private int bpm;

    @Column(name="gender_id")
    private int gender_id;

    @Column(name="age_group_id")
    private int age_group_id;

    //EXTRA RESULTS, ADDED LATER

    @Column(name = "hf")
    private double hf;

    @Column(name = "lf")
    private double lf;

    @Column(name = "sd1")
    private double sd1;

    @Column(name = "sd2")
    private double sd2;

    @Column(name = "sd1_sd2")
    private double sd1_sd2;


    public SignalResults() {
        // Default Constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isComorbidities() {
        return comorbidities;
    }

    public void setComorbidities(boolean comorbidities) {
        this.comorbidities = comorbidities;
    }

    public double getHrv_lfhf() {
        return hrv_lfhf;
    }

    public void setHrv_lfhf(double hrv_lfhf) {
        this.hrv_lfhf = hrv_lfhf;
    }

    public double getHrv_lnhf() {
        return hrv_lnhf;
    }

    public void setHrv_lnhf(double hrv_lnhf) {
        this.hrv_lnhf = hrv_lnhf;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public int getGender_id() {
        return gender_id;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
    }

    public int getAge_group_id() {
        return age_group_id;
    }

    public void setAge_group_id(int age_group_id) {
        this.age_group_id = age_group_id;
    }

    public double getHf() {
        return hf;
    }

    public void setHf(double hf) {
        this.hf = hf;
    }

    public double getLf() {
        return lf;
    }

    public void setLf(double lf) {
        this.lf = lf;
    }

    public double getSd1() {
        return sd1;
    }

    public void setSd1(double sd1) {
        this.sd1 = sd1;
    }

    public double getSd2() {
        return sd2;
    }

    public void setSd2(double sd2) {
        this.sd2 = sd2;
    }

    public double getSd1_sd2() {
        return sd1_sd2;
    }

    public void setSd1_sd2(double sd1_sd2) {
        this.sd1_sd2 = sd1_sd2;
    }

    

}