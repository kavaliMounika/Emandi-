/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.Dao.DeleteQuantityRequestDAOImplementation;
import com.myapp.DaoIN.DeleteQuantityRequestInterface;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trainee
 */
public class DeleteQuantityRequestAction extends org.apache.struts.action.Action {
    
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


        String id =request.getParameter("comment");
        String id1 =request.getParameter("comment1");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+id);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+id1);


        DeleteQuantityRequestInterface dqri = new DeleteQuantityRequestDAOImplementation();

       int i = dqri.delete(id,id1);
       if(i!=0){
           request.setAttribute("msg2", "Accepted ");
            return mapping.findForward(SUCCESS);
        }else{
           request.setAttribute("msg1", "Declined");
             return mapping.findForward(SUCCESS);
        }
    }
}
