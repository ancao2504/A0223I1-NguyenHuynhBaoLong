package com.example.casestudy.model;

public class ContractDetail {
    private int id;
    private int idContract;
    private int idAttachService;
    private int quantity;

    public ContractDetail(int id, int idContract, int idAttachService, int quantity) {
        this.id = id;
        this.idContract = idContract;
        this.idAttachService = idAttachService;
        this.quantity = quantity;
    }

    public ContractDetail(int idContract, int idAttachService, int quantity) {
        this.idContract = idContract;
        this.idAttachService = idAttachService;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(int idAttachService) {
        this.idAttachService = idAttachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
