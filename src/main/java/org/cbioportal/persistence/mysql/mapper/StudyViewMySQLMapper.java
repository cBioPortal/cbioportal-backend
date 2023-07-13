package org.cbioportal.persistence.mysql.mapper;

import java.util.List;

import org.cbioportal.model.AlterationCountByGene;
import org.cbioportal.model.StudyViewFilter;
import org.cbioportal.persistence.mysql.MySQLConnMapper;

@MySQLConnMapper
public interface StudyViewMySQLMapper {
	List<AlterationCountByGene> getMutatedGenes(StudyViewFilter studyViewFilter);
}
