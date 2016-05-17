package com.myapp.javaclasses;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trainee
 */
public class VegetableDetailsBean {

    private int vegetableId;
    private String vegetableName;
    private int vegetableQuantity;
    private String name;
    private String rName;
    private int availableQuantity;

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getVegetableQuantity() {
        return vegetableQuantity;
    }

    public void setVegetableQuantity(int vegetableQuantity) {
        this.vegetableQuantity = vegetableQuantity;
    }
}
