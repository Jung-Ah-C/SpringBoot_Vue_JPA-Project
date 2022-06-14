package com.example.vue_project.controller;

import com.example.vue_project.model.VueProject;
import com.example.vue_project.repository.VueProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8086")
@RestController
@RequestMapping("/api")
public class VueProjectController {
    private final VueProjectRepository vueProjectRepository;

    public VueProjectController(VueProjectRepository vueProjectRepository) {
        this.vueProjectRepository = vueProjectRepository;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<VueProject>> getAllVueProject(@RequestParam(required = false) String keyword) {
        return null;
    }

    // 데이터 검색
    @GetMapping("/findById")
    public ResponseEntity<VueProject> getVueProjectById(@PathVariable("id") long id) {
        return null;
    }

    // 데이터 추가
    @PostMapping("/add")
    public ResponseEntity<VueProject> addVueProject(@RequestBody VueProject vueProject) {
        try {
            vueProject.setPublished(false);
            VueProject savedVueProject = vueProjectRepository.save(vueProject); // insert된 id값 반환
            return new ResponseEntity<>(savedVueProject, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 데이터 수정
    @PutMapping("/update")
    public ResponseEntity<VueProject> updateVueProject(@PathVariable("id") long id, @RequestBody VueProject vueProject) {
        return null;
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<HttpStatus> deleteVueProjectById(@PathVariable("id") long id) {
        try {
            vueProjectRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllVueProject() {
        try {
            vueProjectRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
