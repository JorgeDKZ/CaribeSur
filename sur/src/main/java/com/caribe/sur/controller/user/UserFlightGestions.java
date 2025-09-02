package com.caribe.sur.controller.user;

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
import com.caribe.sur.service.CheckUser;
import com.caribe.sur.service.PlaneGestions;
import com.caribe.sur.service.TicketGestions;
import com.caribe.sur.service.UserGestions;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserFlightGestions {

    @Autowired
    UserGestions users;
    @Autowired
    PlaneGestions planes;
    @Autowired
    TicketGestions tickets;
    @Autowired
    CheckUser checkUser;

    private static final int GET_PLANE = 0;
    private static final int GET_ROW = 1;
    private static final int GET_COLUMN = 2;

    @GetMapping(UrlFromPages.URL_USER_FLIGHT)
    public String seeTheFlight(Model model) {
        model.addAttribute(ModelAtributesVariables.PLANE, planes.getAllPlanes());
        return HtmlFromPages.HTML_USER_FLIGHT;
    }

    @PostMapping(UrlFromPages.URL_USER_SELECTED_PLANE)
    public String selectedThePlane(Model model, @RequestParam long plane) {
        model.addAttribute(ModelAtributesVariables.PLANE, planes.getAllPlanes());
        model.addAttribute(ModelAtributesVariables.SITE, planes.findUserById(plane).getSeats());
        model.addAttribute(ModelAtributesVariables.PLANE_SELECTED, plane);
        return HtmlFromPages.HTML_USER_FLIGHT;
    }

    @PostMapping(UrlFromPages.URL_USER_SELECTED_SEAT)
    public String selectedTheSite(Model model, @RequestParam String seatPosition) {
        String[] seat = seatPosition.split("-");
        Plane selectedPlane = planes.findUserById(Long.parseLong(seat[GET_PLANE]));
        Ticket createTicket;
        User user = users.findUserById(checkUser.getUserName());
        System.out.println(seat[GET_PLANE]);
        if (selectedPlane.isAvaliableSeat(Integer.parseInt(seat[GET_ROW]),
                Integer.parseInt(seat[GET_COLUMN]))) {
            createTicket = new Ticket(Integer.parseInt(seat[GET_ROW]), Integer.parseInt(seat[GET_COLUMN]),
                    user, selectedPlane);
            tickets.saveTicket(createTicket);
            user.addTicket(createTicket);
            selectedPlane.addTicket(createTicket);
            
        } else {

        }
        model.addAttribute(ModelAtributesVariables.PLANE, planes.getAllPlanes());
        model.addAttribute(ModelAtributesVariables.SITE, selectedPlane.getSeats());
        model.addAttribute(ModelAtributesVariables.PLANE_SELECTED, selectedPlane);
        return HtmlFromPages.HTML_USER_FLIGHT;

    }

}
