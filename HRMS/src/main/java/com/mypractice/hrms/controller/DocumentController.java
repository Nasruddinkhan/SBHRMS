/**
 * nasru
 * DocumentController.java
 * Jan 4, 2020
 */
package com.mypractice.hrms.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.mypractice.hrms.exception.ResourceNotFoundException;
import com.mypractice.hrms.model.DocumentMaster;
import com.mypractice.hrms.repository.DocumentRepository;
import io.swagger.annotations.ApiOperation;

/**
 * @author nasru
 *
 */
@RestController
@RequestMapping("/hrms/api/")
public class DocumentController {
	@Autowired
	private DocumentRepository documentRepository;
	@ApiOperation(value = "add new city Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("documentmst/savedocument")
	public ResponseEntity<Object> saveDocument(@RequestBody DocumentMaster documentMaster) {
		DocumentMaster master = documentRepository.save(documentMaster);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{documentID}")
				.buildAndExpand(master.getDocumentID()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "add new Document Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/documentmst/{documentID}/document")
	public Resource<DocumentMaster> getDocument(@PathVariable String documentID) {
		Optional<DocumentMaster> documentmaster = documentRepository.findById(documentID);
		if (!documentmaster.isPresent()) 
			throw new RuntimeException("documentid is not found" + documentID);
		Resource<DocumentMaster> documentResource= new Resource<DocumentMaster>(documentmaster.get());
		ControllerLinkBuilder links= linkTo(methodOn(this.getClass()).getDocumentDetails());
		documentResource.add(links.withRel("all-document"));
		return documentResource;
	}
	@ApiOperation(value = "add new Document Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/documentmst/getDocuments")
	public List<DocumentMaster> getDocumentDetails() {
		List<DocumentMaster> docMst = documentRepository.findAll();
		if (docMst.isEmpty()) 
			throw new ResourceNotFoundException("Record Not Found");
		return docMst;
	}
	@ApiOperation(value = "add new Document Details.", notes = "Returns the  ResponseMessage  in body.")
	@DeleteMapping("/documentmst/{documentId}/deletedocument")
	public void deleteDocument(@PathVariable("documentId") String documentId) {
		Optional<DocumentMaster> documentmaster = documentRepository.findById(documentId);
		if (!documentmaster.isPresent()) 
			throw new RuntimeException("stateId is not found" + documentId);
		DocumentMaster ctyMst = documentmaster.get();
		documentRepository.delete(ctyMst);
	}


}
