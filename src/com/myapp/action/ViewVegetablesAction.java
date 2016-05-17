/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.action;

import com.myapp.Dao.ViewVegetableDAOImplementation;
import com.myapp.DaoIN.ViewVegetablesInterface;
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
public class ViewVegetablesAction extends org.apache.struts.action.Action {

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

        // HttpSession hs = request.getSession();
        String s = request.getParameter("comment");

        System.out.println("++++++++++++===================" + s);

        ViewVegetablesInterface vvi = new ViewVegetableDAOImplementation();

        List ls = vvi.viewVegetables(s);

        request.setAttribute("veg", ls);

        System.out.println("((((((((((((((((((((((" + ls);

        if (ls.isEmpty()) {

            request.setAttribute("emp", "This user doesnt have any vegetables please choose another user");

            return mapping.findForward(NOTSUCCESS);

        } else {
            return mapping.findForward(SUCCESS);
        }
    }
}
