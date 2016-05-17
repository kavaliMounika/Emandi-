/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.actionForm;

/**
 *
 * @author trainee
 */
public class InsertDistictActionForm extends org.apache.struts.validator.ValidatorForm{


    private int stateId;
   
    private String distictName;

  

    public String getDistictName() {
        return distictName;
    }

    public void setDistictName(String distictName) {
        this.distictName = distictName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }





    
  
    public InsertDistictActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//             TODO: add 'error.name.required' key to your resources
//        }
//        return errors;
//    }
}
