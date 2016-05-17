/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.Dao.OrderDeclineActionDAOImplementation;
import com.myapp.DaoIN.OrderDeclineActionInterface;
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
public class OrderDeclineAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
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

        String s = request.getParameter("comment");
        System.out.println("(((((((((((((())))))))))))))"+s);

        OrderDeclineActionInterface oi = new OrderDeclineActionDAOImplementation() ;
        int is = oi.orderDecline(s);

        System.out.println("++++++++++++++++++++++"+is);

        if(is!=0){
           return mapping.findForward(SUCCESS);
        }else{
            request.setAttribute("values", "NO STOCK");
            return mapping.findForward(SUCCESS);
        }
        
        
    }
}
