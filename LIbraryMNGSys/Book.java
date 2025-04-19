public class Book implements Comparable<Book> {
    private String bookId;
    private String bookName;
    private String bookAuthorName;
    private double  bookPrice;
    
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookAuthorName() {
        return bookAuthorName;
    }
    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }
    public double getBookPrice() {
        return bookPrice;
    }
    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    Book(String bookId,String bookName,String bookAuthorName,double bookPrice){
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
        this.bookPrice = bookPrice;
    }
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthorName=" + bookAuthorName
                + ", bookPrice=" + bookPrice + "]";
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }

        // Check for null and ensure same class
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book b = (Book) obj;
        return this.bookAuthorName.equals(b.getBookAuthorName()) && (this.bookId == null ? b.getBookId() == null : this.bookId.equals(b.getBookId())) && this.bookName.equals(b.getBookName()) && this.bookPrice==b.getBookPrice();
    }

    @Override
    public int hashCode() {
        return (bookId.hashCode()+bookName.hashCode()+bookAuthorName.hashCode()+(int)this.bookPrice);
    }

    @Override
    public int compareTo(Book o) {
        return (int) (this.bookPrice-o.bookPrice);
    }
    
}
