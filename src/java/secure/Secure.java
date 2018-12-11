
package secure;

import entity.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.UserFacade;
import session.RoleFacade;
import session.UserRolesFacade;
import util.EncriptPass;
import util.PageReturner;


@WebServlet(loadOnStartup = 1, name = "Secure", urlPatterns = {
    "/login",
    "/logout",
    "/loginPage",
    "/showUserRoles",
    "/changeUserRole"
})
public class Secure extends HttpServlet {

    @EJB
    RoleFacade roleFacade;
    @EJB
    UserFacade userFacade;
    @EJB
    UserRolesFacade userRolesFacade;

    @Override
    public void init() throws ServletException {
        List<User> listUser = userFacade.findAll();
        if (listUser.isEmpty()) {
            EncriptPass ep = new EncriptPass();
            String salts = ep.createSalts();
            String encriptPass = ep.setEncriptPass("admin", salts);
            /*User user = new User("Admin", "",
                    "", "", "admin", encriptPass, salts);
            userFacade.create(user);
            Role role = new Role();
            role.setName("ADMIN");
            roleFacade.create(role);
            UserRoles ur = new UserRoles();
            ur.setUser(user);
            ur.setRole(role);
            userRolesFacade.create(ur);

            role.setName("USER");
            roleFacade.create(role);
            ur.setUser(user);
            ur.setRole(role);
            userRolesFacade.create(ur);*/
            User admin = new User("Admin", "",
                    "", "", "admin", encriptPass, salts);
            userFacade.create(admin);
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            roleFacade.create(adminRole);
            UserRoles ur = new UserRoles();
            ur.setUser(admin);
            ur.setRole(adminRole);
            userRolesFacade.create(ur);
            
            Role userRole = new Role();
            userRole.setName("USER");
            roleFacade.create(userRole);
            ur.setUser(admin);
            ur.setRole(userRole);
            userRolesFacade.create(ur);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF8");
        HttpSession session = request.getSession(false);
        User regUser = null;
        if (session != null) {
            try {
                regUser = (User) session.getAttribute("regUser");
            } catch (Exception e) {
                regUser = null;
            }
        }

        SecureLogic sl = new SecureLogic();
        String path = request.getServletPath();
        if (null != path) {
            switch (path) {
                case "/login":
                    String login = request.getParameter("login");
                    String password = request.getParameter("password");
                    request.setAttribute("info", "No such user!");
                    regUser = userFacade.findByLogin(login);

                    if (regUser == null) {
                        request.getRequestDispatcher(PageReturner.getPage("loginPage"))
                                .forward(request, response);
                        break;
                    }
                    EncriptPass ep = new EncriptPass();
                    String salts = regUser.getSalts();
                    String encriptPass = ep.setEncriptPass(password, salts);
                    if (encriptPass.equals(regUser.getPassword())) {
                        if (login.equals("admin") && password.equals("admin")) {
                            session = request.getSession(true);
                            session.setAttribute("admin", regUser);
                            request.setAttribute("info", "Hello " + regUser.getName()
                                    + "! Your login was successful!");
                            response.sendRedirect("admin");
                            //request.getRequestDispatcher(PageReturner.getPage("admin"))
                                    //.forward(request, response);
                            break;

                        } else {
                            session = request.getSession(true);
                            session.setAttribute("user", regUser);
                            request.setAttribute("info", "Hello " + regUser.getName()
                                    + "! Your login was successful!");
                            //response.sendRedirect("welcome");
                            request.getRequestDispatcher(PageReturner.getPage("welcome"))
                                    .forward(request, response);
                            break;

                        }

                    }
                    response.sendRedirect("loginPage");
                    //request.getRequestDispatcher(PageReturner.getPage("loginPage"))
                            //.forward(request, response);
                    break;
                case "/loginPage":
                    request.getRequestDispatcher(PageReturner.getPage("loginPage"))
                            .forward(request, response);
                    break;
                case "/logout":
                    if (session != null) {
                        session.invalidate();
                        request.setAttribute("info", "Logout was successful!");
                    }
                    request.getRequestDispatcher(PageReturner.getPage("welcome"))
                            .forward(request, response);
                    break;
                    
                case "/showUserRoles":
                    if (!sl.isRole(regUser, "ADMIN")) {
                        request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                        request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                                .forward(request, response);
                        break;
                    }

                    Map<User, String> mapUsers = new HashMap<>();
                    List<User> listUsers = userFacade.findAll();
                    int n = listUsers.size();
                    for (int i = 0; i < n; i++) {
                        mapUsers.put(listUsers.get(i), sl.getRole(listUsers.get(i)));
                    }
                    List<Role> listRoles = roleFacade.findAll();
                    request.setAttribute("mapUsers", mapUsers);
                    request.setAttribute("listRoles", listRoles);
                    request.getRequestDispatcher(PageReturner.getPage("showUserRoles"))
                            .forward(request, response);
                    break;
                case "/changeUserRole":
                    if (!sl.isRole(regUser, "ADMIN")) {
                        request.setAttribute("info", "У вас нет прав доступа к ресурсу");
                        request.getRequestDispatcher(PageReturner.getPage("showLogin"))
                                .forward(request, response);
                        break;
                    }
                    String setButton = request.getParameter("setButton");
                    String deleteButton = request.getParameter("deleteButton");
                    String userId = request.getParameter("user");
                    String roleId = request.getParameter("role");
                    User reader = userFacade.find(new Long(userId));
                    Role roleToUser = roleFacade.find(new Long(roleId));
                    UserRoles ur = new UserRoles(reader, roleToUser);
                    if (setButton != null) {
                        sl.addRoleToUser(ur);
                    }
                    if (deleteButton != null) {
                        sl.deleteRoleToUser(ur.getUser());
                    }
                    mapUsers = new HashMap<>();
                    listUsers = userFacade.findAll();
                    n = listUsers.size();
                    for (int i = 0; i < n; i++) {
                        mapUsers.put(listUsers.get(i), sl.getRole(listUsers.get(i)));
                    }
                    request.setAttribute("mapUsers", mapUsers);
                    List<Role> newListRoles = roleFacade.findAll();
                    request.setAttribute("listRoles", newListRoles);
                    request.getRequestDispatcher(PageReturner.getPage("showUserRoles"))
                            .forward(request, response);
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
