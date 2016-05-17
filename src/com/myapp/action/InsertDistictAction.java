/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.actionForm.InsertDistictActionForm;
import com.myapp.Dao.InsertDistictDAOImplementation;
import com.myapp.DaoIN.InsertDistictInterface;
import com.myapp.javaclasses.InsertDistictBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trainee
 */
public class InsertDistictAction extends org.apache.struts.action.Action {
    
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


        InsertDistictInterface idi = new InsertDistictDAOImplementation();
        InsertDistictActionForm idaf = (InsertDistictActionForm) form;
        InsertDistictBean idb = new InsertDistictBean();


        idb.setStateId(idaf.getStateId());
       
        idb.setDistictName(idaf.getDistictName());

        int i = idi.insertDistict(idb);

          if(i!=0){
             request.setAttribute("msg1", "City added successfully");
        return mapping.findForward(SUCCESS);
        }else{
                       request.setAttribute("msg2", "City already found");
        return mapping.findForward(NOTSUCCESS);
        }
        
        
    }
}
