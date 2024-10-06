package com.nava.santander.controller.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse {

    private String message;
    private Integer code;
    private Object data;
    private Object errors = new ArrayList<>();

}
