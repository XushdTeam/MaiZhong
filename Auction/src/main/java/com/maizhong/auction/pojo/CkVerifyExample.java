package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkVerifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkVerifyExample() {
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

        public Criteria andXszIsNull() {
            addCriterion("xsz is null");
            return (Criteria) this;
        }

        public Criteria andXszIsNotNull() {
            addCriterion("xsz is not null");
            return (Criteria) this;
        }

        public Criteria andXszEqualTo(String value) {
            addCriterion("xsz =", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszNotEqualTo(String value) {
            addCriterion("xsz <>", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszGreaterThan(String value) {
            addCriterion("xsz >", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszGreaterThanOrEqualTo(String value) {
            addCriterion("xsz >=", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszLessThan(String value) {
            addCriterion("xsz <", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszLessThanOrEqualTo(String value) {
            addCriterion("xsz <=", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszLike(String value) {
            addCriterion("xsz like", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszNotLike(String value) {
            addCriterion("xsz not like", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszIn(List<String> values) {
            addCriterion("xsz in", values, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszNotIn(List<String> values) {
            addCriterion("xsz not in", values, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszBetween(String value1, String value2) {
            addCriterion("xsz between", value1, value2, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszNotBetween(String value1, String value2) {
            addCriterion("xsz not between", value1, value2, "xsz");
            return (Criteria) this;
        }

        public Criteria andDjzIsNull() {
            addCriterion("djz is null");
            return (Criteria) this;
        }

        public Criteria andDjzIsNotNull() {
            addCriterion("djz is not null");
            return (Criteria) this;
        }

        public Criteria andDjzEqualTo(String value) {
            addCriterion("djz =", value, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzNotEqualTo(String value) {
            addCriterion("djz <>", value, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzGreaterThan(String value) {
            addCriterion("djz >", value, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzGreaterThanOrEqualTo(String value) {
            addCriterion("djz >=", value, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzLessThan(String value) {
            addCriterion("djz <", value, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzLessThanOrEqualTo(String value) {
            addCriterion("djz <=", value, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzLike(String value) {
            addCriterion("djz like", value, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzNotLike(String value) {
            addCriterion("djz not like", value, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzIn(List<String> values) {
            addCriterion("djz in", values, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzNotIn(List<String> values) {
            addCriterion("djz not in", values, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzBetween(String value1, String value2) {
            addCriterion("djz between", value1, value2, "djz");
            return (Criteria) this;
        }

        public Criteria andDjzNotBetween(String value1, String value2) {
            addCriterion("djz not between", value1, value2, "djz");
            return (Criteria) this;
        }

        public Criteria andCjhIsNull() {
            addCriterion("cjh is null");
            return (Criteria) this;
        }

        public Criteria andCjhIsNotNull() {
            addCriterion("cjh is not null");
            return (Criteria) this;
        }

        public Criteria andCjhEqualTo(String value) {
            addCriterion("cjh =", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhNotEqualTo(String value) {
            addCriterion("cjh <>", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhGreaterThan(String value) {
            addCriterion("cjh >", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhGreaterThanOrEqualTo(String value) {
            addCriterion("cjh >=", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhLessThan(String value) {
            addCriterion("cjh <", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhLessThanOrEqualTo(String value) {
            addCriterion("cjh <=", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhLike(String value) {
            addCriterion("cjh like", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhNotLike(String value) {
            addCriterion("cjh not like", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhIn(List<String> values) {
            addCriterion("cjh in", values, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhNotIn(List<String> values) {
            addCriterion("cjh not in", values, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhBetween(String value1, String value2) {
            addCriterion("cjh between", value1, value2, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhNotBetween(String value1, String value2) {
            addCriterion("cjh not between", value1, value2, "cjh");
            return (Criteria) this;
        }

        public Criteria andLtggIsNull() {
            addCriterion("ltgg is null");
            return (Criteria) this;
        }

        public Criteria andLtggIsNotNull() {
            addCriterion("ltgg is not null");
            return (Criteria) this;
        }

        public Criteria andLtggEqualTo(String value) {
            addCriterion("ltgg =", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggNotEqualTo(String value) {
            addCriterion("ltgg <>", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggGreaterThan(String value) {
            addCriterion("ltgg >", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggGreaterThanOrEqualTo(String value) {
            addCriterion("ltgg >=", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggLessThan(String value) {
            addCriterion("ltgg <", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggLessThanOrEqualTo(String value) {
            addCriterion("ltgg <=", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggLike(String value) {
            addCriterion("ltgg like", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggNotLike(String value) {
            addCriterion("ltgg not like", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggIn(List<String> values) {
            addCriterion("ltgg in", values, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggNotIn(List<String> values) {
            addCriterion("ltgg not in", values, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggBetween(String value1, String value2) {
            addCriterion("ltgg between", value1, value2, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggNotBetween(String value1, String value2) {
            addCriterion("ltgg not between", value1, value2, "ltgg");
            return (Criteria) this;
        }

        public Criteria andBxlcIsNull() {
            addCriterion("bxlc is null");
            return (Criteria) this;
        }

        public Criteria andBxlcIsNotNull() {
            addCriterion("bxlc is not null");
            return (Criteria) this;
        }

        public Criteria andBxlcEqualTo(String value) {
            addCriterion("bxlc =", value, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcNotEqualTo(String value) {
            addCriterion("bxlc <>", value, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcGreaterThan(String value) {
            addCriterion("bxlc >", value, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcGreaterThanOrEqualTo(String value) {
            addCriterion("bxlc >=", value, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcLessThan(String value) {
            addCriterion("bxlc <", value, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcLessThanOrEqualTo(String value) {
            addCriterion("bxlc <=", value, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcLike(String value) {
            addCriterion("bxlc like", value, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcNotLike(String value) {
            addCriterion("bxlc not like", value, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcIn(List<String> values) {
            addCriterion("bxlc in", values, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcNotIn(List<String> values) {
            addCriterion("bxlc not in", values, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcBetween(String value1, String value2) {
            addCriterion("bxlc between", value1, value2, "bxlc");
            return (Criteria) this;
        }

        public Criteria andBxlcNotBetween(String value1, String value2) {
            addCriterion("bxlc not between", value1, value2, "bxlc");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNull() {
            addCriterion("start_price is null");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNotNull() {
            addCriterion("start_price is not null");
            return (Criteria) this;
        }

        public Criteria andStartPriceEqualTo(String value) {
            addCriterion("start_price =", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotEqualTo(String value) {
            addCriterion("start_price <>", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThan(String value) {
            addCriterion("start_price >", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThanOrEqualTo(String value) {
            addCriterion("start_price >=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThan(String value) {
            addCriterion("start_price <", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThanOrEqualTo(String value) {
            addCriterion("start_price <=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLike(String value) {
            addCriterion("start_price like", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotLike(String value) {
            addCriterion("start_price not like", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceIn(List<String> values) {
            addCriterion("start_price in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotIn(List<String> values) {
            addCriterion("start_price not in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceBetween(String value1, String value2) {
            addCriterion("start_price between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotBetween(String value1, String value2) {
            addCriterion("start_price not between", value1, value2, "startPrice");
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