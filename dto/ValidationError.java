package crud.projeto.master.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{
    private List<FildMessage> fildMessages = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FildMessage> getFildMessages() {
        return fildMessages;
    }
}
