package com.example.vue_project.repository;

import com.example.vue_project.model.VueProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 사용할 테이블의 맵핑된 클래스, PK 명시
public interface VueProjectRepository extends JpaRepository<VueProject, Long> {
    List<VueProject> findByPublished(boolean published);
    List<VueProject> findByTitleContaining(String keyword);
}
