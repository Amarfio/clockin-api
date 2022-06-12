package com.example.clockinapi.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    //user details
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="firstName")
    private String firstname;

    @Column(name="otherName")
    private String othername;

    @Column(name="lastName")
    private String lastname;

    @Column(name="dateOfbirth")
    private String dateofbirth;

    @Column(name="gender")
    private String gender;

    @Column(name="groupName")
    private String groupname;

    @Column(name="residence")
    private String residence;

    @Column(name="occupation")
    private String occupation;

    @Column(name="contact")
    private String contact;

    @Column(name="email")
    private String email;

    @Column(name="position")
    private String position;

    @Column(name="department")
    private String department;

    @Column(name="postingDate")
    private String postingdate;

    @Column(name="postedBy")
    private String postedby;

    @Column(name="postingTerminal")
    private String postingterminal;

    @Column(name="postingIP")
    private String postingip;

    @Column(name="macAddress")
    private String macaddress;

    //default constructor
    public User(){

    }

    //value specifying constructor
    public User(String firstname, String othername, String lastname, String dateofbirth, String gender, String groupname, String residence, String occupation, String contact, String email, String position, String department, String postingdate, String postedby, String postingterminal, String postingip, String macaddress){
        this.setFirstname(firstname);
        this.setOthername(othername);
        this.setLastname(lastname);
        this.setDateofbirth(dateofbirth);
        this.setGender(gender);
        this.setGroupname(groupname);
        this.setResidence(residence);
        this.setOccupation(occupation);
        this.setContact(contact);
        this.setEmail(email);
        this.setPosition(position);
        this.setDepartment(department);
        this.setPostingdate(postingdate);
        this.setPostedby(postedby);
        this.setPostingterminal(postingterminal);
        this.setPostingip(postingip);
        this.setMacaddress(macaddress);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPostingdate() {
        return postingdate;
    }

    public void setPostingdate(String postingdate) {
        this.postingdate = postingdate;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    public String getPostingterminal() {
        return postingterminal;
    }

    public void setPostingterminal(String postingterminal) {
        this.postingterminal = postingterminal;
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

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
