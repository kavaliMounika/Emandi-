/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.action;

import com.myapp.actionForm.FeedBackActionForm;
import com.myapp.Dao.FeedBackDAOImplementation;
import com.myapp.DaoIN.FeedBackInterface;
import com.myapp.javaclasses.FeedBackBean;
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
public class FeedBackAction extends org.apache.struts.action.Action {

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

        HttpSession hs = request.getSession();
        String s = hs.getAttribute("id").toString();

         System.out.println("++++++++++++++++++++++++++++-------------"+s);
        FeedBackInterface fbi = new FeedBackDAOImplementation();
        FeedBackActionForm fbaf = (FeedBackActionForm) form;
        FeedBackBean fbb = new FeedBackBean();

          

        fbb.setUserId(s);
        fbb.setFeedBack(fbaf.getFeedBack());
        fbb.setTypeId(fbaf.getTypeId());
        System.out.println("++++++++++-------"+fbb.getTypeId());

        int i = fbi.feedBack(fbb);


        if (i != 0) {
            request.setAttribute("msg1", "Thank you for giving Feedback");
            return mapping.findForward(SUCCESS);
            }
       else {
            request.setAttribute("msg2", "FeedBack Unsuccessful");
            return mapping.findForward(NOTSUCCESS);
        }

        
       


    }
}
