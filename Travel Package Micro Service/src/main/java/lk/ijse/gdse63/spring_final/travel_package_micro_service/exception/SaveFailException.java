package lk.ijse.gdse63.spring_final.travel_package_micro_service.exception;

public class SaveFailException extends Exception{
    public SaveFailException(String message){
        super(message);
    }

    public SaveFailException(String message,Throwable cause){
        super(message,cause);
    }
}
