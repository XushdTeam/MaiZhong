package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkCkhsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkCkhsExample() {
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

        public Criteria andFwIsNull() {
            addCriterion("fw is null");
            return (Criteria) this;
        }

        public Criteria andFwIsNotNull() {
            addCriterion("fw is not null");
            return (Criteria) this;
        }

        public Criteria andFwEqualTo(Integer value) {
            addCriterion("fw =", value, "fw");
            return (Criteria) this;
        }

        public Criteria andFwNotEqualTo(Integer value) {
            addCriterion("fw <>", value, "fw");
            return (Criteria) this;
        }

        public Criteria andFwGreaterThan(Integer value) {
            addCriterion("fw >", value, "fw");
            return (Criteria) this;
        }

        public Criteria andFwGreaterThanOrEqualTo(Integer value) {
            addCriterion("fw >=", value, "fw");
            return (Criteria) this;
        }

        public Criteria andFwLessThan(Integer value) {
            addCriterion("fw <", value, "fw");
            return (Criteria) this;
        }

        public Criteria andFwLessThanOrEqualTo(Integer value) {
            addCriterion("fw <=", value, "fw");
            return (Criteria) this;
        }

        public Criteria andFwIn(List<Integer> values) {
            addCriterion("fw in", values, "fw");
            return (Criteria) this;
        }

        public Criteria andFwNotIn(List<Integer> values) {
            addCriterion("fw not in", values, "fw");
            return (Criteria) this;
        }

        public Criteria andFwBetween(Integer value1, Integer value2) {
            addCriterion("fw between", value1, value2, "fw");
            return (Criteria) this;
        }

        public Criteria andFwNotBetween(Integer value1, Integer value2) {
            addCriterion("fw not between", value1, value2, "fw");
            return (Criteria) this;
        }

        public Criteria andBwIsNull() {
            addCriterion("bw is null");
            return (Criteria) this;
        }

        public Criteria andBwIsNotNull() {
            addCriterion("bw is not null");
            return (Criteria) this;
        }

        public Criteria andBwEqualTo(Integer value) {
            addCriterion("bw =", value, "bw");
            return (Criteria) this;
        }

        public Criteria andBwNotEqualTo(Integer value) {
            addCriterion("bw <>", value, "bw");
            return (Criteria) this;
        }

        public Criteria andBwGreaterThan(Integer value) {
            addCriterion("bw >", value, "bw");
            return (Criteria) this;
        }

        public Criteria andBwGreaterThanOrEqualTo(Integer value) {
            addCriterion("bw >=", value, "bw");
            return (Criteria) this;
        }

        public Criteria andBwLessThan(Integer value) {
            addCriterion("bw <", value, "bw");
            return (Criteria) this;
        }

        public Criteria andBwLessThanOrEqualTo(Integer value) {
            addCriterion("bw <=", value, "bw");
            return (Criteria) this;
        }

        public Criteria andBwIn(List<Integer> values) {
            addCriterion("bw in", values, "bw");
            return (Criteria) this;
        }

        public Criteria andBwNotIn(List<Integer> values) {
            addCriterion("bw not in", values, "bw");
            return (Criteria) this;
        }

        public Criteria andBwBetween(Integer value1, Integer value2) {
            addCriterion("bw between", value1, value2, "bw");
            return (Criteria) this;
        }

        public Criteria andBwNotBetween(Integer value1, Integer value2) {
            addCriterion("bw not between", value1, value2, "bw");
            return (Criteria) this;
        }

        public Criteria andMsIsNull() {
            addCriterion("ms is null");
            return (Criteria) this;
        }

        public Criteria andMsIsNotNull() {
            addCriterion("ms is not null");
            return (Criteria) this;
        }

        public Criteria andMsEqualTo(Integer value) {
            addCriterion("ms =", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotEqualTo(Integer value) {
            addCriterion("ms <>", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsGreaterThan(Integer value) {
            addCriterion("ms >", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ms >=", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsLessThan(Integer value) {
            addCriterion("ms <", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsLessThanOrEqualTo(Integer value) {
            addCriterion("ms <=", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsIn(List<Integer> values) {
            addCriterion("ms in", values, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotIn(List<Integer> values) {
            addCriterion("ms not in", values, "ms");
            return (Criteria) this;
        }

        public Criteria andMsBetween(Integer value1, Integer value2) {
            addCriterion("ms between", value1, value2, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotBetween(Integer value1, Integer value2) {
            addCriterion("ms not between", value1, value2, "ms");
            return (Criteria) this;
        }

        public Criteria andDesIsNull() {
            addCriterion("des is null");
            return (Criteria) this;
        }

        public Criteria andDesIsNotNull() {
            addCriterion("des is not null");
            return (Criteria) this;
        }

        public Criteria andDesEqualTo(String value) {
            addCriterion("des =", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotEqualTo(String value) {
            addCriterion("des <>", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThan(String value) {
            addCriterion("des >", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThanOrEqualTo(String value) {
            addCriterion("des >=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThan(String value) {
            addCriterion("des <", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThanOrEqualTo(String value) {
            addCriterion("des <=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLike(String value) {
            addCriterion("des like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotLike(String value) {
            addCriterion("des not like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesIn(List<String> values) {
            addCriterion("des in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotIn(List<String> values) {
            addCriterion("des not in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesBetween(String value1, String value2) {
            addCriterion("des between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotBetween(String value1, String value2) {
            addCriterion("des not between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
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