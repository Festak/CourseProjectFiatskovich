package Fiatskovich.cartFiatskovich;


import Fiatskovich.modelFiatskovich.Product;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartInfo implements Serializable{

    private int orderNum;

    private CustomerInfo customerInfo;

    private final List<ProductViewModel> cartLines = new ArrayList<ProductViewModel>();

    public CartInfo() {

    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<ProductViewModel> getCartLines() {
        return this.cartLines;
    }

    public void addProduct(ProductViewModel product) {
    this.cartLines.add(product);
    }


    public void removeProduct(long id) {
        Iterator<ProductViewModel> it = this.cartLines.iterator();

        while (it.hasNext()) {
            ProductViewModel product = it.next();
            if (product.getId() == id)
                it.remove(); //<--- iterator safe remove
        }
    }

    public boolean isEmpty() {
        return this.cartLines.isEmpty();
    }

    public boolean isValidCustomer() {
        return this.customerInfo != null && this.customerInfo.isValid();
    }


    public double getAmountTotal() {
        double total = 0;
        for (ProductViewModel line : this.cartLines) {
            total += line.getPrice();
        }
        return total;
    }


}