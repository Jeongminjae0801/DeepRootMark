package DI_Annotation_04;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}

	//@Autowired(required = false) //Default > true (무조건 injection) 
	@Resource(name="yy") //id값 또는 name값을 명시해서 특정 객체 주입
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setter 주입 성공");
	}
	
	
	
}







