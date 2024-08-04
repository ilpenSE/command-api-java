package dev.elite.Exceptions;

public class ArgumentException extends Exception{
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public ArgumentException() {
        super();
    }

    public ArgumentException(String msg){
        super(msg);
    }
}
