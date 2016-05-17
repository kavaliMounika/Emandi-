/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.actionForm.InsertStateActionForm;
import com.myapp.Dao.InsertStateInterfaceDAOImplementation;
import com.myapp.DaoIN.InsertStateInterface;
import com.myapp.javaclasses.InsertStateBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trainee
 */
public class InsertStateAction extends org.apache.struts.action.Action {
    
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

        InsertStateInterface isi = new InsertStateInterfaceDAOImplementation();
        InsertStateActionForm isaf =(InsertStateActionForm) form;
        InsertStateBean isb = new InsertStateBean();

       
        isb.setStateName(isaf.getStateName());

                   int i = isi.insertState(isb);

         if(i!=0){
             request.setAttribute("msg1", "State Added successfully");
        return mapping.findForward(SUCCESS);
        }else{
                       request.setAttribute("msg2", "State Already found");
        return mapping.findForward(NOTSUCCESS);
        }
    }
}
