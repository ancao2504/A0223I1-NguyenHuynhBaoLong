package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.ContractDetail;
import com.example.casestudy.repository.IDetailContractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailContractRepository implements IDetailContractRepository {

    public static final String SELECT_FROM_DETAIL_CONTRACT = "select * from detail_contract";
    public static final String INSERT_INTO = "INSERT INTO `case_study`.`detail_contract` (`quantity`, `contract_id`, `accompanied_service_id`) VALUES (?,?,?);";

    @Override
    public List<ContractDetail> findAll() {
        List<ContractDetail> list = new ArrayList<>();
        ContractDetail contractDetail;
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement= connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_DETAIL_CONTRACT);
            while (resultSet.next()) {
//                int id, int idContract, int idAttachService, int quantity)
                int id = resultSet.getInt("detail_contract_id");
                int idContract = resultSet.getInt("contract_id");
                int idAttachService = resultSet.getInt("accompanied_service_id");
                int quantity = resultSet.getInt("quantity");
                contractDetail = new ContractDetail(id, idContract, idAttachService, quantity);
                list.add(contractDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        try {
            Connection connection =BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1,contractDetail.getQuantity());
            preparedStatement.setInt(2,contractDetail.getIdContract());
            preparedStatement.setInt(3,contractDetail.getIdAttachService());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
