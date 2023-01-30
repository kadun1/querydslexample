package querydsl.dto;

public class ItemDTO {

    private String username;
    private int price;

    public ItemDTO() {
    }

    public ItemDTO(String username, int price) {
        this.username = username;
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
