package mongo.level1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

public class SelectMongoLab {

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase db = mongoClient.getDatabase("edudb");
			MongoCollection<Document> collection = db.getCollection("banjang");
			Bson obj = Projections.fields(Projections.include("name", "age", "favoritebook"));
			MongoCursor<Document> cursor1 = collection.find().projection(obj).iterator();
			MongoCursor<Document> cursor = collection.find().iterator();
			while(cursor1.hasNext()) {
				System.out.println(cursor1.next());
			}
			while(cursor.hasNext()) {
				Document doc = cursor.next();
				System.out.println(doc.get("name")+" 팀원의 나이는 " + ((Double)doc.get("age")).intValue()+ "입니다.");
				System.out.println("[ 좋아하는 책리스트 ]");
				ArrayList<Document> list = (ArrayList<Document>) doc.get("favoritebook");
				for(Document doc1 : list) {
					System.out.println("책제목 : "+doc1.get("book"));
					System.out.println("출판사 : "+doc1.get("publisher"));
					System.out.println("장르 : "+doc1.get("genre"));
				}
				System.out.println("--------------------------------");					
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
