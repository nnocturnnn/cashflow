package world.ucode.cashflow.db;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
// @Entity
@NoArgsConstructor
// @Table(name = "wallet")
public class Category {
    private String name;
    private String subcategory;
}