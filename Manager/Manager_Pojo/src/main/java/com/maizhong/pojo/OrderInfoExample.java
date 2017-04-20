package com.maizhong.pojo;

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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Long value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Long value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Long value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Long value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Long value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Long> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Long> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Long value1, Long value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Long value1, Long value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
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

        public Criteria andRegDateIsNull() {
            addCriterion("reg_date is null");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNotNull() {
            addCriterion("reg_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegDateEqualTo(String value) {
            addCriterion("reg_date =", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotEqualTo(String value) {
            addCriterion("reg_date <>", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThan(String value) {
            addCriterion("reg_date >", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThanOrEqualTo(String value) {
            addCriterion("reg_date >=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThan(String value) {
            addCriterion("reg_date <", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThanOrEqualTo(String value) {
            addCriterion("reg_date <=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLike(String value) {
            addCriterion("reg_date like", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotLike(String value) {
            addCriterion("reg_date not like", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateIn(List<String> values) {
            addCriterion("reg_date in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotIn(List<String> values) {
            addCriterion("reg_date not in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateBetween(String value1, String value2) {
            addCriterion("reg_date between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotBetween(String value1, String value2) {
            addCriterion("reg_date not between", value1, value2, "regDate");
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

        public Criteria andCityIdEqualTo(String value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(String value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(String value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(String value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(String value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLike(String value) {
            addCriterion("city_id like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotLike(String value) {
            addCriterion("city_id not like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<String> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<String> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(String value1, String value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(String value1, String value2) {
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

        public Criteria andSKmEqualTo(String value) {
            addCriterion("s_km =", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmNotEqualTo(String value) {
            addCriterion("s_km <>", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmGreaterThan(String value) {
            addCriterion("s_km >", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmGreaterThanOrEqualTo(String value) {
            addCriterion("s_km >=", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmLessThan(String value) {
            addCriterion("s_km <", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmLessThanOrEqualTo(String value) {
            addCriterion("s_km <=", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmLike(String value) {
            addCriterion("s_km like", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmNotLike(String value) {
            addCriterion("s_km not like", value, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmIn(List<String> values) {
            addCriterion("s_km in", values, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmNotIn(List<String> values) {
            addCriterion("s_km not in", values, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmBetween(String value1, String value2) {
            addCriterion("s_km between", value1, value2, "sKm");
            return (Criteria) this;
        }

        public Criteria andSKmNotBetween(String value1, String value2) {
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

        public Criteria andJqxIsNull() {
            addCriterion("jqx is null");
            return (Criteria) this;
        }

        public Criteria andJqxIsNotNull() {
            addCriterion("jqx is not null");
            return (Criteria) this;
        }

        public Criteria andJqxEqualTo(String value) {
            addCriterion("jqx =", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxNotEqualTo(String value) {
            addCriterion("jqx <>", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxGreaterThan(String value) {
            addCriterion("jqx >", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxGreaterThanOrEqualTo(String value) {
            addCriterion("jqx >=", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxLessThan(String value) {
            addCriterion("jqx <", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxLessThanOrEqualTo(String value) {
            addCriterion("jqx <=", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxLike(String value) {
            addCriterion("jqx like", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxNotLike(String value) {
            addCriterion("jqx not like", value, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxIn(List<String> values) {
            addCriterion("jqx in", values, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxNotIn(List<String> values) {
            addCriterion("jqx not in", values, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxBetween(String value1, String value2) {
            addCriterion("jqx between", value1, value2, "jqx");
            return (Criteria) this;
        }

        public Criteria andJqxNotBetween(String value1, String value2) {
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

        public Criteria andNjEqualTo(String value) {
            addCriterion("nj =", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotEqualTo(String value) {
            addCriterion("nj <>", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjGreaterThan(String value) {
            addCriterion("nj >", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjGreaterThanOrEqualTo(String value) {
            addCriterion("nj >=", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjLessThan(String value) {
            addCriterion("nj <", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjLessThanOrEqualTo(String value) {
            addCriterion("nj <=", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjLike(String value) {
            addCriterion("nj like", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotLike(String value) {
            addCriterion("nj not like", value, "nj");
            return (Criteria) this;
        }

        public Criteria andNjIn(List<String> values) {
            addCriterion("nj in", values, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotIn(List<String> values) {
            addCriterion("nj not in", values, "nj");
            return (Criteria) this;
        }

        public Criteria andNjBetween(String value1, String value2) {
            addCriterion("nj between", value1, value2, "nj");
            return (Criteria) this;
        }

        public Criteria andNjNotBetween(String value1, String value2) {
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

        public Criteria andXzEqualTo(String value) {
            addCriterion("xz =", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotEqualTo(String value) {
            addCriterion("xz <>", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzGreaterThan(String value) {
            addCriterion("xz >", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzGreaterThanOrEqualTo(String value) {
            addCriterion("xz >=", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLessThan(String value) {
            addCriterion("xz <", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLessThanOrEqualTo(String value) {
            addCriterion("xz <=", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLike(String value) {
            addCriterion("xz like", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotLike(String value) {
            addCriterion("xz not like", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzIn(List<String> values) {
            addCriterion("xz in", values, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotIn(List<String> values) {
            addCriterion("xz not in", values, "xz");
            return (Criteria) this;
        }

        public Criteria andXzBetween(String value1, String value2) {
            addCriterion("xz between", value1, value2, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotBetween(String value1, String value2) {
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

        public Criteria andGhEqualTo(String value) {
            addCriterion("gh =", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhNotEqualTo(String value) {
            addCriterion("gh <>", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhGreaterThan(String value) {
            addCriterion("gh >", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhGreaterThanOrEqualTo(String value) {
            addCriterion("gh >=", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhLessThan(String value) {
            addCriterion("gh <", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhLessThanOrEqualTo(String value) {
            addCriterion("gh <=", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhLike(String value) {
            addCriterion("gh like", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhNotLike(String value) {
            addCriterion("gh not like", value, "gh");
            return (Criteria) this;
        }

        public Criteria andGhIn(List<String> values) {
            addCriterion("gh in", values, "gh");
            return (Criteria) this;
        }

        public Criteria andGhNotIn(List<String> values) {
            addCriterion("gh not in", values, "gh");
            return (Criteria) this;
        }

        public Criteria andGhBetween(String value1, String value2) {
            addCriterion("gh between", value1, value2, "gh");
            return (Criteria) this;
        }

        public Criteria andGhNotBetween(String value1, String value2) {
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

        public Criteria andGhtimeEqualTo(String value) {
            addCriterion("ghtime =", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeNotEqualTo(String value) {
            addCriterion("ghtime <>", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeGreaterThan(String value) {
            addCriterion("ghtime >", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ghtime >=", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeLessThan(String value) {
            addCriterion("ghtime <", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeLessThanOrEqualTo(String value) {
            addCriterion("ghtime <=", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeLike(String value) {
            addCriterion("ghtime like", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeNotLike(String value) {
            addCriterion("ghtime not like", value, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeIn(List<String> values) {
            addCriterion("ghtime in", values, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeNotIn(List<String> values) {
            addCriterion("ghtime not in", values, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeBetween(String value1, String value2) {
            addCriterion("ghtime between", value1, value2, "ghtime");
            return (Criteria) this;
        }

        public Criteria andGhtimeNotBetween(String value1, String value2) {
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

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
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

        public Criteria andCkEqualTo(String value) {
            addCriterion("ck =", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkNotEqualTo(String value) {
            addCriterion("ck <>", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkGreaterThan(String value) {
            addCriterion("ck >", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkGreaterThanOrEqualTo(String value) {
            addCriterion("ck >=", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkLessThan(String value) {
            addCriterion("ck <", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkLessThanOrEqualTo(String value) {
            addCriterion("ck <=", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkLike(String value) {
            addCriterion("ck like", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkNotLike(String value) {
            addCriterion("ck not like", value, "ck");
            return (Criteria) this;
        }

        public Criteria andCkIn(List<String> values) {
            addCriterion("ck in", values, "ck");
            return (Criteria) this;
        }

        public Criteria andCkNotIn(List<String> values) {
            addCriterion("ck not in", values, "ck");
            return (Criteria) this;
        }

        public Criteria andCkBetween(String value1, String value2) {
            addCriterion("ck between", value1, value2, "ck");
            return (Criteria) this;
        }

        public Criteria andCkNotBetween(String value1, String value2) {
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

        public Criteria andDelflagEqualTo(String value) {
            addCriterion("delflag =", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotEqualTo(String value) {
            addCriterion("delflag <>", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThan(String value) {
            addCriterion("delflag >", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThanOrEqualTo(String value) {
            addCriterion("delflag >=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThan(String value) {
            addCriterion("delflag <", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThanOrEqualTo(String value) {
            addCriterion("delflag <=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLike(String value) {
            addCriterion("delflag like", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotLike(String value) {
            addCriterion("delflag not like", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagIn(List<String> values) {
            addCriterion("delflag in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotIn(List<String> values) {
            addCriterion("delflag not in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagBetween(String value1, String value2) {
            addCriterion("delflag between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotBetween(String value1, String value2) {
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