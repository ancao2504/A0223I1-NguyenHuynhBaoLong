package CaseStudy.repository.impl;

import CaseStudy.common.ReadAndWriteFile;
import CaseStudy.model.Facility;
import CaseStudy.model.Villa;
import CaseStudy.repository.IFacilityRepository;


import java.util.*;

public class FacilityRepository implements IFacilityRepository<Facility> {
    private Map<Facility, Integer> facilityLinkedHashMap= new LinkedHashMap<>();
    private List <Facility> list = new ArrayList<>();

    @Override
    public void addNewService(Facility facility) {
        facilityLinkedHashMap.put(facility,0);
        list.add(facility);
    }

    @Override
    public List<Facility> display() {
        return list;
    }


}
