package org.cbioportal.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class PatientTreatmentFilter implements Serializable {
    private static final long serialVersionUID = -7129313312024374353L;
	private String treatment;

    /**
     * A sampleId should be included if the treatment row that corresponds
     * to the treatment and time in this filter contains that sampleId.
     * @param sampleId sample.STABLE_ID
     * @param treatments key is PatientTreatmentRow::calculateKey
     */
    public boolean filter(SampleIdentifier sampleId, Map<String, Set<String>> treatments) {
        Set<String> row = treatments.get(treatment);
        return row != null && row.contains(sampleId.toString());
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
