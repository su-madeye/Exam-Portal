package com.example.examserver.controller;

import com.example.examserver.models.Question;
import com.example.examserver.models.Quiz;
import com.example.examserver.service.QuestionService;
import com.example.examserver.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService service;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(service.addQuestion(question));
    }

    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable Long questionId) {
        return service.getQuestion(questionId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuestions() {
        return ResponseEntity.ok(service.getQuestions());
    }

    @PutMapping("/")
    public Question updateQuestion(@RequestBody Question question) {
        return service.updateQuestion(question);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable Long questionId) {
        service.deleteQuestion(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> questionsOfQuiz(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuiz(quizId);
        Set<Question> questions = quiz.getQuestionSet();
        List list  = new ArrayList(questions);
        Collections.shuffle(list);
        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestion())) {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion()) + 1);
        }
        return ResponseEntity.ok(list);
    }

}
