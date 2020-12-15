package com.rt.demo.aspect;

import com.rt.util.IpUtils;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;



@Component
public class Interceptor extends HandlerInterceptorAdapter {

    private static Logger logger = Logger.getLogger(Interceptor.class);
    private static int frequency;

    /**
     * 进入到Controller方法之前执行的内容
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        frequency++;
        // 所有请求第一个进入的方法
        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder(1000);
            HandlerMethod h = (HandlerMethod) handler;
            // Controller 的包名
            sb.append("\n").append(frequency + " > Controller    : ").append(h.getBean().getClass().getName()).append("\n");
            // 方法名称
            sb.append(frequency + " > Method        : ").append(h.getMethod().getName()).append("\n");
            // 请求方式 post\put\get 等等
            sb.append(frequency + " > RequestMethod : ").append(request.getMethod()).append("\n");
            // 所有的请求参数
            sb.append(frequency + " > Params        : ").append(getParamString(request.getParameterMap())).append("\n");
            // 部分请求链接
            sb.append(frequency + " > URI           : ").append(request.getRequestURI()).append("\n");
            // 完整的请求链接
            sb.append(frequency + " > AllURI        : ").append(request.getRequestURL().toString()).append("\n");
            // 请求方的 ip地址
            sb.append(frequency + " > request IP    : ").append(IpUtils.getIpAddress(request)).append("\n");
            sb.append(frequency + " > ------------------------").append(LocalDateTime.now().toString())
                    .append("-------------------------------------\n");
            logger.info(sb.toString());
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }


    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> e : map.entrySet()) {
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if (value != null && value.length == 1) {
                sb.append(value[0]).append("\t");
            } else {
                sb.append(Arrays.toString(value)).append("\t");
            }
        }
        return sb.toString();
    }
}
