package com.gaurav.io.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by oracle on 4/12/16.
 */
@XmlRootElement
public class Exception {
    private int errCode;
    private String errMessage;
    private String documnetation;

    public Exception() {
    }

    public Exception(int errCode, String errMessage, String documnetation) {
        this.errCode = errCode;
        this.errMessage = errMessage;
        this.documnetation = documnetation;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getDocumnetation() {
        return documnetation;
    }

    public void setDocumnetation(String documnetation) {
        this.documnetation = documnetation;
    }
}
