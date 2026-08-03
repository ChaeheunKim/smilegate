package org.example.smilegate.project.controller;

import lombok.RequiredArgsConstructor;
import org.example.smilegate.project.dto.ProjectDTO;
import org.example.smilegate.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class Project {

    private final ProjectService projectService;

    //게시글 생성
    @PostMapping(value = "/project/{user_id}", consumes = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> CreateProjectPost(@RequestPart(value = "post", required = true) ProjectDTO.ProjectRequest requestDTO,@PathVariable("user_id") Long user_id ) throws Exception {

        boolean success = projectService.CreateProject(user_id, requestDTO);

        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body("게시글 생성에 성공했습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("게시글 생성에 실패하였습니다.");
        }
    }

    //게시글 수정
    @PatchMapping(value = "/project/{user_id}/{project_id}", consumes = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> UpdateProjectPost(@RequestPart(value = "post", required = true) ProjectDTO.ProjectRequest requestDTO,@PathVariable("project_id") Long project_id ) throws Exception {

        boolean success = projectService.UpdateProject(project_id, requestDTO);

        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body("게시글 수정에 성공했습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("게시글 수정에 실패하였습니다.");
        }
    }

    //게시글 삭제
    @DeleteMapping(value = "/project/{user_id}", consumes = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> UpdateProjectPost(@PathVariable("project_id") Long project_id ) throws Exception {

        boolean success = projectService.DeleteProject(project_id);

        if (success) {
            return ResponseEntity.status(HttpStatus.OK).body("게시글 삭제에 성공했습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("게시글 삭제에 실패하였습니다.");
        }
    }


}
