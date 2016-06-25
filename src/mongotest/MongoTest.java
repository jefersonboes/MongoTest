package mongotest;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeferson
 */
public class MongoTest {

    public static void main(String[] args) {
        MongoTest mongoTest = new MongoTest();
        mongoTest.insertObjects();
        mongoTest.readObjects();
    }

    private static final String PASSWORD = "";
    private static final String USER = "";
    private static final String SERVER = "";
    private static final String DB = "";
    private static final int PORT = 0;

    private DB getDB() throws UnknownHostException {
        List<MongoCredential> credentials = new ArrayList<>();
        MongoCredential credential = MongoCredential.createCredential(USER, DB, PASSWORD.toCharArray());
        credentials.add(credential);
        ServerAddress address = new ServerAddress(SERVER, PORT);
        MongoClient client = new MongoClient(address, credentials);

        DB db = client.getDB(DB);

        return db;
    }

    private void insertObjects() {
        try {
            DB db = getDB();

            DBCollection collection = db.getCollection("test");

            BasicDBObject object = new BasicDBObject();

            object.put("key1", "value1");
            object.put("key3", "value2");
            object.put("key5", "value3");

            collection.save(object);

        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void readObjects() {
        try {
            DB db = getDB();

            DBCollection collection = db.getCollection("test");

            System.out.println(collection.count());

            try (DBCursor cursor = collection.find()) {
                while (cursor.hasNext()) {
                    DBObject ob = cursor.next();

                    System.out.println(ob);
                }
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
