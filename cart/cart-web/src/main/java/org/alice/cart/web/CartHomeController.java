package org.alice.cart.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartHomeController {
	private static final Logger logger = LoggerFactory.getLogger(CartHomeController.class);

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(Locale locale, Model model) {
		logger.info("Welcome home of cart web! The client locale is {}.", locale);
		
		
		return "cart";
	}
}
