package hello.corespring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.corespring.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LogDemoController {
	private final LogDemoService logDemoService;
	private final MyLogger myLogger;
	
	@Autowired
	public LogDemoController(LogDemoService logDemoService,MyLogger myLogger) {
		this.logDemoService = logDemoService;
		this.myLogger = myLogger;
	}
	
	
	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		String requestURL = request.getRequestURL().toString();
		myLogger.setRequestURL(requestURL);
		
		myLogger.log("Controller Tetst");
		logDemoService.logic("testId");
		return "OK";
	}
}