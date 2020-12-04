package bo.ucb.edu.ingsoft.model;

public class UserSubcategory {

    private Integer userSubId;
    private Integer userId;
    private Integer subcategoryId;
    private Integer status;
    private Transaction transaction;

    public UserSubcategory() {
        transaction = new Transaction();
    }

    public Integer getUserSubId() {
        return userSubId;
    }

    public void setUserSubId(Integer userSubId) {
        this.userSubId = userSubId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "UserSubcategory{" +
                "userSubId=" + userSubId +
                ", userId=" + userId +
                ", subcategoryId=" + subcategoryId +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
