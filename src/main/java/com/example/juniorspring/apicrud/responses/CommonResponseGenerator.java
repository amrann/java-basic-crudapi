package com.example.juniorspring.apicrud.responses;

import org.springframework.stereotype.Component;

@Component
public class CommonResponseGenerator<T> {
    public <T> CommonResponse<T> suksesResponse(T datas, String msg) {
        CommonResponse cr = new CommonResponse<>();
        cr.setStatus("200");
        cr.setPesan(msg);
        cr.setDatas(datas);
        return cr;
    }

    public <T> CommonResponse<T> failedResponse(String msg) {
        CommonResponse failCr = new CommonResponse<>();
        failCr.setStatus("500");
        failCr.setPesan(msg);
        return failCr;
    }
}
