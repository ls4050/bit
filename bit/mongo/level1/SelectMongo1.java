package mongo.level1;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class SelectMongo1 {

	public static void main(String[] args) {
		// 로그에도 레벨이 있는데 SEVERE가 가장 높은 레벨
		// = SEVERE 로그 말고는 출력 안하겠다.
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		try {
			// 27017 몽고디비 접근
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase db = mongoClient.getDatabase("edudb");
			MongoCollection<Document> collection = db.getCollection("book");
			// iterator = iterable한 객체를 받아오는 것
			// cursor는 데이터를 하나하나 접근하게 해주는 역할
			// = jdbc 에서는 ResultSet
			MongoCursor<Document> cursor = collection.find().iterator();
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			System.out.println("--------------------------------");
			cursor = collection.find().iterator();
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				System.out.println(doc.get("name") + " : " + doc.get("price"));
			}
			System.out.println("--------------------------------");
			Consumer<Document> printConsumer = new Consumer<Document>() {
				@Override
				public void accept(final Document document) {
					System.out.println(document.toJson());
				}
			};
			collection.find().forEach(printConsumer);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ":" + e.getMessage());
		}
	}

}
