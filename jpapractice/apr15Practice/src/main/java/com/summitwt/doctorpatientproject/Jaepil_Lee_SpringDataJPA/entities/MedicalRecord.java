package com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.entities;

import com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.entities.Doctors;
import com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.entities.Patients;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "medicalrecord")
@Table
public class MedicalRecord {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long entryID;
    @Column
    private Long patientID;
    @Column
    private LocalDateTime entryDateTime;
    @Column
    private Long doctorID;
    @Column
    private String specialty;
    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "patientid", insertable = false, updatable = false)
    private Patients myPatient;

    @ManyToOne
    @JoinColumn(name="doctorid", insertable = false, updatable = false)
    private Doctors myDoctor;

    public MedicalRecord() {
    }

    public Long getEntryID() {
        return entryID;
    }

    public void setEntryID(Long entryID) {
        this.entryID = entryID;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public Long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Long doctorID) {
        this.doctorID = doctorID;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "entryDateTime=" + entryDateTime +
                ", doctorID=" + doctorID +
                ", specialty='" + specialty + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}