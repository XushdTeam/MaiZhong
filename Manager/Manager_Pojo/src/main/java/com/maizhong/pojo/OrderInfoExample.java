package com.maizhong.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInfoExample() {
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

        public Criteria andInfoIdIsNull() {
            addCriterion("info_id is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("info_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(Long value) {
            addCriterion("info_id =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(Long value) {
            addCriterion("info_id <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(Long value) {
            addCriterion("info_id >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("info_id >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(Long value) {
            addCriterion("info_id <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("info_id <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<Long> values) {
            addCriterion("info_id in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<Long> values) {
            addCriterion("info_id not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(Long value1, Long value2) {
            addCriterion("info_id between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("info_id not between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Long value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Long value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Long value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Long value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Long value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Long> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Long> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Long value1, Long value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Long value1, Long value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andRegYearIsNull() {
            addCriterion("reg_year is null");
            return (Criteria) this;
        }

        public Criteria andRegYearIsNotNull() {
            addCriterion("reg_year is not null");
            return (Criteria) this;
        }

        public Criteria andRegYearEqualTo(Integer value) {
            addCriterion("reg_year =", value, "regYear");
            return (Criteria) this;
        }

        public Criteria andRegYearNotEqualTo(Integer value) {
            addCriterion("reg_year <>", value, "regYear");
            return (Criteria) this;
        }

        public Criteria andRegYearGreaterThan(Integer value) {
            addCriterion("reg_year >", value, "regYear");
            return (Criteria) this;
        }

        public Criteria andRegYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("reg_year >=", value, "regYear");
            return (Criteria) this;
        }

        public Criteria andRegYearLessThan(Integer value) {
            addCriterion("reg_year <", value, "regYear");
            return (Criteria) this;
        }

        public Criteria andRegYearLessThanOrEqualTo(Integer value) {
            addCriterion("reg_year <=", value, "regYear");
            return (Criteria) this;
        }

        public Criteria andRegYearIn(List<Integer> values) {
            addCriterion("reg_year in", values, "regYear");
            return (Criteria) this;
        }

        public Criteria andRegYearNotIn(List<Integer> values) {
            addCriterion("reg_year not in", values, "regYear");
            return (Criteria) this;
        }

        public Criteria andRegYearBetween(Integer value1, Integer value2) {
            addCriterion("reg_year between", value1, value2, "regYear");
            return (Criteria) this;
        }

        public Criteria andRegYearNotBetween(Integer value1, Integer value2) {
            addCriterion("reg_year not between", value1, value2, "regYear");
            return (Criteria) this;
        }

        public Criteria andRegMonthIsNull() {
            addCriterion("reg_month is null");
            return (Criteria) this;
        }

        public Criteria andRegMonthIsNotNull() {
            addCriterion("reg_month is not null");
            return (Criteria) this;
        }

        public Criteria andRegMonthEqualTo(Integer value) {
            addCriterion("reg_month =", value, "regMonth");
            return (Criteria) this;
        }

        public Criteria andRegMonthNotEqualTo(Integer value) {
            addCriterion("reg_month <>", value, "regMonth");
            return (Criteria) this;
        }

        public Criteria andRegMonthGreaterThan(Integer value) {
            addCriterion("reg_month >", value, "regMonth");
            return (Criteria) this;
        }

        public Criteria andRegMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("reg_month >=", value, "regMonth");
            return (Criteria) this;
        }

        public Criteria andRegMonthLessThan(Integer value) {
            addCriterion("reg_month <", value, "regMonth");
            return (Criteria) this;
        }

        public Criteria andRegMonthLessThanOrEqualTo(Integer value) {
            addCriterion("reg_month <=", value, "regMonth");
            return (Criteria) this;
        }

        public Criteria andRegMonthIn(List<Integer> values) {
            addCriterion("reg_month in", values, "regMonth");
            return (Criteria) this;
        }

        public Criteria andRegMonthNotIn(List<Integer> values) {
            addCriterion("reg_month not in", values, "regMonth");
            return (Criteria) this;
        }

        public Criteria andRegMonthBetween(Integer value1, Integer value2) {
            addCriterion("reg_month between", value1, value2, "regMonth");
            return (Criteria) this;
        }

        public Criteria andRegMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("reg_month not between", value1, value2, "regMonth");
            return (Criteria) this;
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

        public Criteria andSKmIsNull() {
            addCriterion("s_km is null");
            return (Criteria) this;
        }

        public Criteria andSKmIsNotNull() {
            addCriterion("s_km is not null");
            return (Criteria) this;
        }

        public Criteria andSKmEqualTo(BigDecimal value) {
            addCriterion("s_km =", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmNotEqualTo(BigDecimal value) {
            addCriterion("s_km <>", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmGreaterThan(BigDecimal value) {
            addCriterion("s_km >", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("s_km >=", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmLessThan(BigDecimal value) {
            addCriterion("s_km <", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("s_km <=", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmIn(List<BigDecimal> values) {
            addCriterion("s_km in", values, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmNotIn(List<BigDecimal> values) {
            addCriterion("s_km not in", values, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("s_km between", value1, value2, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("s_km not between", value1, value2, "sKm");
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

        public Criteria andColorEqualTo(Integer value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(Integer value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(Integer value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(Integer value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(Integer value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(Integer value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<Integer> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<Integer> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(Integer value1, Integer value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(Integer value1, Integer value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andJqxIsNull() {
            addCriterion("jqx is null");
            return (Criteria) this;
        }

        public Criteria andJqxIsNotNull() {
            addCriterion("jqx is not null");
            return (Criteria) this;
        }

        public Criteria andJqxEqualTo(Integer value) {
            addCriterion("jqx =", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxNotEqualTo(Integer value) {
            addCriterion("jqx <>", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxGreaterThan(Integer value) {
            addCriterion("jqx >", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxGreaterThanOrEqualTo(Integer value) {
            addCriterion("jqx >=", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxLessThan(Integer value) {
            addCriterion("jqx <", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxLessThanOrEqualTo(Integer value) {
            addCriterion("jqx <=", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxIn(List<Integer> values) {
            addCriterion("jqx in", values, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxNotIn(List<Integer> values) {
            addCriterion("jqx not in", values, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxBetween(Integer value1, Integer value2) {
            addCriterion("jqx between", value1, value2, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxNotBetween(Integer value1, Integer value2) {
            addCriterion("jqx not between", value1, value2, "jqx");
            return (Criteria) this;
        }

        public Criteria andNjIsNull() {
            addCriterion("nj is null");
            return (Criteria) this;
        }

        public Criteria andNjIsNotNull() {
            addCriterion("nj is not null");
            return (Criteria) this;
        }

        public Criteria andNjEqualTo(Integer value) {
            addCriterion("nj =", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotEqualTo(Integer value) {
            addCriterion("nj <>", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjGreaterThan(Integer value) {
            addCriterion("nj >", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjGreaterThanOrEqualTo(Integer value) {
            addCriterion("nj >=", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjLessThan(Integer value) {
            addCriterion("nj <", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjLessThanOrEqualTo(Integer value) {
            addCriterion("nj <=", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjIn(List<Integer> values) {
            addCriterion("nj in", values, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotIn(List<Integer> values) {
            addCriterion("nj not in", values, "nj");
            return (Criteria) this;
        }

        public Criteria andNjBetween(Integer value1, Integer value2) {
            addCriterion("nj between", value1, value2, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotBetween(Integer value1, Integer value2) {
            addCriterion("nj not between", value1, value2, "nj");
            return (Criteria) this;
        }

        public Criteria andXzIsNull() {
            addCriterion("xz is null");
            return (Criteria) this;
        }

        public Criteria andXzIsNotNull() {
            addCriterion("xz is not null");
            return (Criteria) this;
        }

        public Criteria andXzEqualTo(Integer value) {
            addCriterion("xz =", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotEqualTo(Integer value) {
            addCriterion("xz <>", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzGreaterThan(Integer value) {
            addCriterion("xz >", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzGreaterThanOrEqualTo(Integer value) {
            addCriterion("xz >=", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLessThan(Integer value) {
            addCriterion("xz <", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLessThanOrEqualTo(Integer value) {
            addCriterion("xz <=", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzIn(List<Integer> values) {
            addCriterion("xz in", values, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotIn(List<Integer> values) {
            addCriterion("xz not in", values, "xz");
            return (Criteria) this;
        }

        public Criteria andXzBetween(Integer value1, Integer value2) {
            addCriterion("xz between", value1, value2, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotBetween(Integer value1, Integer value2) {
            addCriterion("xz not between", value1, value2, "xz");
            return (Criteria) this;
        }

        public Criteria andGhIsNull() {
            addCriterion("gh is null");
            return (Criteria) this;
        }

        public Criteria andGhIsNotNull() {
            addCriterion("gh is not null");
            return (Criteria) this;
        }

        public Criteria andGhEqualTo(Integer value) {
            addCriterion("gh =", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhNotEqualTo(Integer value) {
            addCriterion("gh <>", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhGreaterThan(Integer value) {
            addCriterion("gh >", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhGreaterThanOrEqualTo(Integer value) {
            addCriterion("gh >=", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhLessThan(Integer value) {
            addCriterion("gh <", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhLessThanOrEqualTo(Integer value) {
            addCriterion("gh <=", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhIn(List<Integer> values) {
            addCriterion("gh in", values, "gh");
            return (Criteria) this;
        }

        public Criteria andGhNotIn(List<Integer> values) {
            addCriterion("gh not in", values, "gh");
            return (Criteria) this;
        }

        public Criteria andGhBetween(Integer value1, Integer value2) {
            addCriterion("gh between", value1, value2, "gh");
            return (Criteria) this;
        }

        public Criteria andGhNotBetween(Integer value1, Integer value2) {
            addCriterion("gh not between", value1, value2, "gh");
            return (Criteria) this;
        }

        public Criteria andGhtimeIsNull() {
            addCriterion("ghtime is null");
            return (Criteria) this;
        }

        public Criteria andGhtimeIsNotNull() {
            addCriterion("ghtime is not null");
            return (Criteria) this;
        }

        public Criteria andGhtimeEqualTo(Integer value) {
            addCriterion("ghtime =", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeNotEqualTo(Integer value) {
            addCriterion("ghtime <>", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeGreaterThan(Integer value) {
            addCriterion("ghtime >", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ghtime >=", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeLessThan(Integer value) {
            addCriterion("ghtime <", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeLessThanOrEqualTo(Integer value) {
            addCriterion("ghtime <=", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeIn(List<Integer> values) {
            addCriterion("ghtime in", values, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeNotIn(List<Integer> values) {
            addCriterion("ghtime not in", values, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeBetween(Integer value1, Integer value2) {
            addCriterion("ghtime between", value1, value2, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("ghtime not between", value1, value2, "ghtime");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(Integer value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(Integer value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(Integer value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(Integer value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(Integer value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<Integer> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<Integer> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(Integer value1, Integer value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andCkIsNull() {
            addCriterion("ck is null");
            return (Criteria) this;
        }

        public Criteria andCkIsNotNull() {
            addCriterion("ck is not null");
            return (Criteria) this;
        }

        public Criteria andCkEqualTo(Integer value) {
            addCriterion("ck =", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkNotEqualTo(Integer value) {
            addCriterion("ck <>", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkGreaterThan(Integer value) {
            addCriterion("ck >", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkGreaterThanOrEqualTo(Integer value) {
            addCriterion("ck >=", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkLessThan(Integer value) {
            addCriterion("ck <", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkLessThanOrEqualTo(Integer value) {
            addCriterion("ck <=", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkIn(List<Integer> values) {
            addCriterion("ck in", values, "ck");
            return (Criteria) this;
        }

        public Criteria andCkNotIn(List<Integer> values) {
            addCriterion("ck not in", values, "ck");
            return (Criteria) this;
        }

        public Criteria andCkBetween(Integer value1, Integer value2) {
            addCriterion("ck between", value1, value2, "ck");
            return (Criteria) this;
        }

        public Criteria andCkNotBetween(Integer value1, Integer value2) {
            addCriterion("ck not between", value1, value2, "ck");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNull() {
            addCriterion("delflag is null");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNotNull() {
            addCriterion("delflag is not null");
            return (Criteria) this;
        }

        public Criteria andDelflagEqualTo(Integer value) {
            addCriterion("delflag =", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotEqualTo(Integer value) {
            addCriterion("delflag <>", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThan(Integer value) {
            addCriterion("delflag >", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delflag >=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThan(Integer value) {
            addCriterion("delflag <", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThanOrEqualTo(Integer value) {
            addCriterion("delflag <=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagIn(List<Integer> values) {
            addCriterion("delflag in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotIn(List<Integer> values) {
            addCriterion("delflag not in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagBetween(Integer value1, Integer value2) {
            addCriterion("delflag between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotBetween(Integer value1, Integer value2) {
            addCriterion("delflag not between", value1, value2, "delflag");
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