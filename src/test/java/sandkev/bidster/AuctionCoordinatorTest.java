package sandkev.bidster;

import org.junit.Before;
import org.junit.Test;
import sandkev.bidster.dao.BidDao;
import sandkev.bidster.dao.BidDaoImpl;
import sandkev.bidster.dao.BidderDao;
import sandkev.bidster.dao.BidderDaoImpl;

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
        BidderDao bidderDao = new BidderDaoImpl();
        BidDao bidDao = new BidDaoImpl();
        BidDao winningBidDao = new BidDaoImpl();
        auctionService = new TraditionalAuction(bidderDao, bidDao, winningBidDao);
        Auction auction = auctionService.registerAuction("my auction", new Date());
        coordinator = new AuctionCoordinator(auctionService, auction);
    }

    @Test
    public void testStart(){
        assertEquals(AuctionStatus.Pending, coordinator.getState().getStatus());
        coordinator.start();
        assertEquals(AuctionStatus.Virgin, coordinator.getState().getStatus());

        Bidder kevin = auctionService.registerBidder("Kevin");
        Bidder dave = auctionService.registerBidder("Dave");
        Bidder brian = auctionService.registerBidder("Brian");
        Bidder bill = auctionService.registerBidder("Bill");
        Bidder chris = auctionService.registerBidder("Chris");

        assertEquals(BidResponse.Accepted, coordinator.bid(kevin, 10, null));
        assertEquals(BidResponse.RejectedAsTooLow, coordinator.bid(dave, 10, null));
        assertEquals(BidResponse.Accepted, coordinator.bid(brian, 15, null));
        assertEquals(BidResponse.Accepted, coordinator.bid(bill, 20, null));
        coordinator.hammerDown();
        assertEquals(BidResponse.RejectedAsAuctionIsClosed, coordinator.bid(chris, 25, null));


    }

}