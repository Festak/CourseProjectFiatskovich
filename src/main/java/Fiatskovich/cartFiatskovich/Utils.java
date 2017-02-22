package Fiatskovich.cartFiatskovich;

/**
 * Created by Евгений on 21.02.2017.
 */

import javax.servlet.http.HttpServletRequest;


public class Utils {
    public static CartInfo getCartInSession(HttpServletRequest request) {

        // Get Cart from Session.
        CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");

        if (cartInfo == null) {
            cartInfo = new CartInfo();

            request.getSession().setAttribute("myCart", cartInfo);
        }

        return cartInfo;
    }

    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }

    public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
        request.getSession().setAttribute("lastOrderedCart", cartInfo);
    }

    public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
        return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
    }

}