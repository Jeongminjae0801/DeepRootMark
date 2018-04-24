package DI2;

public class NewRecordView {
	//점수 출력 (NewRecord 객체가 필요)
	private NewRecord record;

	//1. 생성자를 사용해서 필용한 객체 생성 , 주입
	//2. 함수(setter)를 통해서 필요한 객체의 주입 가능
	
	
	//setter 함수를 통한 객체의 주입
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	
	public void print() {
		System.out.println(record.total() + " /" + record.avg());
	} 
}
