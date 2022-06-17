package com.example.vue_project.controller;

import com.example.vue_project.model.VueProject;
import com.example.vue_project.repository.VueProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        try {
            List<VueProject> vueProjectList = new ArrayList<>();
            if(keyword == null) {
                vueProjectList.addAll(vueProjectRepository.findAll());
            } else {
                vueProjectList.addAll(vueProjectRepository.findByTitleContaining(keyword));
            }
            if(vueProjectList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vueProjectList, HttpStatus.OK);
        } catch(Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
        Optional<VueProject> foundVueProject = vueProjectRepository.findById(id);
        if(foundVueProject.isPresent()) {
            VueProject data = foundVueProject.get();
            data.setTitle(vueProject.getTitle());
            data.setDescription(vueProject.getDescription());
            data.setPublished(vueProject.isPublished());

            return new ResponseEntity<>(vueProjectRepository.save(data), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
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
