package cn.gson.bookmanage.controller;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import cn.gson.bookmanage.common.Procedure;
import cn.gson.bookmanage.model.dao.BookDao;
import cn.gson.bookmanage.model.dao.OldbookDao;
import cn.gson.bookmanage.model.dao.RecordDao;
import cn.gson.bookmanage.model.dao.ThemeDao;
import cn.gson.bookmanage.model.dao.UserDao;
import cn.gson.bookmanage.model.entity.Attachment;
import cn.gson.bookmanage.model.entity.Book;
import cn.gson.bookmanage.model.entity.Record;
import cn.gson.bookmanage.model.entity.Theme;
import cn.gson.bookmanage.model.entity.User;
import cn.gson.bookmanage.model.services.AttachService;

@Controller
@RequestMapping("/")
public class ManageController {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	BookDao bookDao;
	@Autowired
	UserDao userDao;
	@Autowired
	AttachService attachService;
	@Autowired
	OldbookDao oldbookDao;
	@Autowired
	RecordDao recordDao;
	@Autowired
	ThemeDao themeDao;
	
	
	@GetMapping("manage")
	public String showfewbodok(Model  model){
		return "manage";
	}
	@RequestMapping("easyui")
	public String showfewbook(Model  model){
		return "easyui-study";
	}
	
	@RequestMapping("datagrid")
	@ResponseBody
	public List<Book> showbook(Model  model){
		List<Book> blist= bookDao.findBookByIsuse(1);
		System.out.println("书籍信息"+blist);
		return blist;
	}

	// 书籍信息
	@RequestMapping("booklist")
	public String fds3(Model  model) {
		List<Book> blist= bookDao.findBookByIsuse(0);
		List<Theme> tList= themeDao.findAll();
		 model.addAttribute("blist3", blist);
		 model.addAttribute("tlist", tList);
		return "booklist";
	}

	@RequestMapping(value="booklist",method=RequestMethod.POST)
	public void fDSds3(@RequestParam("bookid")Long bookid) {
		choosebook(bookid,1);
	}

	
	@RequestMapping("newbook")
	public String fDSds31() {
		return "newbook";
	}
	
	//提交新书
	@RequestMapping(value="getbook",method=RequestMethod.POST)
	public String fds3ww(Model  model, 
			@RequestParam(value="file",required=false)MultipartFile file, 
			@Valid Book book,BindingResult br) throws ParseException, IllegalStateException, IOException, PinyinException {
		if(br.hasErrors()){
			model.addAttribute("message", "有错误");
			return "newbook";
		}else{
		bookDao.save(book);
		if(!file.isEmpty()){
			Attachment attachment=  attachService.saveAttachment(file,book);
			book.setBookImgid(attachment.getAttachmentId());
		}else{
			//附件上传如果为空就默认是第一个
			book.setBookImgid(61l);
		}
		//1是表示可以使用
		book.setIsuse(1);
		//得到imgid再次保存
		bookDao.save(book);
		model.addAttribute("message", "提交成功了");
		return "newbook";
		}
	}
	
	// 老书注销
	@RequestMapping("oldbook")
	public String fds3qw(Model  model) {
		List<Book> blist= bookDao.findBookByIsuse(1);
		 model.addAttribute("blist4", blist);
		return "oldbook";
	}
	
	@RequestMapping(value="oldbook",method=RequestMethod.POST)
	public void S(@RequestParam("bookid")Long bookid ) {
		choosebook(bookid,0);
		return;
	}

	// 用户充值
	@RequestMapping("recharge")
	public String fds3qwwq() {
		return "recharge";
	}
	@RequestMapping(value="charge",method=RequestMethod.POST)
	public void fds3qwewq(HttpServletResponse Response, Model model, @RequestParam("chargename")String chargename,
			@RequestParam("chargemoney")Double chargemoney
			) throws IOException {
		String json1=JSONObject.toJSONString("");
		Response.setHeader("Cache-Control", "no-cache");
		Response.setContentType("text/json;charset=UTF-8");
		if(userDao.findUserByUserNameOrUserNumber(chargename)==null){
			json1=JSONObject.toJSONString("错误");
		}else{
			User user=userDao.findUserByUserNameOrUserNumber(chargename);
			user.setMoney(user.getMoney()+chargemoney);
			userDao.save(user);
			Record  record=new Record();
			record.setChongzhidate(new Date());
			record.setMoney(chargemoney);
			record.setUser(user);
			recordDao.save(record);
			json1=JSONObject.toJSONString("提交成功");
		}
		Response.getWriter().write(json1);
		
	}
	
	// 更改主题
	@RequestMapping("theme")
	public String fdwqs3(Model model) {
		List<Theme> tList= themeDao.findAll();
		model.addAttribute("tlist", tList);
		return "theme";
	}
	
	@RequestMapping("apply")
	public String fdwqsw3(Model model,@RequestParam("themeid")Long themeid,HttpSession session) {
		Theme theme= themeDao.findOne(themeid);
		session.setAttribute("fontfamily", theme.getFontfamily());
		return "redirect:/theme";
	}
	private void choosebook(Long bookid,Integer r) {
		new Procedure().callProcedureY(bookid,r,"Updatebook");
//		Book book=bookDao.findOne(bookid);
//		book.setIsuse(r);
//		bookDao.save(book);
	}


}
