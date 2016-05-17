/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.javaclasses;

/**
 *
 * @author trainee
 */
public class FeedBackBean {

    private String feedBack;
    private String userId;
    private int typeId;
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    
    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }



}
