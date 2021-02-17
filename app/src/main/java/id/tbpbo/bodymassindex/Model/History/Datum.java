package id.tbpbo.bodymassindex.Model.History;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id_check_ideal")
    @Expose
    private Integer idCheckIdeal;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("berat_badan")
    @Expose
    private Integer beratBadan;
    @SerializedName("tinggi_badan")
    @Expose
    private Integer tinggiBadan;
    @SerializedName("umur")
    @Expose
    private Integer umur;
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
    private Integer idUser;
    @SerializedName("id_gues")
    @Expose
    private Object idGues;

    public Integer getIdCheckIdeal() {
        return idCheckIdeal;
    }

    public void setIdCheckIdeal(Integer idCheckIdeal) {
        this.idCheckIdeal = idCheckIdeal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(Integer beratBadan) {
        this.beratBadan = beratBadan;
    }

    public Integer getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(Integer tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Object getIdGues() {
        return idGues;
    }

    public void setIdGues(Object idGues) {
        this.idGues = idGues;
    }

}