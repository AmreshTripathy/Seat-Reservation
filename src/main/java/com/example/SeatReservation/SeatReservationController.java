package com.example.SeatReservation;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Amresh Tripathy
 */

@RestController
public class SeatReservationController {
    SeatReservationService seatReservationService = new SeatReservationService();

    @PostMapping("/add-seat")
    public String addSeat(@RequestBody Seat seat) throws Exception {
        seatReservationService.addSeat(seat);
        return "Seat no " + seat.getSeatNo() + "added successfully";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@RequestBody Employee employee) throws Exception {
        seatReservationService.addEmployee(employee);
        return "Employee " + employee.getEmployeeId() + "added successfully";
    }

    @GetMapping("find-vacant-seats")
    public int findVacantSeats(@RequestParam Date date) {
        return seatReservationService.findVacantSeats(date);
    }

    @GetMapping("/employees-more-than-five-times")
    public int findNumberOfEmployeesMoreThanFiveTimes() {
        return seatReservationService.findNumberOfEmployeesMoreThanFiveTimes();
    }

    @GetMapping("/number-of-employees-visited-on-date")
    public int findNumberOfEmployeesVisitedOnDate(@RequestParam Date date, @RequestParam Character team) {
        return seatReservationService.findNumberOfEmployeesVisitedOnDate(date, team);
    }
}
