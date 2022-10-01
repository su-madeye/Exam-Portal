package com.example.examserver.controller;

import com.example.examserver.models.Question;
import com.example.examserver.models.Quiz;
import com.example.examserver.service.QuestionService;
import com.example.examserver.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

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
        Set<Question> questions = new HashSet<>();
        questions = service.getQuestionsofQuiz(quiz);
        return ResponseEntity.ok(questions);
    }

}
