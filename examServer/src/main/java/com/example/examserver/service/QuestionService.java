package com.example.examserver.service;

import com.example.examserver.models.Question;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestiones();
    public Question getQuestion(Long cid);
    public void deleteQuestion(Long cid);
}
