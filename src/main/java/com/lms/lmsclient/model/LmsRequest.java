package com.lms.lmsclient.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lms2000
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LmsRequest implements Serializable {

 private String sql;

}
