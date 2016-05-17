/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.DaoIN.BookingRequestDaoImpl;
import com.myapp.Dao.BookingRequestDao;
import java.util.List;
import com.myapp.javaclasses.BookingRequestBean;
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
public class BookingRequestAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
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

          BookingRequestDaoImpl bri = new BookingRequestDao();
          BookingRequestBean brb = new BookingRequestBean();

          brb.setUserId(id);

          List ls = bri.bookingRequest(brb);
          if(ls.isEmpty()){

            request.setAttribute("fail", "You dint requested for any vegetables");
            return mapping.findForward(FAIL);

          }else{
            request.setAttribute("breq", ls);
        
        return mapping.findForward(SUCCESS);
        }
    }
}
