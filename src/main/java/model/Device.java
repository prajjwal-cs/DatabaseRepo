/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-07-2025
Time: 11:50 AM
File: Device.java */
package model;

import java.util.Objects;

public class Device {
    private int id;
    private String name;
    private String type;
    private String manufacturer;

    public Device() {
    }

    public Device(int deviceId, String deviceName, String type, String manufacturer) {
        this.id = deviceId;
        this.name = deviceName;
        this.type = type;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return id == device.id && Objects.equals(name, device.name) && Objects.equals(type, device.type) && Objects.equals(manufacturer, device.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, manufacturer);
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + id +
                ", deviceName='" + name + '\'' +
                ", type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}