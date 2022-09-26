package com.example.examserver.service;

import com.example.examserver.models.Quiz;

import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzes();
    public Quiz getQuiz(Long cid);
    public void deleteQuiz(Long cid);
}
