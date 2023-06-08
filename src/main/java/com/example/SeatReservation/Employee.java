package com.example.SeatReservation;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Amresh Tripathy
 */

@Getter
@Setter
public class Employee {
    private int employeeId;
    private char team;

    public Employee() {
    }

    public Employee(int employeeId, char team) {
        this.employeeId = employeeId;
        this.team = team;
    }
}
