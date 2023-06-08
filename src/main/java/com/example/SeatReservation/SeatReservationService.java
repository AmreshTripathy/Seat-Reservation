package com.example.SeatReservation;

import java.util.Date;

/**
 * @author Amresh Tripathy
 */
public class SeatReservationService {
    SeatReservationRepository seatReservationRepository = new SeatReservationRepository();


    public void addSeat(Seat seat) throws Exception {
        seatReservationRepository.addSeat(seat);
    }

    public void addEmployee(Employee employee) throws Exception {
        seatReservationRepository.addEmployee(employee);
    }

    public int findVacantSeats(Date date) {
        return seatReservationRepository.findVacantSeats(date);
    }

    public int findNumberOfEmployeesMoreThanFiveTimes() {
        return seatReservationRepository.findNumberOfEmployeesMoreThanFiveTimes();
    }

    public int findNumberOfEmployeesVisitedOnDate(Date date, Character team) {
        return seatReservationRepository.findNumberOfEmployeesVisitedOnDate(date, team);
    }
}
