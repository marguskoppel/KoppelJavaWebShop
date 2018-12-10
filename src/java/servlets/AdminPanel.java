package servlets;

import entity.Product;
import entity.Purchase;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import secure.SecureLogic;
import session.ProductFacade;
import session.PurchaseFacade;
import session.UserFacade;
import util.PageReturner;

@WebServlet(name = "AdminPanel", urlPatterns = {
    "/admin",
    "/admin_products",
    "/notActive",
    "/activateProduct",
    "/admin_users",
    "/usersNotActive",
    "/activateUser",
    "/admin_purchases",
    "/addProduct",
    "/createProduct",
    "/editProduct",
    "/editP",
    "/deleteProduct",
    "/deleteP",
    "/editUser",
    "/editU",
    "/deleteUser",
    "/deleteU",
    "/userPurchase",})
public class AdminPanel extends HttpServlet {

    @EJB
    ProductFacade productFacade;
    @EJB
    UserFacade userFacade;
    @EJB
    PurchaseFacade purchaseFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF8");
        /*
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
                case "/admin":
                    request.setAttribute("role", sl.getRole(regUser));
                    request.getRequestDispatcher(PageReturner.getPage("admin")).forward(request, response);
                    break;
                case "/admin_products":
                    
                    List<Product> products = productFacade.findActived(true);
                    request.setAttribute("role", sl.getRole(regUser));
                    request.setAttribute("products", products);
                    request.setAttribute("info_products", "Products list");
                    request.getRequestDispatcher(PageReturner.getPage("admin_products")).forward(request, response);
                    break;

                case "/notActive":

                    List<Product> productsNotActive = productFacade.findActived(false);
                    request.setAttribute("role", sl.getRole(regUser));
                    request.setAttribute("info_notActive", "Products list");
                    request.setAttribute("productsNotActive", productsNotActive);

                    request.getRequestDispatcher(PageReturner.getPage("notActive")).forward(request, response);
                    break;

                case "/activateProduct":
                    String ap = request.getParameter("ap");
                    Product productNotActiveEdit = productFacade.find(new Long(ap));
                    productNotActiveEdit.setActive(Boolean.TRUE);

                    productFacade.edit(productNotActiveEdit);
                    request.setAttribute("productEdit", "You edited a product");
                    response.sendRedirect("admin_products");
                    break;

                case "/admin_users":

                    //List<User> users = userFacade.findAll();
                    List<User> users = userFacade.findActivedExceptAdmin(true);
                    request.setAttribute("role", sl.getRole(regUser));
                    request.setAttribute("users", users);
                    request.setAttribute("info_users", "Users list");
                    request.getRequestDispatcher(PageReturner.getPage("admin_users")).forward(request, response);
                    break;

                case "/usersNotActive":

                    List<User> usersNotActive = userFacade.findActivedExceptAdmin(false);
                    request.setAttribute("role", sl.getRole(regUser));
                    request.setAttribute("usersNotActive", usersNotActive);
                    request.setAttribute("info_users", "Users list");
                    request.getRequestDispatcher(PageReturner.getPage("usersNotActive")).forward(request, response);
                    break;

                case "/activateUser":
                    String au = request.getParameter("au");
                    User userNotActiveEdit = userFacade.find(new Long(au));
                    userNotActiveEdit.setStatus(Boolean.TRUE);

                    userFacade.edit(userNotActiveEdit);
                    request.setAttribute("userEdit", "You edited a user status");
                    response.sendRedirect("admin_users");
                    break;

                case "/admin_purchases":

                    List<Purchase> purchasesA = purchaseFacade.findAll();
                    request.setAttribute("role", sl.getRole(regUser));
                    request.setAttribute("purchasesA", purchasesA);
                    request.setAttribute("info_purchases", "Purchases list");
                    request.getRequestDispatcher(PageReturner.getPage("admin_purchases")).forward(request, response);
                    break;

                case "/addProduct":

                    
                    request.getRequestDispatcher(PageReturner.getPage("addProduct")).forward(request, response);
                    break;

                case "/createProduct":
                    String nameProduct = request.getParameter("nameProduct");
                    String description = request.getParameter("description");
                    String countStr = request.getParameter("count");
                    String priceStr = request.getParameter("price");
                    Product productAdmin = new Product(nameProduct, description, new Long(priceStr), new Integer(countStr));
                    productFacade.create(productAdmin);
                    request.setAttribute("productCreate", "You added new product");
                    //request.getRequestDispatcher(PageReturner.getPage("admin_products"))forward(request, response);
                    response.sendRedirect("admin_products");
                    break;

                case "/editProduct":

                    String ep = request.getParameter("ep");
                    Product productEdit = productFacade.find(new Long(ep));
                    request.setAttribute("productEdit", productEdit);
                    request.getRequestDispatcher(PageReturner.getPage("editProduct")).forward(request, response);
                    break;

                
                case "/editP":
                    String eId = request.getParameter("eId");
                    Product productAdminEdit = productFacade.find(new Long(eId));
                    productAdminEdit.setNameProduct(request.getParameter("nameProduct"));
                    productAdminEdit.setDescription(request.getParameter("description"));
                    productAdminEdit.setCount(Integer.parseInt(request.getParameter("count")));
                    productAdminEdit.setPrice(Long.parseLong(request.getParameter("price")));
                    productFacade.edit(productAdminEdit);
                    request.setAttribute("productEdit", "You edited a product");
                    response.sendRedirect("admin_products");
                    break;

                case "/deleteProduct":

                    String dp = request.getParameter("dp");
                    Product productDelete = productFacade.find(new Long(dp));
                    request.setAttribute("productDelete", productDelete);
                    request.getRequestDispatcher(PageReturner.getPage("deleteProduct")).forward(request, response);
                    break;

                case "/deleteP":
                    String dId = request.getParameter("dId");
                    Product productAdminDelete = productFacade.find(new Long(dId));
                    productAdminDelete.setActive(Boolean.FALSE);
                    productFacade.edit(productAdminDelete);
                    request.setAttribute("productDelete", "You have deleted a product");
                    response.sendRedirect("admin_products");
                    break;

                case "/editUser":
                    if (sl.isRole(regUser, "ADMIN")) {
                        request.setAttribute("notAdmin", "Access denied. You have no rights to view this page!");
                        request.getRequestDispatcher(PageReturner.getPage("welcome"))
                                .forward(request, response);
                        break;
                    }
                    String eu = request.getParameter("eu");
                    User userEdit = userFacade.find(new Long(eu));
                    request.setAttribute("userEdit", userEdit);
                    request.getRequestDispatcher(PageReturner.getPage("editUser")).forward(request, response);
                    break;

                case "/editU":
                    String euId = request.getParameter("euId");
                    User userAdminEdit = userFacade.find(new Long(euId));
                    userAdminEdit.setName(request.getParameter("name"));
                    userAdminEdit.setSurname(request.getParameter("surname"));
                    userAdminEdit.setPhone(request.getParameter("phone"));
                    userAdminEdit.setCity(request.getParameter("city"));
                    userFacade.edit(userAdminEdit);
                    request.setAttribute("userEdit", "You edited a product");
                    response.sendRedirect("admin_users");
                    break;

                case "/deleteUser":
                    if (!sl.isRole(regUser, "ADMIN")) {
                        request.setAttribute("notAdmin", "Access denied. You have no rights to view this page!");
                        request.getRequestDispatcher(PageReturner.getPage("welcome"))
                                .forward(request, response);
                        break;
                    }
                    String du = request.getParameter("du");
                    User userDelete = userFacade.find(new Long(du));
                    request.setAttribute("userDelete", userDelete);
                    request.getRequestDispatcher(PageReturner.getPage("deleteUser")).forward(request, response);
                    break;

                case "/deleteU":
                    String duId = request.getParameter("duId");
                    User userAdminDelete = userFacade.find(new Long(duId));
                    userAdminDelete.setStatus(Boolean.FALSE);
                    userFacade.edit(userAdminDelete);
                    request.setAttribute("userDelete", "User have been deleted");
                    response.sendRedirect("admin_users");
                    break;

                case "/userPurchase":
                    if (!sl.isRole(regUser, "ADMIN")) {
                        request.setAttribute("notAdmin", "Access denied. You have no rights to view this page!");
                        request.getRequestDispatcher(PageReturner.getPage("welcome"))
                                .forward(request, response);
                        break;
                    }
                    String up = request.getParameter("up");
                    //Purchase purchaseUser = purchaseFacade.find(new Long(up));
                    List<Purchase> purchaseUser = purchaseFacade.findUserById(new Long(up));
                    request.setAttribute("purchaseUser", purchaseUser);
                    request.getRequestDispatcher(PageReturner.getPage("userPurchase")).forward(request, response);
                    break;

                default:
                    request.getRequestDispatcher(PageReturner.getPage("welcome")).forward(request, response);
                    break;

            }

        }*/
    }

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
