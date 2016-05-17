/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.actionForm;

/**
 *
 * @author trainee
 */
public class InsertPriceActionForm extends org.apache.struts.validator.ValidatorForm {





    private int vegetableId;
    private int regionId;
    private float governmentPrice;
    private float wholeSellerPrice;
    private float retailerPrice;
    private float farmerPrice;
     private int stateId;
    private int distictId;

    public int getDistictId() {
        return distictId;
    }

    public void setDistictId(int distictId) {
        this.distictId = distictId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    

    public float getFarmerPrice() {
        return farmerPrice;
    }

    public void setFarmerPrice(float farmerPrice) {
        this.farmerPrice = farmerPrice;
    }

    

    public float getGovernmentPrice() {
        return governmentPrice;
    }

    public void setGovernmentPrice(float governmentPrice) {
        this.governmentPrice = governmentPrice;
    }

  

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public float getRetailerPrice() {
        return retailerPrice;
    }

    public void setRetailerPrice(float retailerPrice) {
        this.retailerPrice = retailerPrice;
    }

    public int getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(int vegetableId) {
        this.vegetableId = vegetableId;
    }

    public float getWholeSellerPrice() {
        return wholeSellerPrice;
    }

    public void setWholeSellerPrice(float wholeSellerPrice) {
        this.wholeSellerPrice = wholeSellerPrice;
    }


    
    
  
    public InsertPriceActionForm() {
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
