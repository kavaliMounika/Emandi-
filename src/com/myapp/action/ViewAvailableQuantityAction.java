package com.myapp.action;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.myapp.actionForm.ViewAvailableQuantityActionForm;
import com.myapp.Dao.ViewAvailableQuantityDAOImplementation;
import com.myapp.DaoIN.ViewAvailableQuantityInterface;
import java.util.List;
import com.myapp.javaclasses.ViewAvailableQuantityBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trainee
 */
public class ViewAvailableQuantityAction extends org.apache.struts.action.Action {
    
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
        

        ViewAvailableQuantityInterface vaqi = new ViewAvailableQuantityDAOImplementation();
        ViewAvailableQuantityActionForm vaqaf = (ViewAvailableQuantityActionForm)form;
        ViewAvailableQuantityBean vaqb = new ViewAvailableQuantityBean();

        vaqb.setVegetableId(vaqaf.getVegetableId());
        vaqb.setUserId(vaqaf.getUserId());

       List ls = vaqi.available(vaqb);
       request.setAttribute("qty", ls);
        
        return mapping.findForward(SUCCESS);
    }
}
