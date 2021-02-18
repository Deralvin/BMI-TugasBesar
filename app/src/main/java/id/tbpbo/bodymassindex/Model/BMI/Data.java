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
    @SerializedName("jumlah_bmi")
    @Expose
    private Double jumlahBmi;
    @SerializedName("id_user")
    @Expose
    private Object idUser;
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

    public Double getJumlahBmi() {
        return jumlahBmi;
    }

    public void setJumlahBmi(Double jumlahBmi) {
        this.jumlahBmi = jumlahBmi;
    }

    public Object getIdUser() {
        return idUser;
    }

    public void setIdUser(Object idUser) {
        this.idUser = idUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
