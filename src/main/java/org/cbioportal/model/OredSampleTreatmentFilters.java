package org.cbioportal.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OredSampleTreatmentFilters implements Serializable {
    private static final long serialVersionUID = -2318744686106956137L;
	private List<SampleTreatmentFilter> filters; // ored

    public boolean filter(SampleIdentifier sampleId, Map<String, Set<String>> treatments) {
        if (filters == null || filters.isEmpty()) {
            return true;
        }

        return filters.stream()
            .anyMatch(f -> f.filter(sampleId, treatments));
    }

    public List<SampleTreatmentFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<SampleTreatmentFilter> filters) {
        this.filters = filters;
    }
}

