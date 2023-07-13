package org.cbioportal.controller;

import java.util.Collection;
import java.util.List;

import org.cbioportal.controller.util.StudyViewFilterUtil;
import org.cbioportal.model.AlterationCountByGene;
import org.cbioportal.model.ClinicalDataCountFilter;
import org.cbioportal.model.ClinicalDataCountItem;
import org.cbioportal.model.ClinicalDataFilter;
import org.cbioportal.model.StudyViewFilter;
import org.cbioportal.service.api.StudyViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

@RestController
public class StudyViewController {

	@Autowired
	private StudyViewService studyViewService;
	
    @PreAuthorize("hasPermission(#involvedCancerStudies, 'Collection<CancerStudyId>', T(org.cbioportal.utils.security.AccessLevel).READ)")
    @RequestMapping(value = "/clinical-data-counts/fetch", method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description="Fetch clinical data counts by study view filter")
    public ResponseEntity<List<ClinicalDataCountItem>> fetchClinicalDataCounts(
    		@Parameter(required = true, description = "Clinical data count filter")
        @Valid @RequestBody(required = false) ClinicalDataCountFilter clinicalDataCountFilter,
        @Parameter // prevent reference to this attribute in the swagger-ui interface
        @RequestAttribute(required = false, value = "involvedCancerStudies") Collection<String> involvedCancerStudies,
        @Parameter // prevent reference to this attribute in the swagger-ui interface. this attribute is needed for the @PreAuthorize tag above.
        @Valid @RequestAttribute(required = false, value = "interceptedClinicalDataCountFilter") ClinicalDataCountFilter interceptedClinicalDataCountFilter) {

        List<ClinicalDataFilter> attributes = interceptedClinicalDataCountFilter.getAttributes();
        StudyViewFilter studyViewFilter = interceptedClinicalDataCountFilter.getStudyViewFilter();
        
        if (attributes.size() == 1) {
            StudyViewFilterUtil.removeSelfFromFilter(attributes.get(0).getAttributeId(), studyViewFilter);
        }
        boolean singleStudyUnfiltered = StudyViewFilterUtil.isSingleStudyUnfiltered(studyViewFilter);
        List<ClinicalDataCountItem> result = studyViewService.getClinicalDataCounts(interceptedClinicalDataCountFilter,singleStudyUnfiltered);
        return new ResponseEntity<>(result, HttpStatus.OK);
                        
    }
	
	

	@PreAuthorize("hasPermission(#involvedCancerStudies, 'Collection<CancerStudyId>', T(org.cbioportal.utils.security.AccessLevel).READ)")
	@PostMapping(value = "/mutated-genes/fetch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(description = "Fetch mutated genes by study view filter")
	public ResponseEntity<List<AlterationCountByGene>> fetchMutatedGenes(
			@Parameter(required = true, description = "Study view filter") @Valid @RequestBody(required = false) StudyViewFilter studyViewFilter,
			@Parameter(hidden = true) // prevent reference to this attribute in the swagger-ui interface
			@RequestAttribute(required = false, value = "involvedCancerStudies") Collection<String> involvedCancerStudies,
			@Parameter(hidden = true) // prevent reference to this attribute in the swagger-ui interface. this
										// attribute is needed for the @PreAuthorize tag above.
			@Valid @RequestAttribute(required = false, value = "interceptedStudyViewFilter") StudyViewFilter interceptedStudyViewFilter) {
		return new ResponseEntity<>(studyViewService.getMutatedGenes(studyViewFilter), HttpStatus.OK);
	}
}
