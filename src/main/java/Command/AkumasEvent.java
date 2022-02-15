package Command;

public class AkumasEvent {

    private String eventName;
    private String eventTime; // Time format: Day,Time(EST,PST)
    private String description;
    private String image;

    public AkumasEvent(String eventName, String eventTime, String description, String image){
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.description = description;
        this.image = image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getDescription() {
        return description;
    }

    public String getEventName() {
        return eventName;
    }
}
