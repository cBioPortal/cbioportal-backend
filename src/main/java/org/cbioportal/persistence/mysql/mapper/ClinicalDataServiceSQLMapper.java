package org.cbioportal.persistence.mysql.mapper;

import java.util.List;

import org.cbioportal.model.ClinicalDataCountItem;
import org.cbioportal.persistence.mysql.MySQLConnMapper;

@MySQLConnMapper
public interface ClinicalDataServiceSQLMapper {

	public List<ClinicalDataCountItem> fetchClinicalDataCounts(List<String> studyIds, List<String> sampleIds,
			List<String> collect);

}
