package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String departureAirport;
    protected String arrivalAirport;
    protected int travelTime;

    @Override
    public int compareTo(Ticket otherTicket) {
        if (price < otherTicket.price) {
            return -1;
        }
        if (price > otherTicket.price) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && travelTime == ticket.travelTime && departureAirport.equals(ticket.departureAirport) && arrivalAirport.equals(ticket.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departureAirport, arrivalAirport, travelTime);
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", travelTime=" + travelTime +
                '}';
    }
}