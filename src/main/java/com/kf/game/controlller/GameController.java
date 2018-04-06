package com.kf.game.controlller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kf.game.bean.Cart;
import com.kf.game.bean.Goods;
import com.kf.game.bean.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/*@Consumes(
		{
			"application/json","application/xml"," multipart/form-data"
		})
@Produces(
		{
			"application/json","application/xml"
		})

@Path("/")*/
@Api(value="game")
@RestController
@RequestMapping("/game")
public class GameController {
	
	/*@Autowired
	@Qualifier("jsonMapper")
	private JsonMapper jsonMapper;*/
	
	/*@GET
	@Path("/user")*/
	@ApiOperation(value="获取用户信息")  
	@RequestMapping(value="/getUser",method=RequestMethod.GET)  
	@ApiResponse(code = 0, message = "")
	public List<User> getUser(){
		List<User> r = new ArrayList<User>();
		Goods goods=new Goods(1, "益达", 9.9);
		User u=new User();
		u.setUserId(1);
		u.setName("kaifei");
		Cart cart=new Cart(1, u);
	
		return r;
	}
	
	@ApiOperation(value="创建用户", notes="创建用户")
    @ApiImplicitParam(name = "user", value = "图书详细实体", required = true,dataType="User")
    @RequestMapping(value="saveUser", method=RequestMethod.POST)
	public User saveUser(@RequestBody User user){
		
		/*String userStr=jsonMapper.toJson(user);
		System.out.println(userStr);
		User u=jsonMapper.from
		Json(userStr, User.class);
		System.out.println(u);*/
		ObjectMapper objmapper=new ObjectMapper();
		try {
			String userStr=objmapper.writeValueAsString(user);
			System.out.println(userStr);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return user;
	}
	@ApiOperation(value="创建cart", notes="创建用户")
    @ApiImplicitParam(name = "cart", value = "图书详细实体", required = true,dataType="Cart")
    @RequestMapping(value="saveCart", method=RequestMethod.POST)
	public Cart saveCart(@RequestBody Cart cart){
		
		/*String userStr=jsonMapper.toJson(user);
		System.out.println(userStr);
		User u=jsonMapper.from
		Json(userStr, User.class);
		System.out.println(u);*/
		ObjectMapper objmapper=new ObjectMapper();
		try {
			/*将bean转化为jsonstr*/
			String cartStr=objmapper.writeValueAsString(cart);
			System.out.println(cartStr);
			JsonParser p;
			/*将jsonst转化为bean*/
			ObjectMapper mapper = new ObjectMapper(); 
			Cart c=objmapper.readValue(cartStr, Cart.class);
			User u=c.getUser();
			System.out.println("22222222222222");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	@ApiOperation(value="创建carts", notes="创建用户")
    @ApiImplicitParam(name = "carts", value = "图书详细实体", required = true,dataType="List<Cart>")
    @RequestMapping(value="saveCarts", method=RequestMethod.POST)
	public List<Cart> saveCarts(@RequestBody List<Cart> carts){
		
		
		ObjectMapper objmapper=new ObjectMapper();
		try {
			/*将bean转化为jsonsArray*/
			String cartStr=objmapper.writeValueAsString(carts);
			System.out.println(cartStr);
			JsonParser p;
			/*将jsonArray转化为List*/
			@SuppressWarnings("unchecked")
			List<Cart> userList=objmapper.readValue(cartStr,List.class);
			for (Cart cart : userList) {
				System.out.println();
			}
			System.out.println("22222222222222");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carts;
	}
}
