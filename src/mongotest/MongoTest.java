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

            for (int i = 0; i < 500000; i++) {
                BasicDBObject object = new BasicDBObject();

                object.put("key1", "value1");
                object.put("key3", "value2");
                object.put("key5", "value3");
                
                object.put("key5sadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("dsfdsff", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5sdfdsfsdfadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5sdsfdsfdfadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5s5435435adas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("544544", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5sa454das", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key535554s4353454543adas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5435435sadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5s56546543543adas", "xc");
                object.put("key534543543sadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5s43543556546adas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5s65665adas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("46ngfbmbnm546", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("dasd", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("hgjhgj", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("wqeqweqw", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("keyewqewqewqew5sadas", "xc");
                object.put("keywqewq5sadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5wqewqesadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key7896789455465sadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5645654654sadas", "xc");
                object.put("key556665sadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5665sadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5s4565464564adas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5789789789sadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5s4564587978987987adas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key59851463123127987sadas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5s8798789adas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("key5s456456546adas", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");          
                object.put("dffa2", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("dfaw34", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("fsd45", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("435f", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("sd4", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("df34", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                object.put("sad32", "value3sadasdssadasdassadasdsadsadasdsadsadsadsdsadsasadsads");
                
                collection.save(object);
            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void readObjects() {
        try {
            Mongo mongo = new Mongo();

            DB db = mongo.getDB("test");

            DBCollection collection = db.getCollection("test");

            System.out.println(collection.count());
            
            try (DBCursor cursor = collection.find()) {
                while (cursor.hasNext()) {
                    DBObject ob = cursor.next();

                    //System.out.println(ob);
                }
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
