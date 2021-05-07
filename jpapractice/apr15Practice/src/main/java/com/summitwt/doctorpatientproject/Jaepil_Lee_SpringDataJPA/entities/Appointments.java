package com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.entities;

import com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.entities.Doctors;
import com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.entities.Patients;

import javax.persistence.*;
import java.time.LocalDateTime;
import static com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.ConsoleColorSettings.*;

@Entity(name = "appointments")
@Table
public class Appointments {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="patientid", insertable = false, updatable = false)
    private Patients myPatient;

    @ManyToOne
    @JoinColumn(name="doctorid", insertable = false, updatable = false)
    private Doctors myDoctor;

    @Column(name="patientid")
    private Long patientID;

    @Column(name="doctorid")
    private Long doctorID;

    @Column(name="apptStatus")
    private String apptStatus = "UPCOMING";
    //CAN BE "UPCOMING", "COMPLETE"

    @Column
    private LocalDateTime apptDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public Long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Long doctorID) {
        this.doctorID = doctorID;
    }

    public String getApptStatus() {
        return apptStatus;
    }

    public void setApptStatus(String apptStatus) {
        this.apptStatus = apptStatus;
    }

    public LocalDateTime getApptDateTime() {
        return apptDateTime;
    }

    public void setApptDateTime(LocalDateTime apptDateTime) {
        this.apptDateTime = apptDateTime;
    }

    @Override
    public String toString() {
        String statusColor = (apptStatus == "COMPLETE") ? CC_WHITE : CC_YELLOW;

        return (statusColor + "\nRequests{" +
                "\nID: " + id +
                ",\n patientID: " + patientID +
                ",\n doctorID=" + doctorID +
                ",\n Apppointment Status: '" + apptStatus + '\'' +
                ",\n apptDateTime: " + apptDateTime +
                "\n}" + CC_WHITE);
    }
}
