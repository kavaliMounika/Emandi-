/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.actionForm;

/**
 *
 * @author trainee
 */
public class InsertVegetableQuantityActionForm extends org.apache.struts.validator.ValidatorForm {



    private int vegetableId;
    private int userId;
    private int vegetableQuantity;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(int vegetableId) {
        this.vegetableId = vegetableId;
    }

    public int getVegetableQuantity() {
        return vegetableQuantity;
    }

    public void setVegetableQuantity(int vegetableQuantity) {
        this.vegetableQuantity = vegetableQuantity;
    }


    
    
   
    public InsertVegetableQuantityActionForm() {
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
//            // TODO: add 'error.name.required' key to your resources
//        }
//        return errors;
//    }
}
