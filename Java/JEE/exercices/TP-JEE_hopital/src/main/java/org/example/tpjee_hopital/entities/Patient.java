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
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "last_name",length = 50)
    private String lastName;
    @Column(name = "first_name",length = 50)
    private String firstName;
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] profilePicture;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalConsultation> consultations;
}
