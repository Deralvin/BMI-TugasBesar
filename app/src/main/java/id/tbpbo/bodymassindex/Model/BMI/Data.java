package id.tbpbo.bodymassindex.Model.BMI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("tinggi_badan")
    @Expose
    private String tinggiBadan;
    @SerializedName("berat_badan")
    @Expose
    private String beratBadan;
    @SerializedName("umur")
    @Expose
    private String umur;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("id_kategori")
    @Expose
    private Integer idKategori;
    @SerializedName("message")
    @Expose
    private String message;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(String tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public String getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(String beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(Integer idKategori) {
        this.idKategori = idKategori;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}