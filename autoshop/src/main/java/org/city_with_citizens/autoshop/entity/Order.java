package org.city_with_citizens.autoshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "car_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private StatusOrderConfirm bankStatusOrderConfirm;

    @ManyToOne
    private StatusOrderConfirm policeStatusOrderConfirm;

    @ManyToOne
    private StatusOrder statusOrder;

    @Column(name = "price")
    private Integer price;

    @Column(name = "citizen_id")
    private UUID citizenId;

    @ManyToOne
    private Car car;

}
