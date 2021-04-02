package com.qingmi.yi.common.exception;


import com.qingmi.yi.common.exception.msg.CenterErrorMsg;
import com.qingmi.yi.common.exception.msg.FileUploadErrorMsg;

public class CenterException extends AbstractException {
    
    public CenterException(int code, String msg) {
        super(code, msg);
    }


    public CenterException(CenterException errorMsg, Throwable t) {
        super(errorMsg.getCode(),String.format(errorMsg.getMsg(),t.getMessage()) );
    }

    public CenterException(FileUploadErrorMsg errorMsg){
        super(errorMsg.getCode(),errorMsg.getMsg() );
    }
    public CenterException(CenterErrorMsg errorMsg){
        super(errorMsg.getCode(),errorMsg.getMsg() );
    }

}
