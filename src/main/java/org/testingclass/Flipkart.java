package org.testingclass;
import java.awt.AWTException;

import baseclass.hotel.FlipkartBase;
import baseclass.hotel.FlipkartpageClass;
public class Flipkart extends FlipkartBase {
	public static void main(String[] args) throws AWTException, InterruptedException {
	lanchbrowser("chrome");
	lanchUrl("https://www.flipkart.com/");
	implicitywait(10);
	escBtn();
	FlipkartpageClass f = new FlipkartpageClass();
	sendKeys(f.getProductSearch(), "iPhone");
	btnclick(f.getBtnsubmit());
	System.out.println("============================Page 1 Products=======================");
	System.out.println();
	listOfProducts();
	System.out.println();
	for (int i = 0; i < 4; i++) {
		System.out.println("=====================Page "+(i+2)+" Products================");
		System.out.println();
		btnclick(f.getPageList().get(i));
		threadsleep(5000);
		listOfProducts();
		System.out.println();
	}
	quitBrowser();
	}
}
