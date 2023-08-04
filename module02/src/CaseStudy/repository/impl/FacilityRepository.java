package CaseStudy.repository.impl;

import CaseStudy.common.ReadAndWriteFile;
import CaseStudy.model.Facility;
import CaseStudy.model.Villa;
import CaseStudy.repository.IFacilityRepository;


import java.util.*;

public class FacilityRepository implements IFacilityRepository<Facility> {
    private Map<String, Facility> facilityLinkedHashMap= new LinkedHashMap<>();
    private List <Facility> list = new ArrayList<>();

    @Override
    public void addNewService(Facility facility) {
        facilityLinkedHashMap.put(facility.getNameService(),facility);
        list.add(facility);
        System.out.println("SUCCESS");
    }

    @Override
    public List<Facility> display() {
        if (list.isEmpty()) {
            System.out.println("list is empty");
        }
            return list;
    }

    @Override
    public void delete(String choice) {
        if (list.isEmpty()) {
            System.out.println("list is empty");
        }
        Object object =facilityLinkedHashMap.get(choice);
        System.out.println(object);
        System.out.println("sure:");
        System.out.println("1.Yes");
        System.out.println("2.No");
        int option = Integer.parseInt(new Scanner(System.in).nextLine());
        if (option ==1) {
            list.remove(object);
            facilityLinkedHashMap.remove(choice);
            System.out.println("SUCCESS");
        }
    }
}
