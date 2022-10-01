package com.example.examserver.repo;

import com.example.examserver.models.Question;
import com.example.examserver.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepo extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
