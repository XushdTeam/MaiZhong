package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkPzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkPzExample() {
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

        public Criteria andAbsIsNull() {
            addCriterion("abs is null");
            return (Criteria) this;
        }

        public Criteria andAbsIsNotNull() {
            addCriterion("abs is not null");
            return (Criteria) this;
        }

        public Criteria andAbsEqualTo(Integer value) {
            addCriterion("abs =", value, "abs");
            return (Criteria) this;
        }

        public Criteria andAbsNotEqualTo(Integer value) {
            addCriterion("abs <>", value, "abs");
            return (Criteria) this;
        }

        public Criteria andAbsGreaterThan(Integer value) {
            addCriterion("abs >", value, "abs");
            return (Criteria) this;
        }

        public Criteria andAbsGreaterThanOrEqualTo(Integer value) {
            addCriterion("abs >=", value, "abs");
            return (Criteria) this;
        }

        public Criteria andAbsLessThan(Integer value) {
            addCriterion("abs <", value, "abs");
            return (Criteria) this;
        }

        public Criteria andAbsLessThanOrEqualTo(Integer value) {
            addCriterion("abs <=", value, "abs");
            return (Criteria) this;
        }

        public Criteria andAbsIn(List<Integer> values) {
            addCriterion("abs in", values, "abs");
            return (Criteria) this;
        }

        public Criteria andAbsNotIn(List<Integer> values) {
            addCriterion("abs not in", values, "abs");
            return (Criteria) this;
        }

        public Criteria andAbsBetween(Integer value1, Integer value2) {
            addCriterion("abs between", value1, value2, "abs");
            return (Criteria) this;
        }

        public Criteria andAbsNotBetween(Integer value1, Integer value2) {
            addCriterion("abs not between", value1, value2, "abs");
            return (Criteria) this;
        }

        public Criteria andAbsBugIsNull() {
            addCriterion("abs_bug is null");
            return (Criteria) this;
        }

        public Criteria andAbsBugIsNotNull() {
            addCriterion("abs_bug is not null");
            return (Criteria) this;
        }

        public Criteria andAbsBugEqualTo(Integer value) {
            addCriterion("abs_bug =", value, "absBug");
            return (Criteria) this;
        }

        public Criteria andAbsBugNotEqualTo(Integer value) {
            addCriterion("abs_bug <>", value, "absBug");
            return (Criteria) this;
        }

        public Criteria andAbsBugGreaterThan(Integer value) {
            addCriterion("abs_bug >", value, "absBug");
            return (Criteria) this;
        }

        public Criteria andAbsBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("abs_bug >=", value, "absBug");
            return (Criteria) this;
        }

        public Criteria andAbsBugLessThan(Integer value) {
            addCriterion("abs_bug <", value, "absBug");
            return (Criteria) this;
        }

        public Criteria andAbsBugLessThanOrEqualTo(Integer value) {
            addCriterion("abs_bug <=", value, "absBug");
            return (Criteria) this;
        }

        public Criteria andAbsBugIn(List<Integer> values) {
            addCriterion("abs_bug in", values, "absBug");
            return (Criteria) this;
        }

        public Criteria andAbsBugNotIn(List<Integer> values) {
            addCriterion("abs_bug not in", values, "absBug");
            return (Criteria) this;
        }

        public Criteria andAbsBugBetween(Integer value1, Integer value2) {
            addCriterion("abs_bug between", value1, value2, "absBug");
            return (Criteria) this;
        }

        public Criteria andAbsBugNotBetween(Integer value1, Integer value2) {
            addCriterion("abs_bug not between", value1, value2, "absBug");
            return (Criteria) this;
        }

        public Criteria andQnIsNull() {
            addCriterion("qn is null");
            return (Criteria) this;
        }

        public Criteria andQnIsNotNull() {
            addCriterion("qn is not null");
            return (Criteria) this;
        }

        public Criteria andQnEqualTo(Integer value) {
            addCriterion("qn =", value, "qn");
            return (Criteria) this;
        }

        public Criteria andQnNotEqualTo(Integer value) {
            addCriterion("qn <>", value, "qn");
            return (Criteria) this;
        }

        public Criteria andQnGreaterThan(Integer value) {
            addCriterion("qn >", value, "qn");
            return (Criteria) this;
        }

        public Criteria andQnGreaterThanOrEqualTo(Integer value) {
            addCriterion("qn >=", value, "qn");
            return (Criteria) this;
        }

        public Criteria andQnLessThan(Integer value) {
            addCriterion("qn <", value, "qn");
            return (Criteria) this;
        }

        public Criteria andQnLessThanOrEqualTo(Integer value) {
            addCriterion("qn <=", value, "qn");
            return (Criteria) this;
        }

        public Criteria andQnIn(List<Integer> values) {
            addCriterion("qn in", values, "qn");
            return (Criteria) this;
        }

        public Criteria andQnNotIn(List<Integer> values) {
            addCriterion("qn not in", values, "qn");
            return (Criteria) this;
        }

        public Criteria andQnBetween(Integer value1, Integer value2) {
            addCriterion("qn between", value1, value2, "qn");
            return (Criteria) this;
        }

        public Criteria andQnNotBetween(Integer value1, Integer value2) {
            addCriterion("qn not between", value1, value2, "qn");
            return (Criteria) this;
        }

        public Criteria andQnBugIsNull() {
            addCriterion("qn_bug is null");
            return (Criteria) this;
        }

        public Criteria andQnBugIsNotNull() {
            addCriterion("qn_bug is not null");
            return (Criteria) this;
        }

        public Criteria andQnBugEqualTo(Integer value) {
            addCriterion("qn_bug =", value, "qnBug");
            return (Criteria) this;
        }

        public Criteria andQnBugNotEqualTo(Integer value) {
            addCriterion("qn_bug <>", value, "qnBug");
            return (Criteria) this;
        }

        public Criteria andQnBugGreaterThan(Integer value) {
            addCriterion("qn_bug >", value, "qnBug");
            return (Criteria) this;
        }

        public Criteria andQnBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("qn_bug >=", value, "qnBug");
            return (Criteria) this;
        }

        public Criteria andQnBugLessThan(Integer value) {
            addCriterion("qn_bug <", value, "qnBug");
            return (Criteria) this;
        }

        public Criteria andQnBugLessThanOrEqualTo(Integer value) {
            addCriterion("qn_bug <=", value, "qnBug");
            return (Criteria) this;
        }

        public Criteria andQnBugIn(List<Integer> values) {
            addCriterion("qn_bug in", values, "qnBug");
            return (Criteria) this;
        }

        public Criteria andQnBugNotIn(List<Integer> values) {
            addCriterion("qn_bug not in", values, "qnBug");
            return (Criteria) this;
        }

        public Criteria andQnBugBetween(Integer value1, Integer value2) {
            addCriterion("qn_bug between", value1, value2, "qnBug");
            return (Criteria) this;
        }

        public Criteria andQnBugNotBetween(Integer value1, Integer value2) {
            addCriterion("qn_bug not between", value1, value2, "qnBug");
            return (Criteria) this;
        }

        public Criteria andZxzlIsNull() {
            addCriterion("zxzl is null");
            return (Criteria) this;
        }

        public Criteria andZxzlIsNotNull() {
            addCriterion("zxzl is not null");
            return (Criteria) this;
        }

        public Criteria andZxzlEqualTo(Integer value) {
            addCriterion("zxzl =", value, "zxzl");
            return (Criteria) this;
        }

        public Criteria andZxzlNotEqualTo(Integer value) {
            addCriterion("zxzl <>", value, "zxzl");
            return (Criteria) this;
        }

        public Criteria andZxzlGreaterThan(Integer value) {
            addCriterion("zxzl >", value, "zxzl");
            return (Criteria) this;
        }

        public Criteria andZxzlGreaterThanOrEqualTo(Integer value) {
            addCriterion("zxzl >=", value, "zxzl");
            return (Criteria) this;
        }

        public Criteria andZxzlLessThan(Integer value) {
            addCriterion("zxzl <", value, "zxzl");
            return (Criteria) this;
        }

        public Criteria andZxzlLessThanOrEqualTo(Integer value) {
            addCriterion("zxzl <=", value, "zxzl");
            return (Criteria) this;
        }

        public Criteria andZxzlIn(List<Integer> values) {
            addCriterion("zxzl in", values, "zxzl");
            return (Criteria) this;
        }

        public Criteria andZxzlNotIn(List<Integer> values) {
            addCriterion("zxzl not in", values, "zxzl");
            return (Criteria) this;
        }

        public Criteria andZxzlBetween(Integer value1, Integer value2) {
            addCriterion("zxzl between", value1, value2, "zxzl");
            return (Criteria) this;
        }

        public Criteria andZxzlNotBetween(Integer value1, Integer value2) {
            addCriterion("zxzl not between", value1, value2, "zxzl");
            return (Criteria) this;
        }

        public Criteria andZxzlBugIsNull() {
            addCriterion("zxzl_bug is null");
            return (Criteria) this;
        }

        public Criteria andZxzlBugIsNotNull() {
            addCriterion("zxzl_bug is not null");
            return (Criteria) this;
        }

        public Criteria andZxzlBugEqualTo(Integer value) {
            addCriterion("zxzl_bug =", value, "zxzlBug");
            return (Criteria) this;
        }

        public Criteria andZxzlBugNotEqualTo(Integer value) {
            addCriterion("zxzl_bug <>", value, "zxzlBug");
            return (Criteria) this;
        }

        public Criteria andZxzlBugGreaterThan(Integer value) {
            addCriterion("zxzl_bug >", value, "zxzlBug");
            return (Criteria) this;
        }

        public Criteria andZxzlBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("zxzl_bug >=", value, "zxzlBug");
            return (Criteria) this;
        }

        public Criteria andZxzlBugLessThan(Integer value) {
            addCriterion("zxzl_bug <", value, "zxzlBug");
            return (Criteria) this;
        }

        public Criteria andZxzlBugLessThanOrEqualTo(Integer value) {
            addCriterion("zxzl_bug <=", value, "zxzlBug");
            return (Criteria) this;
        }

        public Criteria andZxzlBugIn(List<Integer> values) {
            addCriterion("zxzl_bug in", values, "zxzlBug");
            return (Criteria) this;
        }

        public Criteria andZxzlBugNotIn(List<Integer> values) {
            addCriterion("zxzl_bug not in", values, "zxzlBug");
            return (Criteria) this;
        }

        public Criteria andZxzlBugBetween(Integer value1, Integer value2) {
            addCriterion("zxzl_bug between", value1, value2, "zxzlBug");
            return (Criteria) this;
        }

        public Criteria andZxzlBugNotBetween(Integer value1, Integer value2) {
            addCriterion("zxzl_bug not between", value1, value2, "zxzlBug");
            return (Criteria) this;
        }

        public Criteria andCcblIsNull() {
            addCriterion("ccbl is null");
            return (Criteria) this;
        }

        public Criteria andCcblIsNotNull() {
            addCriterion("ccbl is not null");
            return (Criteria) this;
        }

        public Criteria andCcblEqualTo(Integer value) {
            addCriterion("ccbl =", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblNotEqualTo(Integer value) {
            addCriterion("ccbl <>", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblGreaterThan(Integer value) {
            addCriterion("ccbl >", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblGreaterThanOrEqualTo(Integer value) {
            addCriterion("ccbl >=", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblLessThan(Integer value) {
            addCriterion("ccbl <", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblLessThanOrEqualTo(Integer value) {
            addCriterion("ccbl <=", value, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblIn(List<Integer> values) {
            addCriterion("ccbl in", values, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblNotIn(List<Integer> values) {
            addCriterion("ccbl not in", values, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblBetween(Integer value1, Integer value2) {
            addCriterion("ccbl between", value1, value2, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblNotBetween(Integer value1, Integer value2) {
            addCriterion("ccbl not between", value1, value2, "ccbl");
            return (Criteria) this;
        }

        public Criteria andCcblBugIsNull() {
            addCriterion("ccbl_bug is null");
            return (Criteria) this;
        }

        public Criteria andCcblBugIsNotNull() {
            addCriterion("ccbl_bug is not null");
            return (Criteria) this;
        }

        public Criteria andCcblBugEqualTo(Integer value) {
            addCriterion("ccbl_bug =", value, "ccblBug");
            return (Criteria) this;
        }

        public Criteria andCcblBugNotEqualTo(Integer value) {
            addCriterion("ccbl_bug <>", value, "ccblBug");
            return (Criteria) this;
        }

        public Criteria andCcblBugGreaterThan(Integer value) {
            addCriterion("ccbl_bug >", value, "ccblBug");
            return (Criteria) this;
        }

        public Criteria andCcblBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("ccbl_bug >=", value, "ccblBug");
            return (Criteria) this;
        }

        public Criteria andCcblBugLessThan(Integer value) {
            addCriterion("ccbl_bug <", value, "ccblBug");
            return (Criteria) this;
        }

        public Criteria andCcblBugLessThanOrEqualTo(Integer value) {
            addCriterion("ccbl_bug <=", value, "ccblBug");
            return (Criteria) this;
        }

        public Criteria andCcblBugIn(List<Integer> values) {
            addCriterion("ccbl_bug in", values, "ccblBug");
            return (Criteria) this;
        }

        public Criteria andCcblBugNotIn(List<Integer> values) {
            addCriterion("ccbl_bug not in", values, "ccblBug");
            return (Criteria) this;
        }

        public Criteria andCcblBugBetween(Integer value1, Integer value2) {
            addCriterion("ccbl_bug between", value1, value2, "ccblBug");
            return (Criteria) this;
        }

        public Criteria andCcblBugNotBetween(Integer value1, Integer value2) {
            addCriterion("ccbl_bug not between", value1, value2, "ccblBug");
            return (Criteria) this;
        }

        public Criteria andTcIsNull() {
            addCriterion("tc is null");
            return (Criteria) this;
        }

        public Criteria andTcIsNotNull() {
            addCriterion("tc is not null");
            return (Criteria) this;
        }

        public Criteria andTcEqualTo(Integer value) {
            addCriterion("tc =", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcNotEqualTo(Integer value) {
            addCriterion("tc <>", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcGreaterThan(Integer value) {
            addCriterion("tc >", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcGreaterThanOrEqualTo(Integer value) {
            addCriterion("tc >=", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcLessThan(Integer value) {
            addCriterion("tc <", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcLessThanOrEqualTo(Integer value) {
            addCriterion("tc <=", value, "tc");
            return (Criteria) this;
        }

        public Criteria andTcIn(List<Integer> values) {
            addCriterion("tc in", values, "tc");
            return (Criteria) this;
        }

        public Criteria andTcNotIn(List<Integer> values) {
            addCriterion("tc not in", values, "tc");
            return (Criteria) this;
        }

        public Criteria andTcBetween(Integer value1, Integer value2) {
            addCriterion("tc between", value1, value2, "tc");
            return (Criteria) this;
        }

        public Criteria andTcNotBetween(Integer value1, Integer value2) {
            addCriterion("tc not between", value1, value2, "tc");
            return (Criteria) this;
        }

        public Criteria andTcBugIsNull() {
            addCriterion("tc_bug is null");
            return (Criteria) this;
        }

        public Criteria andTcBugIsNotNull() {
            addCriterion("tc_bug is not null");
            return (Criteria) this;
        }

        public Criteria andTcBugEqualTo(Integer value) {
            addCriterion("tc_bug =", value, "tcBug");
            return (Criteria) this;
        }

        public Criteria andTcBugNotEqualTo(Integer value) {
            addCriterion("tc_bug <>", value, "tcBug");
            return (Criteria) this;
        }

        public Criteria andTcBugGreaterThan(Integer value) {
            addCriterion("tc_bug >", value, "tcBug");
            return (Criteria) this;
        }

        public Criteria andTcBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("tc_bug >=", value, "tcBug");
            return (Criteria) this;
        }

        public Criteria andTcBugLessThan(Integer value) {
            addCriterion("tc_bug <", value, "tcBug");
            return (Criteria) this;
        }

        public Criteria andTcBugLessThanOrEqualTo(Integer value) {
            addCriterion("tc_bug <=", value, "tcBug");
            return (Criteria) this;
        }

        public Criteria andTcBugIn(List<Integer> values) {
            addCriterion("tc_bug in", values, "tcBug");
            return (Criteria) this;
        }

        public Criteria andTcBugNotIn(List<Integer> values) {
            addCriterion("tc_bug not in", values, "tcBug");
            return (Criteria) this;
        }

        public Criteria andTcBugBetween(Integer value1, Integer value2) {
            addCriterion("tc_bug between", value1, value2, "tcBug");
            return (Criteria) this;
        }

        public Criteria andTcBugNotBetween(Integer value1, Integer value2) {
            addCriterion("tc_bug not between", value1, value2, "tcBug");
            return (Criteria) this;
        }

        public Criteria andCwhsjIsNull() {
            addCriterion("cwhsj is null");
            return (Criteria) this;
        }

        public Criteria andCwhsjIsNotNull() {
            addCriterion("cwhsj is not null");
            return (Criteria) this;
        }

        public Criteria andCwhsjEqualTo(Integer value) {
            addCriterion("cwhsj =", value, "cwhsj");
            return (Criteria) this;
        }

        public Criteria andCwhsjNotEqualTo(Integer value) {
            addCriterion("cwhsj <>", value, "cwhsj");
            return (Criteria) this;
        }

        public Criteria andCwhsjGreaterThan(Integer value) {
            addCriterion("cwhsj >", value, "cwhsj");
            return (Criteria) this;
        }

        public Criteria andCwhsjGreaterThanOrEqualTo(Integer value) {
            addCriterion("cwhsj >=", value, "cwhsj");
            return (Criteria) this;
        }

        public Criteria andCwhsjLessThan(Integer value) {
            addCriterion("cwhsj <", value, "cwhsj");
            return (Criteria) this;
        }

        public Criteria andCwhsjLessThanOrEqualTo(Integer value) {
            addCriterion("cwhsj <=", value, "cwhsj");
            return (Criteria) this;
        }

        public Criteria andCwhsjIn(List<Integer> values) {
            addCriterion("cwhsj in", values, "cwhsj");
            return (Criteria) this;
        }

        public Criteria andCwhsjNotIn(List<Integer> values) {
            addCriterion("cwhsj not in", values, "cwhsj");
            return (Criteria) this;
        }

        public Criteria andCwhsjBetween(Integer value1, Integer value2) {
            addCriterion("cwhsj between", value1, value2, "cwhsj");
            return (Criteria) this;
        }

        public Criteria andCwhsjNotBetween(Integer value1, Integer value2) {
            addCriterion("cwhsj not between", value1, value2, "cwhsj");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugIsNull() {
            addCriterion("cwhsj_bug is null");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugIsNotNull() {
            addCriterion("cwhsj_bug is not null");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugEqualTo(Integer value) {
            addCriterion("cwhsj_bug =", value, "cwhsjBug");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugNotEqualTo(Integer value) {
            addCriterion("cwhsj_bug <>", value, "cwhsjBug");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugGreaterThan(Integer value) {
            addCriterion("cwhsj_bug >", value, "cwhsjBug");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("cwhsj_bug >=", value, "cwhsjBug");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugLessThan(Integer value) {
            addCriterion("cwhsj_bug <", value, "cwhsjBug");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugLessThanOrEqualTo(Integer value) {
            addCriterion("cwhsj_bug <=", value, "cwhsjBug");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugIn(List<Integer> values) {
            addCriterion("cwhsj_bug in", values, "cwhsjBug");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugNotIn(List<Integer> values) {
            addCriterion("cwhsj_bug not in", values, "cwhsjBug");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugBetween(Integer value1, Integer value2) {
            addCriterion("cwhsj_bug between", value1, value2, "cwhsjBug");
            return (Criteria) this;
        }

        public Criteria andCwhsjBugNotBetween(Integer value1, Integer value2) {
            addCriterion("cwhsj_bug not between", value1, value2, "cwhsjBug");
            return (Criteria) this;
        }

        public Criteria andZyczIsNull() {
            addCriterion("zycz is null");
            return (Criteria) this;
        }

        public Criteria andZyczIsNotNull() {
            addCriterion("zycz is not null");
            return (Criteria) this;
        }

        public Criteria andZyczEqualTo(Integer value) {
            addCriterion("zycz =", value, "zycz");
            return (Criteria) this;
        }

        public Criteria andZyczNotEqualTo(Integer value) {
            addCriterion("zycz <>", value, "zycz");
            return (Criteria) this;
        }

        public Criteria andZyczGreaterThan(Integer value) {
            addCriterion("zycz >", value, "zycz");
            return (Criteria) this;
        }

        public Criteria andZyczGreaterThanOrEqualTo(Integer value) {
            addCriterion("zycz >=", value, "zycz");
            return (Criteria) this;
        }

        public Criteria andZyczLessThan(Integer value) {
            addCriterion("zycz <", value, "zycz");
            return (Criteria) this;
        }

        public Criteria andZyczLessThanOrEqualTo(Integer value) {
            addCriterion("zycz <=", value, "zycz");
            return (Criteria) this;
        }

        public Criteria andZyczIn(List<Integer> values) {
            addCriterion("zycz in", values, "zycz");
            return (Criteria) this;
        }

        public Criteria andZyczNotIn(List<Integer> values) {
            addCriterion("zycz not in", values, "zycz");
            return (Criteria) this;
        }

        public Criteria andZyczBetween(Integer value1, Integer value2) {
            addCriterion("zycz between", value1, value2, "zycz");
            return (Criteria) this;
        }

        public Criteria andZyczNotBetween(Integer value1, Integer value2) {
            addCriterion("zycz not between", value1, value2, "zycz");
            return (Criteria) this;
        }

        public Criteria andZytjfsIsNull() {
            addCriterion("zytjfs is null");
            return (Criteria) this;
        }

        public Criteria andZytjfsIsNotNull() {
            addCriterion("zytjfs is not null");
            return (Criteria) this;
        }

        public Criteria andZytjfsEqualTo(Integer value) {
            addCriterion("zytjfs =", value, "zytjfs");
            return (Criteria) this;
        }

        public Criteria andZytjfsNotEqualTo(Integer value) {
            addCriterion("zytjfs <>", value, "zytjfs");
            return (Criteria) this;
        }

        public Criteria andZytjfsGreaterThan(Integer value) {
            addCriterion("zytjfs >", value, "zytjfs");
            return (Criteria) this;
        }

        public Criteria andZytjfsGreaterThanOrEqualTo(Integer value) {
            addCriterion("zytjfs >=", value, "zytjfs");
            return (Criteria) this;
        }

        public Criteria andZytjfsLessThan(Integer value) {
            addCriterion("zytjfs <", value, "zytjfs");
            return (Criteria) this;
        }

        public Criteria andZytjfsLessThanOrEqualTo(Integer value) {
            addCriterion("zytjfs <=", value, "zytjfs");
            return (Criteria) this;
        }

        public Criteria andZytjfsIn(List<Integer> values) {
            addCriterion("zytjfs in", values, "zytjfs");
            return (Criteria) this;
        }

        public Criteria andZytjfsNotIn(List<Integer> values) {
            addCriterion("zytjfs not in", values, "zytjfs");
            return (Criteria) this;
        }

        public Criteria andZytjfsBetween(Integer value1, Integer value2) {
            addCriterion("zytjfs between", value1, value2, "zytjfs");
            return (Criteria) this;
        }

        public Criteria andZytjfsNotBetween(Integer value1, Integer value2) {
            addCriterion("zytjfs not between", value1, value2, "zytjfs");
            return (Criteria) this;
        }

        public Criteria andZygnIsNull() {
            addCriterion("zygn is null");
            return (Criteria) this;
        }

        public Criteria andZygnIsNotNull() {
            addCriterion("zygn is not null");
            return (Criteria) this;
        }

        public Criteria andZygnEqualTo(Integer value) {
            addCriterion("zygn =", value, "zygn");
            return (Criteria) this;
        }

        public Criteria andZygnNotEqualTo(Integer value) {
            addCriterion("zygn <>", value, "zygn");
            return (Criteria) this;
        }

        public Criteria andZygnGreaterThan(Integer value) {
            addCriterion("zygn >", value, "zygn");
            return (Criteria) this;
        }

        public Criteria andZygnGreaterThanOrEqualTo(Integer value) {
            addCriterion("zygn >=", value, "zygn");
            return (Criteria) this;
        }

        public Criteria andZygnLessThan(Integer value) {
            addCriterion("zygn <", value, "zygn");
            return (Criteria) this;
        }

        public Criteria andZygnLessThanOrEqualTo(Integer value) {
            addCriterion("zygn <=", value, "zygn");
            return (Criteria) this;
        }

        public Criteria andZygnIn(List<Integer> values) {
            addCriterion("zygn in", values, "zygn");
            return (Criteria) this;
        }

        public Criteria andZygnNotIn(List<Integer> values) {
            addCriterion("zygn not in", values, "zygn");
            return (Criteria) this;
        }

        public Criteria andZygnBetween(Integer value1, Integer value2) {
            addCriterion("zygn between", value1, value2, "zygn");
            return (Criteria) this;
        }

        public Criteria andZygnNotBetween(Integer value1, Integer value2) {
            addCriterion("zygn not between", value1, value2, "zygn");
            return (Criteria) this;
        }

        public Criteria andZyBugIsNull() {
            addCriterion("zy_bug is null");
            return (Criteria) this;
        }

        public Criteria andZyBugIsNotNull() {
            addCriterion("zy_bug is not null");
            return (Criteria) this;
        }

        public Criteria andZyBugEqualTo(Integer value) {
            addCriterion("zy_bug =", value, "zyBug");
            return (Criteria) this;
        }

        public Criteria andZyBugNotEqualTo(Integer value) {
            addCriterion("zy_bug <>", value, "zyBug");
            return (Criteria) this;
        }

        public Criteria andZyBugGreaterThan(Integer value) {
            addCriterion("zy_bug >", value, "zyBug");
            return (Criteria) this;
        }

        public Criteria andZyBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("zy_bug >=", value, "zyBug");
            return (Criteria) this;
        }

        public Criteria andZyBugLessThan(Integer value) {
            addCriterion("zy_bug <", value, "zyBug");
            return (Criteria) this;
        }

        public Criteria andZyBugLessThanOrEqualTo(Integer value) {
            addCriterion("zy_bug <=", value, "zyBug");
            return (Criteria) this;
        }

        public Criteria andZyBugIn(List<Integer> values) {
            addCriterion("zy_bug in", values, "zyBug");
            return (Criteria) this;
        }

        public Criteria andZyBugNotIn(List<Integer> values) {
            addCriterion("zy_bug not in", values, "zyBug");
            return (Criteria) this;
        }

        public Criteria andZyBugBetween(Integer value1, Integer value2) {
            addCriterion("zy_bug between", value1, value2, "zyBug");
            return (Criteria) this;
        }

        public Criteria andZyBugNotBetween(Integer value1, Integer value2) {
            addCriterion("zy_bug not between", value1, value2, "zyBug");
            return (Criteria) this;
        }

        public Criteria andKtIsNull() {
            addCriterion("kt is null");
            return (Criteria) this;
        }

        public Criteria andKtIsNotNull() {
            addCriterion("kt is not null");
            return (Criteria) this;
        }

        public Criteria andKtEqualTo(Integer value) {
            addCriterion("kt =", value, "kt");
            return (Criteria) this;
        }

        public Criteria andKtNotEqualTo(Integer value) {
            addCriterion("kt <>", value, "kt");
            return (Criteria) this;
        }

        public Criteria andKtGreaterThan(Integer value) {
            addCriterion("kt >", value, "kt");
            return (Criteria) this;
        }

        public Criteria andKtGreaterThanOrEqualTo(Integer value) {
            addCriterion("kt >=", value, "kt");
            return (Criteria) this;
        }

        public Criteria andKtLessThan(Integer value) {
            addCriterion("kt <", value, "kt");
            return (Criteria) this;
        }

        public Criteria andKtLessThanOrEqualTo(Integer value) {
            addCriterion("kt <=", value, "kt");
            return (Criteria) this;
        }

        public Criteria andKtIn(List<Integer> values) {
            addCriterion("kt in", values, "kt");
            return (Criteria) this;
        }

        public Criteria andKtNotIn(List<Integer> values) {
            addCriterion("kt not in", values, "kt");
            return (Criteria) this;
        }

        public Criteria andKtBetween(Integer value1, Integer value2) {
            addCriterion("kt between", value1, value2, "kt");
            return (Criteria) this;
        }

        public Criteria andKtNotBetween(Integer value1, Integer value2) {
            addCriterion("kt not between", value1, value2, "kt");
            return (Criteria) this;
        }

        public Criteria andKtBugIsNull() {
            addCriterion("kt_bug is null");
            return (Criteria) this;
        }

        public Criteria andKtBugIsNotNull() {
            addCriterion("kt_bug is not null");
            return (Criteria) this;
        }

        public Criteria andKtBugEqualTo(Integer value) {
            addCriterion("kt_bug =", value, "ktBug");
            return (Criteria) this;
        }

        public Criteria andKtBugNotEqualTo(Integer value) {
            addCriterion("kt_bug <>", value, "ktBug");
            return (Criteria) this;
        }

        public Criteria andKtBugGreaterThan(Integer value) {
            addCriterion("kt_bug >", value, "ktBug");
            return (Criteria) this;
        }

        public Criteria andKtBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("kt_bug >=", value, "ktBug");
            return (Criteria) this;
        }

        public Criteria andKtBugLessThan(Integer value) {
            addCriterion("kt_bug <", value, "ktBug");
            return (Criteria) this;
        }

        public Criteria andKtBugLessThanOrEqualTo(Integer value) {
            addCriterion("kt_bug <=", value, "ktBug");
            return (Criteria) this;
        }

        public Criteria andKtBugIn(List<Integer> values) {
            addCriterion("kt_bug in", values, "ktBug");
            return (Criteria) this;
        }

        public Criteria andKtBugNotIn(List<Integer> values) {
            addCriterion("kt_bug not in", values, "ktBug");
            return (Criteria) this;
        }

        public Criteria andKtBugBetween(Integer value1, Integer value2) {
            addCriterion("kt_bug between", value1, value2, "ktBug");
            return (Criteria) this;
        }

        public Criteria andKtBugNotBetween(Integer value1, Integer value2) {
            addCriterion("kt_bug not between", value1, value2, "ktBug");
            return (Criteria) this;
        }

        public Criteria andYysbIsNull() {
            addCriterion("yysb is null");
            return (Criteria) this;
        }

        public Criteria andYysbIsNotNull() {
            addCriterion("yysb is not null");
            return (Criteria) this;
        }

        public Criteria andYysbEqualTo(Integer value) {
            addCriterion("yysb =", value, "yysb");
            return (Criteria) this;
        }

        public Criteria andYysbNotEqualTo(Integer value) {
            addCriterion("yysb <>", value, "yysb");
            return (Criteria) this;
        }

        public Criteria andYysbGreaterThan(Integer value) {
            addCriterion("yysb >", value, "yysb");
            return (Criteria) this;
        }

        public Criteria andYysbGreaterThanOrEqualTo(Integer value) {
            addCriterion("yysb >=", value, "yysb");
            return (Criteria) this;
        }

        public Criteria andYysbLessThan(Integer value) {
            addCriterion("yysb <", value, "yysb");
            return (Criteria) this;
        }

        public Criteria andYysbLessThanOrEqualTo(Integer value) {
            addCriterion("yysb <=", value, "yysb");
            return (Criteria) this;
        }

        public Criteria andYysbIn(List<Integer> values) {
            addCriterion("yysb in", values, "yysb");
            return (Criteria) this;
        }

        public Criteria andYysbNotIn(List<Integer> values) {
            addCriterion("yysb not in", values, "yysb");
            return (Criteria) this;
        }

        public Criteria andYysbBetween(Integer value1, Integer value2) {
            addCriterion("yysb between", value1, value2, "yysb");
            return (Criteria) this;
        }

        public Criteria andYysbNotBetween(Integer value1, Integer value2) {
            addCriterion("yysb not between", value1, value2, "yysb");
            return (Criteria) this;
        }

        public Criteria andYysbBugIsNull() {
            addCriterion("yysb_bug is null");
            return (Criteria) this;
        }

        public Criteria andYysbBugIsNotNull() {
            addCriterion("yysb_bug is not null");
            return (Criteria) this;
        }

        public Criteria andYysbBugEqualTo(Integer value) {
            addCriterion("yysb_bug =", value, "yysbBug");
            return (Criteria) this;
        }

        public Criteria andYysbBugNotEqualTo(Integer value) {
            addCriterion("yysb_bug <>", value, "yysbBug");
            return (Criteria) this;
        }

        public Criteria andYysbBugGreaterThan(Integer value) {
            addCriterion("yysb_bug >", value, "yysbBug");
            return (Criteria) this;
        }

        public Criteria andYysbBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("yysb_bug >=", value, "yysbBug");
            return (Criteria) this;
        }

        public Criteria andYysbBugLessThan(Integer value) {
            addCriterion("yysb_bug <", value, "yysbBug");
            return (Criteria) this;
        }

        public Criteria andYysbBugLessThanOrEqualTo(Integer value) {
            addCriterion("yysb_bug <=", value, "yysbBug");
            return (Criteria) this;
        }

        public Criteria andYysbBugIn(List<Integer> values) {
            addCriterion("yysb_bug in", values, "yysbBug");
            return (Criteria) this;
        }

        public Criteria andYysbBugNotIn(List<Integer> values) {
            addCriterion("yysb_bug not in", values, "yysbBug");
            return (Criteria) this;
        }

        public Criteria andYysbBugBetween(Integer value1, Integer value2) {
            addCriterion("yysb_bug between", value1, value2, "yysbBug");
            return (Criteria) this;
        }

        public Criteria andYysbBugNotBetween(Integer value1, Integer value2) {
            addCriterion("yysb_bug not between", value1, value2, "yysbBug");
            return (Criteria) this;
        }

        public Criteria andDhIsNull() {
            addCriterion("dh is null");
            return (Criteria) this;
        }

        public Criteria andDhIsNotNull() {
            addCriterion("dh is not null");
            return (Criteria) this;
        }

        public Criteria andDhEqualTo(Integer value) {
            addCriterion("dh =", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotEqualTo(Integer value) {
            addCriterion("dh <>", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThan(Integer value) {
            addCriterion("dh >", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThanOrEqualTo(Integer value) {
            addCriterion("dh >=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThan(Integer value) {
            addCriterion("dh <", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThanOrEqualTo(Integer value) {
            addCriterion("dh <=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhIn(List<Integer> values) {
            addCriterion("dh in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotIn(List<Integer> values) {
            addCriterion("dh not in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhBetween(Integer value1, Integer value2) {
            addCriterion("dh between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotBetween(Integer value1, Integer value2) {
            addCriterion("dh not between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andDhBugIsNull() {
            addCriterion("dh_bug is null");
            return (Criteria) this;
        }

        public Criteria andDhBugIsNotNull() {
            addCriterion("dh_bug is not null");
            return (Criteria) this;
        }

        public Criteria andDhBugEqualTo(Integer value) {
            addCriterion("dh_bug =", value, "dhBug");
            return (Criteria) this;
        }

        public Criteria andDhBugNotEqualTo(Integer value) {
            addCriterion("dh_bug <>", value, "dhBug");
            return (Criteria) this;
        }

        public Criteria andDhBugGreaterThan(Integer value) {
            addCriterion("dh_bug >", value, "dhBug");
            return (Criteria) this;
        }

        public Criteria andDhBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("dh_bug >=", value, "dhBug");
            return (Criteria) this;
        }

        public Criteria andDhBugLessThan(Integer value) {
            addCriterion("dh_bug <", value, "dhBug");
            return (Criteria) this;
        }

        public Criteria andDhBugLessThanOrEqualTo(Integer value) {
            addCriterion("dh_bug <=", value, "dhBug");
            return (Criteria) this;
        }

        public Criteria andDhBugIn(List<Integer> values) {
            addCriterion("dh_bug in", values, "dhBug");
            return (Criteria) this;
        }

        public Criteria andDhBugNotIn(List<Integer> values) {
            addCriterion("dh_bug not in", values, "dhBug");
            return (Criteria) this;
        }

        public Criteria andDhBugBetween(Integer value1, Integer value2) {
            addCriterion("dh_bug between", value1, value2, "dhBug");
            return (Criteria) this;
        }

        public Criteria andDhBugNotBetween(Integer value1, Integer value2) {
            addCriterion("dh_bug not between", value1, value2, "dhBug");
            return (Criteria) this;
        }

        public Criteria andDsxhIsNull() {
            addCriterion("dsxh is null");
            return (Criteria) this;
        }

        public Criteria andDsxhIsNotNull() {
            addCriterion("dsxh is not null");
            return (Criteria) this;
        }

        public Criteria andDsxhEqualTo(Integer value) {
            addCriterion("dsxh =", value, "dsxh");
            return (Criteria) this;
        }

        public Criteria andDsxhNotEqualTo(Integer value) {
            addCriterion("dsxh <>", value, "dsxh");
            return (Criteria) this;
        }

        public Criteria andDsxhGreaterThan(Integer value) {
            addCriterion("dsxh >", value, "dsxh");
            return (Criteria) this;
        }

        public Criteria andDsxhGreaterThanOrEqualTo(Integer value) {
            addCriterion("dsxh >=", value, "dsxh");
            return (Criteria) this;
        }

        public Criteria andDsxhLessThan(Integer value) {
            addCriterion("dsxh <", value, "dsxh");
            return (Criteria) this;
        }

        public Criteria andDsxhLessThanOrEqualTo(Integer value) {
            addCriterion("dsxh <=", value, "dsxh");
            return (Criteria) this;
        }

        public Criteria andDsxhIn(List<Integer> values) {
            addCriterion("dsxh in", values, "dsxh");
            return (Criteria) this;
        }

        public Criteria andDsxhNotIn(List<Integer> values) {
            addCriterion("dsxh not in", values, "dsxh");
            return (Criteria) this;
        }

        public Criteria andDsxhBetween(Integer value1, Integer value2) {
            addCriterion("dsxh between", value1, value2, "dsxh");
            return (Criteria) this;
        }

        public Criteria andDsxhNotBetween(Integer value1, Integer value2) {
            addCriterion("dsxh not between", value1, value2, "dsxh");
            return (Criteria) this;
        }

        public Criteria andDsxhBugIsNull() {
            addCriterion("dsxh_bug is null");
            return (Criteria) this;
        }

        public Criteria andDsxhBugIsNotNull() {
            addCriterion("dsxh_bug is not null");
            return (Criteria) this;
        }

        public Criteria andDsxhBugEqualTo(Integer value) {
            addCriterion("dsxh_bug =", value, "dsxhBug");
            return (Criteria) this;
        }

        public Criteria andDsxhBugNotEqualTo(Integer value) {
            addCriterion("dsxh_bug <>", value, "dsxhBug");
            return (Criteria) this;
        }

        public Criteria andDsxhBugGreaterThan(Integer value) {
            addCriterion("dsxh_bug >", value, "dsxhBug");
            return (Criteria) this;
        }

        public Criteria andDsxhBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("dsxh_bug >=", value, "dsxhBug");
            return (Criteria) this;
        }

        public Criteria andDsxhBugLessThan(Integer value) {
            addCriterion("dsxh_bug <", value, "dsxhBug");
            return (Criteria) this;
        }

        public Criteria andDsxhBugLessThanOrEqualTo(Integer value) {
            addCriterion("dsxh_bug <=", value, "dsxhBug");
            return (Criteria) this;
        }

        public Criteria andDsxhBugIn(List<Integer> values) {
            addCriterion("dsxh_bug in", values, "dsxhBug");
            return (Criteria) this;
        }

        public Criteria andDsxhBugNotIn(List<Integer> values) {
            addCriterion("dsxh_bug not in", values, "dsxhBug");
            return (Criteria) this;
        }

        public Criteria andDsxhBugBetween(Integer value1, Integer value2) {
            addCriterion("dsxh_bug between", value1, value2, "dsxhBug");
            return (Criteria) this;
        }

        public Criteria andDsxhBugNotBetween(Integer value1, Integer value2) {
            addCriterion("dsxh_bug not between", value1, value2, "dsxhBug");
            return (Criteria) this;
        }

        public Criteria andDcldIsNull() {
            addCriterion("dcld is null");
            return (Criteria) this;
        }

        public Criteria andDcldIsNotNull() {
            addCriterion("dcld is not null");
            return (Criteria) this;
        }

        public Criteria andDcldEqualTo(Integer value) {
            addCriterion("dcld =", value, "dcld");
            return (Criteria) this;
        }

        public Criteria andDcldNotEqualTo(Integer value) {
            addCriterion("dcld <>", value, "dcld");
            return (Criteria) this;
        }

        public Criteria andDcldGreaterThan(Integer value) {
            addCriterion("dcld >", value, "dcld");
            return (Criteria) this;
        }

        public Criteria andDcldGreaterThanOrEqualTo(Integer value) {
            addCriterion("dcld >=", value, "dcld");
            return (Criteria) this;
        }

        public Criteria andDcldLessThan(Integer value) {
            addCriterion("dcld <", value, "dcld");
            return (Criteria) this;
        }

        public Criteria andDcldLessThanOrEqualTo(Integer value) {
            addCriterion("dcld <=", value, "dcld");
            return (Criteria) this;
        }

        public Criteria andDcldIn(List<Integer> values) {
            addCriterion("dcld in", values, "dcld");
            return (Criteria) this;
        }

        public Criteria andDcldNotIn(List<Integer> values) {
            addCriterion("dcld not in", values, "dcld");
            return (Criteria) this;
        }

        public Criteria andDcldBetween(Integer value1, Integer value2) {
            addCriterion("dcld between", value1, value2, "dcld");
            return (Criteria) this;
        }

        public Criteria andDcldNotBetween(Integer value1, Integer value2) {
            addCriterion("dcld not between", value1, value2, "dcld");
            return (Criteria) this;
        }

        public Criteria andDcldBugIsNull() {
            addCriterion("dcld_bug is null");
            return (Criteria) this;
        }

        public Criteria andDcldBugIsNotNull() {
            addCriterion("dcld_bug is not null");
            return (Criteria) this;
        }

        public Criteria andDcldBugEqualTo(Integer value) {
            addCriterion("dcld_bug =", value, "dcldBug");
            return (Criteria) this;
        }

        public Criteria andDcldBugNotEqualTo(Integer value) {
            addCriterion("dcld_bug <>", value, "dcldBug");
            return (Criteria) this;
        }

        public Criteria andDcldBugGreaterThan(Integer value) {
            addCriterion("dcld_bug >", value, "dcldBug");
            return (Criteria) this;
        }

        public Criteria andDcldBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("dcld_bug >=", value, "dcldBug");
            return (Criteria) this;
        }

        public Criteria andDcldBugLessThan(Integer value) {
            addCriterion("dcld_bug <", value, "dcldBug");
            return (Criteria) this;
        }

        public Criteria andDcldBugLessThanOrEqualTo(Integer value) {
            addCriterion("dcld_bug <=", value, "dcldBug");
            return (Criteria) this;
        }

        public Criteria andDcldBugIn(List<Integer> values) {
            addCriterion("dcld_bug in", values, "dcldBug");
            return (Criteria) this;
        }

        public Criteria andDcldBugNotIn(List<Integer> values) {
            addCriterion("dcld_bug not in", values, "dcldBug");
            return (Criteria) this;
        }

        public Criteria andDcldBugBetween(Integer value1, Integer value2) {
            addCriterion("dcld_bug between", value1, value2, "dcldBug");
            return (Criteria) this;
        }

        public Criteria andDcldBugNotBetween(Integer value1, Integer value2) {
            addCriterion("dcld_bug not between", value1, value2, "dcldBug");
            return (Criteria) this;
        }

        public Criteria andDcyxIsNull() {
            addCriterion("dcyx is null");
            return (Criteria) this;
        }

        public Criteria andDcyxIsNotNull() {
            addCriterion("dcyx is not null");
            return (Criteria) this;
        }

        public Criteria andDcyxEqualTo(Integer value) {
            addCriterion("dcyx =", value, "dcyx");
            return (Criteria) this;
        }

        public Criteria andDcyxNotEqualTo(Integer value) {
            addCriterion("dcyx <>", value, "dcyx");
            return (Criteria) this;
        }

        public Criteria andDcyxGreaterThan(Integer value) {
            addCriterion("dcyx >", value, "dcyx");
            return (Criteria) this;
        }

        public Criteria andDcyxGreaterThanOrEqualTo(Integer value) {
            addCriterion("dcyx >=", value, "dcyx");
            return (Criteria) this;
        }

        public Criteria andDcyxLessThan(Integer value) {
            addCriterion("dcyx <", value, "dcyx");
            return (Criteria) this;
        }

        public Criteria andDcyxLessThanOrEqualTo(Integer value) {
            addCriterion("dcyx <=", value, "dcyx");
            return (Criteria) this;
        }

        public Criteria andDcyxIn(List<Integer> values) {
            addCriterion("dcyx in", values, "dcyx");
            return (Criteria) this;
        }

        public Criteria andDcyxNotIn(List<Integer> values) {
            addCriterion("dcyx not in", values, "dcyx");
            return (Criteria) this;
        }

        public Criteria andDcyxBetween(Integer value1, Integer value2) {
            addCriterion("dcyx between", value1, value2, "dcyx");
            return (Criteria) this;
        }

        public Criteria andDcyxNotBetween(Integer value1, Integer value2) {
            addCriterion("dcyx not between", value1, value2, "dcyx");
            return (Criteria) this;
        }

        public Criteria andDcyxBugIsNull() {
            addCriterion("dcyx_bug is null");
            return (Criteria) this;
        }

        public Criteria andDcyxBugIsNotNull() {
            addCriterion("dcyx_bug is not null");
            return (Criteria) this;
        }

        public Criteria andDcyxBugEqualTo(Integer value) {
            addCriterion("dcyx_bug =", value, "dcyxBug");
            return (Criteria) this;
        }

        public Criteria andDcyxBugNotEqualTo(Integer value) {
            addCriterion("dcyx_bug <>", value, "dcyxBug");
            return (Criteria) this;
        }

        public Criteria andDcyxBugGreaterThan(Integer value) {
            addCriterion("dcyx_bug >", value, "dcyxBug");
            return (Criteria) this;
        }

        public Criteria andDcyxBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("dcyx_bug >=", value, "dcyxBug");
            return (Criteria) this;
        }

        public Criteria andDcyxBugLessThan(Integer value) {
            addCriterion("dcyx_bug <", value, "dcyxBug");
            return (Criteria) this;
        }

        public Criteria andDcyxBugLessThanOrEqualTo(Integer value) {
            addCriterion("dcyx_bug <=", value, "dcyxBug");
            return (Criteria) this;
        }

        public Criteria andDcyxBugIn(List<Integer> values) {
            addCriterion("dcyx_bug in", values, "dcyxBug");
            return (Criteria) this;
        }

        public Criteria andDcyxBugNotIn(List<Integer> values) {
            addCriterion("dcyx_bug not in", values, "dcyxBug");
            return (Criteria) this;
        }

        public Criteria andDcyxBugBetween(Integer value1, Integer value2) {
            addCriterion("dcyx_bug between", value1, value2, "dcyxBug");
            return (Criteria) this;
        }

        public Criteria andDcyxBugNotBetween(Integer value1, Integer value2) {
            addCriterion("dcyx_bug not between", value1, value2, "dcyxBug");
            return (Criteria) this;
        }

        public Criteria andLgIsNull() {
            addCriterion("lg is null");
            return (Criteria) this;
        }

        public Criteria andLgIsNotNull() {
            addCriterion("lg is not null");
            return (Criteria) this;
        }

        public Criteria andLgEqualTo(Integer value) {
            addCriterion("lg =", value, "lg");
            return (Criteria) this;
        }

        public Criteria andLgNotEqualTo(Integer value) {
            addCriterion("lg <>", value, "lg");
            return (Criteria) this;
        }

        public Criteria andLgGreaterThan(Integer value) {
            addCriterion("lg >", value, "lg");
            return (Criteria) this;
        }

        public Criteria andLgGreaterThanOrEqualTo(Integer value) {
            addCriterion("lg >=", value, "lg");
            return (Criteria) this;
        }

        public Criteria andLgLessThan(Integer value) {
            addCriterion("lg <", value, "lg");
            return (Criteria) this;
        }

        public Criteria andLgLessThanOrEqualTo(Integer value) {
            addCriterion("lg <=", value, "lg");
            return (Criteria) this;
        }

        public Criteria andLgIn(List<Integer> values) {
            addCriterion("lg in", values, "lg");
            return (Criteria) this;
        }

        public Criteria andLgNotIn(List<Integer> values) {
            addCriterion("lg not in", values, "lg");
            return (Criteria) this;
        }

        public Criteria andLgBetween(Integer value1, Integer value2) {
            addCriterion("lg between", value1, value2, "lg");
            return (Criteria) this;
        }

        public Criteria andLgNotBetween(Integer value1, Integer value2) {
            addCriterion("lg not between", value1, value2, "lg");
            return (Criteria) this;
        }

        public Criteria andLgBugIsNull() {
            addCriterion("lg_bug is null");
            return (Criteria) this;
        }

        public Criteria andLgBugIsNotNull() {
            addCriterion("lg_bug is not null");
            return (Criteria) this;
        }

        public Criteria andLgBugEqualTo(Integer value) {
            addCriterion("lg_bug =", value, "lgBug");
            return (Criteria) this;
        }

        public Criteria andLgBugNotEqualTo(Integer value) {
            addCriterion("lg_bug <>", value, "lgBug");
            return (Criteria) this;
        }

        public Criteria andLgBugGreaterThan(Integer value) {
            addCriterion("lg_bug >", value, "lgBug");
            return (Criteria) this;
        }

        public Criteria andLgBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("lg_bug >=", value, "lgBug");
            return (Criteria) this;
        }

        public Criteria andLgBugLessThan(Integer value) {
            addCriterion("lg_bug <", value, "lgBug");
            return (Criteria) this;
        }

        public Criteria andLgBugLessThanOrEqualTo(Integer value) {
            addCriterion("lg_bug <=", value, "lgBug");
            return (Criteria) this;
        }

        public Criteria andLgBugIn(List<Integer> values) {
            addCriterion("lg_bug in", values, "lgBug");
            return (Criteria) this;
        }

        public Criteria andLgBugNotIn(List<Integer> values) {
            addCriterion("lg_bug not in", values, "lgBug");
            return (Criteria) this;
        }

        public Criteria andLgBugBetween(Integer value1, Integer value2) {
            addCriterion("lg_bug between", value1, value2, "lgBug");
            return (Criteria) this;
        }

        public Criteria andLgBugNotBetween(Integer value1, Integer value2) {
            addCriterion("lg_bug not between", value1, value2, "lgBug");
            return (Criteria) this;
        }

        public Criteria andQdjBugIsNull() {
            addCriterion("qdj_bug is null");
            return (Criteria) this;
        }

        public Criteria andQdjBugIsNotNull() {
            addCriterion("qdj_bug is not null");
            return (Criteria) this;
        }

        public Criteria andQdjBugEqualTo(Integer value) {
            addCriterion("qdj_bug =", value, "qdjBug");
            return (Criteria) this;
        }

        public Criteria andQdjBugNotEqualTo(Integer value) {
            addCriterion("qdj_bug <>", value, "qdjBug");
            return (Criteria) this;
        }

        public Criteria andQdjBugGreaterThan(Integer value) {
            addCriterion("qdj_bug >", value, "qdjBug");
            return (Criteria) this;
        }

        public Criteria andQdjBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("qdj_bug >=", value, "qdjBug");
            return (Criteria) this;
        }

        public Criteria andQdjBugLessThan(Integer value) {
            addCriterion("qdj_bug <", value, "qdjBug");
            return (Criteria) this;
        }

        public Criteria andQdjBugLessThanOrEqualTo(Integer value) {
            addCriterion("qdj_bug <=", value, "qdjBug");
            return (Criteria) this;
        }

        public Criteria andQdjBugIn(List<Integer> values) {
            addCriterion("qdj_bug in", values, "qdjBug");
            return (Criteria) this;
        }

        public Criteria andQdjBugNotIn(List<Integer> values) {
            addCriterion("qdj_bug not in", values, "qdjBug");
            return (Criteria) this;
        }

        public Criteria andQdjBugBetween(Integer value1, Integer value2) {
            addCriterion("qdj_bug between", value1, value2, "qdjBug");
            return (Criteria) this;
        }

        public Criteria andQdjBugNotBetween(Integer value1, Integer value2) {
            addCriterion("qdj_bug not between", value1, value2, "qdjBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugIsNull() {
            addCriterion("gzd_bug is null");
            return (Criteria) this;
        }

        public Criteria andGzdBugIsNotNull() {
            addCriterion("gzd_bug is not null");
            return (Criteria) this;
        }

        public Criteria andGzdBugEqualTo(String value) {
            addCriterion("gzd_bug =", value, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugNotEqualTo(String value) {
            addCriterion("gzd_bug <>", value, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugGreaterThan(String value) {
            addCriterion("gzd_bug >", value, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugGreaterThanOrEqualTo(String value) {
            addCriterion("gzd_bug >=", value, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugLessThan(String value) {
            addCriterion("gzd_bug <", value, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugLessThanOrEqualTo(String value) {
            addCriterion("gzd_bug <=", value, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugLike(String value) {
            addCriterion("gzd_bug like", value, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugNotLike(String value) {
            addCriterion("gzd_bug not like", value, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugIn(List<String> values) {
            addCriterion("gzd_bug in", values, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugNotIn(List<String> values) {
            addCriterion("gzd_bug not in", values, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugBetween(String value1, String value2) {
            addCriterion("gzd_bug between", value1, value2, "gzdBug");
            return (Criteria) this;
        }

        public Criteria andGzdBugNotBetween(String value1, String value2) {
            addCriterion("gzd_bug not between", value1, value2, "gzdBug");
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

        public Criteria andOtherBugIsNull() {
            addCriterion("other_bug is null");
            return (Criteria) this;
        }

        public Criteria andOtherBugIsNotNull() {
            addCriterion("other_bug is not null");
            return (Criteria) this;
        }

        public Criteria andOtherBugEqualTo(Integer value) {
            addCriterion("other_bug =", value, "otherBug");
            return (Criteria) this;
        }

        public Criteria andOtherBugNotEqualTo(Integer value) {
            addCriterion("other_bug <>", value, "otherBug");
            return (Criteria) this;
        }

        public Criteria andOtherBugGreaterThan(Integer value) {
            addCriterion("other_bug >", value, "otherBug");
            return (Criteria) this;
        }

        public Criteria andOtherBugGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_bug >=", value, "otherBug");
            return (Criteria) this;
        }

        public Criteria andOtherBugLessThan(Integer value) {
            addCriterion("other_bug <", value, "otherBug");
            return (Criteria) this;
        }

        public Criteria andOtherBugLessThanOrEqualTo(Integer value) {
            addCriterion("other_bug <=", value, "otherBug");
            return (Criteria) this;
        }

        public Criteria andOtherBugIn(List<Integer> values) {
            addCriterion("other_bug in", values, "otherBug");
            return (Criteria) this;
        }

        public Criteria andOtherBugNotIn(List<Integer> values) {
            addCriterion("other_bug not in", values, "otherBug");
            return (Criteria) this;
        }

        public Criteria andOtherBugBetween(Integer value1, Integer value2) {
            addCriterion("other_bug between", value1, value2, "otherBug");
            return (Criteria) this;
        }

        public Criteria andOtherBugNotBetween(Integer value1, Integer value2) {
            addCriterion("other_bug not between", value1, value2, "otherBug");
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