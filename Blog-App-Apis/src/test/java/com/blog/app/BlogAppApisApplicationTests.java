package com.blog.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.app.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;
	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest() {
		String clasName = this.userRepo.getClass().getName();
		String pkgName = this.userRepo.getClass().getPackageName();
		System.out.println("Class: " + clasName);
		System.out.println("Package: "+pkgName);
	}
}
