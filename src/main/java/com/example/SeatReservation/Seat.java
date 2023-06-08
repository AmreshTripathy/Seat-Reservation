package com.example.SeatReservation;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Amresh Tripathy
 */

@Getter
@Setter
public class Seat {
    private int seatNo;
    private int employeeId;
    private Date date;
    private boolean reserved;

    public Seat() {
    }

    public Seat(int seatNo, int employeeId, Date date, boolean reserved) {
        this.seatNo = seatNo;
        this.employeeId = employeeId;
        this.date = date;
        this.reserved = reserved;
    }
}
