package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkOtherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkOtherExample() {
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

        public Criteria andWzFIsNull() {
            addCriterion("wz_f is null");
            return (Criteria) this;
        }

        public Criteria andWzFIsNotNull() {
            addCriterion("wz_f is not null");
            return (Criteria) this;
        }

        public Criteria andWzFEqualTo(Integer value) {
            addCriterion("wz_f =", value, "wzF");
            return (Criteria) this;
        }

        public Criteria andWzFNotEqualTo(Integer value) {
            addCriterion("wz_f <>", value, "wzF");
            return (Criteria) this;
        }

        public Criteria andWzFGreaterThan(Integer value) {
            addCriterion("wz_f >", value, "wzF");
            return (Criteria) this;
        }

        public Criteria andWzFGreaterThanOrEqualTo(Integer value) {
            addCriterion("wz_f >=", value, "wzF");
            return (Criteria) this;
        }

        public Criteria andWzFLessThan(Integer value) {
            addCriterion("wz_f <", value, "wzF");
            return (Criteria) this;
        }

        public Criteria andWzFLessThanOrEqualTo(Integer value) {
            addCriterion("wz_f <=", value, "wzF");
            return (Criteria) this;
        }

        public Criteria andWzFIn(List<Integer> values) {
            addCriterion("wz_f in", values, "wzF");
            return (Criteria) this;
        }

        public Criteria andWzFNotIn(List<Integer> values) {
            addCriterion("wz_f not in", values, "wzF");
            return (Criteria) this;
        }

        public Criteria andWzFBetween(Integer value1, Integer value2) {
            addCriterion("wz_f between", value1, value2, "wzF");
            return (Criteria) this;
        }

        public Criteria andWzFNotBetween(Integer value1, Integer value2) {
            addCriterion("wz_f not between", value1, value2, "wzF");
            return (Criteria) this;
        }

        public Criteria andWzQIsNull() {
            addCriterion("wz_q is null");
            return (Criteria) this;
        }

        public Criteria andWzQIsNotNull() {
            addCriterion("wz_q is not null");
            return (Criteria) this;
        }

        public Criteria andWzQEqualTo(String value) {
            addCriterion("wz_q =", value, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQNotEqualTo(String value) {
            addCriterion("wz_q <>", value, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQGreaterThan(String value) {
            addCriterion("wz_q >", value, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQGreaterThanOrEqualTo(String value) {
            addCriterion("wz_q >=", value, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQLessThan(String value) {
            addCriterion("wz_q <", value, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQLessThanOrEqualTo(String value) {
            addCriterion("wz_q <=", value, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQLike(String value) {
            addCriterion("wz_q like", value, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQNotLike(String value) {
            addCriterion("wz_q not like", value, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQIn(List<String> values) {
            addCriterion("wz_q in", values, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQNotIn(List<String> values) {
            addCriterion("wz_q not in", values, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQBetween(String value1, String value2) {
            addCriterion("wz_q between", value1, value2, "wzQ");
            return (Criteria) this;
        }

        public Criteria andWzQNotBetween(String value1, String value2) {
            addCriterion("wz_q not between", value1, value2, "wzQ");
            return (Criteria) this;
        }

        public Criteria andPfbzIsNull() {
            addCriterion("pfbz is null");
            return (Criteria) this;
        }

        public Criteria andPfbzIsNotNull() {
            addCriterion("pfbz is not null");
            return (Criteria) this;
        }

        public Criteria andPfbzEqualTo(Integer value) {
            addCriterion("pfbz =", value, "pfbz");
            return (Criteria) this;
        }

        public Criteria andPfbzNotEqualTo(Integer value) {
            addCriterion("pfbz <>", value, "pfbz");
            return (Criteria) this;
        }

        public Criteria andPfbzGreaterThan(Integer value) {
            addCriterion("pfbz >", value, "pfbz");
            return (Criteria) this;
        }

        public Criteria andPfbzGreaterThanOrEqualTo(Integer value) {
            addCriterion("pfbz >=", value, "pfbz");
            return (Criteria) this;
        }

        public Criteria andPfbzLessThan(Integer value) {
            addCriterion("pfbz <", value, "pfbz");
            return (Criteria) this;
        }

        public Criteria andPfbzLessThanOrEqualTo(Integer value) {
            addCriterion("pfbz <=", value, "pfbz");
            return (Criteria) this;
        }

        public Criteria andPfbzIn(List<Integer> values) {
            addCriterion("pfbz in", values, "pfbz");
            return (Criteria) this;
        }

        public Criteria andPfbzNotIn(List<Integer> values) {
            addCriterion("pfbz not in", values, "pfbz");
            return (Criteria) this;
        }

        public Criteria andPfbzBetween(Integer value1, Integer value2) {
            addCriterion("pfbz between", value1, value2, "pfbz");
            return (Criteria) this;
        }

        public Criteria andPfbzNotBetween(Integer value1, Integer value2) {
            addCriterion("pfbz not between", value1, value2, "pfbz");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andQmgjdIsNull() {
            addCriterion("qmgjd is null");
            return (Criteria) this;
        }

        public Criteria andQmgjdIsNotNull() {
            addCriterion("qmgjd is not null");
            return (Criteria) this;
        }

        public Criteria andQmgjdEqualTo(Integer value) {
            addCriterion("qmgjd =", value, "qmgjd");
            return (Criteria) this;
        }

        public Criteria andQmgjdNotEqualTo(Integer value) {
            addCriterion("qmgjd <>", value, "qmgjd");
            return (Criteria) this;
        }

        public Criteria andQmgjdGreaterThan(Integer value) {
            addCriterion("qmgjd >", value, "qmgjd");
            return (Criteria) this;
        }

        public Criteria andQmgjdGreaterThanOrEqualTo(Integer value) {
            addCriterion("qmgjd >=", value, "qmgjd");
            return (Criteria) this;
        }

        public Criteria andQmgjdLessThan(Integer value) {
            addCriterion("qmgjd <", value, "qmgjd");
            return (Criteria) this;
        }

        public Criteria andQmgjdLessThanOrEqualTo(Integer value) {
            addCriterion("qmgjd <=", value, "qmgjd");
            return (Criteria) this;
        }

        public Criteria andQmgjdIn(List<Integer> values) {
            addCriterion("qmgjd in", values, "qmgjd");
            return (Criteria) this;
        }

        public Criteria andQmgjdNotIn(List<Integer> values) {
            addCriterion("qmgjd not in", values, "qmgjd");
            return (Criteria) this;
        }

        public Criteria andQmgjdBetween(Integer value1, Integer value2) {
            addCriterion("qmgjd between", value1, value2, "qmgjd");
            return (Criteria) this;
        }

        public Criteria andQmgjdNotBetween(Integer value1, Integer value2) {
            addCriterion("qmgjd not between", value1, value2, "qmgjd");
            return (Criteria) this;
        }

        public Criteria andPjIsNull() {
            addCriterion("pj is null");
            return (Criteria) this;
        }

        public Criteria andPjIsNotNull() {
            addCriterion("pj is not null");
            return (Criteria) this;
        }

        public Criteria andPjEqualTo(Integer value) {
            addCriterion("pj =", value, "pj");
            return (Criteria) this;
        }

        public Criteria andPjNotEqualTo(Integer value) {
            addCriterion("pj <>", value, "pj");
            return (Criteria) this;
        }

        public Criteria andPjGreaterThan(Integer value) {
            addCriterion("pj >", value, "pj");
            return (Criteria) this;
        }

        public Criteria andPjGreaterThanOrEqualTo(Integer value) {
            addCriterion("pj >=", value, "pj");
            return (Criteria) this;
        }

        public Criteria andPjLessThan(Integer value) {
            addCriterion("pj <", value, "pj");
            return (Criteria) this;
        }

        public Criteria andPjLessThanOrEqualTo(Integer value) {
            addCriterion("pj <=", value, "pj");
            return (Criteria) this;
        }

        public Criteria andPjIn(List<Integer> values) {
            addCriterion("pj in", values, "pj");
            return (Criteria) this;
        }

        public Criteria andPjNotIn(List<Integer> values) {
            addCriterion("pj not in", values, "pj");
            return (Criteria) this;
        }

        public Criteria andPjBetween(Integer value1, Integer value2) {
            addCriterion("pj between", value1, value2, "pj");
            return (Criteria) this;
        }

        public Criteria andPjNotBetween(Integer value1, Integer value2) {
            addCriterion("pj not between", value1, value2, "pj");
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