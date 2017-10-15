package bean;

import com.mongodb.BasicDBObject;
import org.bson.Document;

import java.time.LocalDate;

public class Media {
    private long id;
    private String name;
    private LocalDate produceDate;
    private MediaType mediaType;

    public Media() {
    }

    public Media(long id, String name, LocalDate produceDate, MediaType mediaType) {
        this.id = id;
        this.name = name;
        this.produceDate = produceDate;
        this.mediaType = mediaType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(LocalDate produceDate) {
        this.produceDate = produceDate;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public BasicDBObject getBasicDBObject() {
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("idMedia", getId());
        basicDBObject.put("Media_name", getName());
        basicDBObject.put("Produce_date", getProduceDate().toString());
        basicDBObject.put("Media_type", getMediaType().getBasicDBObject());
        return basicDBObject;
    }

    public Document getDocument() {
        Document document = new Document();
        document.put("idMedia", getId());
        document.put("Media_name", getName());
        document.put("Produce_date", getProduceDate().toString());
        document.append("Media_type", getMediaType().getDocument());
        return document;
    }
}
