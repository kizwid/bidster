package sandkev.bidster;

/**
 * Created by kevin on 15/06/2016.
 */
public interface AuctionListener {
    void onStart(Auction auction);
    void onOpenBidding(Auction auction, Lot lot);
    void onBid(Bid bid);
    void onHammerDown(Bid bid);
    void onClose(Auction auction);
}
