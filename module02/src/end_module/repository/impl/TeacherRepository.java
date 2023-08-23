package end_module.repository.impl;

import end_module.models.GiaoVien;
import end_module.repository.ITeacherRepository;

import java.util.ArrayList;
import java.util.List;


public class TeacherRepository implements ITeacherRepository {
    private static List list = new ArrayList();

    static {
        list.add(new GiaoVien("1","1","1","1","1"));
        list.add(new GiaoVien("1","1","1","1","1"));
        list.add(new GiaoVien("1","1","1","1","1"));
    }
    @Override
    public List hienThi() {
        return list;
    }
}
