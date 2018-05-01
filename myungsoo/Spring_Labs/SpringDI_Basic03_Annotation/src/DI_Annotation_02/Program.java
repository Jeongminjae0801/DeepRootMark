package DI_Annotation_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class Program {

	public static void main(String[] args) {
		/*
		JAVA 코드 방식
		MonitorViewer viewer = new MonitorViewer();
		Recorder recorder = new Recorder();
		viewer.setRecorder(recorder);
		viewer.getRecorder();
		*/
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_Annotation_02/DI_Annotation_02.xml");
		MonitorViewer viewer = context.getBean("monitorViewer", MonitorViewer.class);
		System.out.println(viewer.getRecorder());
	}

}