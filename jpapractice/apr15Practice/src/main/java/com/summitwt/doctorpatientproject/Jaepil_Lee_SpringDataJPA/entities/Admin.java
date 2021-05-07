package com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.entities;

import javax.persistence.*;

@Entity(name = "admin")
public class Admin extends Users {

    public Admin() {
    }

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



}
