package lk.ijse.gdse63.springfinal.exception;

public class SearchFailException extends Exception{
    public SearchFailException(String message){
        super(message);
    }

    public SearchFailException(String message, Throwable cause){
        super(message, cause);
    }
}
