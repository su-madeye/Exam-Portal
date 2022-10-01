package com.example.examserver.service.impl;

import com.example.examserver.models.Question;
import com.example.examserver.models.Quiz;
import com.example.examserver.repo.QuestionRepo;
import com.example.examserver.repo.QuizRepo;
import com.example.examserver.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(questionRepo.findAll());
    }

    @Override
    public Question getQuestion(Long cid) {
        return questionRepo.findById(cid).get();
    }

    @Override
    public void deleteQuestion(Long cid) {
        questionRepo.deleteById(cid);
    }

    @Override
    public Set<Question> getQuestionsofQuiz(Quiz quiz) {
        return questionRepo.findByQuiz(quiz);
    }
}
