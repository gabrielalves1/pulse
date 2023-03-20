package br.org.sesisc.sim.backend.responses;

public class MessageError {

    private String target;
    private String type;
    private String message;

    public MessageError(final String target, final String type, final String message) {
        this.target = target;
        this.type = type;
        this.message = message;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}