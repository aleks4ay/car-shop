package ua.aser.carshop.model;

import java.time.LocalDateTime;

public class Status {
    private final StatusName statusName;
    private final LocalDateTime dateTime;

    public enum StatusName {
        ORDER_NEW,
        ORDER_REGISTERED,
        ORDER_PAID,
        ORDER_COMPLETED,  //when good shipped
        ORDER_CANCELLED
    }

    public Status(StatusName statusName) {
        this.statusName = statusName;
        this.dateTime = LocalDateTime.now();
    }

    public StatusName getStatusName() {
        return statusName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}