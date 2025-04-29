package com.project.withbook.common.exception;

public abstract class BaseException extends RuntimeException {

    public abstract ErrorCode getErrorCode();

}
