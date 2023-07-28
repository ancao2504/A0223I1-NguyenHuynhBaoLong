package ss17_IO_Binary.exercise;

import java.io.Serializable;

public class ProductManager implements Serializable {
    private int code;
    private String name;
    private String brandName;
    private double price;
    private String moreDetail;

    public ProductManager() {
    }

    public ProductManager(int code, String name, String brandName, double price, String moreDetail) {
        this.code = code;
        this.name = name;
        this.brandName = brandName;
        this.price = price;
        this.moreDetail = moreDetail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMoreDetail() {
        return moreDetail;
    }

    public void setMoreDetail(String moreDetail) {
        this.moreDetail = moreDetail;
    }

    @Override
    public String toString() {
        return "code=" + code +
                "name= " + name + '\n' +
                "brandName= " + brandName + '\n' +
                "price= " + price +'\n'+
                "moreDetail= " + moreDetail + '\n' ;
    }
}
