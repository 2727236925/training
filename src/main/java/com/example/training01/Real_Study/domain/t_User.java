package com.example.training01.Real_Study.domain;

public class t_User {
    private int u_id;
    private String u_name;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public t_User(int u_id, String u_name) {
        this.u_id = u_id;
        this.u_name = u_name;
    }

    public t_User() {
    }

    @Override
    public String toString() {
        return "t_user{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                '}';
    }
}
