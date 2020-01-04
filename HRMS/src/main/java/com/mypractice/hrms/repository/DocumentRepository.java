/**
 * nasru
 * DocumentRepository.java
 * Jan 4, 2020
 */
package com.mypractice.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypractice.hrms.model.DocumentMaster;

/**
 * @author nasru
 *
 */
public interface DocumentRepository extends JpaRepository<DocumentMaster, String> {

}
