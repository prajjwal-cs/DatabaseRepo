/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-07-2025
Time: 11:51 AM
File: Customer.java */
package entity;

import java.util.Objects;

public class Customer {
    private final int ID;
    private String name;
    private String email;
    private String phone;

    public  Customer(int id) {
        ID = id;
    }

    public Customer(int id, String name, String email, String phone) {
        ID = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return ID == customer.ID && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, email, phone);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}