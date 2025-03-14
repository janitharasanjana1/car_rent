package com.janitha.megacity.servlet;

import com.google.gson.Gson;
import com.janitha.megacity.entity.User;
import com.janitha.megacity.service.UserService;
import com.janitha.megacity.service.WhatsAppMessageService;
import com.janitha.megacity.service.impl.SmsServiceImpl;
import com.janitha.megacity.service.impl.UserServiceImpl;
import com.janitha.megacity.service.impl.WhatsAppMessageServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private WhatsAppMessageService messageService = new WhatsAppMessageServiceImpl();
    SmsServiceImpl smsService = new SmsServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String roles=request.getParameter("role");


        User user = new User(0, username, password, email, phone, roles);
        System.out.println(user.getRole());
        boolean isRegistered = userService.registerUser(user);

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        if (isRegistered) {
            //normal sms
            //  smsService.sendSms(user.getPhone(), "Congratulations " + user.getUsername() + " on successfully registering!");
            //whatsapp
            messageService.sendRegistrationWhatsAppMessage(phone, username);
            response.setStatus(HttpServletResponse.SC_OK); // 200 OK
            out.print(gson.toJson("{ \"message\": \"Registration successful!\" }"));
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
            out.print(gson.toJson("{ \"error\": \"Failed to register.\" }"));
        }

        out.flush();
    }
}
