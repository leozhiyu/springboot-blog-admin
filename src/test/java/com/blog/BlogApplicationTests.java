package com.blog;

import com.blog.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println();
	}

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		Map<Integer,String> map1 = new LinkedHashMap<>();
		map.put(1,"a");
		map.put(3,"c");
		map.put(2,"b");
		map.put(4,"d");
		map.keySet().stream().forEach(e->{
			System.out.println(e);
		});
		map.entrySet().stream().sorted(Map.Entry.<Integer,String>comparingByKey().reversed())
				.forEachOrdered(e -> map1.put(e.getKey(), e.getValue()));
		map1.keySet().stream().forEach(e->{
			System.out.println(e);
		});

	}



}
