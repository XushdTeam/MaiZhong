package com.maizhong.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbCarSkuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCarSkuExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCarModelIdIsNull() {
            addCriterion("car_model_id is null");
            return (Criteria) this;
        }

        public Criteria andCarModelIdIsNotNull() {
            addCriterion("car_model_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarModelIdEqualTo(Long value) {
            addCriterion("car_model_id =", value, "carModelId");
            return (Criteria) this;
        }

        public Criteria andCarModelIdNotEqualTo(Long value) {
            addCriterion("car_model_id <>", value, "carModelId");
            return (Criteria) this;
        }

        public Criteria andCarModelIdGreaterThan(Long value) {
            addCriterion("car_model_id >", value, "carModelId");
            return (Criteria) this;
        }

        public Criteria andCarModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("car_model_id >=", value, "carModelId");
            return (Criteria) this;
        }

        public Criteria andCarModelIdLessThan(Long value) {
            addCriterion("car_model_id <", value, "carModelId");
            return (Criteria) this;
        }

        public Criteria andCarModelIdLessThanOrEqualTo(Long value) {
            addCriterion("car_model_id <=", value, "carModelId");
            return (Criteria) this;
        }

        public Criteria andCarModelIdIn(List<Long> values) {
            addCriterion("car_model_id in", values, "carModelId");
            return (Criteria) this;
        }

        public Criteria andCarModelIdNotIn(List<Long> values) {
            addCriterion("car_model_id not in", values, "carModelId");
            return (Criteria) this;
        }

        public Criteria andCarModelIdBetween(Long value1, Long value2) {
            addCriterion("car_model_id between", value1, value2, "carModelId");
            return (Criteria) this;
        }

        public Criteria andCarModelIdNotBetween(Long value1, Long value2) {
            addCriterion("car_model_id not between", value1, value2, "carModelId");
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

        public Criteria andColorEqualTo(Long value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(Long value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(Long value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(Long value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(Long value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(Long value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<Long> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<Long> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(Long value1, Long value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(Long value1, Long value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(Double value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(Double value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(Double value) {
            addCriterion("capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(Double value) {
            addCriterion("capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(Double value) {
            addCriterion("capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(Double value) {
            addCriterion("capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<Double> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<Double> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(Double value1, Double value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(Double value1, Double value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andGearboxIsNull() {
            addCriterion("gearbox is null");
            return (Criteria) this;
        }

        public Criteria andGearboxIsNotNull() {
            addCriterion("gearbox is not null");
            return (Criteria) this;
        }

        public Criteria andGearboxEqualTo(Long value) {
            addCriterion("gearbox =", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxNotEqualTo(Long value) {
            addCriterion("gearbox <>", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxGreaterThan(Long value) {
            addCriterion("gearbox >", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxGreaterThanOrEqualTo(Long value) {
            addCriterion("gearbox >=", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxLessThan(Long value) {
            addCriterion("gearbox <", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxLessThanOrEqualTo(Long value) {
            addCriterion("gearbox <=", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxIn(List<Long> values) {
            addCriterion("gearbox in", values, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxNotIn(List<Long> values) {
            addCriterion("gearbox not in", values, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxBetween(Long value1, Long value2) {
            addCriterion("gearbox between", value1, value2, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxNotBetween(Long value1, Long value2) {
            addCriterion("gearbox not between", value1, value2, "gearbox");
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

        public Criteria andShopPriceIsNull() {
            addCriterion("shop_price is null");
            return (Criteria) this;
        }

        public Criteria andShopPriceIsNotNull() {
            addCriterion("shop_price is not null");
            return (Criteria) this;
        }

        public Criteria andShopPriceEqualTo(Double value) {
            addCriterion("shop_price =", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceNotEqualTo(Double value) {
            addCriterion("shop_price <>", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceGreaterThan(Double value) {
            addCriterion("shop_price >", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("shop_price >=", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceLessThan(Double value) {
            addCriterion("shop_price <", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceLessThanOrEqualTo(Double value) {
            addCriterion("shop_price <=", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceIn(List<Double> values) {
            addCriterion("shop_price in", values, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceNotIn(List<Double> values) {
            addCriterion("shop_price not in", values, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceBetween(Double value1, Double value2) {
            addCriterion("shop_price between", value1, value2, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceNotBetween(Double value1, Double value2) {
            addCriterion("shop_price not between", value1, value2, "shopPrice");
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

        public Criteria andSellPriceEqualTo(Double value) {
            addCriterion("sell_price =", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotEqualTo(Double value) {
            addCriterion("sell_price <>", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThan(Double value) {
            addCriterion("sell_price >", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("sell_price >=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThan(Double value) {
            addCriterion("sell_price <", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceLessThanOrEqualTo(Double value) {
            addCriterion("sell_price <=", value, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceIn(List<Double> values) {
            addCriterion("sell_price in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotIn(List<Double> values) {
            addCriterion("sell_price not in", values, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceBetween(Double value1, Double value2) {
            addCriterion("sell_price between", value1, value2, "sellPrice");
            return (Criteria) this;
        }

        public Criteria andSellPriceNotBetween(Double value1, Double value2) {
            addCriterion("sell_price not between", value1, value2, "sellPrice");
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

        public Criteria andReservePriceEqualTo(Double value) {
            addCriterion("reserve_price =", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotEqualTo(Double value) {
            addCriterion("reserve_price <>", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceGreaterThan(Double value) {
            addCriterion("reserve_price >", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceGreaterThanOrEqualTo(Double value) {
            addCriterion("reserve_price >=", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceLessThan(Double value) {
            addCriterion("reserve_price <", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceLessThanOrEqualTo(Double value) {
            addCriterion("reserve_price <=", value, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceIn(List<Double> values) {
            addCriterion("reserve_price in", values, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotIn(List<Double> values) {
            addCriterion("reserve_price not in", values, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceBetween(Double value1, Double value2) {
            addCriterion("reserve_price between", value1, value2, "reservePrice");
            return (Criteria) this;
        }

        public Criteria andReservePriceNotBetween(Double value1, Double value2) {
            addCriterion("reserve_price not between", value1, value2, "reservePrice");
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