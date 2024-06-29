package org.city_with_citizens.police.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "license")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "driver_id")
    private UUID driverId;

    @Column(name = "license_start")
    private LocalDate licenseStart;

    @Column(name = "license_end")
    private LocalDate licenseEnd;

}
