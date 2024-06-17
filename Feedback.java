public class Feedback {
    private String guestName;
    private int rating;
    private String comments;

    public Feedback(String guestName, int rating, String comments) {
        this.guestName = guestName;
        this.rating = rating;
        this.comments = comments;
    }

    // Getters and setters
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "guestName='" + guestName + '\'' +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}
