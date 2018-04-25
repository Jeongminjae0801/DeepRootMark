package DI_Annotation_04;

import javax.annotation.Resource;

public class MonitorViewer {
	
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}

	@Resource(name="xx") //id 값  또는 name 을 명시해서  특정 객체 주입
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setter 주입 성공");
	}
	
	
	
}







