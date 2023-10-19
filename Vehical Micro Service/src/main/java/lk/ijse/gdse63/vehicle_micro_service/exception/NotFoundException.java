package lk.ijse.gdse63.vehicle_micro_service.exception;

public class NotFoundException extends Exception{

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(String message,Throwable cause){
        super(message,cause);
    }
}
