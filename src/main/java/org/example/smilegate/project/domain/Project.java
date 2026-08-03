package org.example.smilegate.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.smilegate.project.dto.ProjectDTO;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String project_title;
    @Column(nullable = false)
    String program_name;
    @Column(nullable = false)
    Integer year;
    String region;
    @Column(nullable = false)
    List<String> partipants;
    String description;

    ProjectCategory category;
    @Column(nullable = false)
    ProjectStatus status;
    String media_url;
    @Column(nullable = false)
    Integer view_count;
    String reject_reason;
    LocalDateTime created_at;
    LocalDateTime updated_at;

    public Project(ProjectDTO.ProjectRequest request){
        this.project_title=request.getProject_title();
        this.category=request.getCategory();
        this.media_url=request.getMedia_url();
        this.description=request.getDescription();
        this.program_name=request.getProgram_name();
        this.partipants=request.getPartipants();
        this.region=request.getRegion();
        this.status=request.getStatus();
        this.view_count=request.getView_count();
        this.year=request.getYear();
    }

    public void Update(ProjectDTO.ProjectRequest request){
        this.project_title=request.getProject_title();
        this.category=request.getCategory();
        this.media_url=request.getMedia_url();
        this.description=request.getDescription();
        this.program_name=request.getProgram_name();
        this.partipants=request.getPartipants();
        this.region=request.getRegion();
        this.status=request.getStatus();
        this.view_count=request.getView_count();
        this.year=request.getYear();
    }

}
