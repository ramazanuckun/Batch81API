package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyDeletePojo
{

private String status;
private String data;
private String message;

    public DummyDeletePojo() {
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "DummyDeletePojo{" +
                "status='" + status + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DummyDeletePojo(String status, String data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
