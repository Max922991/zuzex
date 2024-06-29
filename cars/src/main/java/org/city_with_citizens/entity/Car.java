package org.city_with_citizens.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "citizen_id")
    private UUID citizenId;

    @Column(name = "number_car")
    private String numberCar;

    @ManyToOne
    private CarMark carMark;

}
