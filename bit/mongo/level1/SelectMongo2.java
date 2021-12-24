package mongo.level1;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class SelectMongo2 {
	public static void main(String[] args) {
		//" " 에 포함되있는 모든 클래스의 로그들을 모두 무시해라
		// severe 가 아주 높은 로그레벨임(인포레벨무시)
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase db = mongoClient.getDatabase("edudb");
			MongoCollection<Document> collection = db.getCollection("book");
			MongoCursor<Document> cursor = collection.find().iterator();
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			System.out.println("--------------------------------");
			// 커서는 forward방향으로 한번만 가능
			cursor = collection.find().iterator();
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				// get을 사용하여 name이라는 필드의 값, price라는 필드의 값을 빼옴
				// get을 했을 때 Object형으로 리턴해줬으므로 
				// double로 강제형변환을 해주고 인트로 형변환해줘야한다
				System.out.println(doc.get("name") + " : " + ((Double)doc.get("price")).intValue());
				// 내가 가져온 doc이 어떤 타입인지 알수 있는 가장 빠른방법
				System.out.println(doc.get("price").getClass().getName());
			}
			System.out.println("--------------------------------");
			Consumer<Document> printConsumer1 = new Consumer<Document>() {
				@Override
				public void accept(final Document document) {
					System.out.println(document.toJson());
				}
			};
			collection.find().forEach(printConsumer1);
			System.out.println("--------------------------------");
			/*
			 *Consumer<Document> printConsumer1 =  new Consumer<Document>() {
				@Override
				public void accept(final Document document) {
					System.out.println(document.toJson());
				}
			};
			 *
			 *위의 것을 람다로 만든 식이 아래 식
			 */
			Consumer<Document> printConsumer2 = doc -> System.out.println(doc.toJson());
			collection.find().forEach(printConsumer2);
			mongoClient.close();
		} catch (Exception exception) {
			System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
		}
	}
}
