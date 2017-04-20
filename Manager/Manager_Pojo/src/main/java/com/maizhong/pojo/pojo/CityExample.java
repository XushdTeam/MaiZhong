package com.maizhong.pojo.pojo;

import java.util.ArrayList;
import java.util.List;

public class CityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityExample() {
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

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andAdminCodeIsNull() {
            addCriterion("admin_code is null");
            return (Criteria) this;
        }

        public Criteria andAdminCodeIsNotNull() {
            addCriterion("admin_code is not null");
            return (Criteria) this;
        }

        public Criteria andAdminCodeEqualTo(Integer value) {
            addCriterion("admin_code =", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeNotEqualTo(Integer value) {
            addCriterion("admin_code <>", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeGreaterThan(Integer value) {
            addCriterion("admin_code >", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_code >=", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeLessThan(Integer value) {
            addCriterion("admin_code <", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeLessThanOrEqualTo(Integer value) {
            addCriterion("admin_code <=", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeIn(List<Integer> values) {
            addCriterion("admin_code in", values, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeNotIn(List<Integer> values) {
            addCriterion("admin_code not in", values, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeBetween(Integer value1, Integer value2) {
            addCriterion("admin_code between", value1, value2, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_code not between", value1, value2, "adminCode");
            return (Criteria) this;
        }

        public Criteria andProvIdIsNull() {
            addCriterion("prov_id is null");
            return (Criteria) this;
        }

        public Criteria andProvIdIsNotNull() {
            addCriterion("prov_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvIdEqualTo(Integer value) {
            addCriterion("prov_id =", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdNotEqualTo(Integer value) {
            addCriterion("prov_id <>", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdGreaterThan(Integer value) {
            addCriterion("prov_id >", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prov_id >=", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdLessThan(Integer value) {
            addCriterion("prov_id <", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdLessThanOrEqualTo(Integer value) {
            addCriterion("prov_id <=", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdIn(List<Integer> values) {
            addCriterion("prov_id in", values, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdNotIn(List<Integer> values) {
            addCriterion("prov_id not in", values, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdBetween(Integer value1, Integer value2) {
            addCriterion("prov_id between", value1, value2, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prov_id not between", value1, value2, "provId");
            return (Criteria) this;
        }

        public Criteria andInitialIsNull() {
            addCriterion("initial is null");
            return (Criteria) this;
        }

        public Criteria andInitialIsNotNull() {
            addCriterion("initial is not null");
            return (Criteria) this;
        }

        public Criteria andInitialEqualTo(String value) {
            addCriterion("initial =", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotEqualTo(String value) {
            addCriterion("initial <>", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialGreaterThan(String value) {
            addCriterion("initial >", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialGreaterThanOrEqualTo(String value) {
            addCriterion("initial >=", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialLessThan(String value) {
            addCriterion("initial <", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialLessThanOrEqualTo(String value) {
            addCriterion("initial <=", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialLike(String value) {
            addCriterion("initial like", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotLike(String value) {
            addCriterion("initial not like", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialIn(List<String> values) {
            addCriterion("initial in", values, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotIn(List<String> values) {
            addCriterion("initial not in", values, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialBetween(String value1, String value2) {
            addCriterion("initial between", value1, value2, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotBetween(String value1, String value2) {
            addCriterion("initial not between", value1, value2, "initial");
            return (Criteria) this;
        }

        public Criteria andHotLevelIsNull() {
            addCriterion("hot_level is null");
            return (Criteria) this;
        }

        public Criteria andHotLevelIsNotNull() {
            addCriterion("hot_level is not null");
            return (Criteria) this;
        }

        public Criteria andHotLevelEqualTo(Integer value) {
            addCriterion("hot_level =", value, "hotLevel");
            return (Criteria) this;
        }

        public Criteria andHotLevelNotEqualTo(Integer value) {
            addCriterion("hot_level <>", value, "hotLevel");
            return (Criteria) this;
        }

        public Criteria andHotLevelGreaterThan(Integer value) {
            addCriterion("hot_level >", value, "hotLevel");
            return (Criteria) this;
        }

        public Criteria andHotLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("hot_level >=", value, "hotLevel");
            return (Criteria) this;
        }

        public Criteria andHotLevelLessThan(Integer value) {
            addCriterion("hot_level <", value, "hotLevel");
            return (Criteria) this;
        }

        public Criteria andHotLevelLessThanOrEqualTo(Integer value) {
            addCriterion("hot_level <=", value, "hotLevel");
            return (Criteria) this;
        }

        public Criteria andHotLevelIn(List<Integer> values) {
            addCriterion("hot_level in", values, "hotLevel");
            return (Criteria) this;
        }

        public Criteria andHotLevelNotIn(List<Integer> values) {
            addCriterion("hot_level not in", values, "hotLevel");
            return (Criteria) this;
        }

        public Criteria andHotLevelBetween(Integer value1, Integer value2) {
            addCriterion("hot_level between", value1, value2, "hotLevel");
            return (Criteria) this;
        }

        public Criteria andHotLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("hot_level not between", value1, value2, "hotLevel");
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