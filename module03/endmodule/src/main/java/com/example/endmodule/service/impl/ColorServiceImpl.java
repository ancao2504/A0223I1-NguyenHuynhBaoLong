package com.example.endmodule.service.impl;

import com.example.endmodule.model.Color;
import com.example.endmodule.repository.IColorRepo;
import com.example.endmodule.repository.impl.ColorRepoImpl;
import com.example.endmodule.service.IColorService;

import java.util.List;

public class ColorServiceImpl implements IColorService {
    private IColorRepo iColorRepo = new ColorRepoImpl();
    @Override
    public List<Color> findAll() {
        return iColorRepo.findAll();
    }

    @Override
    public Color findById(int id) {
        return iColorRepo.findById(id);
    }
}
