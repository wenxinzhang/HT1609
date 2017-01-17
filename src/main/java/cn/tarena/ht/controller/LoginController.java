package cn.tarena.ht.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.Encrypt;

@Controller
public class LoginController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping("toLogin")
	public String toLongin(){
		
		//请求转向登陆页面
		return "sysadmin/login/login";
	}
	
	//登陆验证
	@RequestMapping("login")
	public String login(String username,String password,Model model){
		
		//判断是否为空
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			model.addAttribute("msg", "用户名或密码不能为空");
			return "sysadmin/login/login";
		}
		
		//使用Shiro的方式进行校验
		
		//1.生成令牌   传入用户输入的username和password
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		//2.获取subject
		Subject subject = SecurityUtils.getSubject();
		
		//3.通过subject进行登陆
		
		try {
			subject.login(token);
			//如果没有抛异常 证明登陆成功
			
			//得到用户的真实对象
			User user = (User) subject.getPrincipal();
			//将user对象存入session中
			subject.getSession().setAttribute("sessionUser", user);
			return "redirect:/home.action";
			
		} catch (Exception e) {
			//进行异常的打印
			e.printStackTrace();
			model.addAttribute("msg", "用户名或密码不正确");
			return "sysadmin/login/login";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//需要将密码进行加密
		/*password = Encrypt.getMd5(username, password);
		
		
		 * 检验的规则
		 * 1.获取用户输入的用户名和密码去数据库中查找用户
		 * 如果用户对象为null 则跳转回用户登陆页面 并且提示 用户名或密码错误
		 * 如果用户对象不为null 则说明用户名和密码正确 则跳转到首页
		 
		User user = userService.findUserByU_P(username,password);
		
		if(user ==null){
			model.addAttribute("msg", "用户名或密码不正确");
			return "sysadmin/login/login";
		}
		
		//将user对象保存到session域中
		session.setAttribute("sessionUser", user);
		return "redirect:/home.action";*/
		
		
		
		
		
	}
}
