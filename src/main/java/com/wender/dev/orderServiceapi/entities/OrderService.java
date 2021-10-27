package com.wender.dev.orderServiceapi.entities;

import com.wender.dev.orderServiceapi.entities.enums.OrderPriority;
import com.wender.dev.orderServiceapi.entities.enums.OrderStatus;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderService implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;
    private LocalDateTime dataOpening;
    private LocalDateTime dateClosing;
    private String comments;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Integer priority;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Integer status;

    private Technical technical;
    private Client client;

    public OrderService() {
        this.setDataOpening(LocalDateTime.now());
        this.setOrderPriority(OrderPriority.LOW);
        this.setOrderStatus(OrderStatus.OPEN);
    }

    public OrderService(Long id, LocalDateTime dataOpening, String comments,
                        OrderPriority priority, OrderStatus status, Technical technical, Client client) {
        this.id = id;
        this.setDataOpening(LocalDateTime.now());
        this.comments = comments;
        this.priority = (priority == null) ? 0 : priority.getCode();
        this.status = (priority == null) ? 0 : priority.getCode();
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
