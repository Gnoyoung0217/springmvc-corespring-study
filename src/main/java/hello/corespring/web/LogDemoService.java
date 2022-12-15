package hello.corespring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.corespring.common.MyLogger;

@Service
public class LogDemoService {
	private final MyLogger myLogger;
	
	@Autowired
	public LogDemoService(MyLogger myLogger) {
		this.myLogger = myLogger;
	}

	public void logic(String id) {
		myLogger.log("service id = " + id);
	}

}
