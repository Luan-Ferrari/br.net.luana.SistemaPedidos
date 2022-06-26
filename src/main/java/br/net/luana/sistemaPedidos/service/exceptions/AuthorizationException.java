package br.net.luana.sistemaPedidos.service.exceptions;

public class AuthorizationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public AuthorizationException() { super("Acesso Negado"); }

    public AuthorizationException(String msg) {
        super(msg);
    }

    public AuthorizationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}