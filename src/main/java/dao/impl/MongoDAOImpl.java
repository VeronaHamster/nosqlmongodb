package dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import constant.MongoProperty;
import dao.DocumentDAO;
import dao.manager.MongoDAOManager;

import java.util.List;

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
    public void updateDocument() {

    }

    @Override
    public void deleteDocument(Object document) {

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
}
