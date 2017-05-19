package keyword.suggest.website.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubHomeController {

	@RequestMapping("footer")
	public String footer (){
		return "footer";
	}
	
	@RequestMapping("header")
	public String header (){
		return "header";
	}
}
