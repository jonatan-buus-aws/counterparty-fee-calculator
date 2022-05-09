package dk.jonatanbuus.counterparty_fee_calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openapitools.model.Amount;
import org.openapitools.model.CURRENCY;
import org.openapitools.model.CounterpartyFee;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class CounterpartyFeeMockValues extends BaseTest {
    protected Integer counterpartyId = 1234;
    protected CounterpartyFee expectedFee;

    @BeforeEach
    public void setup() throws Exception {
        super.setup();
        this.createCounterpartyFee();
    }

    private void createCounterpartyFee() {
        Amount fee = new Amount()
                        .currency(CURRENCY.DKK)
                        .value(1000L);
        this.expectedFee = new CounterpartyFee().fee(fee);
    }
}