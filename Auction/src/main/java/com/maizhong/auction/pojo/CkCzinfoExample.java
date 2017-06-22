package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkCzinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkCzinfoExample() {
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

        public Criteria andCzxxIsNull() {
            addCriterion("czxx is null");
            return (Criteria) this;
        }

        public Criteria andCzxxIsNotNull() {
            addCriterion("czxx is not null");
            return (Criteria) this;
        }

        public Criteria andCzxxEqualTo(String value) {
            addCriterion("czxx =", value, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxNotEqualTo(String value) {
            addCriterion("czxx <>", value, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxGreaterThan(String value) {
            addCriterion("czxx >", value, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxGreaterThanOrEqualTo(String value) {
            addCriterion("czxx >=", value, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxLessThan(String value) {
            addCriterion("czxx <", value, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxLessThanOrEqualTo(String value) {
            addCriterion("czxx <=", value, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxLike(String value) {
            addCriterion("czxx like", value, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxNotLike(String value) {
            addCriterion("czxx not like", value, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxIn(List<String> values) {
            addCriterion("czxx in", values, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxNotIn(List<String> values) {
            addCriterion("czxx not in", values, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxBetween(String value1, String value2) {
            addCriterion("czxx between", value1, value2, "czxx");
            return (Criteria) this;
        }

        public Criteria andCzxxNotBetween(String value1, String value2) {
            addCriterion("czxx not between", value1, value2, "czxx");
            return (Criteria) this;
        }

        public Criteria andZjlxIsNull() {
            addCriterion("zjlx is null");
            return (Criteria) this;
        }

        public Criteria andZjlxIsNotNull() {
            addCriterion("zjlx is not null");
            return (Criteria) this;
        }

        public Criteria andZjlxEqualTo(Integer value) {
            addCriterion("zjlx =", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotEqualTo(Integer value) {
            addCriterion("zjlx <>", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxGreaterThan(Integer value) {
            addCriterion("zjlx >", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxGreaterThanOrEqualTo(Integer value) {
            addCriterion("zjlx >=", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxLessThan(Integer value) {
            addCriterion("zjlx <", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxLessThanOrEqualTo(Integer value) {
            addCriterion("zjlx <=", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxIn(List<Integer> values) {
            addCriterion("zjlx in", values, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotIn(List<Integer> values) {
            addCriterion("zjlx not in", values, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxBetween(Integer value1, Integer value2) {
            addCriterion("zjlx between", value1, value2, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotBetween(Integer value1, Integer value2) {
            addCriterion("zjlx not between", value1, value2, "zjlx");
            return (Criteria) this;
        }

        public Criteria andDjzczyzIsNull() {
            addCriterion("djzczyz is null");
            return (Criteria) this;
        }

        public Criteria andDjzczyzIsNotNull() {
            addCriterion("djzczyz is not null");
            return (Criteria) this;
        }

        public Criteria andDjzczyzEqualTo(Integer value) {
            addCriterion("djzczyz =", value, "djzczyz");
            return (Criteria) this;
        }

        public Criteria andDjzczyzNotEqualTo(Integer value) {
            addCriterion("djzczyz <>", value, "djzczyz");
            return (Criteria) this;
        }

        public Criteria andDjzczyzGreaterThan(Integer value) {
            addCriterion("djzczyz >", value, "djzczyz");
            return (Criteria) this;
        }

        public Criteria andDjzczyzGreaterThanOrEqualTo(Integer value) {
            addCriterion("djzczyz >=", value, "djzczyz");
            return (Criteria) this;
        }

        public Criteria andDjzczyzLessThan(Integer value) {
            addCriterion("djzczyz <", value, "djzczyz");
            return (Criteria) this;
        }

        public Criteria andDjzczyzLessThanOrEqualTo(Integer value) {
            addCriterion("djzczyz <=", value, "djzczyz");
            return (Criteria) this;
        }

        public Criteria andDjzczyzIn(List<Integer> values) {
            addCriterion("djzczyz in", values, "djzczyz");
            return (Criteria) this;
        }

        public Criteria andDjzczyzNotIn(List<Integer> values) {
            addCriterion("djzczyz not in", values, "djzczyz");
            return (Criteria) this;
        }

        public Criteria andDjzczyzBetween(Integer value1, Integer value2) {
            addCriterion("djzczyz between", value1, value2, "djzczyz");
            return (Criteria) this;
        }

        public Criteria andDjzczyzNotBetween(Integer value1, Integer value2) {
            addCriterion("djzczyz not between", value1, value2, "djzczyz");
            return (Criteria) this;
        }

        public Criteria andYxzjIsNull() {
            addCriterion("yxzj is null");
            return (Criteria) this;
        }

        public Criteria andYxzjIsNotNull() {
            addCriterion("yxzj is not null");
            return (Criteria) this;
        }

        public Criteria andYxzjEqualTo(String value) {
            addCriterion("yxzj =", value, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjNotEqualTo(String value) {
            addCriterion("yxzj <>", value, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjGreaterThan(String value) {
            addCriterion("yxzj >", value, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjGreaterThanOrEqualTo(String value) {
            addCriterion("yxzj >=", value, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjLessThan(String value) {
            addCriterion("yxzj <", value, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjLessThanOrEqualTo(String value) {
            addCriterion("yxzj <=", value, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjLike(String value) {
            addCriterion("yxzj like", value, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjNotLike(String value) {
            addCriterion("yxzj not like", value, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjIn(List<String> values) {
            addCriterion("yxzj in", values, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjNotIn(List<String> values) {
            addCriterion("yxzj not in", values, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjBetween(String value1, String value2) {
            addCriterion("yxzj between", value1, value2, "yxzj");
            return (Criteria) this;
        }

        public Criteria andYxzjNotBetween(String value1, String value2) {
            addCriterion("yxzj not between", value1, value2, "yxzj");
            return (Criteria) this;
        }

        public Criteria andLxdhIsNull() {
            addCriterion("lxdh is null");
            return (Criteria) this;
        }

        public Criteria andLxdhIsNotNull() {
            addCriterion("lxdh is not null");
            return (Criteria) this;
        }

        public Criteria andLxdhEqualTo(String value) {
            addCriterion("lxdh =", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotEqualTo(String value) {
            addCriterion("lxdh <>", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhGreaterThan(String value) {
            addCriterion("lxdh >", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhGreaterThanOrEqualTo(String value) {
            addCriterion("lxdh >=", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLessThan(String value) {
            addCriterion("lxdh <", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLessThanOrEqualTo(String value) {
            addCriterion("lxdh <=", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLike(String value) {
            addCriterion("lxdh like", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotLike(String value) {
            addCriterion("lxdh not like", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhIn(List<String> values) {
            addCriterion("lxdh in", values, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotIn(List<String> values) {
            addCriterion("lxdh not in", values, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhBetween(String value1, String value2) {
            addCriterion("lxdh between", value1, value2, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotBetween(String value1, String value2) {
            addCriterion("lxdh not between", value1, value2, "lxdh");
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