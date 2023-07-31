package CaseStudy.repository.impl;

import CaseStudy.common.ReadAndWriteFile;
import CaseStudy.model.Facility;
import CaseStudy.model.Villa;
import CaseStudy.repository.IFacilityRepository;

public class FacilityRepository implements IFacilityRepository<Facility> {

    public static final String SRC_FACILITY = "src/CaseStudy/data/Facility.csv";

    @Override
    public void addNewService(Facility facility) {
        ReadAndWriteFile.writeFile(SRC_FACILITY, ConvertToString((Villa) facility),true);
    }

//    @Override
//    public List<Facility> display() {
//        List<String> stringList = ReadAndWriteFile.readFile(SRC_FACILITY);
//        List<Facility> list = new ArrayList<>();
//        String[] temp;
//        for (String string : stringList) {
//          temp= string.split(",");
//          list.add(new Facility(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]));
//        }
//
//    }
    private String ConvertToString(Villa villa) {
        return villa.getNameService()+","+villa.getServiceCode()+","+villa.getStyle()+","+ villa.getFee()+
                ","+ villa.getMaxPeople()+","+villa.getAreaUse()+","+villa.getStandardRoom()+","+villa.getAreaPool()+
                ","+villa.getFloor();
    }
}
