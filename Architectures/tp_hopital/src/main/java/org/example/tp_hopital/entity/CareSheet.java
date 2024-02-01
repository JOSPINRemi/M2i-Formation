package org.example.tp_hopital.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "care_sheet")
public class CareSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private CareType type;
    private int duration;
    @ManyToOne
    @JoinColumn(name = "medical_consultation_id")
    private MedicalConsultation medicalConsultation;
}