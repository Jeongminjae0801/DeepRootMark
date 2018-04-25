package DI3;

import java.util.Scanner;

public class NewRecordView implements RecordView {
	//점수 출력 (NewRecord 객체가 필요)
	private NewRecord record;
	
	//1. 생성자를 통해서 필요한 객체 생성/주입 >> DI
	//2. 함수(setter)를 통해서 필요한 객체를 주입 >> DI2
	
/*	public NewRecord getRecord() {
		return record;
	}
*/
	// record 인터페이스를 구현하는 클래스 >> NewRecord
	// 부모자식 관계의 다형성을 사용해서 부모타입으로 파라미터 설정
	public void setRecord(Record record) {	//함수의 파라미터로 NewRecord 객체의 주소
		this.record = (NewRecord)record;
	} 
	
	@Override
	public void print() {
		System.out.println(record.total() + " / " + record.avg());
	}

	@Override
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Kor : ");
		record.setKor(scan.nextInt());
		System.out.println("Math : ");
		record.setMath(scan.nextInt());
		System.out.println("Eng : ");
		record.setEng(scan.nextInt());
	}
}
