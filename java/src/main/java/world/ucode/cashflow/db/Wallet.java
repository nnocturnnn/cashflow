package world.ucode.cashflow.db;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "wallet")
public class Wallet {
    private String name;
}