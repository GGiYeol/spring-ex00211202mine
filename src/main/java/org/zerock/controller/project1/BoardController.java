package org.zerock.controller.project1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.project1.BoardVO;
import org.zerock.service.project1.BoardService;

import lombok.Setter;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@RequestMapping("/list")
	public void list(Model model) {
		//게시물(board) 목록 가져오기(조회)
		//컨트롤러는 서비스에게 일을 시킴. 
		
		List<BoardVO> list = service.getList();
		
		//add attribute
		model.addAttribute("list", list);
		
		//forward/redirect
		//jsp path : /WEB-INF/views/board/list.jsp
		
		
	}
	// /board/get?id=10
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("id") Integer id, Model model) {
		BoardVO board = service.get(id);
		
		model.addAttribute("board", board);
//		model.addAttribute("board", service.get(id));
		
		
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		
		if(service.modify(board)) {			
			rttr.addFlashAttribute("result",  board.getId() + "번 게시글이 수정되었습니다.");
		}
		
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		service.register(board);
		
		//add attribute
		rttr.addFlashAttribute("result", board.getId() + "번 게시글이 등록되었습니다");
		
		//forward/redirect
		//책에서는 목록으로 redirect
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("id") Integer id, RedirectAttributes rttr) {
		
		if(service.remove(id)) {
			rttr.addFlashAttribute("result", id + "게시글이 삭제되었습니다");
		}
		
		return "redirect:/board/list";
	}

}

