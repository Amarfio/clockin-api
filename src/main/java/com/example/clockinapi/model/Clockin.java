package com.example.clockinapi.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="clockins")
public class Clockin {

    //clockin details
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="userid")
    private String userid;

    @Column(name="firstname")
    private String firstname;

    @Column(name="othername")
    private String othername;

    @Column(name="lastname")
    private String lastname;

    @Column(name="groupname")
    private String groupname;

    @Column(name="date")
    private Date date;

    @Column(name="checkintime")
    private LocalTime checkintime;

    @Column(name="checkouttime")
    private LocalTime checkouttime;

    @Column(name="postingip")
    private String postingip;

    @Column(name="macaddress")
    private String macaddress;

    @Column(name="created_at")
    private Date created_at;

    @Column(name="update_at")
    private Date updated_at;

    public Clockin(){

    }

    //constructor to check in user
    public Clockin(String userid, String firstname, String othername, String lastname, String groupname, Date date, LocalTime checkintime, String postingip, String macaddress){
            this.setUserid(userid);
            this.setFirstname(firstname);
            this.setOthername(othername);
            this.setLastname(lastname);
            this.setGroupname(groupname);
            this.setDate(date);
            this.setCheckintime(checkintime);
            this.setPostingip(postingip);
            this.setMacaddress(macaddress);
            this.setCreated_at(new Date());
    }

    //constructor to check out user
    public Clockin(LocalTime checkouttime){
        this.setCheckouttime(checkouttime);
        this.setUpdated_at(new Date());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(LocalTime checkintime) {
        this.checkintime = checkintime;
    }

    public LocalTime getCheckouttime() {
        return checkouttime;
    }

    public void setCheckouttime(LocalTime checkouttime) {
        this.checkouttime = checkouttime;
    }

    public String getPostingip() {
        return postingip;
    }

    public void setPostingip(String postingip) {
        this.postingip = postingip;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
