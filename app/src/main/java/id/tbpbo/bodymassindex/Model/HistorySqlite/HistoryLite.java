package id.tbpbo.bodymassindex.Model.HistorySqlite;

public class HistoryLite {
    int id;
    String nama;
    String tinggi_badan;
    String berat_badan;
    String umur;
    String gender;

    public HistoryLite() {
    }

    public HistoryLite(int id, String nama, String tinggi_badan, String berat_badan, String umur, String gender) {
        this.id = id;
        this.nama = nama;
        this.tinggi_badan = tinggi_badan;
        this.berat_badan = berat_badan;
        this.umur = umur;
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTinggi_badan(String tinggi_badan) {
        this.tinggi_badan = tinggi_badan;
    }

    public void setBerat_badan(String berat_badan) {
        this.berat_badan = berat_badan;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getTinggi_badan() {
        return tinggi_badan;
    }

    public String getBerat_badan() {
        return berat_badan;
    }

    public String getUmur() {
        return umur;
    }

    public String getGender() {
        return gender;
    }
}
