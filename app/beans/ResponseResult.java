package beans;

/**
 * Created by hadoop on 2016/3/20.
 */
public class ResponseResult {
    public static final String STATUS_SUCCESS = "SUCCESS";
    public static final String STATUS_FAILURE = "FAILURE";

    private String status;
    private Object result;
    private Object error;

    public String getStatus() {
        return status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.status = STATUS_SUCCESS;
        this.result = result;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.status = STATUS_FAILURE;
        this.error = error;
    }
}
