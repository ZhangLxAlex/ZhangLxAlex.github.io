package com.model.zlx.zhanglxalex.ratelimiter.apply;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 限流模块配置
 */
@Slf4j
public class FlowRateControlUtil {

    /**
     * 限速控制器，QPS值
     */
    private static final Map<String, RateLimiter> rateLimiterMap = new HashMap<>();

    /**
     * 获取限流器
     *
     * @param limiterTag
     * @return
     */
    private static RateLimiter getRateLimiterMap(String limiterTag) {
        //此处获取配置，可以限制200QPS，写在nacos中即可
//        Double limit = ConfigurationUtils.getFlowRateLimitConfig().getFlowLimitMapStr(limiterTag);
        Double limit = 10d;

        RateLimiter rateLimiter = rateLimiterMap.get(limiterTag);
        if (null == rateLimiter) {
            rateLimiter = RateLimiter.create(limit);
            rateLimiterMap.put(limiterTag, rateLimiter);
        } else {
            if (rateLimiter.getRate() != limit) {
                rateLimiter.setRate(limit);
            }
        }
        return rateLimiter;

    }

    /**
     * 获取一下是否需要限制
     * 调用下游
     */
    public static void preFlowControl(String limiterTag) {
        if (!StringUtils.hasLength(limiterTag)) {
            limiterTag = LimitTagConstant.rateLimiterTag;
        }
        RateLimiter rateLimiter = getRateLimiterMap(limiterTag);
//        Long waitTime = ConfigurationUtils.getFlowRateLimitConfig().getWaitTimeMapStr(limiterTag);
        long start = System.currentTimeMillis();
        Boolean result = rateLimiter.tryAcquire(0, TimeUnit.SECONDS);
        log.info("[限流等待时间] limiterTag={},time={}", limiterTag, System.currentTimeMillis() - start);
        if (!result) {
            log.warn("[限流] 当前访问频率繁忙 limiterTag={} result={}", limiterTag, result);
            throw new RuntimeException("当前业务繁忙，请稍后再试！");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            try {
                if (i == 50) {
                    log.info("休息1s");
                    Thread.sleep(1000);
                }
                Long start = System.currentTimeMillis();
                //这里可以配置不同的key
                FlowRateControlUtil.preFlowControl(null);
                log.info("[限流耗时] i={}时间：{}", i, (System.currentTimeMillis() - start));

            } catch (Exception e) {
                log.info("[限流] i={}", i);
            }
        }
    }

}
