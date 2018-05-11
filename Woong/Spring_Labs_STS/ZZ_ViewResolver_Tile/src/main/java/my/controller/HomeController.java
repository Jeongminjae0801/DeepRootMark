package my.controller;

import java.time.LocalDateTime; 
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import my.dto.Report;


@Controller
public class HomeController {

	@RequestMapping("/home.do")
	public String home() {
		return "home.home";
	}

	@RequestMapping("/internal.do")
	public String internal(Model model) {
		model.addAttribute("message", "Spring MVC Framework!");
		model.addAttribute("msg", "InternalViewResolver");
		return "internalpage.internal";
	}
	
	@RequestMapping("/beanExcel.do")
	public String beanExcel(Model model) {
		Map<String,String> revenueData = new HashMap<String,String>();
        revenueData.put("Jan-2010", "$100,000,000");
        revenueData.put("Feb-2010", "$110,000,000");
        revenueData.put("Mar-2010", "$130,000,000");
        revenueData.put("Apr-2010", "$140,000,000");
        revenueData.put("May-2010", "$200,000,000");
        
        model.addAttribute("revenueData",revenueData);

        return "myExcelView";
	}
	
	@RequestMapping("/beanPdf.do")
	public String beanPdf(Model model) {
		model.addAttribute("report", getReport());
        return "myPdfView";
	}
	
	@RequestMapping("/beanJson.do")
	public String beanJson(Model model) {
		Map<String, String> data = new HashMap<String, String>();
        data.put("data1", "value1");
        data.put("data2", "value2");
        data.put("data3", "value3");
 
        model.addAttribute("model", data);
        return "myPdfView";
	}
	
	@RequestMapping("/xml.do")
	public String xml(Model model) {
		model.addAttribute("message", "Spring MVC Framework!");
		model.addAttribute("msg", "XmlViewResolver");
		return "xmlpage.xml";
	}
	@RequestMapping("/xml2.do")
	public String xml2(Model model) {
		model.addAttribute("message", "Spring MVC Framework!");
		model.addAttribute("msg", "XmlViewResolver");
		return "xmlpage.xml2";
	}
	@RequestMapping("/xml3.do")
	public String xml3(Model model) {
		model.addAttribute("message", "Spring MVC Framework!");
		model.addAttribute("msg", "XmlViewResolver");
		return "xmlpage.xml3";
	}
	
	@RequestMapping("/bundle.do")
	public String bundle(Model model) {
		model.addAttribute("message", "Spring MVC Framework!");
		model.addAttribute("msg", "ResourceBundleViewResolver");
		return "bundlepage.bundle";
	}
	
	@RequestMapping("/bundle2.do")
	public String bundle2(Model model) {
		model.addAttribute("message", "Spring MVC Framework!");
		model.addAttribute("msg", "ResourceBundleViewResolver2");
		return "bundlepage.bundle2";
	}
	
	public Report getReport() {
		// dummy report
		Report report = new Report();
		report.setName("My Report");
		report.setContent("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. "
				+ "Aenean commodo ligula eget dolor. Aenean massa.");
		report.setDate(LocalDateTime.now());
		return report;
	}
}
