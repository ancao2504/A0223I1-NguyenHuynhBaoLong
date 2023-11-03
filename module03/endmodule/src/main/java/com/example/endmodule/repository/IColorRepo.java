package com.example.endmodule.repository;

import com.example.endmodule.model.Color;

import java.util.List;

public interface IColorRepo {
    List<Color> findAll();
    Color findById(int id);
}
