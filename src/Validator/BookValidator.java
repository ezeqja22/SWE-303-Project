public class BookValidator {
    private static final double MIN_PRICE = 0.01;
    private static final int MIN_TITLE_LENGTH = 2;
    private static final int MIN_AUTHOR_LENGTH = 2;

    public boolean isPriceValid(double price) {
        return price >= MIN_PRICE;
    }

    public boolean isTitleValid(String title) {
        return title != null && title.trim().length() >= MIN_TITLE_LENGTH;
    }

    public boolean isAuthorValid(String author) {
        return author != null && author.trim().length() >= MIN_AUTHOR_LENGTH;
    }

    public boolean isBookValid(String title, String author, double price) {
        return isTitleValid(title) && isAuthorValid(author) && isPriceValid(price);
    }
}
