package com.caribe.sur.controller.admin.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.caribe.sur.enumerators.listFromClass.HtmlFromPages;
import com.caribe.sur.enumerators.listFromClass.ModelAtributesVariables;
import com.caribe.sur.enumerators.listFromClass.UrlFromPages;
import com.caribe.sur.model.Plane;
import com.caribe.sur.model.Ticket;
import com.caribe.sur.model.User;
import com.caribe.sur.service.PlaneGestions;
import com.caribe.sur.service.TicketGestions;
import com.caribe.sur.service.UserGestions;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminPlaneGestions {
    @Autowired
    PlaneGestions planeGestions;
    @Autowired
    TicketGestions ticketGestions;
    @Autowired
    UserGestions userGestions;

    @GetMapping(UrlFromPages.URL_ADMIN_PLANES_NEW_PLANES)
    public String getNewPlanes() {

        return HtmlFromPages.HTML_ADMIN_NEW_PLANE_GESTIONS;
    }

    @GetMapping(UrlFromPages.URL_ADMIN_PLANES_INFORMATION_PLANES)
    public String getGestionOfPlanes(Model model) {

        List<Plane> planes = planeGestions.getAllPlanes();
        model.addAttribute(ModelAtributesVariables.PLANE, planes);
        return HtmlFromPages.HTML_ADMIN_PLANE_GESTIONS;
    }

    @PostMapping(UrlFromPages.URL_POST_MOVE_TO_ADMIN_VIEW_INFORMATION_PLANE)
    public String postViewInformationPlanes(Model model, @RequestParam long id) {

        List<Ticket> tickets = ticketGestions.findTicketWithPlane(id);
        if (tickets.isEmpty()) {
            return HtmlFromPages.HTML_ADMIN_PLANE_GESTIONS;
        } else {
            List<User> users;
            users = userGestions.findUsersByTickets(tickets);
            model.addAttribute(ModelAtributesVariables.USER, users);
            return HtmlFromPages.HTML_ADMIN_PLANE_GESTIONS;
        }

    }

}
