/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author doc
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Session
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        if(user == null || user.equals("")){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }else{
            String action = request.getParameter("action");
            if(action == null){
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }else if(action.equals("logout")){
//            session.removeAttribute("username");
             session.invalidate();
             getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
            
        }
        
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HashMap<String,ArrayList<String>> userAndItems;
        // Session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Object objects = session.getAttribute("userAndItems");
        
        if(objects == null){
            userAndItems = new HashMap<>();
        }else{
            userAndItems = (HashMap<String,ArrayList<String>>) objects;
        }
        
        
        if(request.getParameter("action").equals("register")){
            String user = request.getParameter("user");
            session.setAttribute("username", user);
        }else if(request.getParameter("action").equals("add")){
            String addItem = request.getParameter("addItem");
            
            if(userAndItems.containsKey(username)){
                userAndItems.get(username).add(addItem);
            }else{
                ArrayList<String> items = new ArrayList<>();
                items.add(addItem);
                userAndItems.put(username, items);
            }
            session.setAttribute("userAndItems", userAndItems);
        }else if(request.getParameter("action").equals("delete")){
            int itemIndex = Integer.parseInt(request.getParameter("item"));
            userAndItems.get(username).remove(itemIndex);
            session.setAttribute("userAndItems", userAndItems);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}