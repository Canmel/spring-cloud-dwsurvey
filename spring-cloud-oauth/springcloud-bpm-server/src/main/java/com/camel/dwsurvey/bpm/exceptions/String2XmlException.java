package com.camel.dwsurvey.bpm.exceptions;

public class String2XmlException extends RuntimeException {
    public String2XmlException() {
        super("流程数据结构不正确");
    }
}
