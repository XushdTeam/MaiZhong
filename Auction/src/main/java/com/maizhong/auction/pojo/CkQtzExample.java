package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkQtzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkQtzExample() {
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

        public Criteria andJqxrqIsNull() {
            addCriterion("jqxrq is null");
            return (Criteria) this;
        }

        public Criteria andJqxrqIsNotNull() {
            addCriterion("jqxrq is not null");
            return (Criteria) this;
        }

        public Criteria andJqxrqEqualTo(String value) {
            addCriterion("jqxrq =", value, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqNotEqualTo(String value) {
            addCriterion("jqxrq <>", value, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqGreaterThan(String value) {
            addCriterion("jqxrq >", value, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqGreaterThanOrEqualTo(String value) {
            addCriterion("jqxrq >=", value, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqLessThan(String value) {
            addCriterion("jqxrq <", value, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqLessThanOrEqualTo(String value) {
            addCriterion("jqxrq <=", value, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqLike(String value) {
            addCriterion("jqxrq like", value, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqNotLike(String value) {
            addCriterion("jqxrq not like", value, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqIn(List<String> values) {
            addCriterion("jqxrq in", values, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqNotIn(List<String> values) {
            addCriterion("jqxrq not in", values, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqBetween(String value1, String value2) {
            addCriterion("jqxrq between", value1, value2, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andJqxrqNotBetween(String value1, String value2) {
            addCriterion("jqxrq not between", value1, value2, "jqxrq");
            return (Criteria) this;
        }

        public Criteria andBxyzIsNull() {
            addCriterion("bxyz is null");
            return (Criteria) this;
        }

        public Criteria andBxyzIsNotNull() {
            addCriterion("bxyz is not null");
            return (Criteria) this;
        }

        public Criteria andBxyzEqualTo(Integer value) {
            addCriterion("bxyz =", value, "bxyz");
            return (Criteria) this;
        }

        public Criteria andBxyzNotEqualTo(Integer value) {
            addCriterion("bxyz <>", value, "bxyz");
            return (Criteria) this;
        }

        public Criteria andBxyzGreaterThan(Integer value) {
            addCriterion("bxyz >", value, "bxyz");
            return (Criteria) this;
        }

        public Criteria andBxyzGreaterThanOrEqualTo(Integer value) {
            addCriterion("bxyz >=", value, "bxyz");
            return (Criteria) this;
        }

        public Criteria andBxyzLessThan(Integer value) {
            addCriterion("bxyz <", value, "bxyz");
            return (Criteria) this;
        }

        public Criteria andBxyzLessThanOrEqualTo(Integer value) {
            addCriterion("bxyz <=", value, "bxyz");
            return (Criteria) this;
        }

        public Criteria andBxyzIn(List<Integer> values) {
            addCriterion("bxyz in", values, "bxyz");
            return (Criteria) this;
        }

        public Criteria andBxyzNotIn(List<Integer> values) {
            addCriterion("bxyz not in", values, "bxyz");
            return (Criteria) this;
        }

        public Criteria andBxyzBetween(Integer value1, Integer value2) {
            addCriterion("bxyz between", value1, value2, "bxyz");
            return (Criteria) this;
        }

        public Criteria andBxyzNotBetween(Integer value1, Integer value2) {
            addCriterion("bxyz not between", value1, value2, "bxyz");
            return (Criteria) this;
        }

        public Criteria andWjIsNull() {
            addCriterion("wj is null");
            return (Criteria) this;
        }

        public Criteria andWjIsNotNull() {
            addCriterion("wj is not null");
            return (Criteria) this;
        }

        public Criteria andWjEqualTo(Integer value) {
            addCriterion("wj =", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjNotEqualTo(Integer value) {
            addCriterion("wj <>", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjGreaterThan(Integer value) {
            addCriterion("wj >", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjGreaterThanOrEqualTo(Integer value) {
            addCriterion("wj >=", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjLessThan(Integer value) {
            addCriterion("wj <", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjLessThanOrEqualTo(Integer value) {
            addCriterion("wj <=", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjIn(List<Integer> values) {
            addCriterion("wj in", values, "wj");
            return (Criteria) this;
        }

        public Criteria andWjNotIn(List<Integer> values) {
            addCriterion("wj not in", values, "wj");
            return (Criteria) this;
        }

        public Criteria andWjBetween(Integer value1, Integer value2) {
            addCriterion("wj between", value1, value2, "wj");
            return (Criteria) this;
        }

        public Criteria andWjNotBetween(Integer value1, Integer value2) {
            addCriterion("wj not between", value1, value2, "wj");
            return (Criteria) this;
        }

        public Criteria andJqxdIsNull() {
            addCriterion("jqxd is null");
            return (Criteria) this;
        }

        public Criteria andJqxdIsNotNull() {
            addCriterion("jqxd is not null");
            return (Criteria) this;
        }

        public Criteria andJqxdEqualTo(String value) {
            addCriterion("jqxd =", value, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdNotEqualTo(String value) {
            addCriterion("jqxd <>", value, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdGreaterThan(String value) {
            addCriterion("jqxd >", value, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdGreaterThanOrEqualTo(String value) {
            addCriterion("jqxd >=", value, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdLessThan(String value) {
            addCriterion("jqxd <", value, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdLessThanOrEqualTo(String value) {
            addCriterion("jqxd <=", value, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdLike(String value) {
            addCriterion("jqxd like", value, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdNotLike(String value) {
            addCriterion("jqxd not like", value, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdIn(List<String> values) {
            addCriterion("jqxd in", values, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdNotIn(List<String> values) {
            addCriterion("jqxd not in", values, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdBetween(String value1, String value2) {
            addCriterion("jqxd between", value1, value2, "jqxd");
            return (Criteria) this;
        }

        public Criteria andJqxdNotBetween(String value1, String value2) {
            addCriterion("jqxd not between", value1, value2, "jqxd");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzIsNull() {
            addCriterion("cpjqxyz is null");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzIsNotNull() {
            addCriterion("cpjqxyz is not null");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzEqualTo(Integer value) {
            addCriterion("cpjqxyz =", value, "cpjqxyz");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzNotEqualTo(Integer value) {
            addCriterion("cpjqxyz <>", value, "cpjqxyz");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzGreaterThan(Integer value) {
            addCriterion("cpjqxyz >", value, "cpjqxyz");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpjqxyz >=", value, "cpjqxyz");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzLessThan(Integer value) {
            addCriterion("cpjqxyz <", value, "cpjqxyz");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzLessThanOrEqualTo(Integer value) {
            addCriterion("cpjqxyz <=", value, "cpjqxyz");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzIn(List<Integer> values) {
            addCriterion("cpjqxyz in", values, "cpjqxyz");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzNotIn(List<Integer> values) {
            addCriterion("cpjqxyz not in", values, "cpjqxyz");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzBetween(Integer value1, Integer value2) {
            addCriterion("cpjqxyz between", value1, value2, "cpjqxyz");
            return (Criteria) this;
        }

        public Criteria andCpjqxyzNotBetween(Integer value1, Integer value2) {
            addCriterion("cpjqxyz not between", value1, value2, "cpjqxyz");
            return (Criteria) this;
        }

        public Criteria andCcxIsNull() {
            addCriterion("ccx is null");
            return (Criteria) this;
        }

        public Criteria andCcxIsNotNull() {
            addCriterion("ccx is not null");
            return (Criteria) this;
        }

        public Criteria andCcxEqualTo(String value) {
            addCriterion("ccx =", value, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxNotEqualTo(String value) {
            addCriterion("ccx <>", value, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxGreaterThan(String value) {
            addCriterion("ccx >", value, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxGreaterThanOrEqualTo(String value) {
            addCriterion("ccx >=", value, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxLessThan(String value) {
            addCriterion("ccx <", value, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxLessThanOrEqualTo(String value) {
            addCriterion("ccx <=", value, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxLike(String value) {
            addCriterion("ccx like", value, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxNotLike(String value) {
            addCriterion("ccx not like", value, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxIn(List<String> values) {
            addCriterion("ccx in", values, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxNotIn(List<String> values) {
            addCriterion("ccx not in", values, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxBetween(String value1, String value2) {
            addCriterion("ccx between", value1, value2, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxNotBetween(String value1, String value2) {
            addCriterion("ccx not between", value1, value2, "ccx");
            return (Criteria) this;
        }

        public Criteria andCcxwjIsNull() {
            addCriterion("ccxwj is null");
            return (Criteria) this;
        }

        public Criteria andCcxwjIsNotNull() {
            addCriterion("ccxwj is not null");
            return (Criteria) this;
        }

        public Criteria andCcxwjEqualTo(Integer value) {
            addCriterion("ccxwj =", value, "ccxwj");
            return (Criteria) this;
        }

        public Criteria andCcxwjNotEqualTo(Integer value) {
            addCriterion("ccxwj <>", value, "ccxwj");
            return (Criteria) this;
        }

        public Criteria andCcxwjGreaterThan(Integer value) {
            addCriterion("ccxwj >", value, "ccxwj");
            return (Criteria) this;
        }

        public Criteria andCcxwjGreaterThanOrEqualTo(Integer value) {
            addCriterion("ccxwj >=", value, "ccxwj");
            return (Criteria) this;
        }

        public Criteria andCcxwjLessThan(Integer value) {
            addCriterion("ccxwj <", value, "ccxwj");
            return (Criteria) this;
        }

        public Criteria andCcxwjLessThanOrEqualTo(Integer value) {
            addCriterion("ccxwj <=", value, "ccxwj");
            return (Criteria) this;
        }

        public Criteria andCcxwjIn(List<Integer> values) {
            addCriterion("ccxwj in", values, "ccxwj");
            return (Criteria) this;
        }

        public Criteria andCcxwjNotIn(List<Integer> values) {
            addCriterion("ccxwj not in", values, "ccxwj");
            return (Criteria) this;
        }

        public Criteria andCcxwjBetween(Integer value1, Integer value2) {
            addCriterion("ccxwj between", value1, value2, "ccxwj");
            return (Criteria) this;
        }

        public Criteria andCcxwjNotBetween(Integer value1, Integer value2) {
            addCriterion("ccxwj not between", value1, value2, "ccxwj");
            return (Criteria) this;
        }

        public Criteria andGhpIsNull() {
            addCriterion("ghp is null");
            return (Criteria) this;
        }

        public Criteria andGhpIsNotNull() {
            addCriterion("ghp is not null");
            return (Criteria) this;
        }

        public Criteria andGhpEqualTo(Integer value) {
            addCriterion("ghp =", value, "ghp");
            return (Criteria) this;
        }

        public Criteria andGhpNotEqualTo(Integer value) {
            addCriterion("ghp <>", value, "ghp");
            return (Criteria) this;
        }

        public Criteria andGhpGreaterThan(Integer value) {
            addCriterion("ghp >", value, "ghp");
            return (Criteria) this;
        }

        public Criteria andGhpGreaterThanOrEqualTo(Integer value) {
            addCriterion("ghp >=", value, "ghp");
            return (Criteria) this;
        }

        public Criteria andGhpLessThan(Integer value) {
            addCriterion("ghp <", value, "ghp");
            return (Criteria) this;
        }

        public Criteria andGhpLessThanOrEqualTo(Integer value) {
            addCriterion("ghp <=", value, "ghp");
            return (Criteria) this;
        }

        public Criteria andGhpIn(List<Integer> values) {
            addCriterion("ghp in", values, "ghp");
            return (Criteria) this;
        }

        public Criteria andGhpNotIn(List<Integer> values) {
            addCriterion("ghp not in", values, "ghp");
            return (Criteria) this;
        }

        public Criteria andGhpBetween(Integer value1, Integer value2) {
            addCriterion("ghp between", value1, value2, "ghp");
            return (Criteria) this;
        }

        public Criteria andGhpNotBetween(Integer value1, Integer value2) {
            addCriterion("ghp not between", value1, value2, "ghp");
            return (Criteria) this;
        }

        public Criteria andGzsIsNull() {
            addCriterion("gzs is null");
            return (Criteria) this;
        }

        public Criteria andGzsIsNotNull() {
            addCriterion("gzs is not null");
            return (Criteria) this;
        }

        public Criteria andGzsEqualTo(Integer value) {
            addCriterion("gzs =", value, "gzs");
            return (Criteria) this;
        }

        public Criteria andGzsNotEqualTo(Integer value) {
            addCriterion("gzs <>", value, "gzs");
            return (Criteria) this;
        }

        public Criteria andGzsGreaterThan(Integer value) {
            addCriterion("gzs >", value, "gzs");
            return (Criteria) this;
        }

        public Criteria andGzsGreaterThanOrEqualTo(Integer value) {
            addCriterion("gzs >=", value, "gzs");
            return (Criteria) this;
        }

        public Criteria andGzsLessThan(Integer value) {
            addCriterion("gzs <", value, "gzs");
            return (Criteria) this;
        }

        public Criteria andGzsLessThanOrEqualTo(Integer value) {
            addCriterion("gzs <=", value, "gzs");
            return (Criteria) this;
        }

        public Criteria andGzsIn(List<Integer> values) {
            addCriterion("gzs in", values, "gzs");
            return (Criteria) this;
        }

        public Criteria andGzsNotIn(List<Integer> values) {
            addCriterion("gzs not in", values, "gzs");
            return (Criteria) this;
        }

        public Criteria andGzsBetween(Integer value1, Integer value2) {
            addCriterion("gzs between", value1, value2, "gzs");
            return (Criteria) this;
        }

        public Criteria andGzsNotBetween(Integer value1, Integer value2) {
            addCriterion("gzs not between", value1, value2, "gzs");
            return (Criteria) this;
        }

        public Criteria andByysIsNull() {
            addCriterion("byys is null");
            return (Criteria) this;
        }

        public Criteria andByysIsNotNull() {
            addCriterion("byys is not null");
            return (Criteria) this;
        }

        public Criteria andByysEqualTo(Integer value) {
            addCriterion("byys =", value, "byys");
            return (Criteria) this;
        }

        public Criteria andByysNotEqualTo(Integer value) {
            addCriterion("byys <>", value, "byys");
            return (Criteria) this;
        }

        public Criteria andByysGreaterThan(Integer value) {
            addCriterion("byys >", value, "byys");
            return (Criteria) this;
        }

        public Criteria andByysGreaterThanOrEqualTo(Integer value) {
            addCriterion("byys >=", value, "byys");
            return (Criteria) this;
        }

        public Criteria andByysLessThan(Integer value) {
            addCriterion("byys <", value, "byys");
            return (Criteria) this;
        }

        public Criteria andByysLessThanOrEqualTo(Integer value) {
            addCriterion("byys <=", value, "byys");
            return (Criteria) this;
        }

        public Criteria andByysIn(List<Integer> values) {
            addCriterion("byys in", values, "byys");
            return (Criteria) this;
        }

        public Criteria andByysNotIn(List<Integer> values) {
            addCriterion("byys not in", values, "byys");
            return (Criteria) this;
        }

        public Criteria andByysBetween(Integer value1, Integer value2) {
            addCriterion("byys between", value1, value2, "byys");
            return (Criteria) this;
        }

        public Criteria andByysNotBetween(Integer value1, Integer value2) {
            addCriterion("byys not between", value1, value2, "byys");
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