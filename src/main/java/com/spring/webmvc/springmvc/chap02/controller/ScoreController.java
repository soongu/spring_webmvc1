package com.spring.webmvc.springmvc.chap02.controller;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreMapper;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
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
public class ScoreController {

//    private final ScoreRepository repository;
    private final ScoreMapper repository;


    // 점수 등록 및 조회 화면 열기 요청
    @RequestMapping("/score/list")
    public String list(
            @RequestParam(defaultValue = "num") String sort
            , Model model) {
        log.info("/score/list GET 요청!! - param1 : {}", sort);
        // jsp에게 점수 정보 리스트를 전달해야 함.
        List<Score> scoreList = repository.findAll(sort);

        // 이름 마킹 처리
        for (Score s : scoreList) {
            String original = s.getName();
            StringBuilder markName = new StringBuilder(String.valueOf(original.charAt(0)));
            for (int i = 0; i < original.length() - 1; i++) {
                markName.append("*");
            }
            s.setName(markName.toString());
        }

        model.addAttribute("scores", scoreList);
        return "chap02/score-list";
    }

    // 점수 신규 등록 요청
    @RequestMapping("/score/register")
    public String register(Score score) {
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/score/register POST! - " + score);

        return repository.save(score) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 삭제 요청
    @RequestMapping("/score/delete")
    public String delete(@RequestParam("stuNum") int sn) {
        log.info("/score/delete GET - param1: {}", sn);
        return repository.remove(sn) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 상세 조회 요청
    @RequestMapping("/score/detail")
    public ModelAndView detail(int stuNum) {
        log.info("/score/detail GET - param1: {}", stuNum);
        Score score = repository.findOne(stuNum);
        ModelAndView mv = new ModelAndView("chap02/score-detail");
        mv.addObject("s", score);

        return mv;
    }

}
