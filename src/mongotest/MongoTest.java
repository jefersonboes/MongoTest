package mongotest;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeferson
 */
public class MongoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MongoTest mongoTest = new MongoTest();
        mongoTest.insertObjects();
        mongoTest.readObjects();
    }

    private void insertObjects() {
        try {
            Mongo mongo = new Mongo();

            DB db = mongo.getDB("test");

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
            Mongo mongo = new Mongo();

            DB db = mongo.getDB("test");

            DBCollection collection = db.getCollection("test");

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
