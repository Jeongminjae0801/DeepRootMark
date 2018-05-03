package Spring_DI4;

import java.util.Scanner;

public class NewRecordView implements RecordView {
	//점수 출력 (NewRecord 객체가 필요)
	
	private NewRecord record;
	
	//1.[생성자]를 통해서 필요한 객체 생성,주입  >> DI 
	//2.함수([setter])를 통해서  필용한 객체 주입 >> DI2
	
	//public NewRecord getRecord() {
	//	return record;
	//}

	
    //Record 인터페이스를 구현하는 클래스 >> NewRecord 
	//부모 자식 관계의 다형성을 사용해서 부모타입으로  parameter 
	public void setRecord(Record record) { //함수의 parameter 로 NewRecord 객체의 주소)
		this.record = (NewRecord)record; //downcasting ......
	} 
	
	
	@Override
	public void print() {
		System.out.println(record.total() + " /" + record.avg());
	}

	@Override
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("kor:");
		record.setKor(scan.nextInt());
		
		System.out.println("eng:");
		record.setEng(scan.nextInt());
		
		System.out.println("math:");
		record.setMath(scan.nextInt());
		
	}

	
}
