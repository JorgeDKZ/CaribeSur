package com.caribe.sur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caribe.sur.model.Ticket;
import com.caribe.sur.repository.TicketRepository;

@Service
public class TicketGestions {

    @Autowired
    private TicketRepository ticketRepository;

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public Ticket findTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    public List<Ticket> findTicketsByUserId(String userId) {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getPassenger().getUserName().equals(userId))
                .toList();
    }

     public List<Ticket> findTicketWithPlane(long planeId) {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getPlane().getId() == planeId)
                .toList();
     }
}
