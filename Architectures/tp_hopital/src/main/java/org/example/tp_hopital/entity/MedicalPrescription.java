package org.example.tp_hopital.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medical_prescription")
public class MedicalPrescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private MedicamentType type;
    private int duration;
    @ManyToOne
    @JoinColumn(name = "medical_consultation_id")
    private MedicalConsultation medicalConsultation;
}