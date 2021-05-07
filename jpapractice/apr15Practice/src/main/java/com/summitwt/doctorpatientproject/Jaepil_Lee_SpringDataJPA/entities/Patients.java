package com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.entities;

import javax.persistence.*;
import java.util.*;

@Entity(name = "patients")
public class Patients extends Users {

    /*
    Have a list/set of appointments or ids(with queries) (collections)

     */

    public Patients() {
    }

    @OneToMany(targetEntity= Appointments.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<Appointments> apptList = new HashSet<>();

    @OneToMany(targetEntity= MedicalRecord.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<MedicalRecord> myRecord = new HashSet<>();

    public Long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public void setUsername(String u) {
        super.setUsername(u);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String p) {
        super.setPassword(p);
    }

    @Override
    public String getFirstname() {
        return super.getFirstname();
    }

    @Override
    public void setFirstname(String f) {
        super.setFirstname(f);
    }

    @Override
    public String getLastname() {
        return super.getLastname();
    }

    @Override
    public void setLastname(String l) {
        super.setLastname(l);
    }

    @Override
    public String toString() {
        return "\nPatient: " +
                "\nFirst Name: " + super.getFirstname() +
                "\nLast Name: " + super.getLastname() +
                "\n";
    }
}
