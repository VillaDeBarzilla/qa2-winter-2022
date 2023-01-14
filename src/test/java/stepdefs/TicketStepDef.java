package stepdefs;

import io.cucumber.java.en.Given;

public class TicketStepDef {
    @Given("Order tickets for a two adults and one children")
    public void order_tickets_for_flight(){
        System.out.println("Ticket are ordered");
    }
}
