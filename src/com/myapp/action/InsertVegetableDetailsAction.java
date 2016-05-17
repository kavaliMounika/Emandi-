/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.myapp.Dao.InsertVegetableDetailsDAOImplementation;
import com.myapp.DaoIN.InsertVegetableDetailsInterface;
import com.myapp.actionForm.InsertVegetableDetailsActionForm;
import com.myapp.javaclasses.InsertVegetableDetailsBean;

/**
 *
 * @author trainee
 */
public class InsertVegetableDetailsAction extends org.apache.struts.action.Action {
    
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

            InsertVegetableDetailsInterface ivdi = new InsertVegetableDetailsDAOImplementation();
            InsertVegetableDetailsBean ivdb = new InsertVegetableDetailsBean();
            InsertVegetableDetailsActionForm ivdaf= (InsertVegetableDetailsActionForm) form;

            
            ivdb.setVegetableName(ivdaf.getVegetableName());

            int i = ivdi.insertVegetables(ivdb);

            if(i!=0){
                if(ivdb.getVegetableName().isEmpty()){
                     request.setAttribute("msg3", "Enter Vegetable Name");
                    return mapping.findForward(NOTSUCCESS);
                }else{
                    request.setAttribute("msg1", "Vegetable added successfully");
                    return mapping.findForward(SUCCESS);
                }
            }else{
                    request.setAttribute("msg2", "Vegetable Already Found");
                    return mapping.findForward(NOTSUCCESS);
            }

        
        
    }
}
