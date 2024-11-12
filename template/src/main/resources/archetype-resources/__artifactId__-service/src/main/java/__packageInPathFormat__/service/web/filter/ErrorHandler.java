package ${package}.service.web.filter;

import com.transformer.exception.NestedRuntimeException;
import com.transformer.response.Response;
import com.transformer.response.Result;
import com.transformer.result.ResultSupport;
import com.transformer.status.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author only
 * @since 2020-05-22
 */
@ControllerAdvice
@ResponseBody
public class ErrorHandler {
    private final static Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(NestedRuntimeException.class)
    public ResultSupport handlerBusinessException(NestedRuntimeException e) {
        logger.error(e.getStatusCode(), e);
        ResultSupport result = Result.create(e);
        return result;
    }

    @ExceptionHandler(Exception.class)
    public ResultSupport handlerException(Exception e) {
        logger.error(StatusCode.SERVICE_UNAVAILABLE.getStatusCode(), e);
        return Result.create(StatusCode.SERVICE_UNAVAILABLE);
    }
}

