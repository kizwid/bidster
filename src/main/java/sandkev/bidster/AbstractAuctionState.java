package sandkev.bidster;

import lombok.Getter;
import lombok.Value;

/**
 * Created by kevin on 10/06/2016.
 */
@Getter
public abstract class AbstractAuctionState implements AuctionState {
    AuctionCoordinator coordinator;
    Auction auction;
    public AbstractAuctionState(AuctionCoordinator coordinator, Auction auction){
        this.coordinator = coordinator;
        this.auction = auction;
    }
    public String toString(){
        return "State: " + getStatus();
    }
}
