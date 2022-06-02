package com.order.model;
/** 
 *    
 * @className: ProductVo     
 * @author: liuqi
 * @date: 2022/4/30  
 */ 
public class ProductVo {

    private String productName;

    private String departDate;

    private int stock;

    private int saleOutNum;

    private int leftNum;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSaleOutNum() {
        return saleOutNum;
    }

    public void setSaleOutNum(int saleOutNum) {
        this.saleOutNum = saleOutNum;
    }

    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
    }
}
