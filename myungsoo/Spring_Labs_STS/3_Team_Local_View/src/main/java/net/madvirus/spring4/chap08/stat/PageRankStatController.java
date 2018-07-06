package net.madvirus.spring4.chap08.stat;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageRankStatController {

	@RequestMapping("/pagestat/rank")
	public String pageRank(Model model,Bcard bcard) {
		List<PageRank> pageRanks = Arrays.asList(
				new PageRank("company", bcard.getCompany()),
				new PageRank("name", bcard.getName()),
				new PageRank("h.p", bcard.getPhone()),
				new PageRank("email", bcard.getEmail())
				);
		model.addAttribute("pageRankList", pageRanks);
		return "pageRank";
	}

	@RequestMapping("/pagestat/rankreport")
	public String pageRankReport(Model model,Bcard bcard) {
		List<PageRank> pageRanks = Arrays.asList(
				new PageRank("company", bcard.getCompany()),
				new PageRank("name", bcard.getName()),
				new PageRank("h.p", bcard.getPhone()),
				new PageRank("email", bcard.getEmail())
				);
		model.addAttribute("pageRankList", pageRanks);
		return "pageReport";
	}
}
