package emanuele_mangano.Exception;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(long id) {
        super("Event with ID -> " + id + " not found");
    }
}

