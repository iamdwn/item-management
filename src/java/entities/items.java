/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class items {

    private int ItemId;
    private String ItemName;
    private int price;
    private int CateId;

    public items() {
    }

    public items(int ItemId, String ItemName, int price, int CateId) {
        this.ItemId = ItemId;
        this.ItemName = ItemName;
        this.price = price;
        this.CateId = CateId;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCateId() {
        return CateId;
    }

    public void setCateId(int CateId) {
        this.CateId = CateId;
    }

}
