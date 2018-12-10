package servlets;

import entity.Product;
import entity.Purchase;
import entity.User;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import util.EncriptPass;
import util.PageReturner;

@WebServlet(name = "ShopLogic", urlPatterns = {
    "/registerPage",
    "/register",
    "/products",
    "/products2",
    "/products3",
    "/singleProduct",
    "/single_product",
    "/catalog/product/*",
    "/purchase",
    "/userInfo",
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
public class ShopLogic extends HttpServlet {

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

                case "/registerPage":
                    request.getRequestDispatcher(PageReturner.getPage("registerPage")).forward(request, response);
                    break;
                case "/register": {
                    String name = request.getParameter("name");
                    String surname = request.getParameter("surname");
                    String phone = request.getParameter("phone");
                    String city = request.getParameter("city");
                    String login = request.getParameter("login");
                    String password1 = request.getParameter("password1");
                    String password2 = request.getParameter("password2");
                    if (!password1.equals(password2)) {
                        request.setAttribute("info_error", "Passwords do not match!");
                        response.sendRedirect("registerPage");
                        //request.getRequestDispatcher(PageReturner.getPage("registerPage")).forward(request, response);
                        break;
                    }
                    EncriptPass ep = new EncriptPass();
                    String salts = ep.createSalts();
                    String encriptPass = ep.setEncriptPass(password1, salts);
                    User user = new User(name, surname, phone, city, login,
                            encriptPass, salts);
                    userFacade.create(user);
                    request.setAttribute("user", user);
                    request.setAttribute("info", "Your registration was successful. You can Login now!");
                    response.sendRedirect("loginPage");
                    //request.getRequestDispatcher(PageReturner.getPage("loginPage")).forward(request, response);
                    break;
                }
                case "/products": {
                    List<Product> products = productFacade.findActived(true);
                    request.setAttribute("role", sl.getRole(regUser));
                    request.setAttribute("products", products);
                    request.getRequestDispatcher(PageReturner.getPage("products")).forward(request, response);
                    break;
                }

                /*case "/products2":
                    List<Product> products2 = productFacade.findActived(true);
                    request.setAttribute("role", sl.getRole(regUser));
                    request.setAttribute("products2", products2);
                    request.getRequestDispatcher(PageReturner.getPage("products2")).forward(request, response);
                    break;*/
                case "/products3":
                    List<Product> products3 = productFacade.findActived(true);
                    request.setAttribute("role", sl.getRole(regUser));
                    request.setAttribute("products3", products3);
                    request.getRequestDispatcher(PageReturner.getPage("products3")).forward(request, response);
                    break;

                /*case "/single_product":
                    String sp = request.getParameter("sp");
                    Product singleProduct = productFacade.find(new Long(sp));
                    request.setAttribute("singleProduct", singleProduct);
                    request.getRequestDispatcher(PageReturner.getPage("single_product")).forward(request, response);
                    break;*/
                case "/purchase":
                    String p = request.getParameter("p");
                    String p2 = request.getParameter("p2");

                    String quantityStr = request.getParameter("quantity");

                    Product product = productFacade.find(new Long(p));
                    User user = userFacade.find(new Long(p2));
                    Calendar c = new GregorianCalendar();
                    if (product.getCount() > 0) {
                        product.setCount(product.getCount() - 1);
                        productFacade.edit(product);

                        Purchase purchase = new Purchase(product, user, c.getTime(), null, 0);
                        purchaseFacade.create(purchase);

                        purchase.setQuantity(Integer.parseInt(request.getParameter("quantity")));

                        //purchase.setQuantity(1);
                        purchase.setTotal(purchase.getQuantity() * product.getPrice());

                        //purchase.setTotal(Long.parseLong(product.getPrice() * purchase.getQuantity()));
                        //purchase.setTotal(product.getCount() * purchase.getQuantity);
                        //Purchase purchase = new Purchase(product, user, c.getTime(), null);
                        // purchase.setQuantity(Integer.parseInt(request.getParameter("quant")));
                        purchaseFacade.edit(purchase);
                        request.setAttribute("purchase", purchase);
                        request.setAttribute("info_purchase", "You bought!" + product.getNameProduct());
                        response.sendRedirect("products");

                    } else {
                        request.setAttribute("info_purchase", "This product is sold out!");
                        response.sendRedirect("products");

                    }

                    break;

                case "/userInfo":
                    String userI = request.getParameter("userI");

                    List<Purchase> usersInfo = purchaseFacade.findUserById(new Long(userI));
                    request.setAttribute("usersInfo", usersInfo);

                    request.getRequestDispatcher(PageReturner.getPage("userInfo")).forward(request, response);
                    break;

                case "/admin":

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
