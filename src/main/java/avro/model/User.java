package avro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private UUID id;
    private boolean checked;
    private Object messageContext;
    private String source;
    private Integer status;
    private UUID event;
    private Object body;
    // тип канала
    private String channel;

    public boolean isChecked() {
        return checked;
    }

    public Object getMessageContext() {
        return messageContext;
    }

    public String getSource() {
        return source;
    }

    public Integer getStatus() {
        return status;
    }


    public UUID getEvent() {
        return event;
    }

    public Object getBody() {
        return body;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setMessageContext(Object messageContext) {
        this.messageContext = messageContext;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setEvent(UUID event) {
        this.event = event;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
