package com.sharry.learning.springbatch.service;

import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.exception.ExceptionHandler;

public class BatchExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(RepeatContext context, Throwable throwable) throws Throwable {
        //context.
    }

}
