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

    private int saleOutNums;

    private int leftNums;

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

    public int getSaleOutNums() {
        return saleOutNums;
    }

    public void setSaleOutNums(int saleOutNums) {
        this.saleOutNums = saleOutNums;
    }

    public int getLeftNums() {
        return leftNums;
    }

    public void setLeftNums(int leftNums) {
        this.leftNums = leftNums;
    }
}
