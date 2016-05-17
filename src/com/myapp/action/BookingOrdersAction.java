/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.Dao.BookingOrdersDAOImplementation;
import com.myapp.DaoIN.BookingOrdersInterface;
import java.util.List;
import com.myapp.javaclasses.BookingOrdersBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trainee
 */
public class BookingOrdersAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAIL ="fail";
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession hs = request.getSession();


         String id =  request.getParameter("comment");
          System.out.println("((((((((((((((((((((("+id);

          BookingOrdersInterface boi = new BookingOrdersDAOImplementation();
          BookingOrdersBean bob = new BookingOrdersBean();

          bob.setUserId(id);

          List ls = boi.bookingOrders(bob);
          if(ls.isEmpty()){

          //   hs.setAttribute("userId", )
            request.setAttribute("fail", "You didn't have any vegetable orders");
            return mapping.findForward(FAIL);
          }else{
         
          request.setAttribute("bord", ls);

        return mapping.findForward(SUCCESS);
        }
        
     
    }
}
