package org.example.smilegate.project.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.smilegate.project.domain.Project;
import org.example.smilegate.project.dto.ProjectDTO;
import org.example.smilegate.project.repository.ProjectRepository;
import org.example.smilegate.user.domain.User;
import org.example.smilegate.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    //프로젝트 게시글 생성
    public boolean CreateProject(Long user_id, ProjectDTO.ProjectRequest RequestDTO) throws Exception {

        User user = userRepository.findById(user_id).orElseThrow(()-> new Exception("사용자가 존재하지 않습니다."));
        try{
            Project project = new Project(RequestDTO);
         projectRepository.save(project);
         return true; }
        catch (Exception e){
            throw new Exception(e);
        }

    }

    //프로젝트 게시물 수정
    public boolean UpdateProject(Long project_id, ProjectDTO.ProjectRequest RequestDTO) throws Exception{
        Project project = projectRepository.findById(project_id).orElseThrow(()-> new Exception("프로젝트가 존재하지 않습니다."));
        try{
            project.Update(RequestDTO);
            projectRepository.save(project);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //프로젝트 게시글 삭제
    public boolean DeleteProject(Long project_id) throws Exception{
        Project project = projectRepository.findById(project_id).orElseThrow(()-> new Exception("프로젝트가 존재하지 않습니다."));
        try{
            projectRepository.deleteById(project_id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
