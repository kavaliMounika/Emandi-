/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.Dao.ViewVegetable1DAOImplementation;
import com.myapp.DaoIN.ViewVegetable1Interface;
import java.util.List;
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
public class ViewVegetable1Action extends org.apache.struts.action.Action {
    
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

            HttpSession hs = request.getSession();
         
        ViewVegetable1Interface vvi = new ViewVegetable1DAOImplementation();

        List ls = vvi.viewVegetable1();

        hs.setAttribute("veg", ls);

        System.out.println("((((((((((((((((((((((" + ls);

        if (ls.isEmpty()) {

            request.setAttribute("emp", "No Vegetables");

            return mapping.findForward(NOTSUCCESS);

        } else {
            return mapping.findForward(SUCCESS);
        }
        
       
    }
}
