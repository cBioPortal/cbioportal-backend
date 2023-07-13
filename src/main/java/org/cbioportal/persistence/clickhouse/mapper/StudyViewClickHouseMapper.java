package org.cbioportal.persistence.clickhouse.mapper;

import java.util.List;

import org.cbioportal.model.AlterationCountByGene;
import org.cbioportal.model.StudyViewFilter;
import org.cbioportal.persistence.clickhouse.ClickHouseConnMapper;

@ClickHouseConnMapper
public interface StudyViewClickHouseMapper {
	List<AlterationCountByGene> getMutatedGenes(StudyViewFilter studyViewFilter);

}
