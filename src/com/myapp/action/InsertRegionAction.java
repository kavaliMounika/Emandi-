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

import com.myapp.Dao.InsertRegionDAOImplementation;
import com.myapp.DaoIN.InsertRegionInterface;
import com.myapp.actionForm.InsertRegionActionForm;
import com.myapp.javaclasses.InsertRegionBean;



/**
 *
 * @author trainee
 */
public class InsertRegionAction extends org.apache.struts.action.Action {
    
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

        InsertRegionInterface iri = new InsertRegionDAOImplementation();
        InsertRegionActionForm iraf = (InsertRegionActionForm) form;
        InsertRegionBean irb = new InsertRegionBean();

        irb.setDistictId(iraf.getDistictId());
       
        irb.setRegionName(iraf.getRegionName());

            int i = iri.insertRegion(irb);


          if(i!=0){
             request.setAttribute("msg1", "Region added successfully");
        return mapping.findForward(SUCCESS);
        }else{
              request.setAttribute("msg2", "Region Already Found");
        return mapping.findForward(NOTSUCCESS);
        }

        
      
    }
}
