
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
    }
    
   try {
            if ( request.getParameter("action").equals("logout") ) {

                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
        } 
        catch(NullPointerException notLoggingOut) {
            
        }
        
        if (session.getAttribute("username") == null){
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        else {
        
            getServletContext().getDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //receive the form from register.jsp and store the username field in a session attribute called 'username'
        //display shoppingList.jsp and use the 'username' attribute with the welcome message
        //on the shoppingList.jsp is a logout hyperlink with the welcome message and a form to add items
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String addItem = request.getParameter("addItem");
        ArrayList<String> itemList;
        


        switch (action) {
        
            case "register": 
                
                session.setAttribute("username", username); 
                break;
            
            case "add": 
                
                if (addItem.equals("")) { break; }
                
                // Adding to the list for display
                // Store a collection of objects ArrayList
                String item = request.getParameter("addItem");
                
                itemList = (ArrayList<String>) session.getAttribute("itemList");
                
                if (itemList == null) {

                    itemList = new ArrayList<>();
                }

                itemList.add(item);
                session.setAttribute("itemList", itemList);
                
                
                
                
                break;
                
            case "delete": 
                
                itemList = (ArrayList<String>) session.getAttribute("itemList");
                
                String toRemove = request.getParameter("selected");
                itemList.remove(toRemove);
                
                break;
        }
        
        
        response.sendRedirect("ShoppingList");
        return;
    } // end of doPost
}