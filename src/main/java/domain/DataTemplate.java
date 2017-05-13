package domain;

/**
 * Created by vpnk on 03.05.17.
 */
public abstract class DataTemplate<T> {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
