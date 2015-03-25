package net.shangtech.eshop.shop.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.shangtech.eshop.shop.constants.ScopConstants.SessionScope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CaptchaController {
	
	private static final Logger logger = LoggerFactory.getLogger(CaptchaController.class);
	
	private static final String[] CAPATCH_DIC = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	/**
	 * 输出验证码
	 * @param session
	 * @param response
	 */
	@RequestMapping("/captcha")
	public void captcha(HttpSession session, HttpServletResponse response){
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		int width = 89, height = 32;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		Random random = new Random();
		
		graphics.setColor(getRandColor(200, 250));
		graphics.fillRect(0, 0, width, height);
		
		graphics.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		
		graphics.setColor(getRandColor(160, 200));
		for(int i = 0; i < 100; i++){
			int xs = random.nextInt(width);
			int ys = random.nextInt(height);
			int dx = random.nextInt(12);
			int dy = random.nextInt(12);
			graphics.drawLine(xs, ys, xs + dx, ys + dy);
		}
		
		String sRand = "";
		for(int i = 0; i < 4; i ++){
			String rand = CAPATCH_DIC[random.nextInt(CAPATCH_DIC.length)];
			sRand += rand;
			
			graphics.setColor(new Color(20 + random.nextInt(100), 20 + random.nextInt(100), 20 + random.nextInt(100)));
			graphics.drawString(rand, 20*i + 6, 24+random.nextInt(11));
		}
		
		session.setAttribute(SessionScope.CAPTCHA_KEY, sRand);
		graphics.dispose();
		try {
	        ImageIO.write(image, "jpeg", response.getOutputStream());
        } catch (IOException e) {
	        logger.error("输出验证码异常", e);
        }
	}
	
	private Color getRandColor(int fc, int bc){
		Random random = new Random();
		if(fc > 255){
			fc = 255;
		}
		if(bc > 255){
			bc = 255;
		}
		int max = Math.abs(bc - fc);
		int r = fc + random.nextInt(max);
		int g = fc + random.nextInt(max);
		int b = fc + random.nextInt(max);
		return new Color(r, g, b);
	}
}
