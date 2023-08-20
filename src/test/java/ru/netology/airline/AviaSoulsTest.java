package ru.netology.airline;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldCompareTicketsByPrise() {
        AviaSoulsManager manager = new AviaSoulsManager();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 12000, 12, 19);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Москва", 5000, 9, 10);
        Ticket ticket3 = new Ticket("Краснодар", "Калининград", 7000, 6, 9);
        Ticket ticket4 = new Ticket("Казань", "Анталия", 9000, 4, 8);
        Ticket ticket5 = new Ticket("Казань", "Анталия", 10000, 4, 8);
        Ticket ticket6 = new Ticket("Казань", "Анталия", 8000, 4, 8);
        Ticket ticket7 = new Ticket("Казань", "Анталия", 9700, 4, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("Казань", "Анталия");
        Ticket[] expected = {ticket6, ticket4, ticket7, ticket5};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldCompareNoTickets() {
        AviaSoulsManager manager = new AviaSoulsManager();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 12000, 12, 19);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Москва", 5000, 9, 10);
        Ticket ticket3 = new Ticket("Краснодар", "Калининград", 7000, 6, 9);
        Ticket ticket4 = new Ticket("Казань", "Анталия", 9000, 4, 8);
        Ticket ticket5 = new Ticket("Казань", "Анталия", 10000, 4, 8);
        Ticket ticket6 = new Ticket("Казань", "Анталия", 8000, 4, 8);
        Ticket ticket7 = new Ticket("Казань", "Анталия", 9700, 4, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("Рига", "Новосибирск");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldCompareOneTicket() {
        AviaSoulsManager manager = new AviaSoulsManager();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 12000, 12, 19);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Москва", 5000, 9, 10);
        Ticket ticket3 = new Ticket("Краснодар", "Калининград", 7000, 6, 9);
        Ticket ticket4 = new Ticket("Казань", "Анталия", 9000, 4, 8);
        Ticket ticket5 = new Ticket("Казань", "Анталия", 10000, 4, 8);
        Ticket ticket6 = new Ticket("Казань", "Анталия", 8000, 4, 8);
        Ticket ticket7 = new Ticket("Казань", "Анталия", 9700, 4, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("Москва", "Владивосток");
        Ticket[] expected = {ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareTicketTime1() {

        AviaSoulsManager manager = new AviaSoulsManager();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 12000, 12, 19);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Москва", 5000, 9, 10);
        Ticket ticket3 = new Ticket("Краснодар", "Калининград", 7000, 6, 9);
        Ticket ticket4 = new Ticket("Казань", "Анталия", 9000, 3, 8);//5
        Ticket ticket5 = new Ticket("Казань", "Анталия", 10000, 4, 5);//1
        Ticket ticket6 = new Ticket("Казань", "Анталия", 8000, 4, 10);//6
        Ticket ticket7 = new Ticket("Казань", "Анталия", 9700, 5, 8);//3

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("Казань", "Анталия", comparator);

        Ticket[] expected = {ticket5, ticket7, ticket4, ticket6};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldCompareTicketTime2() {

        AviaSoulsManager manager = new AviaSoulsManager();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 12000, 12, 19);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Москва", 5000, 9, 10);
        Ticket ticket3 = new Ticket("Краснодар", "Калининград", 7000, 6, 9);
        Ticket ticket4 = new Ticket("Казань", "Анталия", 9000, 3, 8);//5
        Ticket ticket5 = new Ticket("Казань", "Анталия", 10000, 4, 5);//1
        Ticket ticket6 = new Ticket("Казань", "Анталия", 8000, 4, 10);//6
        Ticket ticket7 = new Ticket("Казань", "Анталия", 9700, 5, 8);//3

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("Новосибирск", "Сочи", comparator);

        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareTicketTime3() {

        AviaSoulsManager manager = new AviaSoulsManager();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 12000, 12, 19);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Москва", 5000, 9, 10);
        Ticket ticket3 = new Ticket("Краснодар", "Калининград", 7000, 6, 9);
        Ticket ticket4 = new Ticket("Казань", "Анталия", 9000, 3, 8);//5
        Ticket ticket5 = new Ticket("Казань", "Анталия", 10000, 4, 5);//1
        Ticket ticket6 = new Ticket("Казань", "Анталия", 8000, 4, 10);//6
        Ticket ticket7 = new Ticket("Казань", "Анталия", 9700, 5, 8);//3

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("Краснодар", "Калининград", comparator);

        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }
}

