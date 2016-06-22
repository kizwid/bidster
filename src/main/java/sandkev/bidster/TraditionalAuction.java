package sandkev.bidster;

import lombok.Value;
import sandkev.bidster.dao.BidDao;
import sandkev.bidster.dao.BidderDao;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kevin on 10/06/2016.
 */
@Value
public class TraditionalAuction implements AuctionService {
    AtomicLong bidderId;
    AtomicLong bidId;
    BidderDao bidderDao;
    BidDao bidDao;
    BidDao winningBidDao;
    public TraditionalAuction(BidderDao bidderDao, BidDao bidDao, BidDao winningBidDao) {
        this.bidderDao = bidderDao;
        this.bidDao = bidDao;
        this.winningBidDao = winningBidDao;
        this.bidderId = new AtomicLong(0);
        this.bidId = new AtomicLong(0);
    }

    public Auction registerAuction(String description, Date startTime) {
        return new Auction(0L, description, 10.0);
    }

    public Lot registerLot(String description, byte[] image, double startingPrice, int timeoutBeforeWinningBid) {
        return null;
    }

    public Bidder registerBidder(String name) {
        Bidder bidder = new Bidder(bidderId.getAndIncrement(), name);
        bidderDao.save(bidder);
        return bidder;
    }

    public Bid recordBid(Bidder bidder, Lot lot, Auction auction, double amount) {
        long nextId = bidId.getAndIncrement();
        LocalDateTime timestamp=LocalDateTime.now();
        Bid bid = new Bid(nextId, timestamp, auction, bidder, lot, amount);
        bidDao.save(bid);
        return bid;
    }

    @Override
    public void recordWinningBid(Bid winningBid) {
        winningBidDao.save(winningBid);
    }
}
