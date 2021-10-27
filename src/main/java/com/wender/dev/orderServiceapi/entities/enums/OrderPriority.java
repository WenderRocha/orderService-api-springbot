package com.wender.dev.orderServiceapi.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderPriority {

    LOW(0, "LOW"),
    MEDIUM(1, "MEDIUM"),
    HIGHT(2, "HIGHT");

    private Integer code;
    private String description;

    public static OrderPriority toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (OrderPriority x : OrderPriority.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Priority inválid! " + code);
    }

}
