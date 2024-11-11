package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String shopName;
    private String ownerName;
    private long taxId;

    private List<Computer> computersList;

    public Shop(String shopName, String ownerName, long taxId, List<Computer> computersList) {
        this.shopName = shopName;
        this.ownerName = ownerName;
        this.taxId = taxId;
        this.computersList = computersList != null ? computersList : new ArrayList<>();
    }

    public Shop(String string, String string2, int i, ArrayList<Computer> arrayList) {
        this.computersList = new ArrayList<>();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getTaxId() {
        return taxId;
    }

    public void setTaxId(long taxId) {
        this.taxId = taxId;
    }

    public void addComputer(Computer computer) {
        if (computer != null) {
            computersList.add(computer);
        }
    }

    public List<Computer> getComputers() {
        return computersList;
    }

    public List<Computer> searchComputer(String brandToSearch) {
        List<Computer> computerSearched = new ArrayList<>();

        for (Computer computer : computersList) {
            if (computer.getBrand().equals(brandToSearch)) {
                computerSearched.add(computer);
            }
        }

        return computerSearched;
    }

    public void deleteComputer(String brandToDelete) {
        computersList.removeIf(computer -> computer.getBrand().equals(brandToDelete));
    }
}
