package cn.gson.bookmanage.controller;

import static org.mockito.Matchers.intThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import cn.gson.bookmanage.mappers.BookMapper;
import cn.gson.bookmanage.mappers.KeywordMapper;
import cn.gson.bookmanage.model.dao.AttachDao;
import cn.gson.bookmanage.model.dao.BackDao;
import cn.gson.bookmanage.model.dao.BookDao;
import cn.gson.bookmanage.model.dao.BorrowDao;
import cn.gson.bookmanage.model.dao.ShareDao;
import cn.gson.bookmanage.model.dao.UserDao;
import cn.gson.bookmanage.model.entity.Attachment;
import cn.gson.bookmanage.model.entity.Back;
import cn.gson.bookmanage.model.entity.Book;
import cn.gson.bookmanage.model.entity.Borrow;
import cn.gson.bookmanage.model.entity.Keyword;
import cn.gson.bookmanage.model.entity.Share;
import cn.gson.bookmanage.model.entity.User;
import cn.gson.bookmanage.model.services.AttachService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	UserDao userDao;
	@Autowired
	AttachDao attachDao;
	@Autowired
	BookDao bookDao;
	@Autowired
	BackDao backDao;
	@Autowired
	BorrowDao borrowDao;
	@Autowired
	AttachService attachService;
	@Autowired
	ShareDao shareDao;
	@Autowired
	KeywordMapper keywordMapper;
	
	List<Book> blist = null;
	List<Borrow> borrows = null;
	List<Back> backs = null;
    
	@GetMapping("login")
	public String dfs(Model model) {
		model.addAttribute("fontfamily", "宋体");
		return "login";
	}
	
	
	// 注册一个用户
	@RequestMapping(value = "reg", method = RequestMethod.POST)
	public String dfssdf(Model model, @RequestParam(value = "file", required = false) MultipartFile file,
			@Valid User user, BindingResult br) throws IllegalStateException, IOException {
		// 先save这个用户得到userid 再给att去插入一条记录
		user.setMoney(100.00);
		userDao.save(user);
		if (!file.isEmpty()) {
			Attachment attachment = attachService.saveAttachment(file, user);
			user.setUserImgid(attachment.getAttachmentId());
		} else {
			// 附件上传如果为空就默认是第一个
			user.setUserImgid(27l);
		}
		user.setIsmanage(1);

		// 得到imgid再次保存
		userDao.save(user);
		return "redirect:/login";
	}

	// 注册验证
	@RequestMapping("check")
	public void sdf(HttpServletResponse Response, @RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "usernumber", required = false) String usernumber) throws IOException {
		String json1 = JSONObject.toJSONString("ok");
		Response.setHeader("Cache-Control", "no-cache");
		Response.setContentType("text/json;charset=UTF-8");
		List<User> uList = userDao.findAll();
		for (User user : uList) {
			if (user.getUserName().equals(username)) {
				json1 = JSONObject.toJSONString("该名字已经存在");
				break;
			}
			if (user.getUserNumber().equals(usernumber)) {
				json1 = JSONObject.toJSONString("该学号已经存在");
				break;
			}
		}
		String str = json1.toString().substring(1, json1.toString().length() - 1).toString();
		if (!str.equals("该学号已经存在")) {
			if (!StringUtils.isEmpty(usernumber) && !usernumber.startsWith("144081")) {
				json1 = JSONObject.toJSONString("请以144081开头");
			}
		}
		Response.getWriter().write(json1);
	}

	// 登录验证
	@RequestMapping("landcheck")
	public void dfssdf22(HttpServletResponse Response, @RequestParam(value = "number", required = false) String number)
			throws IllegalStateException, IOException {
		Response.setHeader("Cache-Control", "no-cache");
		Response.setContentType("text/json;charset=UTF-8");
		String json1 = JSONObject.toJSONString("ok");
		if (userDao.findUserByUserNameOrUserNumber(number) == null) {
			json1 = JSONObject.toJSONString("没有这个用户");
		}
		Response.getWriter().write(json1);
	}

	
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String dsad(HttpServletRequest request, HttpServletResponse Response, HttpSession session, Model model)
			throws PinyinException {
		User realuser = (User) session.getAttribute("user");

		if (!StringUtils.isEmpty(realuser)) {
			// System.out.println("真实"+realuser.toString());
			// 1表示可以使用 0是禁止使用
			blist = bookDao.findBookByIsuse(1);
			borrows = borrowDao.findBorrowsByuserId(realuser.getUserId());
			backs = backDao.findBacksByuserId(realuser.getUserId());
			Integer notreadcount = shareDao.countnotread(realuser.getUserId());
			List<Share> notreadbook = shareDao.findSharesByUserAndIsRead(realuser, 0);
			for (Iterator<Book> ite = blist.iterator(); ite.hasNext();) {
				// 拼音字段为空就设置
				Book book = ite.next();
				if (StringUtils.isEmpty(book.getPinyin()) && !StringUtils.isEmpty(book.getBookName())) {
					String bookNameString = PinyinHelper.convertToPinyinString(book.getBookName(), "",
							PinyinFormat.WITHOUT_TONE);
					book.setPinyin(bookNameString);
				}

			}
			// 提交
			bookDao.save(blist);
			
			setKeyWord(model,keywordMapper);
			model.addAttribute("noread", notreadcount);
			model.addAttribute("noreadlist", notreadbook);
			model.addAttribute("blist", blist);
			model.addAttribute("borlist", borrows);
			model.addAttribute("balist", backs);
			return "main";
		}
		return null;
	}


	public  static  void setKeyWord(Model model,KeywordMapper keywordMapper) {
		List<Keyword> kList=keywordMapper.findhotthree();
		Iterator<Keyword> kIterator=kList.iterator();
		int count=0;
		String hotKey="";
		while(kIterator.hasNext()) {
			count++;
			Keyword kword=kIterator.next();
			hotKey=kword.getRkeyword();
			if(count==1) {
				model.addAttribute("keyword1", hotKey);
			}if(count==2) {
				model.addAttribute("keyword2", hotKey);
			}if(count==3) {
				model.addAttribute("keyword3", hotKey);
			}
		}
	}

	// 登录
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String dfssdjf2(HttpSession session, User user, Model model) {
		// 上面这个user是里面只有用户名和密码
		if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
			model.addAttribute("error", "密码或者用户为空");
			return "forward:/login";
		} else {
			String pwString = userDao.findpasswordByUserNameOrUserNumber(user.getUserName());
			if (!StringUtils.isEmpty(pwString) && !pwString.equals(user.getPassword())) {
				model.addAttribute("error", "密码或者用户错误");
				model.addAttribute("userName", user.getUserName());
				return "login";
			} else {
				// 这里面是已经包装好了的user 含有所有user信息
				User realuser = userDao.findUserByUserNameOrUserNumber(user.getUserName());
				if (user.getIsmanage() != realuser.getIsmanage()) {
					model.addAttribute("error", "您的用户类型输入有误");
					// 用户名重填
					model.addAttribute("userName", user.getUserName());
					return "login";
				} else {

					model.addAttribute("user", realuser);
					model.addAttribute("fontfamily", "宋体");

					if (realuser.getIsmanage() == 0) {
						session.setAttribute("admin", realuser);
						return "redirect:/manage";
					} else {
						session.setAttribute("user", realuser);
						return "redirect:/main";
					}
				}
			}
		}

		
	}

	// 下载附件
	@RequestMapping("down")
	public void dfssdf2(HttpServletResponse response, @RequestParam(value = "userId", required = false) Long userId,
			@RequestParam(value = "bookId", required = false) Long bookId) throws IOException {
		Attachment att = null;
		if (userId != null) {
			// 得到用户的附件
			att = attachDao.findOne(userDao.findOne(userId).getUserImgid());
		}
		if (bookId != null) {
			// 得到书籍的附件
			att = attachDao.findOne(bookDao.findOne(bookId).getBookImgid());
		}
		if (!ObjectUtils.isEmpty(att)) {
			// 得到文件
			File file = attachService.get(att);
			response.setContentLength(att.getAttachmentSize().intValue());
			response.setContentType(att.getAttachmentType());
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(att.getAttachmentName().getBytes("UTF-8"), "ISO8859-1"));
			ServletOutputStream sos = response.getOutputStream();
			byte[] data = new byte[att.getAttachmentSize().intValue()];
			IOUtils.readFully(new FileInputStream(file), data);
			IOUtils.write(data, sos);
		}

	}

}
