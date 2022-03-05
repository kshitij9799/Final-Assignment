package com.example.finalapplication;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetData {

    @SerializedName("page")
    int page;

    @SerializedName("per_page")
    int per_page;

    @SerializedName("total")
    int total;

    @SerializedName("total_pages")
    int total_pages;

    @SerializedName("data")
    ArrayList<UserData> data;

    public GetData(int page, int per_page, int total, int total_pages, ArrayList data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<UserData> getData() {
        return data;
    }

    public void setData(ArrayList<UserData> data) {
        this.data = data;
    }
}
