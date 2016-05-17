/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.javaclasses;

/**
 *
 * @author trainee
 */
public class InsertPriceBean {

  
    private int vegetableId;
    private int regionId;
    private int stateId;
    private int distictId;
    private float governmentPrice;
    private float wholeSellerPrice;
    private float retailerPrice;
    private float farmerPrice;

    public int getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(int vegetableId) {
        this.vegetableId = vegetableId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getDistictId() {
        return distictId;
    }

    public void setDistictId(int distictId) {
        this.distictId = distictId;
    }

    public float getGovernmentPrice() {
        return governmentPrice;
    }

    public void setGovernmentPrice(float governmentPrice) {
        this.governmentPrice = governmentPrice;
    }

    public float getWholeSellerPrice() {
        return wholeSellerPrice;
    }

    public void setWholeSellerPrice(float wholeSellerPrice) {
        this.wholeSellerPrice = wholeSellerPrice;
    }

    public float getRetailerPrice() {
        return retailerPrice;
    }

    public void setRetailerPrice(float retailerPrice) {
        this.retailerPrice = retailerPrice;
    }

    public float getFarmerPrice() {
        return farmerPrice;
    }

    public void setFarmerPrice(float farmerPrice) {
        this.farmerPrice = farmerPrice;
    }
    
}
   