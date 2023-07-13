package org.cbioportal.controller.util;

import java.util.List;

import org.cbioportal.model.SampleIdentifier;
import org.cbioportal.model.StudyViewFilter;

public class StudyViewFilterUtil {
	public static void removeSelfFromFilter(String attributeId, StudyViewFilter studyViewFilter) {
		if (studyViewFilter != null && studyViewFilter.getClinicalDataFilters() != null) {
			studyViewFilter.getClinicalDataFilters().removeIf(f -> f.getAttributeId().equals(attributeId));
		}
	}

	public static boolean isSingleStudyUnfiltered(StudyViewFilter filter) {
		return filter.getStudyIds() != null && filter.getStudyIds().size() == 1
				&& (filter.getClinicalDataFilters() == null || filter.getClinicalDataFilters().isEmpty())
				&& (filter.getGeneFilters() == null || filter.getGeneFilters().isEmpty())
				&& (filter.getSampleTreatmentFilters() == null
						|| filter.getSampleTreatmentFilters().getFilters().isEmpty())
				&& (filter.getPatientTreatmentFilters() == null
						|| filter.getPatientTreatmentFilters().getFilters().isEmpty())
				&& (filter.getGenomicProfiles() == null || filter.getGenomicProfiles().isEmpty())
				&& (filter.getGenomicDataFilters() == null || filter.getGenomicDataFilters().isEmpty())
				&& (filter.getGenericAssayDataFilters() == null || filter.getGenericAssayDataFilters().isEmpty())
				&& (filter.getCaseLists() == null || filter.getCaseLists().isEmpty())
				&& (filter.getCustomDataFilters() == null || filter.getCustomDataFilters().isEmpty());
	}

	public static void extractStudyAndSampleIds(List<SampleIdentifier> sampleIdentifiers, List<String> studyIds,
			List<String> sampleIds) {
		for (SampleIdentifier sampleIdentifier : sampleIdentifiers) {
            studyIds.add(sampleIdentifier.getStudyId());
            sampleIds.add(sampleIdentifier.getSampleId());
        }
		
	}
}
