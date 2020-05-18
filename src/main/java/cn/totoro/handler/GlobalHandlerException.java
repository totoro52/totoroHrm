package cn.totoro.handler;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ControllerAdvice
public class GlobalHandlerException {


    /**
     * 参数校验失败处理
     * @return
     */
    @ExceptionHandler(value = { ServletRequestBindingException.class})
    public ModelAndView parameterHandlerException(ServletRequestBindingException e){
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        model.addObject("code",-1);
        model.addObject("msg","参数校验不通过:"+e.getLocalizedMessage());
        return model;

    }

    @ExceptionHandler(value = {MalformedJwtException.class, SignatureException.class, ExpiredJwtException.class})
    public ModelAndView HandlerMalformedJwtException(){
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        model.addObject("code","tokenError");
        model.addObject("msg","Token令牌无效，请重新登录获取");
        return model;
    }



    /**
     * 错误其他处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = { Exception.class})
    public ModelAndView HandlerException(Exception e){
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        model.addObject("code",-1);
        model.addObject("msg",e.getMessage());
        return model;
    }

}
