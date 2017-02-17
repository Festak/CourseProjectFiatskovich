package Fiatskovich.viewModelsFiatskovich;

/**
 * Created by Евгений on 16.02.2017.
 */
public class Medal {
    private int id;
    private String name;

    public Medal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Medal(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
