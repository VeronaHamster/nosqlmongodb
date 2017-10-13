package bean;

import com.mongodb.BasicDBObject;
import org.bson.Document;

public class Game implements MediaType{
    private Types name;
    private String gameDesigner;
    private String platform;

    public Game() {}

    public Game (Types name,String gameDesigner, String platform) {
        this.name = name;
        this.gameDesigner = gameDesigner;
        this.platform = platform;
    }

    public String getGameDesigner() {
        return gameDesigner;
    }

    public void setGameDesigner(String gameDesigner) {
        this.gameDesigner = gameDesigner;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Types getName() {
        return name;
    }

    public void setName(Types name) {
        this.name = name;
    }

    public BasicDBObject getBasicDBObject() {
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("Type", getName());
        basicDBObject.put("Game_designer", getGameDesigner());
        basicDBObject.put("Platform", getPlatform());
        return basicDBObject;
    }

    public Document getDocument() {
        Document document = new Document();
        document.put("Type", getName().toString());
        document.put("Game_designer", getGameDesigner());
        document.put("Platform", getPlatform());
        return document;
    }
}
