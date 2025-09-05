package com.caribe.sur.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.ModelAtributesVariables;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;
import com.caribe.sur.model.Ticket;
import com.caribe.sur.service.CheckUser;
import com.caribe.sur.service.TicketGestions;
import com.caribe.sur.service.UserGestions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserTicketsGestions {

    @Autowired
    CheckUser checkUser;
    @Autowired
    UserGestions users;
    @Autowired
    TicketGestions tickets;

    @GetMapping(UrlFromPages.URL_USER_SEE_TICKETS)
    public String showSeeTickets(Model model) {
        List<Ticket> tickets = users.findUserById(checkUser.getUserName()).getMyTickets();
        if (tickets.isEmpty()) {
            model.addAttribute(ModelAtributesVariables.TICKETS, null);
        } else {
            model.addAttribute(ModelAtributesVariables.TICKETS, tickets);
        }

        return HtmlFromPages.HTML_USER_TICKETS;
    }

    @PostMapping(UrlFromPages.URL_USER_POST_DELETE_TICKETS)
    public String deleteTicket(@RequestParam long ticketId) {
        Ticket ticket = tickets.findTicketById(ticketId);
        ticket.deleteTicket();
        tickets.deleteTicket(ticket.getId());


        return UrlFromPages.toRedirect(UrlFromPages.URL_USER_SEE_TICKETS);
    }

}
