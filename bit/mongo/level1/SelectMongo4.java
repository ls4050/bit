package mongo.level1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class SelectMongo4 {

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase db = mongoClient.getDatabase("edudb");
			MongoCollection<Document> collection = db.getCollection("datecoll");
			Document doc = collection.find().first();
			// 모든 도큐먼트중 첫번째 도큐먼트만 뽑은 것
			System.out.println(doc.toJson());
			
			
			FindIterable<Document> dlist = collection.find(Filters.eq("name", "ㅋㅋ"));
			// 몇개 추출될지 몰라서 for문 돌림
			for (var doc1 : dlist) {
				Document doc2 = doc1;
				// get메서드 이용해서 dt라는 필드 추출
				// 자바스크립트의 데이트객체는 자바.유틸.데이트로 바뀌어서 불러오기때문에 자바 api가지고 그 안의 내용을 얼마든지 자유롭게 활용할수 있다
				System.out.println(doc2.get("dt")); // 영어기반 날짜정보추출 
				
				// 자바에서 받아올때는 java.util.date로 사용해야하므로 강제형변환을 해줘야한다
				// 자바의 날짜나 시간관련 api활용
				Date d = (Date) doc2.get("dt");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM 월 dd일 HH시 mm분 ss초");
				System.out.println(sdf.format(d)); // 포맷적용해서 추출
			}
			mongoClient.close();
		} catch (Exception exception) {
			System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
		}
	}
}
