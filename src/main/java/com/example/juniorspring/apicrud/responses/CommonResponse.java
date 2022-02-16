package com.example.juniorspring.apicrud.responses;

public class CommonResponse<T> {
    private String status;
    private String pesan;
    private T datas;

    public CommonResponse() {
    }

    public CommonResponse(String status, String pesan, T datas) {
        this.status = status;
        this.pesan = pesan;
        this.datas = datas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }
}
