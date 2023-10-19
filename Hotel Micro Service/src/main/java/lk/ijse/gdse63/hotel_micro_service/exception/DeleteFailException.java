package lk.ijse.gdse63.hotel_micro_service.exception;

public class DeleteFailException extends Exception{
    public DeleteFailException(String message){
        super(message);
    }

    public DeleteFailException(String message, Throwable cause){
        super(message,cause);
    }
}
