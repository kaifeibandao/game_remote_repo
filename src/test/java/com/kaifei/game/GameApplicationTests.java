package com.kaifei.game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kf.game.bean.Cart;
import com.kf.game.bean.User;

import io.swagger.util.Json;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class GameApplicationTests {

	@Test
	public void contextLoads() {
		
		ObjectMapper objmapper=new ObjectMapper();
		List<Cart> obj=new ArrayList<Cart>();
		try {
			String strText="C:\\Users\\keepitup\\Desktop\\game.txt";
			JsonNode rootNode = objmapper.readTree(new File(strText)); 
			
			String resultStr=rootNode.toString();
			List userList=objmapper.readValue(resultStr,List.class);
			List<Cart> cartList=new ArrayList<>();
			for (Object object : userList) {
				String json=object.toString();
				Cart c=objmapper.readValue(json, Cart.class);
				/*User u=c.getUser();*/
				cartList.add(c);
				/*System.out.println(c);
				System.out.println(object.toString());*/
			}
			/*List<Cart> list=userList;
			
			*/
			for (Cart cart : cartList) {
				System.out.println(cart);
				System.out.println(cart.getUser());
			}
			System.out.println(userList.size());
			System.out.println(resultStr);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void contextLoads1() {
		
	}

}
