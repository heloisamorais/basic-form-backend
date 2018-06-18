package br.com.portfolio.basicform.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super("Resource not found");
    }

}
