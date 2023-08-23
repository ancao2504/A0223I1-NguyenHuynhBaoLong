package end_module.service.impl;

import end_module.repository.ITeacherRepository;
import end_module.repository.impl.TeacherRepository;
import end_module.service.IServiceTeacher;

import java.util.List;


public class TeacherServiceImpl implements IServiceTeacher {
    private static ITeacherRepository iTeacherRepository = new TeacherRepository();
    @Override
    public void hienThiGiaoVien() {
        List danhSach = iTeacherRepository.hienThi();
        for (Object giaoVien: danhSach) {
            System.out.println(giaoVien);
        }
    }
}
