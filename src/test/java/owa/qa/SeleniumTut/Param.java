package owa.qa.SeleniumTut;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Param {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {{"H","b",8,true}, {"i","y",4,false}});
//		same as:
//		Object[][] ob = new Object[2][3];
//		ob[0][0] = 1;
//		ob[0][1] = 2;
//		ob[0][2] = 3;
//		ob[1][0] = 6;
//		ob[1][1] = 7;
//		ob[1][2] = 8;
//		return Arrays.asList(ob);
	}
	
	private String a; 
	private String b; 
	private int c; 
	private boolean d; 
	
	public Param(String a, String b, int c, boolean d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d=d;
	}
	
	@Test
	public void test() {
		System.out.println(a + " " + b +" "+ c + " " + d);
	}
}