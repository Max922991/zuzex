package org.city_with_citizens.autoshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "model")
    private String model;

    @Column(name = "mark")
    private String mark;

    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;

    @Column(name = "price")
    private Integer price;

}
