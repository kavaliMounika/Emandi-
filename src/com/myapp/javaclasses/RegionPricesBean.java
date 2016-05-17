/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.javaclasses;

/**
 *
 * @author trainee
 */
public class RegionPricesBean {

    private String regionId;
    private String vegetableName;
    private int governmentPrice;
    private int farmerPrice;
    private int wholeSellerPrice;
    private int retailerPrice;

    public int getFarmerPrice() {
        return farmerPrice;
    }

    public void setFarmerPrice(int farmerPrice) {
        this.farmerPrice = farmerPrice;
    }

    public int getGovernmentPrice() {
        return governmentPrice;
    }

    public void setGovernmentPrice(int governmentPrice) {
        this.governmentPrice = governmentPrice;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public int getRetailerPrice() {
        return retailerPrice;
    }

    public void setRetailerPrice(int retailerPrice) {
        this.retailerPrice = retailerPrice;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public int getWholeSellerPrice() {
        return wholeSellerPrice;
    }

    public void setWholeSellerPrice(int wholeSellerPrice) {
        this.wholeSellerPrice = wholeSellerPrice;
    }

    

}
