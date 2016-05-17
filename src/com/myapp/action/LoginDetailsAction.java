package com.myapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.myapp.Dao.LoginDetailsDao;
import com.myapp.DaoIN.LoginDetailsDaoImpl;
import com.myapp.actionForm.LoginDetailsActionForm;
import com.myapp.javaclasses.LoginDetailsBean;

public class LoginDetailsAction extends org.apache.struts.action.Action {

	private static final String SUCCESS = "success";
    private static final String NOTSUCCESS = "notsuccess";
    private static final String SUCCESS1 = "success1";
    private static final String SUCCESS2 = "success2";
    
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     
    	LoginDetailsActionForm laf = (LoginDetailsActionForm) form;
    	LoginDetailsBean lb = new LoginDetailsBean();
    	
    	lb.setUserName(laf.getUserName());
    	lb.setPassword(laf.getPassword());
    	lb.setRoleId(laf.getRoleId());
    	LoginDetailsDaoImpl ld = new LoginDetailsDao();
    	int userId = ld.loginUser(lb);
    	int roleId = lb.getRoleId();
    	
    	HttpSession hs = request.getSession();
        hs.setAttribute("id", userId);
        hs.setAttribute("userName", lb.getUserName());       
        hs.setAttribute("role", lb.getRoleId());
    	
        if (roleId == 1) {
            return mapping.findForward(SUCCESS1);
        }else if(roleId == 2){
            return mapping.findForward(SUCCESS2);

        } else if (userId != 0) {
            request.setAttribute("userId", userId);
            return mapping.findForward(SUCCESS);
        } else {
            request.setAttribute("msg1", "Authentication Failed");
            return mapping.findForward(NOTSUCCESS);
        }

     }
}
