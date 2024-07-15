package gift.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private String imageUrl;

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

    protected Product(){
    }
    public Product(Long id, String name, int price, String imageUrl){
        isValidName(name);
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public void update(String name, int price, String imageUrl){
        isValidName(name);
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    private void isValidName(String name){
        if(name.contains("카카오")){
            throw new IllegalArgumentException( "\"카카오\"가 포함된 문구는 담당 MD와 협의한 경우에만 사용할 수 있습니다.");
        }
    }
}
