package top.vikingyang.lovinglambs.entity.common;

public class CommonResult<T> {


    private String msg;

    private T data;

    //0 失败 1 成功
    private int code = 1;

    public CommonResult() {
    }

    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CommonResult(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public CommonResult(String msg) {
        this.msg = msg;
    }

    public CommonResult(T data){
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
