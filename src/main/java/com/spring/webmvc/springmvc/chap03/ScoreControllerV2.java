package com.spring.webmvc.springmvc.chap03;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import com.spring.webmvc.springmvc.chap03.service.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ScoreControllerV2 {

    private final ScoreService service;


    // 점수 등록 및 조회 화면 열기 요청
    @RequestMapping("/score/list")
    public String list(
            @RequestParam(defaultValue = "num") String sort
            , Model model) {
        log.info("/score/list GET 요청!! - param1 : {}", sort);

        List<Score> scoreList = service.listService(sort);

        model.addAttribute("scores", scoreList);
        return "chap02/score-list";
    }

    // 점수 신규 등록 요청
    @RequestMapping("/score/register")
    public String register(Score score) {
        log.info("/score/register POST! - " + score);

        return service.saveService(score) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 삭제 요청
    @RequestMapping("/score/delete")
    public String delete(@RequestParam("stuNum") int sn) {
        log.info("/score/delete GET - param1: {}", sn);
        return service.deleteService(sn) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 상세 조회 요청
    @RequestMapping("/score/detail")
    public ModelAndView detail(int stuNum) {
        log.info("/score/detail GET - param1: {}", stuNum);
        Score score = service.detailService(stuNum);
        ModelAndView mv = new ModelAndView("chap02/score-detail");
        mv.addObject("s", score);

        return mv;
    }

}
