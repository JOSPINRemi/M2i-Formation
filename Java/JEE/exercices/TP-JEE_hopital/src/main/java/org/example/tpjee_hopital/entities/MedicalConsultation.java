package org.example.tpjee_hopital.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "medical_consultation")
public class MedicalConsultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    @Column(name = "doctor_name")
    private String doctorName;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToMany(mappedBy = "medicalConsultation", cascade = CascadeType.ALL)
    private List<MedicalPrescription> prescriptions;
    @OneToMany(mappedBy = "medicalConsultation", cascade = CascadeType.ALL)
    private List<CareSheet> careSheets;
}
