package com.lukas.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Pattern(regexp = "^$|[0-9]{10}", message = "AccountNumber must be 10 digits")
    @Schema(
            description = "Account Number of Lukas Bank account", example = "1234567890"
    )
    private Long accountNumber;


    @NotEmpty(message = "AccountType can not be a null or empty")
    @Schema(
            description = "Account Type of Lukas Bank account", example = "Savings"
    )
    private String accountType;


    @NotEmpty(message = "BranchAddress can not be a null or empty")
    @Schema(
            description = "Account Branch Address of Lukas Bank account", example = "123 New York"
    )
    private String branchAddress;
}
