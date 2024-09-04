/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


public class FAQs {
    private int Id;
    private String CustName;
    private String CustContent;
    private int ItemId;

    public FAQs() {
    }

    public FAQs(int Id, String CustName, String CustContent, int ItemId) {
        this.Id = Id;
        this.CustName = CustName;
        this.CustContent = CustContent;
        this.ItemId = ItemId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String CustName) {
        this.CustName = CustName;
    }

    public String getCustContent() {
        return CustContent;
    }

    public void setCustContent(String CustContent) {
        this.CustContent = CustContent;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }
    
    
}
