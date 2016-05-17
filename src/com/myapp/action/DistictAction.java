/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.Dao.DistictDAOImplementation;
import com.myapp.DaoIN.DistictInterface;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trainee
 */
public class DistictAction extends org.apache.struts.action.Action {
    
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
        System.out.println("comment value is ======"+request.getParameter("comment"));
        

        DistictInterface ius = new DistictDAOImplementation();
        
        //DistictBean db = new DistictBean();

        String id = request.getParameter("comment");

        

        List ls = ius.distict(id);

        request.setAttribute("distict", ls);

        if(ls.isEmpty()){
                request.setAttribute("msg2", "No Districts");
        return mapping.findForward(SUCCESS);

        }else{
           
        return mapping.findForward(SUCCESS);
        }

    }
}
