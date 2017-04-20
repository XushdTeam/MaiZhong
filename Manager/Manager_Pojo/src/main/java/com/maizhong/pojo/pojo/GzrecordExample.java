package com.maizhong.pojo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GzrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GzrecordExample() {
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

        public Criteria andParamIsNull() {
            addCriterion("param is null");
            return (Criteria) this;
        }

        public Criteria andParamIsNotNull() {
            addCriterion("param is not null");
            return (Criteria) this;
        }

        public Criteria andParamEqualTo(String value) {
            addCriterion("param =", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotEqualTo(String value) {
            addCriterion("param <>", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThan(String value) {
            addCriterion("param >", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThanOrEqualTo(String value) {
            addCriterion("param >=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThan(String value) {
            addCriterion("param <", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThanOrEqualTo(String value) {
            addCriterion("param <=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLike(String value) {
            addCriterion("param like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotLike(String value) {
            addCriterion("param not like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamIn(List<String> values) {
            addCriterion("param in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotIn(List<String> values) {
            addCriterion("param not in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamBetween(String value1, String value2) {
            addCriterion("param between", value1, value2, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotBetween(String value1, String value2) {
            addCriterion("param not between", value1, value2, "param");
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

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(Integer value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Integer value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Integer value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Integer value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Integer value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Integer> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Integer> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Integer value1, Integer value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Integer value1, Integer value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(Integer value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(Integer value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(Integer value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(Integer value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(Integer value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<Integer> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<Integer> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(Integer value1, Integer value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(Integer value1, Integer value2) {
            addCriterion("mail not between", value1, value2, "mail");
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

        public Criteria andPriceMaxAIsNull() {
            addCriterion("price_max_a is null");
            return (Criteria) this;
        }

        public Criteria andPriceMaxAIsNotNull() {
            addCriterion("price_max_a is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMaxAEqualTo(String value) {
            addCriterion("price_max_a =", value, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxANotEqualTo(String value) {
            addCriterion("price_max_a <>", value, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxAGreaterThan(String value) {
            addCriterion("price_max_a >", value, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxAGreaterThanOrEqualTo(String value) {
            addCriterion("price_max_a >=", value, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxALessThan(String value) {
            addCriterion("price_max_a <", value, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxALessThanOrEqualTo(String value) {
            addCriterion("price_max_a <=", value, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxALike(String value) {
            addCriterion("price_max_a like", value, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxANotLike(String value) {
            addCriterion("price_max_a not like", value, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxAIn(List<String> values) {
            addCriterion("price_max_a in", values, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxANotIn(List<String> values) {
            addCriterion("price_max_a not in", values, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxABetween(String value1, String value2) {
            addCriterion("price_max_a between", value1, value2, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxANotBetween(String value1, String value2) {
            addCriterion("price_max_a not between", value1, value2, "priceMaxA");
            return (Criteria) this;
        }

        public Criteria andPriceMinAIsNull() {
            addCriterion("price_min_a is null");
            return (Criteria) this;
        }

        public Criteria andPriceMinAIsNotNull() {
            addCriterion("price_min_a is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMinAEqualTo(String value) {
            addCriterion("price_min_a =", value, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinANotEqualTo(String value) {
            addCriterion("price_min_a <>", value, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinAGreaterThan(String value) {
            addCriterion("price_min_a >", value, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinAGreaterThanOrEqualTo(String value) {
            addCriterion("price_min_a >=", value, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinALessThan(String value) {
            addCriterion("price_min_a <", value, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinALessThanOrEqualTo(String value) {
            addCriterion("price_min_a <=", value, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinALike(String value) {
            addCriterion("price_min_a like", value, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinANotLike(String value) {
            addCriterion("price_min_a not like", value, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinAIn(List<String> values) {
            addCriterion("price_min_a in", values, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinANotIn(List<String> values) {
            addCriterion("price_min_a not in", values, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinABetween(String value1, String value2) {
            addCriterion("price_min_a between", value1, value2, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMinANotBetween(String value1, String value2) {
            addCriterion("price_min_a not between", value1, value2, "priceMinA");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBIsNull() {
            addCriterion("price_max_b is null");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBIsNotNull() {
            addCriterion("price_max_b is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBEqualTo(String value) {
            addCriterion("price_max_b =", value, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBNotEqualTo(String value) {
            addCriterion("price_max_b <>", value, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBGreaterThan(String value) {
            addCriterion("price_max_b >", value, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBGreaterThanOrEqualTo(String value) {
            addCriterion("price_max_b >=", value, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBLessThan(String value) {
            addCriterion("price_max_b <", value, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBLessThanOrEqualTo(String value) {
            addCriterion("price_max_b <=", value, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBLike(String value) {
            addCriterion("price_max_b like", value, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBNotLike(String value) {
            addCriterion("price_max_b not like", value, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBIn(List<String> values) {
            addCriterion("price_max_b in", values, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBNotIn(List<String> values) {
            addCriterion("price_max_b not in", values, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBBetween(String value1, String value2) {
            addCriterion("price_max_b between", value1, value2, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxBNotBetween(String value1, String value2) {
            addCriterion("price_max_b not between", value1, value2, "priceMaxB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBIsNull() {
            addCriterion("price_min_b is null");
            return (Criteria) this;
        }

        public Criteria andPriceMinBIsNotNull() {
            addCriterion("price_min_b is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMinBEqualTo(String value) {
            addCriterion("price_min_b =", value, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBNotEqualTo(String value) {
            addCriterion("price_min_b <>", value, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBGreaterThan(String value) {
            addCriterion("price_min_b >", value, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBGreaterThanOrEqualTo(String value) {
            addCriterion("price_min_b >=", value, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBLessThan(String value) {
            addCriterion("price_min_b <", value, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBLessThanOrEqualTo(String value) {
            addCriterion("price_min_b <=", value, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBLike(String value) {
            addCriterion("price_min_b like", value, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBNotLike(String value) {
            addCriterion("price_min_b not like", value, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBIn(List<String> values) {
            addCriterion("price_min_b in", values, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBNotIn(List<String> values) {
            addCriterion("price_min_b not in", values, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBBetween(String value1, String value2) {
            addCriterion("price_min_b between", value1, value2, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMinBNotBetween(String value1, String value2) {
            addCriterion("price_min_b not between", value1, value2, "priceMinB");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCIsNull() {
            addCriterion("price_max_c is null");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCIsNotNull() {
            addCriterion("price_max_c is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCEqualTo(String value) {
            addCriterion("price_max_c =", value, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCNotEqualTo(String value) {
            addCriterion("price_max_c <>", value, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCGreaterThan(String value) {
            addCriterion("price_max_c >", value, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCGreaterThanOrEqualTo(String value) {
            addCriterion("price_max_c >=", value, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCLessThan(String value) {
            addCriterion("price_max_c <", value, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCLessThanOrEqualTo(String value) {
            addCriterion("price_max_c <=", value, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCLike(String value) {
            addCriterion("price_max_c like", value, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCNotLike(String value) {
            addCriterion("price_max_c not like", value, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCIn(List<String> values) {
            addCriterion("price_max_c in", values, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCNotIn(List<String> values) {
            addCriterion("price_max_c not in", values, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCBetween(String value1, String value2) {
            addCriterion("price_max_c between", value1, value2, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxCNotBetween(String value1, String value2) {
            addCriterion("price_max_c not between", value1, value2, "priceMaxC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCIsNull() {
            addCriterion("price_min_c is null");
            return (Criteria) this;
        }

        public Criteria andPriceMinCIsNotNull() {
            addCriterion("price_min_c is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMinCEqualTo(String value) {
            addCriterion("price_min_c =", value, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCNotEqualTo(String value) {
            addCriterion("price_min_c <>", value, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCGreaterThan(String value) {
            addCriterion("price_min_c >", value, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCGreaterThanOrEqualTo(String value) {
            addCriterion("price_min_c >=", value, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCLessThan(String value) {
            addCriterion("price_min_c <", value, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCLessThanOrEqualTo(String value) {
            addCriterion("price_min_c <=", value, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCLike(String value) {
            addCriterion("price_min_c like", value, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCNotLike(String value) {
            addCriterion("price_min_c not like", value, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCIn(List<String> values) {
            addCriterion("price_min_c in", values, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCNotIn(List<String> values) {
            addCriterion("price_min_c not in", values, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCBetween(String value1, String value2) {
            addCriterion("price_min_c between", value1, value2, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMinCNotBetween(String value1, String value2) {
            addCriterion("price_min_c not between", value1, value2, "priceMinC");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDIsNull() {
            addCriterion("price_max_d is null");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDIsNotNull() {
            addCriterion("price_max_d is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDEqualTo(String value) {
            addCriterion("price_max_d =", value, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDNotEqualTo(String value) {
            addCriterion("price_max_d <>", value, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDGreaterThan(String value) {
            addCriterion("price_max_d >", value, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDGreaterThanOrEqualTo(String value) {
            addCriterion("price_max_d >=", value, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDLessThan(String value) {
            addCriterion("price_max_d <", value, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDLessThanOrEqualTo(String value) {
            addCriterion("price_max_d <=", value, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDLike(String value) {
            addCriterion("price_max_d like", value, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDNotLike(String value) {
            addCriterion("price_max_d not like", value, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDIn(List<String> values) {
            addCriterion("price_max_d in", values, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDNotIn(List<String> values) {
            addCriterion("price_max_d not in", values, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDBetween(String value1, String value2) {
            addCriterion("price_max_d between", value1, value2, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMaxDNotBetween(String value1, String value2) {
            addCriterion("price_max_d not between", value1, value2, "priceMaxD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDIsNull() {
            addCriterion("price_min_d is null");
            return (Criteria) this;
        }

        public Criteria andPriceMinDIsNotNull() {
            addCriterion("price_min_d is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMinDEqualTo(String value) {
            addCriterion("price_min_d =", value, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDNotEqualTo(String value) {
            addCriterion("price_min_d <>", value, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDGreaterThan(String value) {
            addCriterion("price_min_d >", value, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDGreaterThanOrEqualTo(String value) {
            addCriterion("price_min_d >=", value, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDLessThan(String value) {
            addCriterion("price_min_d <", value, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDLessThanOrEqualTo(String value) {
            addCriterion("price_min_d <=", value, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDLike(String value) {
            addCriterion("price_min_d like", value, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDNotLike(String value) {
            addCriterion("price_min_d not like", value, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDIn(List<String> values) {
            addCriterion("price_min_d in", values, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDNotIn(List<String> values) {
            addCriterion("price_min_d not in", values, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDBetween(String value1, String value2) {
            addCriterion("price_min_d between", value1, value2, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andPriceMinDNotBetween(String value1, String value2) {
            addCriterion("price_min_d not between", value1, value2, "priceMinD");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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