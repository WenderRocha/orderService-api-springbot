package com.wender.dev.orderServiceapi.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    OPEN(0, "OPEN"),
    PROGRESS(1, "PROGRESS"),
    CLOSED(2, "CLOSED");

    private Integer code;
    private String description;

    public static  OrderStatus toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (OrderStatus x : OrderStatus.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Status invalid! " + code);
    }
}
