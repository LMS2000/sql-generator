package com.lms.lmsclient.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author lms2000
 */
@Data

public class LmsResponseBody implements Serializable {

    private String createSql;

    private Map<String, List<Map<String, Object>>> dataList;

    private String insertSql;

    private String dataJson;

    private String javaEntityCode;

    private String javaObjectCode;

    private String typescriptTypeCode;

    private static final long serialVersionUID = 7122637163626243606L;
}
