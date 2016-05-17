/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.myapp.Dao.RegionDAOImplementation;
import com.myapp.DaoIN.RegionInterface;

/**
 *
 * @author trainee
 */
public class RegionAction extends org.apache.struts.action.Action {
    
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

        System.out.println("*************************"+request.getParameter("comment"));

        String s = request.getParameter("comment");

        RegionInterface ri = new RegionDAOImplementation();

        List ls = ri.region(s);

        request.setAttribute("region", ls);

        if(ls.isEmpty()){
                request.setAttribute("msg2", "No Regions");
        return mapping.findForward(SUCCESS);

        }else{

        return mapping.findForward(SUCCESS);
        }
       
    }
}
