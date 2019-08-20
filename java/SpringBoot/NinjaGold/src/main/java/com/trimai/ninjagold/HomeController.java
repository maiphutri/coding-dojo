package com.trimai.ninjagold;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null && session.getAttribute("activities") == null) {
			ArrayList<HashMap<String, String>> activities = new ArrayList<HashMap<String, String>>();
			session.setAttribute("gold", 0);
			session.setAttribute("activities", activities);
		}
		model.addAttribute("gold", (int) session.getAttribute("gold"));
		model.addAttribute("activities", (ArrayList<HashMap<String, String>>) session.getAttribute("activities"));
		return "index.jsp";
	}
	
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
	public String gold(@RequestParam(value="building") String building, HttpSession session, Model model) {
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		String date = now.format(DateTimeFormatter.ofPattern("dd L yyyy hh:mm a"));
		int currentGold = (int) session.getAttribute("gold");
		ArrayList<HashMap<String, String>> activities = (ArrayList<HashMap<String, String>>) session.getAttribute("activities");
		HashMap<String, String> activity = new HashMap<String, String>();
		activity.put("isLost", "earned");
		
		if (building.equals("farm")) { 
			int randFarm = r.nextInt(10) + 10;
			currentGold += randFarm;
			session.setAttribute("gold", currentGold);
			activity.put("msg", "Earned " + randFarm + " golds from the Farm (" + date + ")");
			activities.add(activity);
		}
		
		if (building.equals("cave")) {
			int randCave = r.nextInt(5) + 5;
			currentGold += randCave;
			session.setAttribute("gold", currentGold);
			activity.put("msg", "Earned " + randCave + " golds from the Cave (" + date + ")");
			activities.add(activity);
		}
		
		if (building.equals("house")) {
			int randHouse = r.nextInt(3) + 2;
			currentGold += randHouse;
			session.setAttribute("gold", currentGold);
			activity.put("msg", "Earned " + randHouse + " golds from the House (" + date + ")");
			activities.add(activity);
		}
		
		if (building.equals("casino")) {
			int randCasino = r.nextInt(100) - 50;
			currentGold += randCasino;
			session.setAttribute("gold", currentGold);
			if (randCasino > 0) {
				activity.put("msg", "Earned " + randCasino + " golds from the Casino (" + date + ")");
				activities.add(activity);
			} else {
				activity.put("msg", "Earned " + randCasino + " golds from the Casino (" + date + ")");
				activity.replace("isLost", "lost");
				activities.add(activity);
			}
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", null);
		session.setAttribute("activities", null);
		return "redirect:/";
	}
}
