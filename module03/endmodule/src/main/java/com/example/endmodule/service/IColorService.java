package com.example.endmodule.service;

import com.example.endmodule.model.Color;

import java.util.List;

public interface IColorService {
    List<Color> findAll();
    Color findById(int id);
}
