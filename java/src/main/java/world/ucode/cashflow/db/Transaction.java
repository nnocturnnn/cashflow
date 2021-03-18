package world.ucode.cashflow.db;

import world.ucode.cashflow.db.User;
import javax.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id = 1;
    private String text = "df";
    private String type = "df";
    private String category;
    private String subcategory;
    private String currency = "df";
    private String wallet = "df";
    private String tag = "df";
    
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date;
    @DateTimeFormat(pattern = "HH:mm")
    private Date time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
}