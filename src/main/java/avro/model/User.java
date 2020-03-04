package avro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.specific.SpecificRecord;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements SpecificRecord {

    private UUID id;
    private boolean checked;
    private Object messageContext;
    private String source;
    private Integer status;
    private UUID event;
    private Object body;
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

    @Override
    public void put(int i, Object v) {

    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public Schema getSchema() {
        return ReflectData.get().getSchema(User.class);
    }
}
