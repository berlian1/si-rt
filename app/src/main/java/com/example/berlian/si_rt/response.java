package com.example.berlian.si_rt;

/**
 * Created by berlian on 6/16/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by berlian on 6/10/2017.
 */

public class response {
    @SerializedName("admin_id")
    @Expose
    private String adminId;
    @SerializedName("admin_uname")
    @Expose
    private String adminUname;
    @SerializedName("admin_passwd")
    @Expose
    private String adminPasswd;
    @SerializedName("admin_nama")
    @Expose
    private String adminNama;
    @SerializedName("admin_kondisi")
    @Expose
    private String adminKondisi;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminUname() {
        return adminUname;
    }

    public void setAdminUname(String adminUname) {
        this.adminUname = adminUname;
    }

    public String getAdminPasswd() {
        return adminPasswd;
    }

    public void setAdminPasswd(String adminPasswd) {
        this.adminPasswd = adminPasswd;
    }

    public String getAdminNama() {
        return adminNama;
    }

    public void setAdminNama(String adminNama) {
        this.adminNama = adminNama;
    }

    public String getAdminKondisi() {
        return adminKondisi;
    }

    public void setAdminKondisi(String adminKondisi) {
        this.adminKondisi = adminKondisi;
    }

}

