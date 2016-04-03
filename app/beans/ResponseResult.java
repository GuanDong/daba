package beans;

import consts.DabbawalConsts;

/**
 * Created by hadoop on 2016/3/20.
 */
public class ResponseResult {
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
        this.status = DabbawalConsts.RESPONSE_RESULT_SUCCESS;
        this.result = result;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.status = DabbawalConsts.RESPONSE_RESULT_ERROR;
        this.error = error;
    }
}
