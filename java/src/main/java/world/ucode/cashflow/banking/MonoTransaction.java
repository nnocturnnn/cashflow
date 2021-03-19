package world.ucode.cashflow.banking;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MonoTransaction {
    private String id;
    private String time;
    private String description;
    private String mcc;
    private String originalMcc;
    private String amount;
    private String operationAmount;
    private String currencyCode;
    private String commissionRate;
    private String cashbackAmount;
    private String balance;
    private String hold;
    private String receiptId;
    private String counterEdrpou;
    private String counterIban;

}   