package sandkev.bidster;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by kevin on 16/06/2016.
 */
public class AuctionCoordinatorTest {

    private AuctionCoordinator coordinator;
    private AuctionService auctionService;

    @Before
    public void setUp(){
        auctionService = new TraditionalAuction();
        Auction auction = auctionService.registerAuction("my auction", new Date());
        coordinator = new AuctionCoordinator(auctionService, auction);
    }

    @Test
    public void testStart(){
        assertEquals(AuctionStatus.Pending, coordinator.getState().getStatus());
        coordinator.start();
        assertEquals(AuctionStatus.Virgin, coordinator.getState().getStatus());


    }

}