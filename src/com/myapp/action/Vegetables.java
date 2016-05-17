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

import com.myapp.Dao.VegetableDetailsDAOImplementation;
import com.myapp.DaoIN.VegetableDetailsInterface;
import com.myapp.actionForm.VegetableDetailsActionForm;
import com.myapp.javaclasses.VegetableDetailsBean;

/**
 *
 * @author trainee
 */
public class Vegetables extends org.apache.struts.action.Action {
    
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
         System.out.println("************************ action");
        VegetableDetailsInterface iud = new VegetableDetailsDAOImplementation();
        VegetableDetailsActionForm vdaf = (VegetableDetailsActionForm)form;
        VegetableDetailsBean vdb = new VegetableDetailsBean();

       vdb.setVegetableId(vdaf.getVegetableId());

        List ls = iud.details(vdb);


        request.setAttribute("details", ls);
        if(ls.isEmpty()){
                request.setAttribute("no", "No Available Persons");
            return mapping.findForward(SUCCESS);
        }else{

        return mapping.findForward(SUCCESS);
        }
    }
}
