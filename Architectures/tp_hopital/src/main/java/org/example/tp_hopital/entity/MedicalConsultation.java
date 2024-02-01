package org.example.tp_hopital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medical_consultation")
public class MedicalConsultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "doctor_name")
    private String doctorName;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToMany(mappedBy = "medicalConsultation", cascade = CascadeType.ALL)
    private List<MedicalPrescription> prescriptions = new ArrayList<>();
    @OneToMany(mappedBy = "medicalConsultation", cascade = CascadeType.ALL)
    private List<CareSheet> careSheets = new ArrayList<>();
}