package com.fanddong.psw.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "pswkey")
public class Pswkey {
    @Id
    private int id;

    private String usrname;

    private String psw;

    private int style;

    private String remark;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Pswkey{" +
                "id=" + id +
                ", usrname='" + usrname + '\'' +
                ", psw='" + psw + '\'' +
                ", style=" + style +
                ", remark='" + remark + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
