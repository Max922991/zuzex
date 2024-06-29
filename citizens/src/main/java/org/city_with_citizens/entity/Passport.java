package org.city_with_citizens.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private Citizen citizen;

    @Column(name = "address_flat_id")
    private UUID addressFlatId;

    @Column(name = "number")
    private String number;

    @Column(name = "series")
    private String series;

}
