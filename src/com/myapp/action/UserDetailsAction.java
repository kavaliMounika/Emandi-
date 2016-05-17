/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.actionForm.UserDetailsActionForm;
import com.myapp.Dao.UserDetailsDao;
import com.myapp.DaoIN.UserDetailsDaoImpl;
import java.io.PrintWriter;
import com.myapp.javaclasses.UserDetailsBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author trainee
 */
public class UserDetailsAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String NOTSUCCESS="notsuccess";
    
    


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
            PrintWriter out = response.getWriter();
            UserDetailsActionForm udaf =(UserDetailsActionForm) form;
            UserDetailsBean udb = new UserDetailsBean();

            udb.setRoleId(udaf.getRoleId());
            udb.setName(udaf.getName());
            udb.setUserName(udaf.getUserName());
            udb.setPassword(udaf.getPassword());
            udb.setAddress(udaf.getAddress());
            udb.setPhoneNumber(udaf.getPhoneNumber());

            System.out.println("************ role:"+udb.getPhoneNumber());

           // InsertUserDetails iud = new InsertUserDetails();
            UserDetailsDaoImpl iud = new UserDetailsDao();
            int i=iud.setValues(udb);
            out.println(i+"row inserted");

          //  System.out.println("*******************passs"+udb.getPassword());


            

          if(i==1){
                request.setAttribute("msg", "you are succesfully registered please login");
                return mapping.findForward(SUCCESS);

          }
            else{
                request.setAttribute("msg1", "UserName already Exists Please try another");
                return mapping.findForward(NOTSUCCESS);
          }

        
        
    }
}
