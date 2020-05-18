package cn.totoro.handler;

public class ApiResult {

    public static final String DEFAULT_CODE = "success";
    private String code;
    private String msg;
    private Object data;

    public ApiResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static ApiResult success(String code,String msg,Object data){
        return new ApiResult(code,msg,data);
    }

    public static ApiResult success(String msg,Object data){
        return new ApiResult(DEFAULT_CODE,msg,data);
    }

    public static ApiResult success(String code,String msg){
        return new ApiResult(code,msg,null);
    }

    public static ApiResult fail(String code,String msg){
        return new ApiResult(code,msg,null);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
