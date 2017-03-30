package com.maizhong.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCarExample() {
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andBaseIdIsNull() {
            addCriterion("base_id is null");
            return (Criteria) this;
        }

        public Criteria andBaseIdIsNotNull() {
            addCriterion("base_id is not null");
            return (Criteria) this;
        }

        public Criteria andBaseIdEqualTo(Long value) {
            addCriterion("base_id =", value, "baseId");
            return (Criteria) this;
        }

        public Criteria andBaseIdNotEqualTo(Long value) {
            addCriterion("base_id <>", value, "baseId");
            return (Criteria) this;
        }

        public Criteria andBaseIdGreaterThan(Long value) {
            addCriterion("base_id >", value, "baseId");
            return (Criteria) this;
        }

        public Criteria andBaseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("base_id >=", value, "baseId");
            return (Criteria) this;
        }

        public Criteria andBaseIdLessThan(Long value) {
            addCriterion("base_id <", value, "baseId");
            return (Criteria) this;
        }

        public Criteria andBaseIdLessThanOrEqualTo(Long value) {
            addCriterion("base_id <=", value, "baseId");
            return (Criteria) this;
        }

        public Criteria andBaseIdIn(List<Long> values) {
            addCriterion("base_id in", values, "baseId");
            return (Criteria) this;
        }

        public Criteria andBaseIdNotIn(List<Long> values) {
            addCriterion("base_id not in", values, "baseId");
            return (Criteria) this;
        }

        public Criteria andBaseIdBetween(Long value1, Long value2) {
            addCriterion("base_id between", value1, value2, "baseId");
            return (Criteria) this;
        }

        public Criteria andBaseIdNotBetween(Long value1, Long value2) {
            addCriterion("base_id not between", value1, value2, "baseId");
            return (Criteria) this;
        }

        public Criteria andCarBrandIsNull() {
            addCriterion("car_brand is null");
            return (Criteria) this;
        }

        public Criteria andCarBrandIsNotNull() {
            addCriterion("car_brand is not null");
            return (Criteria) this;
        }

        public Criteria andCarBrandEqualTo(Long value) {
            addCriterion("car_brand =", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotEqualTo(Long value) {
            addCriterion("car_brand <>", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandGreaterThan(Long value) {
            addCriterion("car_brand >", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandGreaterThanOrEqualTo(Long value) {
            addCriterion("car_brand >=", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLessThan(Long value) {
            addCriterion("car_brand <", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLessThanOrEqualTo(Long value) {
            addCriterion("car_brand <=", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandIn(List<Long> values) {
            addCriterion("car_brand in", values, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotIn(List<Long> values) {
            addCriterion("car_brand not in", values, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandBetween(Long value1, Long value2) {
            addCriterion("car_brand between", value1, value2, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotBetween(Long value1, Long value2) {
            addCriterion("car_brand not between", value1, value2, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineIsNull() {
            addCriterion("car_brand_line is null");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineIsNotNull() {
            addCriterion("car_brand_line is not null");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineEqualTo(Long value) {
            addCriterion("car_brand_line =", value, "carBrandLine");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineNotEqualTo(Long value) {
            addCriterion("car_brand_line <>", value, "carBrandLine");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineGreaterThan(Long value) {
            addCriterion("car_brand_line >", value, "carBrandLine");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineGreaterThanOrEqualTo(Long value) {
            addCriterion("car_brand_line >=", value, "carBrandLine");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineLessThan(Long value) {
            addCriterion("car_brand_line <", value, "carBrandLine");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineLessThanOrEqualTo(Long value) {
            addCriterion("car_brand_line <=", value, "carBrandLine");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineIn(List<Long> values) {
            addCriterion("car_brand_line in", values, "carBrandLine");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineNotIn(List<Long> values) {
            addCriterion("car_brand_line not in", values, "carBrandLine");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineBetween(Long value1, Long value2) {
            addCriterion("car_brand_line between", value1, value2, "carBrandLine");
            return (Criteria) this;
        }

        public Criteria andCarBrandLineNotBetween(Long value1, Long value2) {
            addCriterion("car_brand_line not between", value1, value2, "carBrandLine");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(Long value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(Long value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(Long value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(Long value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(Long value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<Long> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<Long> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(Long value1, Long value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(Long value1, Long value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarYearIsNull() {
            addCriterion("car_year is null");
            return (Criteria) this;
        }

        public Criteria andCarYearIsNotNull() {
            addCriterion("car_year is not null");
            return (Criteria) this;
        }

        public Criteria andCarYearEqualTo(String value) {
            addCriterion("car_year =", value, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearNotEqualTo(String value) {
            addCriterion("car_year <>", value, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearGreaterThan(String value) {
            addCriterion("car_year >", value, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearGreaterThanOrEqualTo(String value) {
            addCriterion("car_year >=", value, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearLessThan(String value) {
            addCriterion("car_year <", value, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearLessThanOrEqualTo(String value) {
            addCriterion("car_year <=", value, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearLike(String value) {
            addCriterion("car_year like", value, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearNotLike(String value) {
            addCriterion("car_year not like", value, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearIn(List<String> values) {
            addCriterion("car_year in", values, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearNotIn(List<String> values) {
            addCriterion("car_year not in", values, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearBetween(String value1, String value2) {
            addCriterion("car_year between", value1, value2, "carYear");
            return (Criteria) this;
        }

        public Criteria andCarYearNotBetween(String value1, String value2) {
            addCriterion("car_year not between", value1, value2, "carYear");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andSellpointIsNull() {
            addCriterion("sellpoint is null");
            return (Criteria) this;
        }

        public Criteria andSellpointIsNotNull() {
            addCriterion("sellpoint is not null");
            return (Criteria) this;
        }

        public Criteria andSellpointEqualTo(String value) {
            addCriterion("sellpoint =", value, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointNotEqualTo(String value) {
            addCriterion("sellpoint <>", value, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointGreaterThan(String value) {
            addCriterion("sellpoint >", value, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointGreaterThanOrEqualTo(String value) {
            addCriterion("sellpoint >=", value, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointLessThan(String value) {
            addCriterion("sellpoint <", value, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointLessThanOrEqualTo(String value) {
            addCriterion("sellpoint <=", value, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointLike(String value) {
            addCriterion("sellpoint like", value, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointNotLike(String value) {
            addCriterion("sellpoint not like", value, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointIn(List<String> values) {
            addCriterion("sellpoint in", values, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointNotIn(List<String> values) {
            addCriterion("sellpoint not in", values, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointBetween(String value1, String value2) {
            addCriterion("sellpoint between", value1, value2, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andSellpointNotBetween(String value1, String value2) {
            addCriterion("sellpoint not between", value1, value2, "sellpoint");
            return (Criteria) this;
        }

        public Criteria andReservePriceIsNull() {
            addCriterion("reserve_price is null");
            return (Criteria) this;
        }

        public Criteria andReservePriceIsNotNull() {
            addCriterion("reserve_price is not null");
            return (Criteria) this;
        }

        public Criteria andReservePriceEqualTo(BigDecimal value) {
            addCriterion("reserve_price =", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotEqualTo(BigDecimal value) {
            addCriterion("reserve_price <>", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceGreaterThan(BigDecimal value) {
            addCriterion("reserve_price >", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reserve_price >=", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceLessThan(BigDecimal value) {
            addCriterion("reserve_price <", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reserve_price <=", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceIn(List<BigDecimal> values) {
            addCriterion("reserve_price in", values, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotIn(List<BigDecimal> values) {
            addCriterion("reserve_price not in", values, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reserve_price between", value1, value2, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reserve_price not between", value1, value2, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNull() {
            addCriterion("sell_price is null");
            return (Criteria) this;
        }

        public Criteria andSellPriceIsNotNull() {
            addCriterion("sell_price is not null");
            return (Criteria) this;
        }

        public Criteria andSellPriceEqualTo(BigDecimal value) {
            addCriterion("sell_price =", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotEqualTo(BigDecimal value) {
            addCriterion("sell_price <>", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThan(BigDecimal value) {
            addCriterion("sell_price >", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_price >=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThan(BigDecimal value) {
            addCriterion("sell_price <", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sell_price <=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIn(List<BigDecimal> values) {
            addCriterion("sell_price in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotIn(List<BigDecimal> values) {
            addCriterion("sell_price not in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_price between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell_price not between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andSmimageIsNull() {
            addCriterion("smimage is null");
            return (Criteria) this;
        }

        public Criteria andSmimageIsNotNull() {
            addCriterion("smimage is not null");
            return (Criteria) this;
        }

        public Criteria andSmimageEqualTo(String value) {
            addCriterion("smimage =", value, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageNotEqualTo(String value) {
            addCriterion("smimage <>", value, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageGreaterThan(String value) {
            addCriterion("smimage >", value, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageGreaterThanOrEqualTo(String value) {
            addCriterion("smimage >=", value, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageLessThan(String value) {
            addCriterion("smimage <", value, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageLessThanOrEqualTo(String value) {
            addCriterion("smimage <=", value, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageLike(String value) {
            addCriterion("smimage like", value, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageNotLike(String value) {
            addCriterion("smimage not like", value, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageIn(List<String> values) {
            addCriterion("smimage in", values, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageNotIn(List<String> values) {
            addCriterion("smimage not in", values, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageBetween(String value1, String value2) {
            addCriterion("smimage between", value1, value2, "smimage");
            return (Criteria) this;
        }

        public Criteria andSmimageNotBetween(String value1, String value2) {
            addCriterion("smimage not between", value1, value2, "smimage");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNull() {
            addCriterion("business_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNotNull() {
            addCriterion("business_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdEqualTo(Long value) {
            addCriterion("business_id =", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotEqualTo(Long value) {
            addCriterion("business_id <>", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThan(Long value) {
            addCriterion("business_id >", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("business_id >=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThan(Long value) {
            addCriterion("business_id <", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThanOrEqualTo(Long value) {
            addCriterion("business_id <=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIn(List<Long> values) {
            addCriterion("business_id in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotIn(List<Long> values) {
            addCriterion("business_id not in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdBetween(Long value1, Long value2) {
            addCriterion("business_id between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotBetween(Long value1, Long value2) {
            addCriterion("business_id not between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andStockNumIsNull() {
            addCriterion("stock_num is null");
            return (Criteria) this;
        }

        public Criteria andStockNumIsNotNull() {
            addCriterion("stock_num is not null");
            return (Criteria) this;
        }

        public Criteria andStockNumEqualTo(Integer value) {
            addCriterion("stock_num =", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotEqualTo(Integer value) {
            addCriterion("stock_num <>", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumGreaterThan(Integer value) {
            addCriterion("stock_num >", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_num >=", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumLessThan(Integer value) {
            addCriterion("stock_num <", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumLessThanOrEqualTo(Integer value) {
            addCriterion("stock_num <=", value, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumIn(List<Integer> values) {
            addCriterion("stock_num in", values, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotIn(List<Integer> values) {
            addCriterion("stock_num not in", values, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumBetween(Integer value1, Integer value2) {
            addCriterion("stock_num between", value1, value2, "stockNum");
            return (Criteria) this;
        }

        public Criteria andStockNumNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_num not between", value1, value2, "stockNum");
            return (Criteria) this;
        }

        public Criteria andSellNumIsNull() {
            addCriterion("sell_num is null");
            return (Criteria) this;
        }

        public Criteria andSellNumIsNotNull() {
            addCriterion("sell_num is not null");
            return (Criteria) this;
        }

        public Criteria andSellNumEqualTo(Integer value) {
            addCriterion("sell_num =", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumNotEqualTo(Integer value) {
            addCriterion("sell_num <>", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumGreaterThan(Integer value) {
            addCriterion("sell_num >", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_num >=", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumLessThan(Integer value) {
            addCriterion("sell_num <", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumLessThanOrEqualTo(Integer value) {
            addCriterion("sell_num <=", value, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumIn(List<Integer> values) {
            addCriterion("sell_num in", values, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumNotIn(List<Integer> values) {
            addCriterion("sell_num not in", values, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumBetween(Integer value1, Integer value2) {
            addCriterion("sell_num between", value1, value2, "sellNum");
            return (Criteria) this;
        }

        public Criteria andSellNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_num not between", value1, value2, "sellNum");
            return (Criteria) this;
        }

        public Criteria andIssaleIsNull() {
            addCriterion("issale is null");
            return (Criteria) this;
        }

        public Criteria andIssaleIsNotNull() {
            addCriterion("issale is not null");
            return (Criteria) this;
        }

        public Criteria andIssaleEqualTo(Integer value) {
            addCriterion("issale =", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleNotEqualTo(Integer value) {
            addCriterion("issale <>", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleGreaterThan(Integer value) {
            addCriterion("issale >", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("issale >=", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleLessThan(Integer value) {
            addCriterion("issale <", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleLessThanOrEqualTo(Integer value) {
            addCriterion("issale <=", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleIn(List<Integer> values) {
            addCriterion("issale in", values, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleNotIn(List<Integer> values) {
            addCriterion("issale not in", values, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleBetween(Integer value1, Integer value2) {
            addCriterion("issale between", value1, value2, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleNotBetween(Integer value1, Integer value2) {
            addCriterion("issale not between", value1, value2, "issale");
            return (Criteria) this;
        }

        public Criteria andUnableIsNull() {
            addCriterion("unable is null");
            return (Criteria) this;
        }

        public Criteria andUnableIsNotNull() {
            addCriterion("unable is not null");
            return (Criteria) this;
        }

        public Criteria andUnableEqualTo(Integer value) {
            addCriterion("unable =", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableNotEqualTo(Integer value) {
            addCriterion("unable <>", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableGreaterThan(Integer value) {
            addCriterion("unable >", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("unable >=", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableLessThan(Integer value) {
            addCriterion("unable <", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableLessThanOrEqualTo(Integer value) {
            addCriterion("unable <=", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableIn(List<Integer> values) {
            addCriterion("unable in", values, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableNotIn(List<Integer> values) {
            addCriterion("unable not in", values, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableBetween(Integer value1, Integer value2) {
            addCriterion("unable between", value1, value2, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableNotBetween(Integer value1, Integer value2) {
            addCriterion("unable not between", value1, value2, "unable");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
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