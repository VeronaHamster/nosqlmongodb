import bean.Game;
import bean.Media;
import bean.Movie;
import bean.Types;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.Cursor;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import constant.MongoProperty;
import org.bson.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        MongoDatabase mongoDatabase = getDataBase();
        System.out.println(mongoDatabase.getName());
        mongoDatabase.listCollections().forEach((Block<? super Document>) System.out::println);

        Movie bladeRunner = new Movie(Types.MOVIE, "Ridley Scott", 28000000);
        Game patapon = new Game(Types.GAME, "Junichi Yoshizawa", "PlayStation Portable");
        Media movie = new Media("Blade runner", LocalDate.of(1982, 06, 25), bladeRunner);
        Media game = new Media("Patapon",  LocalDate.of(2007, 12, 20), patapon);

//        List<BasicDBObject> documents = new ArrayList<>();
//        documents.add(movie.getBasicDBObject());
//        documents.add(game.getBasicDBObject());

        List<Document> documents = new ArrayList<>();
        documents.add(movie.getDocument());
        documents.add(game.getDocument());


        if(mongoDatabase.getCollection(MongoProperty.COLLECTION_MEDIA) == null) {
            mongoDatabase.createCollection(MongoProperty.COLLECTION_MEDIA);
        }

        MongoCollection collection = mongoDatabase.getCollection(MongoProperty.COLLECTION_MEDIA);
//        collection.insertMany(documents);

        BasicDBObject query = new BasicDBObject();
        query.put("Media_name", "Patapon");

        BasicDBObject newObject = new BasicDBObject();
        newObject.put("Media_name", "Patapon 3");

        BasicDBObject update = new BasicDBObject();
        update.put("$set", newObject);

        collection.updateOne(query, update);

        collection.insertOne(game.getDocument());

//        BasicDBObject search = new BasicDBObject();
//        search.put("Media_type", "GAME");
//
//        FindIterable findIterable = collection.find(search);
//
//        while (findIterable.iterator().getServerCursor().hasNext()) {
//            System.out.println(findIterable.iterator().next().;
//        }

//        collection.drop();

    }


    /**
     * Method gets mongoDB client instance
     * @return database client
     */
    public static MongoClient getClient() {
        return new MongoClient(MongoProperty.HOST, MongoProperty.PORT);
    }

    /**
     * Method gets MongoDatabase
     * @return database
     */
    public static MongoDatabase getDataBase() {
        return getClient().getDatabase(MongoProperty.DB_NAME);
    }

}
