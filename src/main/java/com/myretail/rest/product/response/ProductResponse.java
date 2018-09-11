package com.myretail.rest.product.response;


public class ProductResponse {
    private String partNumber;
    private String title;
    private String price;

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "partNumber='" + partNumber + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
