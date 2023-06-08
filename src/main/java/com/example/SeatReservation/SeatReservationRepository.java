package com.example.SeatReservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Amresh Tripathy
 */
public class SeatReservationRepository {
    private List<Seat> seats;
    private HashMap<Date, List<Seat>> dateSeatMap;
    private List<Employee> employees;
    private HashMap<Character, List<Employee>> teamEmployeeMap;
    private HashMap<Employee, Integer> employeeCountMap;

    public SeatReservationRepository() {
        this.seats = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.dateSeatMap = new HashMap<>();
        this.teamEmployeeMap = new HashMap<>();
        this.employeeCountMap = new HashMap<>();
    }

    public void addSeat(Seat seat) throws Exception {
        List<Seat> allSeats = dateSeatMap.getOrDefault(seat.getDate(), new ArrayList<>());
        if (allSeats.size() > 50)
            throw new Exception("all seats are booked");

        for (Seat seat1 : allSeats) {
            if (seat1.getSeatNo() == seat.getSeatNo()) {
                throw new Exception("this seat no. is already booked");
            }
        }
        seat.setReserved(true);
        allSeats.add(seat);
        seats.add(seat);
    }

    public void addEmployee(Employee employee) throws Exception {
        employees.add(employee);
        List<Employee> allEmployee = teamEmployeeMap.getOrDefault(employee.getTeam(), new ArrayList<>());
        if (!allEmployee.contains(employee)) {
            allEmployee.add(employee);
        }
        teamEmployeeMap.put(employee.getTeam(), allEmployee);
        employeeCountMap.put(employee, employeeCountMap.getOrDefault(employee, 0) + 1);
    }

    public int findVacantSeats(Date date) {
        return (dateSeatMap.containsKey(date)) ? 50 - dateSeatMap.get(date).size() : 50;
    }


    public int findNumberOfEmployeesMoreThanFiveTimes() {
        int count = 0;
        for (int tempCount : employeeCountMap.values()) {
            if (tempCount > 5)
                count++;
        }
        return count;
    }

    public int findNumberOfEmployeesVisitedOnDate(Date date, Character team) {
        int count = 0;
        List<Employee> allEmployees = teamEmployeeMap.get(team);
        for (Employee employee : teamEmployeeMap.get(team)) {
            for (Seat seat : dateSeatMap.get(date)) {
                if (seat.getEmployeeId() == employee.getEmployeeId())
                    count++;
            }
        }
        return count;
    }
}
