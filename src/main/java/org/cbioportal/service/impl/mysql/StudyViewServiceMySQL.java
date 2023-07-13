package org.cbioportal.service.impl.mysql;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.cbioportal.controller.util.StudyViewFilterUtil;
import org.cbioportal.model.AlterationCountByGene;
import org.cbioportal.model.ClinicalDataCountFilter;
import org.cbioportal.model.ClinicalDataCountItem;
import org.cbioportal.model.ClinicalDataFilter;
import org.cbioportal.model.Projection;
import org.cbioportal.model.Sample;
import org.cbioportal.model.SampleIdentifier;
import org.cbioportal.model.StudyViewFilter;
import org.cbioportal.persistence.mysql.mapper.ClinicalDataServiceSQLMapper;
import org.cbioportal.persistence.mysql.mapper.SampleServiceSQLMapper;
import org.cbioportal.persistence.mysql.mapper.StudyViewMySQLMapper;
import org.cbioportal.service.api.StudyViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.validation.Valid;

@Component
//@Profile("mysql")
public class StudyViewServiceMySQL implements StudyViewService {

	@Override
	public List<AlterationCountByGene> getMutatedGenes(StudyViewFilter studyViewFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClinicalDataCountItem> getClinicalDataCounts(
			@Valid ClinicalDataCountFilter interceptedClinicalDataCountFilter, boolean singleStudyUnfiltered) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Autowired
//	StudyViewMySQLMapper studyViewMapper;
//	
//	@Autowired
//	ClinicalDataServiceSQLMapper clinicalDataService;
//	
//	@Autowired
//	SampleServiceSQLMapper sampleService;
//	
//	Function<Sample, SampleIdentifier> sampleToSampleIdentifier = new Function<Sample, SampleIdentifier>() {
//
//        public SampleIdentifier apply(Sample sample) {
//            SampleIdentifier sampleIdentifier = new SampleIdentifier();
//            sampleIdentifier.setSampleId(sample.getStableId());
//            sampleIdentifier.setStudyId(sample.getCancerStudyIdentifier());
//            return sampleIdentifier;
//        }
//    };
//
//	@Override
//	public List<AlterationCountByGene> getMutatedGenes(StudyViewFilter studyViewFilter) {
//		return studyViewMapper.getMutatedGenes(studyViewFilter);
//	}
//
//	@Override
//	@Cacheable(cacheResolver = "staticRepositoryCacheOneResolver", condition = "@cacheEnabledConfig.getEnabled() && #singleStudyUnfiltered")
//	public List<ClinicalDataCountItem> getClinicalDataCounts(
//			@Valid ClinicalDataCountFilter interceptedClinicalDataCountFilter, boolean singleStudyUnfiltered) {
//
//		List<ClinicalDataFilter> attributes = interceptedClinicalDataCountFilter.getAttributes();
//		StudyViewFilter studyViewFilter = interceptedClinicalDataCountFilter.getStudyViewFilter();
//		if (attributes.size() == 1) {
//			StudyViewFilterUtil.removeSelfFromFilter(attributes.get(0).getAttributeId(), studyViewFilter);
//		}
//		List<SampleIdentifier> filteredSampleIdentifiers = this.apply(studyViewFilter);
//
//		if (filteredSampleIdentifiers.isEmpty()) {
//			return new ArrayList<>();
//		}
//		List<String> studyIds = new ArrayList<>();
//		List<String> sampleIds = new ArrayList<>();
//		StudyViewFilterUtil.extractStudyAndSampleIds(filteredSampleIdentifiers, studyIds, sampleIds);
//
//		List<ClinicalDataCountItem> result = clinicalDataService.fetchClinicalDataCounts(studyIds, sampleIds,
//				attributes.stream().map(a -> a.getAttributeId()).collect(Collectors.toList()));
//
//		return result;
//	}
//
//	public List<SampleIdentifier> apply(StudyViewFilter studyViewFilter) {
//		return (instance == null ? this : instance).cachedApply(studyViewFilter);
//	}
//
//	public List<SampleIdentifier> cachedApply(StudyViewFilter studyViewFilter) {
//		return this.apply(studyViewFilter, false);
//	}
//
//	public List<SampleIdentifier> apply(StudyViewFilter studyViewFilter, Boolean negateFilters) {
//
//		List<SampleIdentifier> sampleIdentifiers = new ArrayList<>();
//		if (studyViewFilter == null) {
//			return sampleIdentifiers;
//		}
//
//		if (studyViewFilter != null && studyViewFilter.getSampleIdentifiers() != null
//				&& !studyViewFilter.getSampleIdentifiers().isEmpty()) {
//			List<String> studyIds = new ArrayList<>();
//			List<String> sampleIds = new ArrayList<>();
//			StudyViewFilterUtil.extractStudyAndSampleIds(studyViewFilter.getSampleIdentifiers(), studyIds, sampleIds);
//			sampleIdentifiers = sampleService.fetchSamples(studyIds, sampleIds, Projection.ID.name()).stream()
//					.map(sampleToSampleIdentifier).collect(Collectors.toList());
//		} else {
//			sampleIdentifiers = sampleService
//					.getAllSamplesInStudies(studyViewFilter.getStudyIds(), Projection.ID.name(), null, null, null, null)
//					.stream().map(sampleToSampleIdentifier).collect(Collectors.toList());
//		}
//
//		List<String> studyIds = sampleIdentifiers.stream().map(SampleIdentifier::getStudyId).distinct()
//				.collect(Collectors.toList());
//
//		List<ClinicalDataFilter> clinicalDataEqualityFilters = new ArrayList<>();
//		List<ClinicalDataFilter> clinicalDataIntervalFilters = new ArrayList<>();
//
//		List<ClinicalDataFilter> clinicalDataFilters = studyViewFilter.getClinicalDataFilters();
//
//		if (!CollectionUtils.isEmpty(clinicalDataFilters)) {
//			List<String> attributeIds = clinicalDataFilters.stream().map(ClinicalDataFilter::getAttributeId)
//					.collect(Collectors.toList());
//			List<ClinicalAttribute> clinicalAttributes = clinicalAttributeService
//					.getClinicalAttributesByStudyIdsAndAttributeIds(studyIds, attributeIds);
//
//			Map<String, ClinicalAttribute> clinicalAttributeMap = clinicalAttributes.stream()
//					.collect(Collectors.toMap(ClinicalAttribute::getAttrId, Function.identity(), (a, b) -> {
//						return a.getDatatype().equals("STRING") ? a : b;
//					}));
//
//			clinicalDataFilters.forEach(clinicalDataFilter -> {
//				String attributeId = clinicalDataFilter.getAttributeId();
//				if (clinicalAttributeMap.containsKey(attributeId)) {
//					if (clinicalAttributeMap.get(attributeId).getDatatype().equals("STRING")) {
//						clinicalDataEqualityFilters.add(clinicalDataFilter);
//					} else {
//						clinicalDataIntervalFilters.add(clinicalDataFilter);
//					}
//				}
//			});
//		}
//
//		if (!CollectionUtils.isEmpty(clinicalDataEqualityFilters)) {
//			sampleIdentifiers = equalityFilterClinicalData(sampleIdentifiers, clinicalDataEqualityFilters,
//					negateFilters);
//		}
//
//		if (!CollectionUtils.isEmpty(clinicalDataIntervalFilters)) {
//			sampleIdentifiers = intervalFilterClinicalData(sampleIdentifiers, clinicalDataIntervalFilters,
//					negateFilters);
//		}
//
//		if (!CollectionUtils.isEmpty(studyViewFilter.getCustomDataFilters())) {
//			sampleIdentifiers = customDataFilterApplier.apply(sampleIdentifiers, studyViewFilter.getCustomDataFilters(),
//					negateFilters);
//		}
//
//		List<MolecularProfile> molecularProfiles = null;
//		if (!CollectionUtils.isEmpty(studyViewFilter.getGeneFilters())
//				|| !CollectionUtils.isEmpty(studyViewFilter.getGenomicDataFilters())
//				|| !CollectionUtils.isEmpty(studyViewFilter.getGenericAssayDataFilters())
//				|| !CollectionUtils.isEmpty(studyViewFilter.getGenomicProfiles())) {
//
//			molecularProfiles = molecularProfileService.getMolecularProfilesInStudies(studyIds, "SUMMARY");
//		}
//
//		sampleIdentifiers = intervalFilterExpressionData(sampleIdentifiers, molecularProfiles,
//				studyViewFilter.getGenomicDataFilters(), negateFilters);
//
//		sampleIdentifiers = intervalFilterExpressionData(sampleIdentifiers, molecularProfiles,
//				studyViewFilter.getGenericAssayDataFilters(), negateFilters);
//
//		if (!CollectionUtils.isEmpty(studyViewFilter.getGeneFilters())) {
//			Map<String, MolecularProfile> molecularProfileMap = molecularProfiles.stream()
//					.collect(Collectors.toMap(MolecularProfile::getStableId, Function.identity()));
//			List<StudyViewGeneFilter> mutatedGeneFilters = new ArrayList<>();
//			List<StudyViewGeneFilter> structuralVariantGeneFilters = new ArrayList<>();
//			List<StudyViewGeneFilter> cnaGeneFilters = new ArrayList<>();
//
//			splitGeneFiltersByMolecularAlterationType(studyViewFilter.getGeneFilters(), molecularProfileMap,
//					mutatedGeneFilters, structuralVariantGeneFilters, cnaGeneFilters);
//
//			if ((mutatedGeneFilters.size() + structuralVariantGeneFilters.size()
//					+ cnaGeneFilters.size()) == studyViewFilter.getGeneFilters().size()) {
//				if (!mutatedGeneFilters.isEmpty()) {
//					sampleIdentifiers = filterMutatedGenes(mutatedGeneFilters, molecularProfileMap, sampleIdentifiers);
//				}
//				if (!structuralVariantGeneFilters.isEmpty()) {
//					sampleIdentifiers = filterStructuralVariantGenes(structuralVariantGeneFilters, molecularProfileMap,
//							sampleIdentifiers);
//				}
//				if (!cnaGeneFilters.isEmpty()) {
//					sampleIdentifiers = filterCNAGenes(cnaGeneFilters, molecularProfileMap, sampleIdentifiers);
//				}
//
//			} else {
//				return new ArrayList<>();
//			}
//		}
//
//		if (!CollectionUtils.isEmpty(studyViewFilter.getGenomicProfiles())) {
//			Map<String, List<SampleIdentifier>> groupStudySampleIdentifiers = sampleIdentifiers.stream()
//					.collect(Collectors.groupingBy(SampleIdentifier::getStudyId));
//
//			Map<String, List<MolecularProfile>> molecularProfileSet = molecularProfileUtil
//					.categorizeMolecularProfilesByStableIdSuffixes(molecularProfiles);
//
//			List<MolecularProfileCaseIdentifier> molecularProfileSampleIdentifiers = new ArrayList<>();
//
//			studyViewFilter.getGenomicProfiles().stream().forEach(profileValues -> {
//				profileValues.stream().forEach(profileValue -> {
//					molecularProfileSet.getOrDefault(profileValue, new ArrayList<>()).stream().forEach(profile -> {
//						groupStudySampleIdentifiers.getOrDefault(profile.getCancerStudyIdentifier(), new ArrayList<>())
//								.forEach(sampleIdentifier -> {
//									MolecularProfileCaseIdentifier profileCaseIdentifier = new MolecularProfileCaseIdentifier();
//									profileCaseIdentifier.setMolecularProfileId(profile.getStableId());
//									profileCaseIdentifier.setCaseId(sampleIdentifier.getSampleId());
//									molecularProfileSampleIdentifiers.add(profileCaseIdentifier);
//								});
//					});
//
//				});
//			});
//
//			List<GenePanelData> genePanelData = genePanelService
//					.fetchGenePanelDataInMultipleMolecularProfiles(molecularProfileSampleIdentifiers);
//
//			for (List<String> profileValues : studyViewFilter.getGenomicProfiles()) {
//				Map<String, MolecularProfile> profileMap = profileValues.stream().flatMap(
//						profileValue -> molecularProfileSet.getOrDefault(profileValue, new ArrayList<>()).stream())
//						.collect(Collectors.toMap(MolecularProfile::getStableId, Function.identity()));
//
//				Set<SampleIdentifier> filteredSampleIdentifiers = new HashSet<>();
//				genePanelData.forEach(datum -> {
//					if (datum.getProfiled() && profileMap.containsKey(datum.getMolecularProfileId())) {
//						SampleIdentifier sampleIdentifier = new SampleIdentifier();
//						sampleIdentifier.setStudyId(datum.getStudyId());
//						sampleIdentifier.setSampleId(datum.getSampleId());
//						filteredSampleIdentifiers.add(sampleIdentifier);
//					}
//				});
//				sampleIdentifiers.retainAll(filteredSampleIdentifiers);
//			}
//		}
//
//		if (!CollectionUtils.isEmpty(studyViewFilter.getCaseLists())) {
//			List<SampleList> sampleLists = sampleListService.getAllSampleListsInStudies(studyIds,
//					Projection.DETAILED.name());
//			Map<String, List<SampleList>> groupedSampleListByListType = studyViewFilterUtil
//					.categorizeSampleLists(sampleLists);
//
//			for (List<String> sampleListTypes : studyViewFilter.getCaseLists()) {
//				List<SampleIdentifier> filteredSampleIdentifiers = sampleListTypes.stream()
//						.flatMap(sampleListType -> groupedSampleListByListType
//								.getOrDefault(sampleListType, new ArrayList<>()).stream().flatMap(sampleList -> {
//									return sampleList.getSampleIds().stream().map(sampleId -> {
//										SampleIdentifier sampleIdentifier = new SampleIdentifier();
//										sampleIdentifier.setStudyId(sampleList.getCancerStudyIdentifier());
//										sampleIdentifier.setSampleId(sampleId);
//										return sampleIdentifier;
//									});
//								}))
//						.collect(Collectors.toList());
//
//				sampleIdentifiers.retainAll(filteredSampleIdentifiers);
//			}
//		}
//
//		return chainSubFilters(studyViewFilter, sampleIdentifiers);
//	}

}
