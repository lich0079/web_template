package com.lich0079.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.lich0079.entity.User;
import com.lich0079.service.UserService;
import com.lich0079.util.BaseLogAble;

@Controller
@RequestMapping("/")
public class MainController extends BaseLogAble  implements ApplicationContextAware{
	@Autowired
	private UserService userService;
    
	private static ApplicationContext context;
	
	@Autowired
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
	    context = arg0;
        
    }
	
	@RequestMapping("index")
	public String index() {
		log("index");
		return "index";
	}


	@RequestMapping(method = RequestMethod.POST, value = "login")
	public String login(@RequestParam("userName") String userName,
						@RequestParam("password") String password, HttpSession session) {
		User user = userService.login(new User(userName, password));
		if (user != null) {
			return "redirect:list.do?pageNum=1";
		} else {
			return "index";
		}

	}
	

	@RequestMapping(method = RequestMethod.GET, value = "list")
	public ModelAndView list(@RequestParam("pageNum") String pageNum) {
		int page = Integer.parseInt(pageNum); //
		int pageSize = 7; //
		List users = getUserList(pageSize, page);

		return new ModelAndView("home", "users", users);

	}

	@RequestMapping(method = RequestMethod.GET, value = "listjson")
	public @ResponseBody
	HttpEntity patientListJson(@RequestHeader(value="Range") String range) {

		String[] pageinfo =  range.split("=")[1].split("-");
		int start = Integer.parseInt(pageinfo[0]);
		int offset = Integer.parseInt(pageinfo[1]);
		int total = 1000;//TODO

		int pageSize = offset - start + 1;
		int page = offset/pageSize + 1 ;
		List patients = getUserList(pageSize, page);
		HttpHeaders headers = new HttpHeaders();
		headers.add( "Content-Range" , "items "+start+"-"+offset+"/"+total);
		return new HttpEntity<List<User>>(patients,headers);

	}

	private List getUserList(int pageSize, int page) {
		PageBounds pageBounds = new PageBounds(page, pageSize);
		List patients = userService.findUsers(pageBounds);
		return patients;
	}
	

}
