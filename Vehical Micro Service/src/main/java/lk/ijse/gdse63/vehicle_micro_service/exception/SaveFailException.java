package lk.ijse.gdse63.vehicle_micro_service.exception;

public class SaveFailException extends Exception{
    public SaveFailException(String message, Throwable cause) {
    super(message + " : "+cause.getMessage(), cause);
    }
}
