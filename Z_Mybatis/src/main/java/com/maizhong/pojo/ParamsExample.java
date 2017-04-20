package com.maizhong.pojo;

import java.util.ArrayList;
import java.util.List;

public class ParamsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParamsExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Integer value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Integer value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Integer value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Integer value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Integer> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Integer> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Integer value1, Integer value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andP1IsNull() {
            addCriterion("p1 is null");
            return (Criteria) this;
        }

        public Criteria andP1IsNotNull() {
            addCriterion("p1 is not null");
            return (Criteria) this;
        }

        public Criteria andP1EqualTo(String value) {
            addCriterion("p1 =", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1NotEqualTo(String value) {
            addCriterion("p1 <>", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1GreaterThan(String value) {
            addCriterion("p1 >", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1GreaterThanOrEqualTo(String value) {
            addCriterion("p1 >=", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1LessThan(String value) {
            addCriterion("p1 <", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1LessThanOrEqualTo(String value) {
            addCriterion("p1 <=", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1Like(String value) {
            addCriterion("p1 like", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1NotLike(String value) {
            addCriterion("p1 not like", value, "p1");
            return (Criteria) this;
        }

        public Criteria andP1In(List<String> values) {
            addCriterion("p1 in", values, "p1");
            return (Criteria) this;
        }

        public Criteria andP1NotIn(List<String> values) {
            addCriterion("p1 not in", values, "p1");
            return (Criteria) this;
        }

        public Criteria andP1Between(String value1, String value2) {
            addCriterion("p1 between", value1, value2, "p1");
            return (Criteria) this;
        }

        public Criteria andP1NotBetween(String value1, String value2) {
            addCriterion("p1 not between", value1, value2, "p1");
            return (Criteria) this;
        }

        public Criteria andP2IsNull() {
            addCriterion("p2 is null");
            return (Criteria) this;
        }

        public Criteria andP2IsNotNull() {
            addCriterion("p2 is not null");
            return (Criteria) this;
        }

        public Criteria andP2EqualTo(String value) {
            addCriterion("p2 =", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2NotEqualTo(String value) {
            addCriterion("p2 <>", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2GreaterThan(String value) {
            addCriterion("p2 >", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2GreaterThanOrEqualTo(String value) {
            addCriterion("p2 >=", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2LessThan(String value) {
            addCriterion("p2 <", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2LessThanOrEqualTo(String value) {
            addCriterion("p2 <=", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2Like(String value) {
            addCriterion("p2 like", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2NotLike(String value) {
            addCriterion("p2 not like", value, "p2");
            return (Criteria) this;
        }

        public Criteria andP2In(List<String> values) {
            addCriterion("p2 in", values, "p2");
            return (Criteria) this;
        }

        public Criteria andP2NotIn(List<String> values) {
            addCriterion("p2 not in", values, "p2");
            return (Criteria) this;
        }

        public Criteria andP2Between(String value1, String value2) {
            addCriterion("p2 between", value1, value2, "p2");
            return (Criteria) this;
        }

        public Criteria andP2NotBetween(String value1, String value2) {
            addCriterion("p2 not between", value1, value2, "p2");
            return (Criteria) this;
        }

        public Criteria andP3IsNull() {
            addCriterion("p3 is null");
            return (Criteria) this;
        }

        public Criteria andP3IsNotNull() {
            addCriterion("p3 is not null");
            return (Criteria) this;
        }

        public Criteria andP3EqualTo(String value) {
            addCriterion("p3 =", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3NotEqualTo(String value) {
            addCriterion("p3 <>", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3GreaterThan(String value) {
            addCriterion("p3 >", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3GreaterThanOrEqualTo(String value) {
            addCriterion("p3 >=", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3LessThan(String value) {
            addCriterion("p3 <", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3LessThanOrEqualTo(String value) {
            addCriterion("p3 <=", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3Like(String value) {
            addCriterion("p3 like", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3NotLike(String value) {
            addCriterion("p3 not like", value, "p3");
            return (Criteria) this;
        }

        public Criteria andP3In(List<String> values) {
            addCriterion("p3 in", values, "p3");
            return (Criteria) this;
        }

        public Criteria andP3NotIn(List<String> values) {
            addCriterion("p3 not in", values, "p3");
            return (Criteria) this;
        }

        public Criteria andP3Between(String value1, String value2) {
            addCriterion("p3 between", value1, value2, "p3");
            return (Criteria) this;
        }

        public Criteria andP3NotBetween(String value1, String value2) {
            addCriterion("p3 not between", value1, value2, "p3");
            return (Criteria) this;
        }

        public Criteria andP4IsNull() {
            addCriterion("p4 is null");
            return (Criteria) this;
        }

        public Criteria andP4IsNotNull() {
            addCriterion("p4 is not null");
            return (Criteria) this;
        }

        public Criteria andP4EqualTo(String value) {
            addCriterion("p4 =", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotEqualTo(String value) {
            addCriterion("p4 <>", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4GreaterThan(String value) {
            addCriterion("p4 >", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4GreaterThanOrEqualTo(String value) {
            addCriterion("p4 >=", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4LessThan(String value) {
            addCriterion("p4 <", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4LessThanOrEqualTo(String value) {
            addCriterion("p4 <=", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4Like(String value) {
            addCriterion("p4 like", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotLike(String value) {
            addCriterion("p4 not like", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4In(List<String> values) {
            addCriterion("p4 in", values, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotIn(List<String> values) {
            addCriterion("p4 not in", values, "p4");
            return (Criteria) this;
        }

        public Criteria andP4Between(String value1, String value2) {
            addCriterion("p4 between", value1, value2, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotBetween(String value1, String value2) {
            addCriterion("p4 not between", value1, value2, "p4");
            return (Criteria) this;
        }

        public Criteria andP5IsNull() {
            addCriterion("p5 is null");
            return (Criteria) this;
        }

        public Criteria andP5IsNotNull() {
            addCriterion("p5 is not null");
            return (Criteria) this;
        }

        public Criteria andP5EqualTo(String value) {
            addCriterion("p5 =", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5NotEqualTo(String value) {
            addCriterion("p5 <>", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5GreaterThan(String value) {
            addCriterion("p5 >", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5GreaterThanOrEqualTo(String value) {
            addCriterion("p5 >=", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5LessThan(String value) {
            addCriterion("p5 <", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5LessThanOrEqualTo(String value) {
            addCriterion("p5 <=", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5Like(String value) {
            addCriterion("p5 like", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5NotLike(String value) {
            addCriterion("p5 not like", value, "p5");
            return (Criteria) this;
        }

        public Criteria andP5In(List<String> values) {
            addCriterion("p5 in", values, "p5");
            return (Criteria) this;
        }

        public Criteria andP5NotIn(List<String> values) {
            addCriterion("p5 not in", values, "p5");
            return (Criteria) this;
        }

        public Criteria andP5Between(String value1, String value2) {
            addCriterion("p5 between", value1, value2, "p5");
            return (Criteria) this;
        }

        public Criteria andP5NotBetween(String value1, String value2) {
            addCriterion("p5 not between", value1, value2, "p5");
            return (Criteria) this;
        }

        public Criteria andP6IsNull() {
            addCriterion("p6 is null");
            return (Criteria) this;
        }

        public Criteria andP6IsNotNull() {
            addCriterion("p6 is not null");
            return (Criteria) this;
        }

        public Criteria andP6EqualTo(String value) {
            addCriterion("p6 =", value, "p6");
            return (Criteria) this;
        }

        public Criteria andP6NotEqualTo(String value) {
            addCriterion("p6 <>", value, "p6");
            return (Criteria) this;
        }

        public Criteria andP6GreaterThan(String value) {
            addCriterion("p6 >", value, "p6");
            return (Criteria) this;
        }

        public Criteria andP6GreaterThanOrEqualTo(String value) {
            addCriterion("p6 >=", value, "p6");
            return (Criteria) this;
        }

        public Criteria andP6LessThan(String value) {
            addCriterion("p6 <", value, "p6");
            return (Criteria) this;
        }

        public Criteria andP6LessThanOrEqualTo(String value) {
            addCriterion("p6 <=", value, "p6");
            return (Criteria) this;
        }

        public Criteria andP6Like(String value) {
            addCriterion("p6 like", value, "p6");
            return (Criteria) this;
        }

        public Criteria andP6NotLike(String value) {
            addCriterion("p6 not like", value, "p6");
            return (Criteria) this;
        }

        public Criteria andP6In(List<String> values) {
            addCriterion("p6 in", values, "p6");
            return (Criteria) this;
        }

        public Criteria andP6NotIn(List<String> values) {
            addCriterion("p6 not in", values, "p6");
            return (Criteria) this;
        }

        public Criteria andP6Between(String value1, String value2) {
            addCriterion("p6 between", value1, value2, "p6");
            return (Criteria) this;
        }

        public Criteria andP6NotBetween(String value1, String value2) {
            addCriterion("p6 not between", value1, value2, "p6");
            return (Criteria) this;
        }

        public Criteria andP7IsNull() {
            addCriterion("p7 is null");
            return (Criteria) this;
        }

        public Criteria andP7IsNotNull() {
            addCriterion("p7 is not null");
            return (Criteria) this;
        }

        public Criteria andP7EqualTo(String value) {
            addCriterion("p7 =", value, "p7");
            return (Criteria) this;
        }

        public Criteria andP7NotEqualTo(String value) {
            addCriterion("p7 <>", value, "p7");
            return (Criteria) this;
        }

        public Criteria andP7GreaterThan(String value) {
            addCriterion("p7 >", value, "p7");
            return (Criteria) this;
        }

        public Criteria andP7GreaterThanOrEqualTo(String value) {
            addCriterion("p7 >=", value, "p7");
            return (Criteria) this;
        }

        public Criteria andP7LessThan(String value) {
            addCriterion("p7 <", value, "p7");
            return (Criteria) this;
        }

        public Criteria andP7LessThanOrEqualTo(String value) {
            addCriterion("p7 <=", value, "p7");
            return (Criteria) this;
        }

        public Criteria andP7Like(String value) {
            addCriterion("p7 like", value, "p7");
            return (Criteria) this;
        }

        public Criteria andP7NotLike(String value) {
            addCriterion("p7 not like", value, "p7");
            return (Criteria) this;
        }

        public Criteria andP7In(List<String> values) {
            addCriterion("p7 in", values, "p7");
            return (Criteria) this;
        }

        public Criteria andP7NotIn(List<String> values) {
            addCriterion("p7 not in", values, "p7");
            return (Criteria) this;
        }

        public Criteria andP7Between(String value1, String value2) {
            addCriterion("p7 between", value1, value2, "p7");
            return (Criteria) this;
        }

        public Criteria andP7NotBetween(String value1, String value2) {
            addCriterion("p7 not between", value1, value2, "p7");
            return (Criteria) this;
        }

        public Criteria andP8IsNull() {
            addCriterion("p8 is null");
            return (Criteria) this;
        }

        public Criteria andP8IsNotNull() {
            addCriterion("p8 is not null");
            return (Criteria) this;
        }

        public Criteria andP8EqualTo(String value) {
            addCriterion("p8 =", value, "p8");
            return (Criteria) this;
        }

        public Criteria andP8NotEqualTo(String value) {
            addCriterion("p8 <>", value, "p8");
            return (Criteria) this;
        }

        public Criteria andP8GreaterThan(String value) {
            addCriterion("p8 >", value, "p8");
            return (Criteria) this;
        }

        public Criteria andP8GreaterThanOrEqualTo(String value) {
            addCriterion("p8 >=", value, "p8");
            return (Criteria) this;
        }

        public Criteria andP8LessThan(String value) {
            addCriterion("p8 <", value, "p8");
            return (Criteria) this;
        }

        public Criteria andP8LessThanOrEqualTo(String value) {
            addCriterion("p8 <=", value, "p8");
            return (Criteria) this;
        }

        public Criteria andP8Like(String value) {
            addCriterion("p8 like", value, "p8");
            return (Criteria) this;
        }

        public Criteria andP8NotLike(String value) {
            addCriterion("p8 not like", value, "p8");
            return (Criteria) this;
        }

        public Criteria andP8In(List<String> values) {
            addCriterion("p8 in", values, "p8");
            return (Criteria) this;
        }

        public Criteria andP8NotIn(List<String> values) {
            addCriterion("p8 not in", values, "p8");
            return (Criteria) this;
        }

        public Criteria andP8Between(String value1, String value2) {
            addCriterion("p8 between", value1, value2, "p8");
            return (Criteria) this;
        }

        public Criteria andP8NotBetween(String value1, String value2) {
            addCriterion("p8 not between", value1, value2, "p8");
            return (Criteria) this;
        }

        public Criteria andP9IsNull() {
            addCriterion("p9 is null");
            return (Criteria) this;
        }

        public Criteria andP9IsNotNull() {
            addCriterion("p9 is not null");
            return (Criteria) this;
        }

        public Criteria andP9EqualTo(String value) {
            addCriterion("p9 =", value, "p9");
            return (Criteria) this;
        }

        public Criteria andP9NotEqualTo(String value) {
            addCriterion("p9 <>", value, "p9");
            return (Criteria) this;
        }

        public Criteria andP9GreaterThan(String value) {
            addCriterion("p9 >", value, "p9");
            return (Criteria) this;
        }

        public Criteria andP9GreaterThanOrEqualTo(String value) {
            addCriterion("p9 >=", value, "p9");
            return (Criteria) this;
        }

        public Criteria andP9LessThan(String value) {
            addCriterion("p9 <", value, "p9");
            return (Criteria) this;
        }

        public Criteria andP9LessThanOrEqualTo(String value) {
            addCriterion("p9 <=", value, "p9");
            return (Criteria) this;
        }

        public Criteria andP9Like(String value) {
            addCriterion("p9 like", value, "p9");
            return (Criteria) this;
        }

        public Criteria andP9NotLike(String value) {
            addCriterion("p9 not like", value, "p9");
            return (Criteria) this;
        }

        public Criteria andP9In(List<String> values) {
            addCriterion("p9 in", values, "p9");
            return (Criteria) this;
        }

        public Criteria andP9NotIn(List<String> values) {
            addCriterion("p9 not in", values, "p9");
            return (Criteria) this;
        }

        public Criteria andP9Between(String value1, String value2) {
            addCriterion("p9 between", value1, value2, "p9");
            return (Criteria) this;
        }

        public Criteria andP9NotBetween(String value1, String value2) {
            addCriterion("p9 not between", value1, value2, "p9");
            return (Criteria) this;
        }

        public Criteria andP10IsNull() {
            addCriterion("p10 is null");
            return (Criteria) this;
        }

        public Criteria andP10IsNotNull() {
            addCriterion("p10 is not null");
            return (Criteria) this;
        }

        public Criteria andP10EqualTo(String value) {
            addCriterion("p10 =", value, "p10");
            return (Criteria) this;
        }

        public Criteria andP10NotEqualTo(String value) {
            addCriterion("p10 <>", value, "p10");
            return (Criteria) this;
        }

        public Criteria andP10GreaterThan(String value) {
            addCriterion("p10 >", value, "p10");
            return (Criteria) this;
        }

        public Criteria andP10GreaterThanOrEqualTo(String value) {
            addCriterion("p10 >=", value, "p10");
            return (Criteria) this;
        }

        public Criteria andP10LessThan(String value) {
            addCriterion("p10 <", value, "p10");
            return (Criteria) this;
        }

        public Criteria andP10LessThanOrEqualTo(String value) {
            addCriterion("p10 <=", value, "p10");
            return (Criteria) this;
        }

        public Criteria andP10Like(String value) {
            addCriterion("p10 like", value, "p10");
            return (Criteria) this;
        }

        public Criteria andP10NotLike(String value) {
            addCriterion("p10 not like", value, "p10");
            return (Criteria) this;
        }

        public Criteria andP10In(List<String> values) {
            addCriterion("p10 in", values, "p10");
            return (Criteria) this;
        }

        public Criteria andP10NotIn(List<String> values) {
            addCriterion("p10 not in", values, "p10");
            return (Criteria) this;
        }

        public Criteria andP10Between(String value1, String value2) {
            addCriterion("p10 between", value1, value2, "p10");
            return (Criteria) this;
        }

        public Criteria andP10NotBetween(String value1, String value2) {
            addCriterion("p10 not between", value1, value2, "p10");
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