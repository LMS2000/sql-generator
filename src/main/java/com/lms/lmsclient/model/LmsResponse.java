package com.lms.lmsclient.model;

import lombok.Data;

import java.io.Serializable;
/**
 * @author lms2000
 */
@Data
public class LmsResponse<T> implements Serializable {

    private int code;

    private T data;

    private String msg;
}
