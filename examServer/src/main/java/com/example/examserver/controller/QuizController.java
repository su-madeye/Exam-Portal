package com.example.examserver.controller;

import com.example.examserver.models.Quiz;
import com.example.examserver.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    private QuizService service;

    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(service.addQuiz(quiz));
    }

    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable Long quizId) {
        return service.getQuiz(quizId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuizzes() {
        return ResponseEntity.ok(service.getQuizzes());
    }

    @PutMapping("/")
    public Quiz updateQuiz(@RequestBody Quiz quiz) {
        return service.updateQuiz(quiz);
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable Long quizId) {
        service.deleteQuiz(quizId);
    }
}
