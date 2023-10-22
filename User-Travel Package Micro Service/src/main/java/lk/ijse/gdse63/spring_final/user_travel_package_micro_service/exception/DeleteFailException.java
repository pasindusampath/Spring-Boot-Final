package lk.ijse.gdse63.spring_final.user_travel_package_micro_service.exception;

public class DeleteFailException extends Exception{
    public DeleteFailException(String message){
        super(message);
    }

    public DeleteFailException(String message, Throwable cause){
        super(message,cause);
    }
}
