package mongo.level1;

// java로 시작하는 것들은 표준API
import java.util.logging.Level;
import java.util.logging.Logger;

// java로 시작하지 않은 것들은 서드파티API
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DeleteMongo1 {

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		try {
            MongoClient mongoClient = new MongoClient();
            MongoDatabase db = mongoClient.getDatabase("edudb");
            MongoCollection<Document> collection = db.getCollection("book");
            Bson filter = Filters.eq("name", "book1");
            collection.deleteOne(filter);
            MongoCursor<Document>  cursor  = collection.find().iterator();
            while(cursor.hasNext()) {
            	Document doc1 = cursor.next();
            	System.out.println(doc1.get("name") + " : " + doc1.get("price"));           
            }      
            // 가격이 5만보다 큰 놈들 다 삭제
            filter = Filters.gt("price", 50000);
            collection.deleteMany(filter);
            cursor  = collection.find().iterator();
            while(cursor.hasNext()) {
            	Document doc1 = cursor.next();
            	System.out.println(doc1.get("name") + " : " + doc1.get("price"));           
            }      
            mongoClient.close();
        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
	}
}


