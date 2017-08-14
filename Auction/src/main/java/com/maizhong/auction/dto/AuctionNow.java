package com.maizhong.auction.dto;

import java.util.List;

/**
 * Created by Xushd on 2017/8/11.
 */
public class AuctionNow {

    // 拍卖ID
    private long auctionId;
    // 当期拍卖价格
    private String curPrice;
    // 结束时间
    private long overTime;
    // 服务器当期时间
    private long nowTime;
    // 最新出价用户ID
    private long lastUserId;
    // 拍卖是否结束
    private int auction;
    // 拍卖通道
    private String chKey;
    // 我是否出价
    private int myPlus;
    // 出价记录
    private List<BidDto> bidList;
    // 关注数
    private int likeCount;
    // 我是否关注
    private int myLike;
    // 我是否最高价
    private int myTop;
    // 出价列表
    private List<PlusDto> plusList;
    // 我是否智能
    private int myAuto;
    // 我的智能价格
    private String autoPrice;


    public AuctionNow() {
    }


    public long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(long auctionId) {
        this.auctionId = auctionId;
    }

    public String getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(String curPrice) {
        this.curPrice = curPrice;
    }

    public long getOverTime() {
        return overTime;
    }

    public void setOverTime(long overTime) {
        this.overTime = overTime;
    }

    public long getNowTime() {
        return nowTime;
    }

    public void setNowTime(long nowTime) {
        this.nowTime = nowTime;
    }

    public long getLastUserId() {
        return lastUserId;
    }

    public void setLastUserId(long lastUserId) {
        this.lastUserId = lastUserId;
    }

    public int getAuction() {
        return auction;
    }

    public void setAuction(int auction) {
        this.auction = auction;
    }

    public String getChKey() {
        return chKey;
    }

    public void setChKey(String chKey) {
        this.chKey = chKey;
    }

    public int getMyPlus() {
        return myPlus;
    }

    public void setMyPlus(int myPlus) {
        this.myPlus = myPlus;
    }

    public List<BidDto> getBidList() {
        return bidList;
    }

    public void setBidList(List<BidDto> bidList) {
        this.bidList = bidList;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getMyLike() {
        return myLike;
    }

    public void setMyLike(int myLike) {
        this.myLike = myLike;
    }

    public int getMyTop() {
        return myTop;
    }

    public void setMyTop(int myTop) {
        this.myTop = myTop;
    }


    public List<PlusDto> getPlusList() {
        return plusList;
    }

    public void setPlusList(List<PlusDto> plusList) {
        this.plusList = plusList;
    }

    public int getMyAuto() {
        return myAuto;
    }

    public void setMyAuto(int myAuto) {
        this.myAuto = myAuto;
    }

    public String getAutoPrice() {
        return autoPrice;
    }

    public void setAutoPrice(String autoPrice) {
        this.autoPrice = autoPrice;
    }
}
