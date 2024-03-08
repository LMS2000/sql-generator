package com.lms.lmsclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author lms2000
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LmsResponseBody implements Serializable {


    /**
     * 建表语句
     */
    private String createSql;

    /**
     * 生成的数据，key为表名
     */
    private Map<String, List<Map<String, Object>>> dataList;

    /**
     * 插入语句
     */
    private String insertSql;

    /**
     * json化的生成数据
     */
    private String dataJson;

    /**
     * 将表改成java实体类
     */
    private String javaEntityCode;


    private String javaObjectCode;

    private String typescriptTypeCode;

    private static final long serialVersionUID = 7122637163626243606L;
}
