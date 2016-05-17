/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;
import com.myapp.actionForm.BookingActionForm;
import com.myapp.DaoIN.BookingDaoImpl;
import com.myapp.Dao.BookingDao;

import com.myapp.javaclasses.BookingBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class BookingAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String NOTSUCCESS = "notsuccess";
    
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

                BookingActionForm baf = (BookingActionForm) form;
                BookingBean bb = new BookingBean();
                //HttpSession hs = request.getSession();

             
             // System.out.println("+++++++++++++++++++++++++++"+s);

                bb.setBookingQuantity(baf.getBookingQuantity());
                bb.setVegetableId(baf.getVegetableId());
                bb.setBookingDate(baf.getBookingDate());
                bb.setUserId(baf.getUserId());
                bb.setRoleId(baf.getRoleId());
                bb.setBookingTo(baf.getBookingTo());
               // bb.setBookingTo(s);
                System.out.println("************+++++++++++++"+baf.getBookingTo());
                //InsertUserDetails ius = new InsertUserDetails();
                BookingDaoImpl ius = new BookingDao();

                int i = ius.booking(bb);

        if(i==1){
            request.setAttribute("userId", bb.getUserId());
            request.setAttribute("msg2", "Booking Successful");
        return mapping.findForward(SUCCESS);
        }else{
           request.setAttribute("msg3", "Booking Failed");
            return mapping.findForward(NOTSUCCESS);
        }


    }
}
