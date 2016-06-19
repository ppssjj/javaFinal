package week11_1;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

/**
 * 사용자 전화번호부 클래스 
 * 
 *
 */
class Phone{
	public String addr; // 주소
	public String phone; // 전화번호
	

	/**
	 * 생성자, 전화번호를 처음 등록할 때 사용됨
	 * 
	 * @param addr  등록자 주소
	 * @param phone  등록자 전화번호
	 */
	public Phone(String addr, String phone) {
		this.addr = addr;
		this.phone = phone;
	}
	/**
	 * 등록자의 정보를 보여줌
	 * @return  "주소 전화번호"
	 */
	public String getInfo() {
		return new StringBuffer().append(this.addr).append(" ").append(this.phone)
				.toString();
	}
	
	/**
	 * 등록자가 동일한지 비교
	 * 
	 * @deprecated  한번도 사용이 안됨
	 * @param p
	 * @return
	 */
	public boolean equals(Phone p){
		if(	this.phone == p.phone && this.addr==p.addr)
			return true;
		return false;
	}
}

public class Main {
	static HashMap<String, Phone> map = new HashMap<>(); 
	static Iterator<String> itr = map.keySet().iterator();
	static int phones = 0;
	static Scanner sc = new Scanner(System.in);
	static boolean exitPhone = false;// 게임을 종료하려면 true, 아니면false
	
	public static void addPhone(String key) {
		System.out.print("주소>>");
		String addr = sc.next();
		System.out.print("전화번호>>");
		String phone = sc.next();
		if (map.get(key) == null) 
			map.put(key, new Phone(addr,phone));
		else
			System.out.println("중복된 이름이 있습니다");
	}
	public static void allPhone(){
		while(itr.hasNext()){
			String key = itr.next();
			System.out.println(key+ " " + map.get(key).getInfo());
		}
	}
	public static void deletePhone(String key){
		if(map.get(key) != null){
			map.remove(key);
			System.out.println(key + "는 삭제되었습니다.");
		}
		else
			System.out.println(key+"은 등록되지 않은 사용자입니다.");
	}
	public static void findPhone(String key){
		if(map.get(key) == null)
			System.out.println(key + "등록되지 않은 사용자 입니다.");
		else
			System.out.println(key + " " + map.get(key).getInfo());
	}

	/**
	 * 전화번호부
	 * 
	 * @param option
	 */
	public static void phoneStart(int option) {
		switch (option) {
		case 0: // 사용자 등록
			System.out.print("이름>>");
			addPhone(sc.next());
			break;
		case 1: // 사용자 삭제
			System.out.print("이름>>");
			deletePhone(sc.next());
			break;
		case 2: // 사용자 찾기
			System.out.print("이름>>");
			findPhone(sc.next());
			break;
		case 3: // 모든 사용자 표시
			itr= map.keySet().iterator();
			allPhone();
			break;
		case 4: // 프로그램 종료
			exitPhone = true;
			System.out.println("프로그램을 종료합니다...");
			break;
		default: // 프로그램 다시 돌기
			System.out.println("잘못된 번호를 입력하였습니다");
			break;
		}
	}

	public static void main(String[] args) {
		System.out.println("----------------------------");
		System.out.println("전화번호 관리 프로그램을 시작합니다. 파일로 저장하지 않습니다.");
		System.out.println("----------------------------");
		
		while (!exitPhone){ 
			System.out.println("삽입 :0, 삭제:1, 찾기 :2, 전체보기 : 3, 종료 : 4");
			phoneStart(sc.nextInt());
		}
		
	}

}