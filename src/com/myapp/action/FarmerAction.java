/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.actionForm.FarmerActionForm;
import com.myapp.Dao.FarmerDAOImplementation;
import com.myapp.DaoIN.FarmerInterface;
import java.util.List;
import com.myapp.javaclasses.FarmerBean;
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
public class FarmerAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAIL="fail";
    
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
       FarmerInterface fi = new FarmerDAOImplementation();
       FarmerActionForm faf = (FarmerActionForm) form;
       FarmerBean fb = new FarmerBean();

       fb.setRoleId(faf.getRoleId());
       fb.setUserId(faf.getUserId());
      

        System.out.println("((((((((((((((((((((((((((((("+ fb.getUserId());
       //int i = fb.getRoleId();
       List ls = fi.farmer(fb);

       if(ls.isEmpty()){
           request.setAttribute("FAIL","No records" );
        return mapping.findForward(FAIL);
       }
 else{
       hs.setAttribute("role", fb.getRoleId());
    //   hs.setAttribute("userId", fb.getUserId());
       
       request.setAttribute("roles", ls);
        
        return mapping.findForward(SUCCESS);
        }
    }
}
