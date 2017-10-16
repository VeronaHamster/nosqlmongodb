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
        DocumentDAO dao = new MongoDAOImpl();

//        dao.drop();
//
        Movie bladeRunner = new Movie(Types.MOVIE, "Ridley Scott", 28000000);
        Game patapon = new Game(Types.GAME, "Junichi Yoshizawa", "PlayStation Portable");
        Media movie = new Media(1,"Blade runner", LocalDate.of(1982, 06, 25), bladeRunner);
        Media game = new Media(2,"Patapon",  LocalDate.of(2007, 12, 20), patapon);
//
//        dao.saveDocument(game.getDocument());
//
//        List<Object> documents = new ArrayList<>();
//        documents.add(movie.getDocument());
//        documents.add(game.getDocument());
//        dao.saveDocuments(documents);
//
        MongoDAOManager mongoDAOManager = new MongoDAOManager();
        MongoDatabase mongoDatabase = mongoDAOManager.getDataBase(MongoProperty.DB_NAME);
        System.out.println(mongoDatabase.getName());
        mongoDatabase.listCollections().forEach((Block<? super Document>) System.out::println);

        Media newGame = new Media(3,"Patapon 3",  LocalDate.of(2011, 12, 20), patapon);
//        dao.updateDocument(game.getDocument(), newGame.getDocument());

        dao.deleteDocument("Media_name", "Patapon 3");

        dao.closeConnection();
    }
}
