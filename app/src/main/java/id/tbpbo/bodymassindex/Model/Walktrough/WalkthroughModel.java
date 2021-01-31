package id.tbpbo.bodymassindex.Model.Walktrough;

public class WalkthroughModel {
    int id;
    String status;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WalkthroughModel() {
    }

    public WalkthroughModel(int id, String status,String name) {
        this.id = id;
        this.status = status;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
