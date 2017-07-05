package com.example.berlian.si_rt.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by berlian on 6/19/2017.
 */

public class loginAdmin {
    private String username;
    private String password;

    public loginAdmin(String username, String password){
        this.username = username;
        this.password = password;
    }

    @SerializedName("admin_id")
    @Expose
    private String adminId;
    @SerializedName("adminuname")
    @Expose
    private String adminuname;
    @SerializedName("adminnama")
    @Expose
    private String adminnama;
    @SerializedName("adminlogin")
    @Expose
    private Boolean adminlogin;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminuname() {
        return adminuname;
    }

    public void setAdminuname(String adminuname) {
        this.adminuname = adminuname;
    }

    public String getAdminnama() {
        return adminnama;
    }

    public void setAdminnama(String adminnama) {
        this.adminnama = adminnama;
    }

    public Boolean getAdminlogin() {
        return adminlogin;
    }

    public void setAdminlogin(Boolean adminlogin) {
        this.adminlogin = adminlogin;
    }


}
