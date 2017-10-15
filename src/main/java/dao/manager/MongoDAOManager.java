package dao.manager;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import constant.MongoProperty;

public class MongoDAOManager {
    private static MongoClient instance;

    public static synchronized MongoClient getInstance() {
        if(null == instance) {
            synchronized (MongoDAOManager.class){
                instance = new MongoClient(MongoProperty.HOST, MongoProperty.PORT);
            }
        }
        return instance;
    }

    public MongoDatabase getDataBase(String dbName) {
        return instance.getDatabase(dbName);
    }
}
