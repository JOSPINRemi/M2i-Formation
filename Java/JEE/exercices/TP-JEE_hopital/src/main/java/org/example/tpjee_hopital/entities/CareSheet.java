package org.example.tpjee_hopital.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "care_sheet")
public class CareSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CareType type;
    private Integer duration;
    @ManyToOne
    @JoinColumn(name = "medical_consultation_id")
    private MedicalConsultation medicalConsultation;
}
