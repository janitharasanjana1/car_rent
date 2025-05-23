package com.janitha.megacity.servlet;


import com.google.gson.Gson;
import com.janitha.megacity.dto.ErrorResponse;
import com.janitha.megacity.entity.User;
import com.janitha.megacity.filters.JwtUtil;
import com.janitha.megacity.service.UserService;
import com.janitha.megacity.service.impl.UserServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(gson.toJson(new ErrorResponse("Missing or invalid token")));
            return;
        }

        String token = authHeader.substring(7); // Remove "Bearer " prefix

        try {
            // Extract email from JWT token
            String email = JwtUtil.extractEmail(token);

            // Retrieve user profile using email
           // User user = userService.getUserByEmail(email);

//            if (user != null) {
//                response.setStatus(HttpServletResponse.SC_OK);
//                PrintWriter out = response.getWriter();
//                out.print(gson.toJson(user));
//                out.flush();
//            } else {
//                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//                response.getWriter().write(gson.toJson(new ErrorResponse("User not found")));
//            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(gson.toJson(new ErrorResponse("Invalid or expired token")));
        }
    }
}
