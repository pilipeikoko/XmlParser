package org.epam.xmltask.exception;

public class CustomXmlParserException extends Exception {
    public CustomXmlParserException() {
    }

    public CustomXmlParserException(String message) {
        super(message);
    }

    public CustomXmlParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomXmlParserException(Throwable cause) {
        super(cause);
    }
}
