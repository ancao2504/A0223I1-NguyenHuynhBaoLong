package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.Contract;
import com.example.casestudy.repository.IContractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {


    public static final String SELECT_FROM_CONTRACT = "SELECT * FROM contract;";
    public static final String INSERT_INTO = "INSERT INTO `contract` (`start_contract`, `end_contract`, `advance_deposit`, `total`,`employee_id`, `customer_id`, `service_id`) VALUES (?,?,?,?,?,?,?);";
    public static final String SELECT_CONTRACT_WHERE = "SELECT FROM contract WHERE contract_id =?";

    @Override
    public List<Contract> findAll() {
        List<Contract> list = new ArrayList<>();
        Contract contract;
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_CONTRACT);
            while (resultSet.next()) {
//                contract_id int AI PK
//start_contract datetime
//end_contract datetime
//advance_deposit double
//employee_id int
//customer_id int
//service_id int
                int id = resultSet.getInt("contract_id");
                Date startContract = resultSet.getDate("start_contract");
                Date endContract = resultSet.getDate("end_contract");
                double deposit = resultSet.getDouble("advance_deposit");
                double total = resultSet.getDouble("total");
                int idEmployee = resultSet.getInt("employee_id");
                int idCustomer = resultSet.getInt("customer_id");
                int idService = resultSet.getInt("service_id");
                //int id, Date startContract, Date endContract, double depositContract, double totalMoney,
                //                    int idEmployee, int idCustomer, int idService
                contract = new Contract(id, startContract, endContract, deposit, total, idEmployee, idCustomer, idService);
                list.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Contract contract) {
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setDate(1, contract.getStartContract());
            preparedStatement.setDate(2, contract.getEndContract());
            preparedStatement.setDouble(3,contract.getDepositContract());
            preparedStatement.setDouble(4,contract.getTotalMoney());
            preparedStatement.setInt(5,contract.getIdEmployee());
            preparedStatement.setInt(6,contract.getIdCustomer());
            preparedStatement.setInt(7,contract.getIdService());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contract FindById(int id) {
        Contract contract =null;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_WHERE);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 id = resultSet.getInt("contract_id");
                Date startContract = resultSet.getDate("start_contract");
                Date endContract = resultSet.getDate("end_contract");
                double deposit = resultSet.getDouble("advance_deposit");
                double total = resultSet.getDouble("total");
                int idEmployee = resultSet.getInt("employee_id");
                int idCustomer = resultSet.getInt("customer_id");
                int idService = resultSet.getInt("service_id");
                contract = new Contract(id, startContract, endContract, deposit, total, idEmployee, idCustomer, idService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract;
    }

    @Override
    public Boolean update(Contract contract) {
        return null;
    }

    @Override
    public Boolean delete(Contract contract) {
        return null;
    }
}
