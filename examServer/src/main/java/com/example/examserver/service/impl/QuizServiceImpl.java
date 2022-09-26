package com.example.examserver.service.impl;

import com.example.examserver.models.Quiz;
import com.example.examserver.repo.QuizRepo;
import com.example.examserver.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new LinkedHashSet<>(quizRepo.findAll());
    }

    @Override
    public Quiz getQuiz(Long cid) {
        return quizRepo.findById(cid).get();
    }

    @Override
    public void deleteQuiz(Long cid) {
        quizRepo.deleteById(cid);
    }
}
