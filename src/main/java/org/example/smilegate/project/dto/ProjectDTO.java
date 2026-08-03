package org.example.smilegate.project.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.example.smilegate.project.domain.ProjectCategory;
import org.example.smilegate.project.domain.ProjectStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectDTO {


    @Getter
    @Setter
    public static class ProjectResponse{
        @Column(nullable = false)
        private String project_title;
        @Column(nullable = false)
        private String program_name;
        @Column(nullable = false)
        private Integer year;
        private String region;
        private ProjectCategory category;
        @Column(nullable = false)
        private ProjectStatus status;
        private String media_url;
        @Column(nullable = false)
        private Integer view_count;
    }

    @Getter
    @Setter
    public static class ProjectRequest{
        @Column(nullable = false)
        private String project_title;
        @Column(nullable = false)
        private String program_name;
        @Column(nullable = false)
        private Integer year;
        private String region;
        @Column(nullable = false)
        private List<String> partipants;
        private String description;

        private ProjectCategory category;
        @Column(nullable = false)
        private ProjectStatus status;
        private String media_url;
        @Column(nullable = false)
        private Integer view_count;
        private String reject_reason;
    }
}
