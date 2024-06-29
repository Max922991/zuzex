package org.city_with_citizens.autoshop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.city_with_citizens.enums.StatusOrderConfirmType;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "status_order_confirm")
public class StatusOrderConfirm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private StatusOrderConfirmType type;

}
