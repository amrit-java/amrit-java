package com.exm.captcha;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer;

public interface CaptchaUtils {
	
	public static Captcha createCaptcha(int width, int height) {// This method is declared as static, which means you can call it without having to create an instance of the class. It takes two parameters: width and height, which define the dimensions of the generated CAPTCHA image.
		return new Captcha.Builder(width, height)//This line creates a new Captcha.Builder instance, initializing it with the provided width and height for the dimensions of the CAPTCHA image.
				.addBackground(new GradiatedBackgroundProducer())//: This method chain adds a background to the CAPTCHA image using a GradiatedBackgroundProducer. A gradiated background typically involves a smooth transition of colors.
				.addText(new DefaultTextProducer(), new DefaultWordRenderer())// using a DefaultTextProducer to generate the text,DefaultWordRenderer to render the text onto the image.
				.addNoise(new CurvedLineNoiseProducer()).build();//CurvedLineNoiseProducer. Noise is added to make it harder for automated bots to distinguish the text from the background.
	}

	public static String encodeBase64(Captcha captcha) {//This method is declared as static and takes a Captcha object as a parameter. The method's purpose is to encode the provided CAPTCHA image as a base64-encoded string.
		String image= null;// A string variable image is initialized to null. This variable will store the base64-encoded image data.
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();//This line creates a ByteArrayOutputStream, which is used to hold the binary image data before encoding.
			ImageIO.write(captcha.getImage(), "png", outputStream);//captcha.getImage() method retrieves the actual image from the Captcha object.
			byte[] arr = Base64.getEncoder().encode(outputStream.toByteArray());
			image = new String(arr);//The base64-encoded byte array is converted into a string using the constructor of the String class that takes a byte array as an argument. This creates the base64-encoded image string.
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}


//encodeBase64 method takes a Captcha image, converts it to a base64-encoded string, and returns the encoded image.
//This method is useful when you want to embed the CAPTCHA image directly into your HTML or any other context that supports base64-encoded images.