/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.actionForm;

/**
 *
 * @author trainee
 */
public class InsertVegetableDetailsActionForm extends org.apache.struts.validator.ValidatorForm {

    private int VegetableId;
    private String VegetableName;

    public int getVegetableId() {
        return VegetableId;
    }

    public void setVegetableId(int VegetableId) {
        this.VegetableId = VegetableId;
    }

    public String getVegetableName() {
        return VegetableName;
    }

    public void setVegetableName(String VegetableName) {
        this.VegetableName = VegetableName;
    }

    public InsertVegetableDetailsActionForm() {
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
