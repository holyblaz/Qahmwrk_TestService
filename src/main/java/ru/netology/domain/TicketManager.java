package ru.netology.domain;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }

    public Ticket[] getAll() {
        return repository.findAll();
    }

    public Ticket[] findAll(String departureAirport, String arrivalAirport, Comparator<Ticket> comparator) {

        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.departureAirport == departureAirport && ticket.arrivalAirport == arrivalAirport) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        Arrays.sort(result, comparator);
        System.out.println(Arrays.toString(result));
        return result;
    }
}