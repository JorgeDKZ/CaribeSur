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
import com.caribe.sur.service.UserGestions;

@Controller
public class UserTicketsGestions {

    @Autowired
    CheckUser checkUser;
    @Autowired
    UserGestions users;

    @GetMapping(UrlFromPages.URL_USER_SEE_TICKETS)
    public String getMethodName(Model model) {
        List<Ticket> tickets = users.findUserById(checkUser.getUserName()).getMyTickets();
        if (tickets.size() == 0) {
            model.addAttribute(ModelAtributesVariables.TICKETS, null);
        } else {
            model.addAttribute(ModelAtributesVariables.TICKETS, tickets);
        }

        return HtmlFromPages.HTML_USER_TICKETS;
    }

}
