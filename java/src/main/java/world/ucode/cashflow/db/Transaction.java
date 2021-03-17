package world.ucode.cashflow.db;

import world.ucode.cashflow.db.User;
import javax.persistence.*;
import lombok.*;

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
    private String category = "df";
    private String currency = "df";
    private String wallet = "df";
    private String tag = "df";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
}