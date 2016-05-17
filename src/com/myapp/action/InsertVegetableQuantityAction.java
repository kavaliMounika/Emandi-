/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.actionForm.InsertVegetableQuantityActionForm;
import com.myapp.Dao.InsertVegetableQuantityDAOImplementation;
import com.myapp.DaoIN.InsertVegetableQuantityInterface;
import com.myapp.javaclasses.InsertVegetableQuantityBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trainee
 */
public class InsertVegetableQuantityAction extends org.apache.struts.action.Action {
    
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

         InsertVegetableQuantityInterface ivqi = new InsertVegetableQuantityDAOImplementation();
            InsertVegetableQuantityBean ivqb = new InsertVegetableQuantityBean();
            InsertVegetableQuantityActionForm ivqaf= (InsertVegetableQuantityActionForm) form;


            ivqb.setUserId(ivqaf.getUserId());
            ivqb.setVegetableId(ivqaf.getVegetableId());
            ivqb.setVegetableQuantity(ivqaf.getVegetableQuantity());

            int i = ivqi.insertVegetables(ivqb);

            if(i!=0){
                
                
                    request.setAttribute("msg1", "insert successfull");
                    return mapping.findForward(SUCCESS);
            }else{
                    request.setAttribute("msg2", "Insert fail");
                    return mapping.findForward(NOTSUCCESS);
            }


        
        
    }
}
