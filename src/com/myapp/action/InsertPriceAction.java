/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.actionForm.InsertPriceActionForm;
import com.myapp.Dao.InsertPriceDAOImplementation;
import com.myapp.DaoIN.InsertPriceDetailsInterface;
import com.myapp.javaclasses.InsertPriceBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trainee
 */
public class InsertPriceAction extends org.apache.struts.action.Action {
    
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


        InsertPriceDetailsInterface ipdi = new InsertPriceDAOImplementation();
        InsertPriceActionForm ipaf = (InsertPriceActionForm) form;
        InsertPriceBean ipb = new InsertPriceBean();

        
        ipb.setVegetableId(ipaf.getVegetableId());
        ipb.setRegionId(ipaf.getRegionId());
        ipb.setGovernmentPrice(ipaf.getGovernmentPrice());
        ipb.setFarmerPrice(ipaf.getFarmerPrice());
        ipb.setWholeSellerPrice(ipaf.getWholeSellerPrice());
        ipb.setRetailerPrice(ipaf.getRetailerPrice());

        int i = ipdi.Prices(ipb);

        if(i!=0){
            request.setAttribute("msg1", "Row Successfully updated");
           return mapping.findForward(NOTSUCCESS);
        }else{
            request.setAttribute("msg2", "Row updation failed");
            return mapping.findForward(NOTSUCCESS);
        }

    }
}
