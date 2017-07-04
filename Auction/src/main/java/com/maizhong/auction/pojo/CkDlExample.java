package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkDlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkDlExample() {
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

        public Criteria andFdjXnIsNull() {
            addCriterion("fdj_xn is null");
            return (Criteria) this;
        }

        public Criteria andFdjXnIsNotNull() {
            addCriterion("fdj_xn is not null");
            return (Criteria) this;
        }

        public Criteria andFdjXnEqualTo(Integer value) {
            addCriterion("fdj_xn =", value, "fdjXn");
            return (Criteria) this;
        }

        public Criteria andFdjXnNotEqualTo(Integer value) {
            addCriterion("fdj_xn <>", value, "fdjXn");
            return (Criteria) this;
        }

        public Criteria andFdjXnGreaterThan(Integer value) {
            addCriterion("fdj_xn >", value, "fdjXn");
            return (Criteria) this;
        }

        public Criteria andFdjXnGreaterThanOrEqualTo(Integer value) {
            addCriterion("fdj_xn >=", value, "fdjXn");
            return (Criteria) this;
        }

        public Criteria andFdjXnLessThan(Integer value) {
            addCriterion("fdj_xn <", value, "fdjXn");
            return (Criteria) this;
        }

        public Criteria andFdjXnLessThanOrEqualTo(Integer value) {
            addCriterion("fdj_xn <=", value, "fdjXn");
            return (Criteria) this;
        }

        public Criteria andFdjXnIn(List<Integer> values) {
            addCriterion("fdj_xn in", values, "fdjXn");
            return (Criteria) this;
        }

        public Criteria andFdjXnNotIn(List<Integer> values) {
            addCriterion("fdj_xn not in", values, "fdjXn");
            return (Criteria) this;
        }

        public Criteria andFdjXnBetween(Integer value1, Integer value2) {
            addCriterion("fdj_xn between", value1, value2, "fdjXn");
            return (Criteria) this;
        }

        public Criteria andFdjXnNotBetween(Integer value1, Integer value2) {
            addCriterion("fdj_xn not between", value1, value2, "fdjXn");
            return (Criteria) this;
        }

        public Criteria andFdjWqIsNull() {
            addCriterion("fdj_wq is null");
            return (Criteria) this;
        }

        public Criteria andFdjWqIsNotNull() {
            addCriterion("fdj_wq is not null");
            return (Criteria) this;
        }

        public Criteria andFdjWqEqualTo(Integer value) {
            addCriterion("fdj_wq =", value, "fdjWq");
            return (Criteria) this;
        }

        public Criteria andFdjWqNotEqualTo(Integer value) {
            addCriterion("fdj_wq <>", value, "fdjWq");
            return (Criteria) this;
        }

        public Criteria andFdjWqGreaterThan(Integer value) {
            addCriterion("fdj_wq >", value, "fdjWq");
            return (Criteria) this;
        }

        public Criteria andFdjWqGreaterThanOrEqualTo(Integer value) {
            addCriterion("fdj_wq >=", value, "fdjWq");
            return (Criteria) this;
        }

        public Criteria andFdjWqLessThan(Integer value) {
            addCriterion("fdj_wq <", value, "fdjWq");
            return (Criteria) this;
        }

        public Criteria andFdjWqLessThanOrEqualTo(Integer value) {
            addCriterion("fdj_wq <=", value, "fdjWq");
            return (Criteria) this;
        }

        public Criteria andFdjWqIn(List<Integer> values) {
            addCriterion("fdj_wq in", values, "fdjWq");
            return (Criteria) this;
        }

        public Criteria andFdjWqNotIn(List<Integer> values) {
            addCriterion("fdj_wq not in", values, "fdjWq");
            return (Criteria) this;
        }

        public Criteria andFdjWqBetween(Integer value1, Integer value2) {
            addCriterion("fdj_wq between", value1, value2, "fdjWq");
            return (Criteria) this;
        }

        public Criteria andFdjWqNotBetween(Integer value1, Integer value2) {
            addCriterion("fdj_wq not between", value1, value2, "fdjWq");
            return (Criteria) this;
        }

        public Criteria andBsqIsNull() {
            addCriterion("bsq is null");
            return (Criteria) this;
        }

        public Criteria andBsqIsNotNull() {
            addCriterion("bsq is not null");
            return (Criteria) this;
        }

        public Criteria andBsqEqualTo(Integer value) {
            addCriterion("bsq =", value, "bsq");
            return (Criteria) this;
        }

        public Criteria andBsqNotEqualTo(Integer value) {
            addCriterion("bsq <>", value, "bsq");
            return (Criteria) this;
        }

        public Criteria andBsqGreaterThan(Integer value) {
            addCriterion("bsq >", value, "bsq");
            return (Criteria) this;
        }

        public Criteria andBsqGreaterThanOrEqualTo(Integer value) {
            addCriterion("bsq >=", value, "bsq");
            return (Criteria) this;
        }

        public Criteria andBsqLessThan(Integer value) {
            addCriterion("bsq <", value, "bsq");
            return (Criteria) this;
        }

        public Criteria andBsqLessThanOrEqualTo(Integer value) {
            addCriterion("bsq <=", value, "bsq");
            return (Criteria) this;
        }

        public Criteria andBsqIn(List<Integer> values) {
            addCriterion("bsq in", values, "bsq");
            return (Criteria) this;
        }

        public Criteria andBsqNotIn(List<Integer> values) {
            addCriterion("bsq not in", values, "bsq");
            return (Criteria) this;
        }

        public Criteria andBsqBetween(Integer value1, Integer value2) {
            addCriterion("bsq between", value1, value2, "bsq");
            return (Criteria) this;
        }

        public Criteria andBsqNotBetween(Integer value1, Integer value2) {
            addCriterion("bsq not between", value1, value2, "bsq");
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