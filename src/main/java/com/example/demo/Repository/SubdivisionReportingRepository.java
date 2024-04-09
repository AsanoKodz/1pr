package com.example.demo.Repository;

import com.example.demo.Models.SubdivisionReporting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubdivisionReportingRepository extends CrudRepository<SubdivisionReporting, Long> {
    public List<SubdivisionReporting> findByDocumentName(String documentName);
    public List<SubdivisionReporting> findByDocumentNameContains(String documentName);
}
