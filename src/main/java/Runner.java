import bean.Game;
import bean.Media;
import bean.Movie;
import bean.Types;
import com.mongodb.Block;
import com.mongodb.client.MongoDatabase;
import constant.MongoProperty;
import dao.DocumentDAO;
import dao.impl.MongoDAOImpl;
import dao.manager.MongoDAOManager;
import org.bson.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Movie bladeRunner = new Movie(Types.MOVIE, "Ridley Scott", 28000000);
        Game patapon = new Game(Types.GAME, "Junichi Yoshizawa", "PlayStation Portable");
        Media movie = new Media(1,"Blade runner", LocalDate.of(1982, 06, 25), bladeRunner);
        Media game = new Media(2,"Patapon",  LocalDate.of(2007, 12, 20), patapon);

        DocumentDAO dao = new MongoDAOImpl();
        dao.saveDocument(game.getDocument());
//        dao.saveDocument(game.getBasicDBObject().toJson());


        List<Object> documents = new ArrayList<>();
        documents.add(movie.getDocument());
        documents.add(game.getDocument());
        dao.saveDocuments(documents);

//        dao.closeConnection();

        MongoDAOManager mongoDAOManager = new MongoDAOManager();
        MongoDatabase mongoDatabase = mongoDAOManager.getDataBase(MongoProperty.DB_NAME);
        System.out.println(mongoDatabase.getName());
        mongoDatabase.listCollections().forEach((Block<? super Document>) System.out::println);

//        MongoCollection collection = mongoDatabase.getCollection(MongoProperty.COLLECTION_MEDIA);
//        collection.insertMany(documents);
//
//        BasicDBObject query = new BasicDBObject();
//        query.put("Media_name", "Patapon");
//
//        BasicDBObject newObject = new BasicDBObject();
//        newObject.put("Media_name", "Patapon 3");
//
//        BasicDBObject update = new BasicDBObject();
//        update.put("$set", newObject);
//
//        collection.updateOne(query, update);
//
////        collection.insertOne(game.getDocument());
//
////        BasicDBObject search = new BasicDBObject();
////        search.put("Media_type", "GAME");
////
////        FindIterable findIterable = collection.find(search);
////
////        while (findIterable.iterator().getServerCursor().hasNext()) {
////            System.out.println(findIterable.iterator().next().;
////        }

//        collection.drop();
//        mongoClient.close();

    }
}
