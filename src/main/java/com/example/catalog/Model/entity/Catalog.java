package com.example.catalog.Model.entity;

public class Catalog {
    private int catalogId;
    private String catalogName;
    private boolean catalogStatus;
    private String descriptions;

    public Catalog() {
    }


    public Catalog(int catalogId, String catalogName, boolean catalogStatus, String descriptions) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.catalogStatus = catalogStatus;
        this.descriptions = descriptions;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
