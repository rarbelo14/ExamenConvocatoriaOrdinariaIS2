package subastas.apps.mock;

import subastas.control.HoldAuctionCommand;

public class Main {

    private final HoldAuctionCommand holdAuctionCommand;
    
    public static void main(String[] args) {
        new Main().execute();
    }
    
    public Main() {
        holdAuctionCommand = new HoldAuctionCommand();
    }
    
    private void execute() {
        holdAuctionCommand.execute();
    }
    
}
