package com.example.training01.AopStudy.entity;

public class Operation {
    private int id;
    private String operation;
    private int u_id;

    public Operation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_is) {
        this.u_id = u_is;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", operation='" + operation + '\'' +
                ", u_is=" + u_id +
                '}';
    }
}
