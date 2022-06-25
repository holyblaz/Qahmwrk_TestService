package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestManager {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket first = new Ticket(1, 15000, "ARK", "SAD", 240);
    Ticket second = new Ticket(2, 11000, "ARK", "SAD", 330);
    Ticket third = new Ticket(3, 4300, "SAD", "ARK", 453);
    Ticket fourth = new Ticket(4, 15000, "LAN", "ARK", 210);
    Ticket fifth = new Ticket(5, 12000, "LAN", "ARK", 140);
    Ticket sixth = new Ticket(6, 15000, "LAN", "ARK", 1240);

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldShowAllAddTickets() {
        manager.getAll();
        assertArrayEquals(new Ticket[]{first, second, third, fourth, fifth, sixth}, manager.getAll());
    }

    @Test
    public void shouldRemoveIdTicket() {
        manager.removeById(5);
        assertArrayEquals(new Ticket[]{first, second, third, fourth, sixth}, manager.getAll());
    }

    @Test
    public void shouldShowSelectedAirTickets() {
        assertArrayEquals(new Ticket[]{fifth, fourth, sixth}, manager.findAll("LAN", "ARK"));
    }

    @Test
    public void shouldShowAirTicketsAndSort() {
        assertArrayEquals(new Ticket[]{second, first}, manager.findAll("ARK", "SAD"));
    }

    @Test
    public void shouldNotShowNothingBecauseEverythingFalse() {
        assertArrayEquals(new Ticket[]{}, manager.findAll("GGG", "ZZZ"));
    }

    @Test
    public void shouldNotShowNothingBecauseOneTrueSecondFalse() {
        assertArrayEquals(new Ticket[]{}, manager.findAll("ARK", "ZZZ"));
    }
    @Test
    public void shouldNotShowNothingBecauseOneFalseSecondTrue() {
        assertArrayEquals(new Ticket[]{}, manager.findAll("ZZZ", "SAD"));
    }
}