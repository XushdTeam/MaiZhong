package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TpHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TpHistoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Long value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Long value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Long value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Long value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Long value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Long value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Long> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Long> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Long value1, Long value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Long value1, Long value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPlusIsNull() {
            addCriterion("plus is null");
            return (Criteria) this;
        }

        public Criteria andPlusIsNotNull() {
            addCriterion("plus is not null");
            return (Criteria) this;
        }

        public Criteria andPlusEqualTo(Integer value) {
            addCriterion("plus =", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusNotEqualTo(Integer value) {
            addCriterion("plus <>", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusGreaterThan(Integer value) {
            addCriterion("plus >", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusGreaterThanOrEqualTo(Integer value) {
            addCriterion("plus >=", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusLessThan(Integer value) {
            addCriterion("plus <", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusLessThanOrEqualTo(Integer value) {
            addCriterion("plus <=", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusIn(List<Integer> values) {
            addCriterion("plus in", values, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusNotIn(List<Integer> values) {
            addCriterion("plus not in", values, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusBetween(Integer value1, Integer value2) {
            addCriterion("plus between", value1, value2, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusNotBetween(Integer value1, Integer value2) {
            addCriterion("plus not between", value1, value2, "plus");
            return (Criteria) this;
        }

        public Criteria andBussinessNameIsNull() {
            addCriterion("bussiness_name is null");
            return (Criteria) this;
        }

        public Criteria andBussinessNameIsNotNull() {
            addCriterion("bussiness_name is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessNameEqualTo(String value) {
            addCriterion("bussiness_name =", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameNotEqualTo(String value) {
            addCriterion("bussiness_name <>", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameGreaterThan(String value) {
            addCriterion("bussiness_name >", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameGreaterThanOrEqualTo(String value) {
            addCriterion("bussiness_name >=", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameLessThan(String value) {
            addCriterion("bussiness_name <", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameLessThanOrEqualTo(String value) {
            addCriterion("bussiness_name <=", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameLike(String value) {
            addCriterion("bussiness_name like", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameNotLike(String value) {
            addCriterion("bussiness_name not like", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameIn(List<String> values) {
            addCriterion("bussiness_name in", values, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameNotIn(List<String> values) {
            addCriterion("bussiness_name not in", values, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameBetween(String value1, String value2) {
            addCriterion("bussiness_name between", value1, value2, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameNotBetween(String value1, String value2) {
            addCriterion("bussiness_name not between", value1, value2, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAuctionDateIsNull() {
            addCriterion("auction_date is null");
            return (Criteria) this;
        }

        public Criteria andAuctionDateIsNotNull() {
            addCriterion("auction_date is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionDateEqualTo(Date value) {
            addCriterion("auction_date =", value, "auctionDate");
            return (Criteria) this;
        }

        public Criteria andAuctionDateNotEqualTo(Date value) {
            addCriterion("auction_date <>", value, "auctionDate");
            return (Criteria) this;
        }

        public Criteria andAuctionDateGreaterThan(Date value) {
            addCriterion("auction_date >", value, "auctionDate");
            return (Criteria) this;
        }

        public Criteria andAuctionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("auction_date >=", value, "auctionDate");
            return (Criteria) this;
        }

        public Criteria andAuctionDateLessThan(Date value) {
            addCriterion("auction_date <", value, "auctionDate");
            return (Criteria) this;
        }

        public Criteria andAuctionDateLessThanOrEqualTo(Date value) {
            addCriterion("auction_date <=", value, "auctionDate");
            return (Criteria) this;
        }

        public Criteria andAuctionDateIn(List<Date> values) {
            addCriterion("auction_date in", values, "auctionDate");
            return (Criteria) this;
        }

        public Criteria andAuctionDateNotIn(List<Date> values) {
            addCriterion("auction_date not in", values, "auctionDate");
            return (Criteria) this;
        }

        public Criteria andAuctionDateBetween(Date value1, Date value2) {
            addCriterion("auction_date between", value1, value2, "auctionDate");
            return (Criteria) this;
        }

        public Criteria andAuctionDateNotBetween(Date value1, Date value2) {
            addCriterion("auction_date not between", value1, value2, "auctionDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}