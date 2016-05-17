/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.actionForm.ViewFeedBackActionForm;
import com.myapp.Dao.ViewFeedBackDAOImplementation;
import com.myapp.DaoIN.ViewFeedBackInterface;
import java.util.List;
import com.myapp.javaclasses.ViewFeedBackBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trainee
 */
public class ViewFeedBackAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
   // private static final String NOTSUCCESS = "notsuccess";
    
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



        ViewFeedBackInterface vfi = new ViewFeedBackDAOImplementation();
        ViewFeedBackActionForm vfaf = (ViewFeedBackActionForm)form;
        ViewFeedBackBean vfb= new ViewFeedBackBean();

        vfb.setTypeId(vfaf.getTypeId());

        
        

        List ls = vfi.feedBack(vfb);

        request.setAttribute("feedback", ls);

        if (ls.isEmpty()) {
            request.setAttribute("msg2", " No Records");
            return mapping.findForward(SUCCESS);

            }
       else {
            
            return mapping.findForward(SUCCESS);
        }

        
        
       
    }
}
