package vo;

// 요청은 servlets이, CountVO는 서블릿이 생성
// 응답은 JSP가 하게끔
// 그러므로 브라우저에서 요청할대상은 서블릿
public class CountVO {
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number += number;
	}
}
