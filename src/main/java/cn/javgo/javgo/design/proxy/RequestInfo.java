package cn.javgo.javgo.design.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Desc：
 *
 * @author javgo
 * @date 2024-08-10
 */
@Data
@AllArgsConstructor
public class RequestInfo {

    private String apiName;

    private long responseTime;

    private long startTimestamp;
}
