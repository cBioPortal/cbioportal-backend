package org.cbioportal.service.api;

import java.util.List;

import org.cbioportal.model.AlterationCountByGene;
import org.cbioportal.model.ClinicalDataCountFilter;
import org.cbioportal.model.ClinicalDataCountItem;
import org.cbioportal.model.StudyViewFilter;

import jakarta.validation.Valid;

public interface StudyViewService {
	List<AlterationCountByGene> getMutatedGenes(StudyViewFilter studyViewFilter);

	List<ClinicalDataCountItem> getClinicalDataCounts(@Valid ClinicalDataCountFilter interceptedClinicalDataCountFilter,
			boolean singleStudyUnfiltered);
}
