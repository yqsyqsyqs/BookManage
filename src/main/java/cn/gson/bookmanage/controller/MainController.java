package cn.gson.bookmanage.controller;



import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import cn.gson.bookmanage.common.tool.CollectionUtils;
import cn.gson.bookmanage.mappers.BookMapper;
import cn.gson.bookmanage.mappers.KeywordMapper;
import cn.gson.bookmanage.model.dao.BackDao;
import cn.gson.bookmanage.model.dao.BookDao;
import cn.gson.bookmanage.model.dao.BorrowDao;
import cn.gson.bookmanage.model.dao.CollectDao;
import cn.gson.bookmanage.model.dao.KeywordDao;
import cn.gson.bookmanage.model.dao.ShareDao;
import cn.gson.bookmanage.model.dao.UserDao;
import cn.gson.bookmanage.model.entity.Back;
import cn.gson.bookmanage.model.entity.Book;
import cn.gson.bookmanage.model.entity.Borrow;
import cn.gson.bookmanage.model.entity.Collect;
import cn.gson.bookmanage.model.entity.Keyword;
import cn.gson.bookmanage.model.entity.Share;
import cn.gson.bookmanage.model.entity.User;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	UserDao userDao;
	@Autowired
	BookDao bookDao;
	@Autowired
	BackDao backDao;
	@Autowired
	BorrowDao borrowDao;
	@Autowired
	CollectDao collectDao;
	@Autowired
	ShareDao shareDao;
	@Autowired
	BookMapper bookMapper;
	@Autowired
	KeywordDao keywordDao;
	@Autowired
	KeywordMapper keywordMapper;
	
	Keyword keyEntity=null;
	Borrow borrow=null;
	Book book=null;
	Back back=null;
	User user=null;
	@RequestMapping("logout")
	public String d(){
		return "redirect:/login";
	}
	
	@RequestMapping("share")
	public void ddsdfazzzz(HttpServletResponse response, Model model,@RequestParam(value="userName",required=false)String userName
			,@RequestParam(value="bookName",required=false)String bookName) throws IOException{
		User user= userDao.findUserByUserName(userName);
		Book book=bookDao.findBookByBookName(bookName);
		Share share=new Share();
		share.setBook(book);
		share.setIs_read(0);
		share.setUser(user);
		shareDao.save(share);
	}
	
	@RequestMapping("shareinfo")
	public void ddsdfdsazzzz(HttpServletResponse response, Model model,@RequestParam(value="userId",required=false)Long userId
			,@RequestParam(value="bookId",required=false)Long bookId) throws IOException{
		Share share=shareDao.findShareByUserAndBook(userDao.findOne(userId), bookDao.findOne(bookId));
		share.setIs_read(1);
		shareDao.save(share);
	}
	private String setjson(HttpServletResponse response) {
		String json=JSONObject.toJSONString("");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		return json;
	}
	@RequestMapping(value="find",method=RequestMethod.POST)
	public String dsaed(Model model,@RequestParam(value="research",required=false)String research
			,@RequestParam(value="userid",required=false)Long userid
			){
		//List<Book> blist=bookDao.findByBookNameOrRebulisherOrAuthor(research);
		//List<Book> blist=bookMapper.mohufind(research);
		List<Keyword> kList =keywordDao.findAll();
		if(!CollectionUtils.isEmptyList(kList)) {
			for (Keyword kword: kList) {
				String keyword=kword.getRkeyword();
					//比较关键字
					if(keyword.contains(research)||research.contains(keyword)) {
						Keyword keyword2=keywordMapper.findKeywordByRkeyword(research);
						saveKeyWord(research, keyword2);
						break;
					}else {
					    keyEntity=new Keyword();
					    saveKeyWord(research, keyEntity);
					}
			}
		}else {
			//第一次加入关键字
			keyEntity=new Keyword();
			saveKeyWord(research, keyEntity);
		}
		LoginController.setKeyWord(model,keywordMapper);
		//第一种方法
		//List<Book> blist=bookMapper.mohufind2("%"+research+"%");
		//第二种方法 bind
		//List<Book> blist=bookMapper.mohufind2(research);
		//第三种方法 封装实体类
		Book book=new Book();
		book.setBookName("%"+research+"%");
		book.setRebulisher("%"+research+"%");
		book.setAuthor("%"+research+"%");
		List<Book> blist=bookMapper.mohufind3(book);
		model.addAttribute("blist", blist);
		model.addAttribute("user", userDao.findOne(userid));
		return "mainbook";
		
	}

	private void saveKeyWord(String research, Keyword keyword2) {
		keyword2.setCreateTime(new Date());
		//更新最新的关键字
		keyword2.setRkeyword(research);
		keyword2.setKeyWordNumber(keyword2.getKeyWordNumber()+1);
		keywordDao.save(keyword2);
	}
	
	@RequestMapping("collect")
	public String dsaedd(HttpServletResponse Response,Model model,@RequestParam(value="userid",required=false)Long userid
			,@RequestParam(value="bookid",required=false)Long bookid
			){
		List<Book> bList= collectDao.findBookByUser(userid);
		model.addAttribute("blist2", bList);
		return "collect";
		
	}
	
	@RequestMapping(value="collect",method=RequestMethod.POST)
	public void dsadedd(HttpServletResponse Response,Model model,@RequestParam(value="userid",required=false)Long userid
			,@RequestParam(value="bookid",required=false)Long bookid
			){
		Collect collect=new Collect();
		collect.setBookId(bookid);
		collect.setUser(userDao.findOne(userid));
		collect.setCollectDate(new Date());
		collectDao.save(collect);
		return;
		
	}
	
		
			
	@RequestMapping(value="mainborrow",method=RequestMethod.POST)
	public void dsad(HttpServletResponse Response, Model model,
			@RequestParam(value="userid",required=false)Long userid,
			@RequestParam(value="bookid",required=false)Long bookid,
			@RequestParam(value="number",required=false)Long number) throws IOException{
		String json1 = null;out(Response, json1);
		book=bookDao.findOne(bookid);
		System.out.println(book);
		if(book.getStorenumber()-number>=0){
			//没有这个书类就新增
			if(borrowDao.findBorrowByBook(bookid,userid)==null){
				borrow=new Borrow();
				if(borrow.getBorrowNumber()==null)
					{borrow.setBorrowNumber(0l);
					borrowDao.save(borrow);}
			//给借阅类里面添加书籍数量
			saveborrow(userid, number);}
			else{
				//有这个借书类就仅仅修改
				borrow=borrowDao.findBorrowByBook(bookid,userid);
				saveborrow(userid, number);
			}
			//给库存里面减少书籍数量
			book.setStorenumber(book.getStorenumber()-number);
			bookDao.save(book);
			 json1=JSONObject.toJSONString("ok");
		}else{
			//不足只有那么几本
			json1=JSONObject.toJSONString(book.getStorenumber());
			
		}
		Response.getWriter().write(json1);
	}

	@RequestMapping(value="mainback",method=RequestMethod.POST)
	public void dsad2(HttpServletResponse Response, Model model,
			@RequestParam(value="borrowid",required=false)Long borrowid,
			@RequestParam(value="userid",required=false)Long userid,
			@RequestParam(value="bookid",required=false)Long bookid,
			@RequestParam(value="backnumber",required=false)Long backnumber) throws IOException{
		String json1 = null ;out(Response, json1);
		user= userDao.findOne(userid);
		borrow= borrowDao.findOne(borrowid);
		book=bookDao.findOne(bookid);
		//首先得到借了多长时间
		int days=(int) ((new Date().getTime()-borrow.getBorrowDate().getTime())/86400000);
		System.out.println("bornumber"+borrow.getBorrowNumber()+"number"+backnumber);
		if(borrow.getBorrowNumber()==backnumber){
			borrowDao.delete(borrowid);
			//以下代码用触发器替代
//			if(backDao.findBackByBook(bookid,userid)!=null){
//			Back back2= backDao.findBackByBook(bookid,userid);
//			backDao.delete(back2.getBackId());
//			}
			adjust(backnumber, days);
			json1=JSONObject.toJSONString("还清了");
			System.out.println("111");
		}
		if(borrow.getBorrowNumber()>backnumber){
			//没有这个书类就新增
			if(backDao.findBackByBook(bookid,userid)==null){
				back=new Back();
				if(back.getBcakNumber()==null)
					{back.setBcakNumber(0l);
					backDao.save(back);}
			//给借阅类里面添加书籍数量
				bookset(backnumber);
				}
			else{
				//有这个借书类就仅仅修改
				Back back=backDao.findBackByBook(bookid,userid);
				bookset(backnumber);
			}
			System.out.println("222");
			adjust(backnumber, days);
			reduce(backnumber);
			 json1=JSONObject.toJSONString("还没有还清o");
		}if(borrow.getBorrowNumber()<backnumber){
			//不足只有那么几本
			System.out.println("333");
			json1=JSONObject.toJSONString(borrow.getBorrowNumber());
		}
		
		Response.getWriter().write(json1);
	}
	
	private void saveborrow(Long userid, Long number) {
		borrow.setBook(book);
		borrow.setUser(userDao.findOne(userid));
		borrow.setBorrowDate(new Date());
		borrow.setBorrowNumber(borrow.getBorrowNumber()+number);
		borrowDao.save(borrow);
	}

	private void out(HttpServletResponse Response,String json1) {
		Response.setHeader("Cache-Control", "no-cache");
		Response.setContentType("text/json;charset=UTF-8");
		 json1=JSONObject.toJSONString("");
	}

	
	private void bookset(Long backnumber) {
		back.setBook(book);
		back.setUser(user);
		back.setBcakDate(new Date());
		back.setBcakNumber(back.getBcakNumber()+backnumber);
		backDao.save(back);
	}


	private void adjust(Long backnumber, int days) {
		//给库存里面增加书籍数量
		book.setStorenumber(book.getStorenumber()+backnumber);
		bookDao.save(book);
		//扣去借阅费用
		user.setMoney(user.getMoney()-days*backnumber*0.5);
		userDao.save(user);
	}


	private void reduce(Long backnumber) {
		//借书库存减少
		borrow.setBorrowNumber(borrow.getBorrowNumber()-backnumber);
		borrowDao.save(borrow);
	}
	
	
}
