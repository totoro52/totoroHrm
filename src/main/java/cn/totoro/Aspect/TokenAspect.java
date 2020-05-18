package cn.totoro.Aspect;

import cn.totoro.annotation.TokenAccess;
import cn.totoro.entity.User;
import cn.totoro.util.JwtUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

public class TokenAspect {

    public Object execute(ProceedingJoinPoint point) throws Throwable {
        /**
         * 先获取正在执行的方法签名
         * 通过签名获取方法
         * 判断方法或类上注释是否正确
         * 获取请求头内的token
         * 判断token是否存在
         */

        MethodSignature signature = (MethodSignature) point.getSignature();
        System.out.println("当前方法："+signature.getName());
        Method method = signature.getMethod();
        Class mClass = method.getDeclaringClass();
        System.out.println("当前类："+mClass.getName());
        if(method.isAnnotationPresent(TokenAccess.class) || mClass.isAnnotationPresent(TokenAccess.class)){
            //从Spring容器中取出我们需要的request
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if(token == null || "".equals(token)){
                throw new RuntimeException("token失效，请重新登录");
            }
            //验证不通过将直接抛异常，被异常拦截器拦截处理。
            JwtUtil.verify(token, User.class);
        }

        return point.proceed();
    }

}
