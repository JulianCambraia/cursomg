package br.com.juliancambraia.cursomc.services.exceptions;

public class ObjectNotFoundExeption extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundExeption(String msg) {
        super(msg);
    }

    public ObjectNotFoundExeption(String msg, Throwable cause) {
        super(msg, cause);
    }

}
