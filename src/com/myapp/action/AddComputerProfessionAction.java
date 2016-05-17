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

import com.myapp.Dao.AddComputerProfessionDAOImplementation;
import com.myapp.DaoIN.AddComputerProfessionInterface;
import com.myapp.actionForm.AddComputerProfessionalActionForm;
import com.myapp.javaclasses.AddComputerProfessionBean;

/**
 *
 * @author trainee
 */
public class AddComputerProfessionAction extends org.apache.struts.action.Action {
    
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

        AddComputerProfessionalActionForm acpaf =(AddComputerProfessionalActionForm)form;
        AddComputerProfessionInterface acpi = new AddComputerProfessionDAOImplementation();
        AddComputerProfessionBean acpb = new AddComputerProfessionBean();

        acpb.setRoleId(acpaf.getRoleId());
        acpb.setUserId(acpaf.getUserId());
        acpb.setName(acpaf.getName());
        acpb.setAddress(acpaf.getAddress());
        acpb.setUserName(acpaf.getUserName());
        acpb.setPassword(acpaf.getPassword());
        acpb.setPhoneNumber(acpaf.getPhoneNumber());


        int i = acpi.insert(acpb);

        if(i!=0){
                request.setAttribute("msg2", "ComputerProfesional Successfully Added");
                return mapping.findForward(SUCCESS);
        }else{
                request.setAttribute("msg1", "UserName Already Exist Please try another");
                return mapping.findForward(NOTSUCCESS);
        }
        
        
    }
}
