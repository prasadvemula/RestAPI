package com.myretail;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class TestApp {
    public static void main(String[] args) {

        TestApp  app = new TestApp();
        Order order = app.getOrder();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        System.out.println("billing apt1:: "+order.customer.name.firstName);
        System.out.println("billing apt2:: "+orderDTO.firstName);
    }

    public Order getOrder() {
        Order order = new Order();
        Customer customer = new Customer();
        order.apt = "8Z";

        Name name = new Name();
        name.firstName = "Target";
        name.lastName = "Corp";
        customer.name = name;

        Address address = new Address();
        address.city ="MPLS";
        address.street = "110";
        order.billingAddress = address;

        order.customer =customer;
        return order;
    }
}


// Assume getters and setters on each class
@Data
class Order {
    Customer customer;
    Address billingAddress;
    String apt;

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }
}

@Data
class Customer {
    Name name;
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }


}

@Data
class Name {
    String firstName;
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}

@Data
class Address {
    String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String city;
}

@Data
class OrderDTO {
    String apt;
    String billingCity;
    String firstName;
    String customerLastName;
    String billingAddressStreet;

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String customerFirstName) {
        this.firstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getBillingAddressStreet() {
        return billingAddressStreet;
    }

    public void setBillingAddressStreet(String billingAddressStreet) {
        this.billingAddressStreet = billingAddressStreet;
    }


}