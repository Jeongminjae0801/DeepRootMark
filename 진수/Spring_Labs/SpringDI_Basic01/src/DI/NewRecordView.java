package DI;

public class NewRecordView {
	//점수 출력 (NewRecord 객체가 필요)
	private NewRecord record; //함수 밖에서 만들어서 복합연관
	public NewRecordView(int kor , int eng , int math) {
		record = new NewRecord(kor, eng, math);
		//NewRecord record = new NewRecord(kor, eng, math); //함수 안에서 만들었다면 의존
	}
	public void print() {
		System.out.println(record.total() + " /" + record.avg());
	} 
}
