package com.wender.dev.orderServiceapi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wender.dev.orderServiceapi.entities.enums.OrderPriority;
import com.wender.dev.orderServiceapi.entities.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class OrderService implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataOpening;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dateClosing;

    private String description;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Integer priority;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "technical_id")
    private Technical technical;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public OrderService() {
        this.setDataOpening(LocalDateTime.now());
        this.setOrderPriority(OrderPriority.LOW);
        this.setOrderStatus(OrderStatus.OPEN);
    }

    public OrderService(Long id, String description,
                        OrderPriority priority, OrderStatus status, Technical technical, Client client) {
        this.id = id;
        this.setDataOpening(LocalDateTime.now());
        this.description = description;
        this.priority = (priority == null) ? 0 : priority.getCode();
        this.status = (status == null) ? 0 : status.getCode();
        this.technical = technical;
        this.client = client;
    }

    public OrderPriority getPriority() {
        return OrderPriority.toEnum(this.priority);
    }

    public void setOrderPriority(OrderPriority priority) {
        this.priority = priority.getCode();
    }

    public OrderStatus getStatus() {
        return OrderStatus.toEnum(this.status);
    }

    public void setOrderStatus(OrderStatus status) {
        this.status = status.getCode();
    }
}
