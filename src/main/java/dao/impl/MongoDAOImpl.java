package dao.impl;

import bean.Media;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import constant.MongoProperty;
import dao.DocumentDAO;
import dao.manager.MongoDAOManager;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;

public class MongoDAOImpl implements DocumentDAO {

    private MongoDAOManager mongoDAOManager = new MongoDAOManager();

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveDocument(Object document) {
        MongoDatabase mongoDatabase = MongoDAOManager.getInstance().getDatabase(MongoProperty.DB_NAME);
        MongoCollection collection = mongoDatabase.getCollection(MongoProperty.COLLECTION_MEDIA);
//        collection.dropIndex("idMedia");
//        Document keys = new Document("idMedia", 1);
//        collection.createIndex(keys, new IndexOptions().unique(true));
        collection.insertOne(document);
    }

    @Override
    public void saveDocuments(List<Object> documents) {
        MongoDatabase mongoDatabase = MongoDAOManager.getInstance().getDatabase(MongoProperty.DB_NAME);
        MongoCollection collection = mongoDatabase.getCollection(MongoProperty.COLLECTION_MEDIA);
        collection.insertMany(documents);
    }

    @Override
    public void updateDocument(Object oldDocument, Object newDocument) {
        MongoDatabase mongoDatabase = MongoDAOManager.getInstance().getDatabase(MongoProperty.DB_NAME);
        MongoCollection collection = mongoDatabase.getCollection(MongoProperty.COLLECTION_MEDIA);

//        collection.updateOne(new Document("Media_name", ((Media) oldDocument).getName()), new Document("$set", newDocument));
        collection.updateOne(new Document("Media_name", "Patapon"), new Document("$set", newDocument));

//        Object updated = collection.findOneAndUpdate(new Document("Media_name", "Patapon 3"), new Document("$set", oldDocument));
//        Object updated = collection.findOneAndUpdate(eq(newDocument.toString()), new Document("$set", oldDocument));
//        Object updated = collection.findOneAndUpdate(in(newDocument.toString()), new Document("$set", oldDocument));

//        collection.updateOne(query, update);

    }

    @Override
    public void deleteDocument(String key, String value) {
        MongoDatabase mongoDatabase = MongoDAOManager.getInstance().getDatabase(MongoProperty.DB_NAME);
        MongoCollection collection = mongoDatabase.getCollection(MongoProperty.COLLECTION_MEDIA);
        Object deleted = collection.findOneAndDelete(new Document(key, value));

    }

    @Override
    public Object getAllDocuments() {
        return null;
    }

    @Override
    public Object getDocumentByCriteria() {
        return null;
    }

    @Override
    public void closeConnection(){
        MongoDAOManager.getInstance().close();
    }

    @Override
    public void drop() {
        MongoDAOManager.getInstance().getDatabase(MongoProperty.DB_NAME).drop();
    }
}
