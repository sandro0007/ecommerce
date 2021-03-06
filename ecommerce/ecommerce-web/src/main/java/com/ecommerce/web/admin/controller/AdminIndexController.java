/**
 * 
 */
package com.ecommerce.web.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.web.dao.UserDao;

/**
 * @author richard
 *
 */
@Controller
public class AdminIndexController {
	
	protected final Logger logger = Logger.getLogger(AdminIndexController.class);
	
	@Resource
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	@RequestMapping({ "/admin/index.ec" })
	public ModelAndView index(HttpServletRequest request,
            HttpServletResponse response, ModelMap modelMap) throws Exception {
		logger.info("start accessing admin index");
		
		getUserDao().testIfNamedQueryWorks("admin");
		return new ModelAndView("admin/index", modelMap);  
    }
	
	@RequestMapping({ "/admin/accessdenied.ec" })
	public ModelAndView accessdenied(HttpServletRequest request,
            HttpServletResponse response, ModelMap modelMap) throws Exception {
		logger.info("start accessing admin index");
		
		return new ModelAndView("admin/accessdenied", modelMap);  
    }
	
}
