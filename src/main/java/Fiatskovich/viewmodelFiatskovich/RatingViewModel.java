package Fiatskovich.viewmodelFiatskovich;

/**
 * Created by Евгений on 21.02.2017.
 */
public class RatingViewModel {
    private int id;
    private int user_id;
    private int rating;

    public RatingViewModel(int id, int user_id, int rating) {
        this.id = id;
        this.user_id = user_id;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
