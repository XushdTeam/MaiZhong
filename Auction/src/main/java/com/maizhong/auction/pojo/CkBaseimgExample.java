package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkBaseimgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkBaseimgExample() {
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

        public Criteria andCphIsNull() {
            addCriterion("cph is null");
            return (Criteria) this;
        }

        public Criteria andCphIsNotNull() {
            addCriterion("cph is not null");
            return (Criteria) this;
        }

        public Criteria andCphEqualTo(String value) {
            addCriterion("cph =", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphNotEqualTo(String value) {
            addCriterion("cph <>", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphGreaterThan(String value) {
            addCriterion("cph >", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphGreaterThanOrEqualTo(String value) {
            addCriterion("cph >=", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphLessThan(String value) {
            addCriterion("cph <", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphLessThanOrEqualTo(String value) {
            addCriterion("cph <=", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphLike(String value) {
            addCriterion("cph like", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphNotLike(String value) {
            addCriterion("cph not like", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphIn(List<String> values) {
            addCriterion("cph in", values, "cph");
            return (Criteria) this;
        }

        public Criteria andCphNotIn(List<String> values) {
            addCriterion("cph not in", values, "cph");
            return (Criteria) this;
        }

        public Criteria andCphBetween(String value1, String value2) {
            addCriterion("cph between", value1, value2, "cph");
            return (Criteria) this;
        }

        public Criteria andCphNotBetween(String value1, String value2) {
            addCriterion("cph not between", value1, value2, "cph");
            return (Criteria) this;
        }

        public Criteria andZq45IsNull() {
            addCriterion("zq45 is null");
            return (Criteria) this;
        }

        public Criteria andZq45IsNotNull() {
            addCriterion("zq45 is not null");
            return (Criteria) this;
        }

        public Criteria andZq45EqualTo(String value) {
            addCriterion("zq45 =", value, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45NotEqualTo(String value) {
            addCriterion("zq45 <>", value, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45GreaterThan(String value) {
            addCriterion("zq45 >", value, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45GreaterThanOrEqualTo(String value) {
            addCriterion("zq45 >=", value, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45LessThan(String value) {
            addCriterion("zq45 <", value, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45LessThanOrEqualTo(String value) {
            addCriterion("zq45 <=", value, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45Like(String value) {
            addCriterion("zq45 like", value, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45NotLike(String value) {
            addCriterion("zq45 not like", value, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45In(List<String> values) {
            addCriterion("zq45 in", values, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45NotIn(List<String> values) {
            addCriterion("zq45 not in", values, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45Between(String value1, String value2) {
            addCriterion("zq45 between", value1, value2, "zq45");
            return (Criteria) this;
        }

        public Criteria andZq45NotBetween(String value1, String value2) {
            addCriterion("zq45 not between", value1, value2, "zq45");
            return (Criteria) this;
        }

        public Criteria andFdjcIsNull() {
            addCriterion("fdjc is null");
            return (Criteria) this;
        }

        public Criteria andFdjcIsNotNull() {
            addCriterion("fdjc is not null");
            return (Criteria) this;
        }

        public Criteria andFdjcEqualTo(String value) {
            addCriterion("fdjc =", value, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcNotEqualTo(String value) {
            addCriterion("fdjc <>", value, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcGreaterThan(String value) {
            addCriterion("fdjc >", value, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcGreaterThanOrEqualTo(String value) {
            addCriterion("fdjc >=", value, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcLessThan(String value) {
            addCriterion("fdjc <", value, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcLessThanOrEqualTo(String value) {
            addCriterion("fdjc <=", value, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcLike(String value) {
            addCriterion("fdjc like", value, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcNotLike(String value) {
            addCriterion("fdjc not like", value, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcIn(List<String> values) {
            addCriterion("fdjc in", values, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcNotIn(List<String> values) {
            addCriterion("fdjc not in", values, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcBetween(String value1, String value2) {
            addCriterion("fdjc between", value1, value2, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjcNotBetween(String value1, String value2) {
            addCriterion("fdjc not between", value1, value2, "fdjc");
            return (Criteria) this;
        }

        public Criteria andFdjczIsNull() {
            addCriterion("fdjcz is null");
            return (Criteria) this;
        }

        public Criteria andFdjczIsNotNull() {
            addCriterion("fdjcz is not null");
            return (Criteria) this;
        }

        public Criteria andFdjczEqualTo(String value) {
            addCriterion("fdjcz =", value, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczNotEqualTo(String value) {
            addCriterion("fdjcz <>", value, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczGreaterThan(String value) {
            addCriterion("fdjcz >", value, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczGreaterThanOrEqualTo(String value) {
            addCriterion("fdjcz >=", value, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczLessThan(String value) {
            addCriterion("fdjcz <", value, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczLessThanOrEqualTo(String value) {
            addCriterion("fdjcz <=", value, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczLike(String value) {
            addCriterion("fdjcz like", value, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczNotLike(String value) {
            addCriterion("fdjcz not like", value, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczIn(List<String> values) {
            addCriterion("fdjcz in", values, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczNotIn(List<String> values) {
            addCriterion("fdjcz not in", values, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczBetween(String value1, String value2) {
            addCriterion("fdjcz between", value1, value2, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjczNotBetween(String value1, String value2) {
            addCriterion("fdjcz not between", value1, value2, "fdjcz");
            return (Criteria) this;
        }

        public Criteria andFdjcyIsNull() {
            addCriterion("fdjcy is null");
            return (Criteria) this;
        }

        public Criteria andFdjcyIsNotNull() {
            addCriterion("fdjcy is not null");
            return (Criteria) this;
        }

        public Criteria andFdjcyEqualTo(String value) {
            addCriterion("fdjcy =", value, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyNotEqualTo(String value) {
            addCriterion("fdjcy <>", value, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyGreaterThan(String value) {
            addCriterion("fdjcy >", value, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyGreaterThanOrEqualTo(String value) {
            addCriterion("fdjcy >=", value, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyLessThan(String value) {
            addCriterion("fdjcy <", value, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyLessThanOrEqualTo(String value) {
            addCriterion("fdjcy <=", value, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyLike(String value) {
            addCriterion("fdjcy like", value, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyNotLike(String value) {
            addCriterion("fdjcy not like", value, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyIn(List<String> values) {
            addCriterion("fdjcy in", values, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyNotIn(List<String> values) {
            addCriterion("fdjcy not in", values, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyBetween(String value1, String value2) {
            addCriterion("fdjcy between", value1, value2, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdjcyNotBetween(String value1, String value2) {
            addCriterion("fdjcy not between", value1, value2, "fdjcy");
            return (Criteria) this;
        }

        public Criteria andFdcjhIsNull() {
            addCriterion("fdcjh is null");
            return (Criteria) this;
        }

        public Criteria andFdcjhIsNotNull() {
            addCriterion("fdcjh is not null");
            return (Criteria) this;
        }

        public Criteria andFdcjhEqualTo(String value) {
            addCriterion("fdcjh =", value, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhNotEqualTo(String value) {
            addCriterion("fdcjh <>", value, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhGreaterThan(String value) {
            addCriterion("fdcjh >", value, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhGreaterThanOrEqualTo(String value) {
            addCriterion("fdcjh >=", value, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhLessThan(String value) {
            addCriterion("fdcjh <", value, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhLessThanOrEqualTo(String value) {
            addCriterion("fdcjh <=", value, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhLike(String value) {
            addCriterion("fdcjh like", value, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhNotLike(String value) {
            addCriterion("fdcjh not like", value, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhIn(List<String> values) {
            addCriterion("fdcjh in", values, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhNotIn(List<String> values) {
            addCriterion("fdcjh not in", values, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhBetween(String value1, String value2) {
            addCriterion("fdcjh between", value1, value2, "fdcjh");
            return (Criteria) this;
        }

        public Criteria andFdcjhNotBetween(String value1, String value2) {
            addCriterion("fdcjh not between", value1, value2, "fdcjh");
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

        public Criteria andMpIsNull() {
            addCriterion("mp is null");
            return (Criteria) this;
        }

        public Criteria andMpIsNotNull() {
            addCriterion("mp is not null");
            return (Criteria) this;
        }

        public Criteria andMpEqualTo(String value) {
            addCriterion("mp =", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpNotEqualTo(String value) {
            addCriterion("mp <>", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpGreaterThan(String value) {
            addCriterion("mp >", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpGreaterThanOrEqualTo(String value) {
            addCriterion("mp >=", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpLessThan(String value) {
            addCriterion("mp <", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpLessThanOrEqualTo(String value) {
            addCriterion("mp <=", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpLike(String value) {
            addCriterion("mp like", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpNotLike(String value) {
            addCriterion("mp not like", value, "mp");
            return (Criteria) this;
        }

        public Criteria andMpIn(List<String> values) {
            addCriterion("mp in", values, "mp");
            return (Criteria) this;
        }

        public Criteria andMpNotIn(List<String> values) {
            addCriterion("mp not in", values, "mp");
            return (Criteria) this;
        }

        public Criteria andMpBetween(String value1, String value2) {
            addCriterion("mp between", value1, value2, "mp");
            return (Criteria) this;
        }

        public Criteria andMpNotBetween(String value1, String value2) {
            addCriterion("mp not between", value1, value2, "mp");
            return (Criteria) this;
        }

        public Criteria andLtxhIsNull() {
            addCriterion("ltxh is null");
            return (Criteria) this;
        }

        public Criteria andLtxhIsNotNull() {
            addCriterion("ltxh is not null");
            return (Criteria) this;
        }

        public Criteria andLtxhEqualTo(String value) {
            addCriterion("ltxh =", value, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhNotEqualTo(String value) {
            addCriterion("ltxh <>", value, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhGreaterThan(String value) {
            addCriterion("ltxh >", value, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhGreaterThanOrEqualTo(String value) {
            addCriterion("ltxh >=", value, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhLessThan(String value) {
            addCriterion("ltxh <", value, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhLessThanOrEqualTo(String value) {
            addCriterion("ltxh <=", value, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhLike(String value) {
            addCriterion("ltxh like", value, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhNotLike(String value) {
            addCriterion("ltxh not like", value, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhIn(List<String> values) {
            addCriterion("ltxh in", values, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhNotIn(List<String> values) {
            addCriterion("ltxh not in", values, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhBetween(String value1, String value2) {
            addCriterion("ltxh between", value1, value2, "ltxh");
            return (Criteria) this;
        }

        public Criteria andLtxhNotBetween(String value1, String value2) {
            addCriterion("ltxh not between", value1, value2, "ltxh");
            return (Criteria) this;
        }

        public Criteria andQpzyIsNull() {
            addCriterion("qpzy is null");
            return (Criteria) this;
        }

        public Criteria andQpzyIsNotNull() {
            addCriterion("qpzy is not null");
            return (Criteria) this;
        }

        public Criteria andQpzyEqualTo(String value) {
            addCriterion("qpzy =", value, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyNotEqualTo(String value) {
            addCriterion("qpzy <>", value, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyGreaterThan(String value) {
            addCriterion("qpzy >", value, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyGreaterThanOrEqualTo(String value) {
            addCriterion("qpzy >=", value, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyLessThan(String value) {
            addCriterion("qpzy <", value, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyLessThanOrEqualTo(String value) {
            addCriterion("qpzy <=", value, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyLike(String value) {
            addCriterion("qpzy like", value, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyNotLike(String value) {
            addCriterion("qpzy not like", value, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyIn(List<String> values) {
            addCriterion("qpzy in", values, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyNotIn(List<String> values) {
            addCriterion("qpzy not in", values, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyBetween(String value1, String value2) {
            addCriterion("qpzy between", value1, value2, "qpzy");
            return (Criteria) this;
        }

        public Criteria andQpzyNotBetween(String value1, String value2) {
            addCriterion("qpzy not between", value1, value2, "qpzy");
            return (Criteria) this;
        }

        public Criteria andYbpIsNull() {
            addCriterion("ybp is null");
            return (Criteria) this;
        }

        public Criteria andYbpIsNotNull() {
            addCriterion("ybp is not null");
            return (Criteria) this;
        }

        public Criteria andYbpEqualTo(String value) {
            addCriterion("ybp =", value, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpNotEqualTo(String value) {
            addCriterion("ybp <>", value, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpGreaterThan(String value) {
            addCriterion("ybp >", value, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpGreaterThanOrEqualTo(String value) {
            addCriterion("ybp >=", value, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpLessThan(String value) {
            addCriterion("ybp <", value, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpLessThanOrEqualTo(String value) {
            addCriterion("ybp <=", value, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpLike(String value) {
            addCriterion("ybp like", value, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpNotLike(String value) {
            addCriterion("ybp not like", value, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpIn(List<String> values) {
            addCriterion("ybp in", values, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpNotIn(List<String> values) {
            addCriterion("ybp not in", values, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpBetween(String value1, String value2) {
            addCriterion("ybp between", value1, value2, "ybp");
            return (Criteria) this;
        }

        public Criteria andYbpNotBetween(String value1, String value2) {
            addCriterion("ybp not between", value1, value2, "ybp");
            return (Criteria) this;
        }

        public Criteria andHpzyIsNull() {
            addCriterion("hpzy is null");
            return (Criteria) this;
        }

        public Criteria andHpzyIsNotNull() {
            addCriterion("hpzy is not null");
            return (Criteria) this;
        }

        public Criteria andHpzyEqualTo(String value) {
            addCriterion("hpzy =", value, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyNotEqualTo(String value) {
            addCriterion("hpzy <>", value, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyGreaterThan(String value) {
            addCriterion("hpzy >", value, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyGreaterThanOrEqualTo(String value) {
            addCriterion("hpzy >=", value, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyLessThan(String value) {
            addCriterion("hpzy <", value, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyLessThanOrEqualTo(String value) {
            addCriterion("hpzy <=", value, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyLike(String value) {
            addCriterion("hpzy like", value, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyNotLike(String value) {
            addCriterion("hpzy not like", value, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyIn(List<String> values) {
            addCriterion("hpzy in", values, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyNotIn(List<String> values) {
            addCriterion("hpzy not in", values, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyBetween(String value1, String value2) {
            addCriterion("hpzy between", value1, value2, "hpzy");
            return (Criteria) this;
        }

        public Criteria andHpzyNotBetween(String value1, String value2) {
            addCriterion("hpzy not between", value1, value2, "hpzy");
            return (Criteria) this;
        }

        public Criteria andZktIsNull() {
            addCriterion("zkt is null");
            return (Criteria) this;
        }

        public Criteria andZktIsNotNull() {
            addCriterion("zkt is not null");
            return (Criteria) this;
        }

        public Criteria andZktEqualTo(String value) {
            addCriterion("zkt =", value, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktNotEqualTo(String value) {
            addCriterion("zkt <>", value, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktGreaterThan(String value) {
            addCriterion("zkt >", value, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktGreaterThanOrEqualTo(String value) {
            addCriterion("zkt >=", value, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktLessThan(String value) {
            addCriterion("zkt <", value, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktLessThanOrEqualTo(String value) {
            addCriterion("zkt <=", value, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktLike(String value) {
            addCriterion("zkt like", value, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktNotLike(String value) {
            addCriterion("zkt not like", value, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktIn(List<String> values) {
            addCriterion("zkt in", values, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktNotIn(List<String> values) {
            addCriterion("zkt not in", values, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktBetween(String value1, String value2) {
            addCriterion("zkt between", value1, value2, "zkt");
            return (Criteria) this;
        }

        public Criteria andZktNotBetween(String value1, String value2) {
            addCriterion("zkt not between", value1, value2, "zkt");
            return (Criteria) this;
        }

        public Criteria andHbxIsNull() {
            addCriterion("hbx is null");
            return (Criteria) this;
        }

        public Criteria andHbxIsNotNull() {
            addCriterion("hbx is not null");
            return (Criteria) this;
        }

        public Criteria andHbxEqualTo(String value) {
            addCriterion("hbx =", value, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxNotEqualTo(String value) {
            addCriterion("hbx <>", value, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxGreaterThan(String value) {
            addCriterion("hbx >", value, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxGreaterThanOrEqualTo(String value) {
            addCriterion("hbx >=", value, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxLessThan(String value) {
            addCriterion("hbx <", value, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxLessThanOrEqualTo(String value) {
            addCriterion("hbx <=", value, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxLike(String value) {
            addCriterion("hbx like", value, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxNotLike(String value) {
            addCriterion("hbx not like", value, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxIn(List<String> values) {
            addCriterion("hbx in", values, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxNotIn(List<String> values) {
            addCriterion("hbx not in", values, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxBetween(String value1, String value2) {
            addCriterion("hbx between", value1, value2, "hbx");
            return (Criteria) this;
        }

        public Criteria andHbxNotBetween(String value1, String value2) {
            addCriterion("hbx not between", value1, value2, "hbx");
            return (Criteria) this;
        }

        public Criteria andYh45IsNull() {
            addCriterion("yh45 is null");
            return (Criteria) this;
        }

        public Criteria andYh45IsNotNull() {
            addCriterion("yh45 is not null");
            return (Criteria) this;
        }

        public Criteria andYh45EqualTo(String value) {
            addCriterion("yh45 =", value, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45NotEqualTo(String value) {
            addCriterion("yh45 <>", value, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45GreaterThan(String value) {
            addCriterion("yh45 >", value, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45GreaterThanOrEqualTo(String value) {
            addCriterion("yh45 >=", value, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45LessThan(String value) {
            addCriterion("yh45 <", value, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45LessThanOrEqualTo(String value) {
            addCriterion("yh45 <=", value, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45Like(String value) {
            addCriterion("yh45 like", value, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45NotLike(String value) {
            addCriterion("yh45 not like", value, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45In(List<String> values) {
            addCriterion("yh45 in", values, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45NotIn(List<String> values) {
            addCriterion("yh45 not in", values, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45Between(String value1, String value2) {
            addCriterion("yh45 between", value1, value2, "yh45");
            return (Criteria) this;
        }

        public Criteria andYh45NotBetween(String value1, String value2) {
            addCriterion("yh45 not between", value1, value2, "yh45");
            return (Criteria) this;
        }

        public Criteria andYsIsNull() {
            addCriterion("ys is null");
            return (Criteria) this;
        }

        public Criteria andYsIsNotNull() {
            addCriterion("ys is not null");
            return (Criteria) this;
        }

        public Criteria andYsEqualTo(String value) {
            addCriterion("ys =", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsNotEqualTo(String value) {
            addCriterion("ys <>", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsGreaterThan(String value) {
            addCriterion("ys >", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsGreaterThanOrEqualTo(String value) {
            addCriterion("ys >=", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsLessThan(String value) {
            addCriterion("ys <", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsLessThanOrEqualTo(String value) {
            addCriterion("ys <=", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsLike(String value) {
            addCriterion("ys like", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsNotLike(String value) {
            addCriterion("ys not like", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsIn(List<String> values) {
            addCriterion("ys in", values, "ys");
            return (Criteria) this;
        }

        public Criteria andYsNotIn(List<String> values) {
            addCriterion("ys not in", values, "ys");
            return (Criteria) this;
        }

        public Criteria andYsBetween(String value1, String value2) {
            addCriterion("ys between", value1, value2, "ys");
            return (Criteria) this;
        }

        public Criteria andYsNotBetween(String value1, String value2) {
            addCriterion("ys not between", value1, value2, "ys");
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