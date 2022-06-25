package ru.netology.domain;

public class TicketRepository {
    private Ticket[] tick = new Ticket[0];

    public void save(Ticket ticket) {
        int length = tick.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tick, 0, tmp, 0, tick.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tick = tmp;
    }

    public Ticket[] findAll() {
        return tick;
    }

    public void deleteById(int id) {

        Ticket[] tmp = new Ticket[tick.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tick) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tick = tmp;
    }
}