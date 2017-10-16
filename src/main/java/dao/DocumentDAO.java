package dao;

import java.util.List;

/**
 * Document means smth object whitch we want to insert/delete/update/read to/from DataBase
 */
public interface DocumentDAO {
    /**
     * For MongoDB we should use {@link org.bson.Document}
     * @param document - Document
     */
    void saveDocument(Object document);

    void saveDocuments(List<Object> documents);
    void updateDocument(Object oldDocument, Object newDocument);
    void deleteDocument(String key, String value);
    Object getAllDocuments();
    Object getDocumentByCriteria();
    void closeConnection();
    void drop();
}
