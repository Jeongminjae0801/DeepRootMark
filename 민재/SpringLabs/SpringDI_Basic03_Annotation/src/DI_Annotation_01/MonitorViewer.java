package DI_Annotation_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
public class MonitorViewer {

	/*1단계 : xml 설정파일 기반의 DI 작업
	  <bean id="viewer" class="DI_Annotation_01.MonitorViewer">
	  	<property name="recorder" >
	  		<ref bean="recorder"/>
	  	</property>
	  </bean>  
	  <bean id="recorder" class="DI_Annotation_01.Recorder"></bean>
	*/
	
	// 2단계 : Annotation 기반으로 DI 작업 (injection 자원 : 생성자 주입 / setter 주입 / 멤버 필드 주입
/*
	@Autowired
	private Recorder recorder;
	
	public Recorder getRecorder() {
		return recorder;
	}
	*/
	
	// 3단계 : Annotation 기반으로 DI 작업 // setter를 통한 주입

	private Recorder recorder;
	
	public Recorder getRecorder() {	
		return recorder;
	}
	
	@Autowired
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	
}
