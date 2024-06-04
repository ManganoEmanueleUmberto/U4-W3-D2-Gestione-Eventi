package emanuele_mangano.Entities;

import emanuele_mangano.Enums.EventType;
import jakarta.persistence.*;

@Entity
@Table
public class Evento {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private String eventDate;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @Column
    private int maxParticipants;

    public Evento() {

    }

    public Evento(String title, String eventDate, String description, EventType eventType, int maxParticipants) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.eventType = eventType;
        this.maxParticipants = maxParticipants;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }


    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxParticipants=" + maxParticipants +
                '}';
    }

}
