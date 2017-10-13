package bean;

import com.mongodb.BasicDBObject;
import org.bson.Document;

public class Movie implements MediaType {
    private Types name;
    private String producer;
    private long budget;

    public Movie() {
    }

    public Movie(Types name, String producer, long budget) {
        this.name = name;
        this.producer = producer;
        this.budget = budget;
    }

    public Types getName() {
        return name;
    }

    public void setName(Types name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public BasicDBObject getBasicDBObject() {
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("Type", getName().toString());
        basicDBObject.put("Producer", getProducer());
        basicDBObject.put("Budget", getBudget());
        return basicDBObject;
    }

    public Document getDocument() {
        Document document = new Document();
        document.put("Type", getName().toString());
        document.put("Producer", getProducer());
        document.put("Budget", getBudget());
        return document;
    }
}
