package CaseStudy.repository;

import CaseStudy.model.Facility;

import java.util.List;

public interface IFacilityRepository<E>{
    void addNewService(E facility);
//    List<E> display();
}
