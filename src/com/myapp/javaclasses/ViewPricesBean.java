/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.javaclasses;

/**
 *
 * @author trainee
 */
public class ViewPricesBean {

    private int priceId;
    private float governmentPrice;
    private float farmerPrice;
    private float wholeSellerPrice;
    private float retailerPrice;
    private int vegetableId;
    private String vegetableName;
    private String regionName;

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public float getGovernmentPrice() {
        return governmentPrice;
    }

    public void setGovernmentPrice(float governmentPrice) {
        this.governmentPrice = governmentPrice;
    }

    public float getFarmerPrice() {
        return farmerPrice;
    }

    public void setFarmerPrice(float farmerPrice) {
        this.farmerPrice = farmerPrice;
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

    public int getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(int vegetableId) {
        this.vegetableId = vegetableId;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

}