package DI_Annotation_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}

	@Autowired
	@Qualifier("corder1") //<qualifier value="corder1" />
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setter 주입 성공");
	}
	
	@Autowired
	@Qualifier("corder2") //<qualifier value="corder2"></qualifier>
	public void RecorderMethod(Recorder rec) {
		System.out.println("rec : " + rec);
	}
	
}







